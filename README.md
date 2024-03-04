# El Plan

Erstellt ein neues BlueJ-Projekt. 

    Importiere die Abiturklassen 

    Nutzen sie die Klasse Connection (siehe Dokumentation) 

        Erstellen Sie ein Programm, dass sich mit time-b.timefreq.bldrdoc.gov verbindet (Port 13). Im Anschluss soll es hier die Uhrzeit abrufen. 

        Erstellen Sie ein Programm, dass sich mit time.fu-berlin.de verbindet (Port 13). Im Anschluss soll es hier die Uhrzeit abrufen.

        Erstellen Sie ein Programm, dass sich mit einem QOTD-Server verbindet (Port 17). Beispiele: qotd.nngn.net, qotd.atheistwisdom.com, djxmmx.net, alpha.mike-r.com).
        Im Anschluss soll es hier ein Spruch des Tages abgerufen werden. 

Dokumentation der Abiturklassen: 

Die Java-Klassen: 

(siehe Dateien) 
 
<<Dokumentation Netzwerkklassen.pdf>>


Wichtig.rtf ->

Diese Server-Klasse benötigt zusätzlich die Klasse List<ContentType> aus den aktuellen Datenstrukturklassen für das Abitur.

----------------------------------------------------------------------------------------------

Für den 26.2.2024: 

Wir wollen nun Client und Server aufsetzen. 

Im Folgenden sollen jeweils die Klassen Server und Client vom Abitur NRW (s. Vorhergehende Aufgabe) genutzt werden. 

Setzt also bitte jeweils eine eigene Instanz eines Servers und eins Clients auf.
Diese von euch geschriebenen Klassen sollen von den vorgegebenen Klassen erben.
In dieser Phase wollen wir erst einmal immer den "localhost" (127.0.0.1) nutzen. 

a) Erstellt einen Echo-Server. Der Client verbindet sich mit Server und bekommt eine Bestätigung.
Nun kann der Client Nachrichten an den Server schicken. Diese werden aufgenommen und zurück geschickt. Eine Echo. 

b) Es soll ermöglicht werden, das sich ein zweiter Client auf dem Server einloggt.
Eingehende Textnachrichten sollen nun "Broadcast", also an alle Clients verschickt werden.
Schaffst du es das sich auch noch mehr Clients einloggen können?


## Specification
Commands and Descriptions:

HELO [name]
- Client logs in with their name to the server.
- Possible Responses:
  - 201 OK
  - 202 OK [name]
  - 405 Incorrect username or password
  - 401 Error! [Name] not found. Register the name or try again.
  - 501 Server not found
  - 402 Already logged in

QUIT
- Client leaves the interaction with the server.
- Possible Response:
  - 203 Goodbye [name]! Nice to have you here.

MSG [name]
- Client informs the server that they would like to chat with [name], so the server connects them.
- Possible Response:
  - 404 You are alone on the server

MSGALL
- Client informs the server that they would like to chat with everyone, so the server connects them.

PNMSG [name]
- Client informs the server that they would like to privately chat with [name], so the server connects them without reading the conversation.

PNMSGALL
- Client informs the server that they would like to privately chat with everyone, so the server connects them without reading the conversations.

ENDPNMSG
- Client informs the server that they want to end the private chat, so the server does so without reading the message.

REG [name]
- Client registers a new name.

SERVERINFO
- Server informs the client about IP address and name.

PASSWORD [password]
- Server demands password from the client.

CHANGENAME [name]
- Client changes their name.

CHANGEPASSWORD [password]
- Client changes their password.

SENDEMOJI [int]
- [Description of this command]

TIMESTAMP [getTime]
- [Description of this command]
