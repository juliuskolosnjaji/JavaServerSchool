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
EINGABE		BESCHREIBUNG																	MÖGLICHE ANTWORTEN

HELO [name]  	//Client meldet sich mit seinem Namen beim Server an												201 OK
																				202 OK [name]
																				405 Falscher Benutzername oder Passwort 
																				401 Fehler! [Name] nicht gefunden. Registriere den Namen oder versuche es erneut.
																				501 Server nicht gefunden
																				402 Bereits angemledet
QUIT         	//Client verlässt die Interaktion mit dem Server												203 Auf Wiedersehen [name]! Schön dass du da warst
																				 
																				403 Name bereits in Verwendung 
MSG [name]   	//Client informiert den Server, dass er gerne mit [name] chatten würde, damit der Server sie verbindet						404 Du bist alleine auf dem Server
MSGALL       	//Client informiert den Server, dass er gerne mit allen chatten würde, damit der Server sie verbindet
PNMSG [name] 	//Client informiert den Server, dass er gerne mit [name] privat chatten, sodass der Server sie verbindet ohne das Gespräch zu lesen
PNMSGALL     	//Client informiert den Server, dass er gerne mit allen privat chatten würde, sodass der Server sie verbindet ohne das Gespräche zu lesen
ENDPNMSG    	//Clinet informiert den Server, dass er den chat beenden will, damit dieser das tut, ohne sich die Nachricht durchzulesen
REG [name]   	//Client registriert einen neuen Namen
SERVERINFO 	//Server informiert Client über IP-Adresse und Name
PASSWORD [password] 	//Server verlangt Passwrd vom Client
CHANGENAME [name] 	// Client ändert seinen Namen
CHANGEPASSWORT [passwort] // Client ändert sein Passwort
SENDEMOJI [int]	//  
TIMESTAMP [getTime]
