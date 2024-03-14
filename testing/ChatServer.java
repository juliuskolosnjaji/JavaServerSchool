package testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ChatServer extends Server {
    private static final int SERVER_PORT = 8888;
    private static final Map<String, String> registeredUsers = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Map<String, String[]> chatSessions = new HashMap<>();

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        System.out.println("Server started. Listening on port " + SERVER_PORT);

        String command;
        try {
            while ((command = reader.readLine()) != null) {
                if (command.equalsIgnoreCase("exit")) {
                    server.close();
                    break;
                } else {
                    // Process the command
                    System.out.println("Received command: " + command);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ChatServer() {
        super(SERVER_PORT);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
        System.out.println("New connection from " + pClientIP + ":" + pClientPort);
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        String[] parts = pMessage.split(" ", 2);
        String command = parts[0];

        switch (command) {
            case "HELO":
                handleHelo(pClientIP, pClientPort, parts);
                break;
            case "QUIT":
                handleQuit(pClientIP, pClientPort);
                break;
            case "MSG":
                if (parts.length >= 2) {
                    handleMsg(pClientIP, pClientPort, parts[1]);
                } else {
                    send(pClientIP, pClientPort, "Invalid command format");
                }
                break;
            case "MSGALL":
                if (parts.length >= 2) {
                    handleMsgAll(pClientIP, pClientPort, parts[1]);
                } else {
                    send(pClientIP, pClientPort, "Invalid command format");
                }
                break;
            case "SEND":
                if (parts.length >= 2) {
                    handleSend(pClientIP, pClientPort, parts[1]);
                } else {
                    send(pClientIP, pClientPort, "Invalid command format");
                }
                break;
            default:
                send(pClientIP, pClientPort, "Invalid command");
        }
    }


    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {
        System.out.println("Connection closed from " + pClientIP + ":" + pClientPort);
    }

    private void handleHelo(String pClientIP, int pClientPort, String[] parts) {
        if (parts.length == 2) {
            String name = parts[1];
            if (!registeredUsers.containsKey(name)) {
                registeredUsers.put(name, pClientIP + ":" + pClientPort);
                send(pClientIP, pClientPort, "202 OK " + name);
            } else {
                send(pClientIP, pClientPort, "401 Error! " + name + " not found. Register the name or try again.");
            }
        } else {
            send(pClientIP, pClientPort, "405 Incorrect username or password");
        }
    }

    private void handleQuit(String pClientIP, int pClientPort) {
        String userName = getUserName(pClientIP, pClientPort);
        if (userName != null) {
            registeredUsers.remove(userName);
            send(pClientIP, pClientPort, "203 Goodbye " + userName + "! Nice to have you here.");
            closeConnection(pClientIP, pClientPort);
        }
    }

    private void handleMsg(String pClientIP, int pClientPort, String message) {
        String[] parts = message.split(" ");
        if (parts.length >= 3) {
            String targetName = parts[1];
            message = parts[2];
            String targetAddress = registeredUsers.get(targetName);

            if (targetAddress != null) {
                String senderName = getUserName(pClientIP, pClientPort);
                if (senderName != null) {
                    String senderAddress = pClientIP + ":" + pClientPort;
                    sendMessageToClient(targetAddress, "Message from " + senderName + ": " + message);
                    send(pClientIP, pClientPort, "Message sent to " + targetName);
                } else {
                    send(pClientIP, pClientPort, "404 Sender not found");
                }
            } else {
                send(pClientIP, pClientPort, "404 User not found");
            }
        } else {
            send(pClientIP, pClientPort, "Invalid command format");
        }
    }




    private void handleMsgAll(String pClientIP, int pClientPort, String receivedMessage) {
        String[] parts = receivedMessage.split(" ");
        if (parts.length >= 2) { // Ensure there are at least 2 parts (command and message)
            String senderName = getUserName(pClientIP, pClientPort);
            if (senderName != null) {
                StringBuilder messageBuilder = new StringBuilder("Message from " + senderName + ": ");
                for (int i = 1; i < parts.length; i++) { // Start from index 1 to include the message
                    messageBuilder.append(parts[i]).append(" ");
                }
                String formattedMessage = messageBuilder.toString().trim();
                broadcastMessageToAllClients(formattedMessage);
            } else {
                send(pClientIP, pClientPort, "404 Sender not found");
            }
        } else {
            send(pClientIP, pClientPort, "Invalid command format");
        }
    }


    private void sendMessageToClient(String clientAddress, String message) {
        String[] parts = clientAddress.split(":");
        String ip = parts[0];
        int port = Integer.parseInt(parts[1]);
        send(ip, port, message);
    }

    private void broadcastMessageToAllClients(String message) {
        for (Map.Entry<String, String> entry : registeredUsers.entrySet()) {
            String clientAddress = entry.getValue();
            sendMessageToClient(clientAddress, message);
        }
    }

    private void handleSend(String pClientIP, int pClientPort, String message) {
        String senderAddress = pClientIP + ":" + pClientPort;
        boolean sent = false;

        for (Map.Entry<String, String[]> entry : chatSessions.entrySet()) {
            String[] addresses = entry.getValue();
            String sender = addresses[0];
            String recipient = addresses[1];

            if (sender.equals(senderAddress) || recipient.equals(senderAddress)) {
                String[] recipientAddressParts;
                if (sender.equals(senderAddress)) {
                    recipientAddressParts = recipient.split(":");
                } else {
                    recipientAddressParts = sender.split(":");
                }

                String recipientIP = recipientAddressParts[0];
                int recipientPort = Integer.parseInt(recipientAddressParts[1]);
                send(recipientIP, recipientPort, message); // Corrected line to send the message
                sent = true;
            }
        }

        if (!sent) {
            send(pClientIP, pClientPort, "No active chat sessions found");
        }
    }



    private String getUserName(String pClientIP, int pClientPort) {
        for (Map.Entry<String, String> entry : registeredUsers.entrySet()) {
            if (entry.getValue().equals(pClientIP + ":" + pClientPort)) {
                return entry.getKey();
            }
        }
        return null;
    }

}