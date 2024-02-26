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
