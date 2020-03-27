# UNDO in Datenbanken  
Als erstes soll innerhalb der Datenbank eine neue Tabelle <ins>history</ins> erstellt werden, mit 2 Spalten:  
Primray-Key mit fortlaufender Nummer und eine Spalte für VARCHARS(String)  
In dem String sollen, wenn der USER eine Datenbanktransaktion durchführt, den <ins>Namen der betreffenden Tabelle</ins>, 
die <ins>Art der durchgeführten Operation</ins>(CREATE, READ(wobei Read vernachlässigt werden kann), UPDATE, DELETE),  
sowie die <ins>geänderten bzw. gelöschten Parameter</ins> enthalten.  
Führt der User eine CREATE Operation durch, dann wird im String folgendes gespeichert, durch leerzeichen getrennt:  
"Tabellenname CREATE primarykey"--> Sollte der Benutzer undo nach einem CREATE ausführen wird durch den Tabellennamen und PrimaryKey der zu löschende Eintrag gefunden.
Bei UPDATE werden zusätzlich alle alten Parameter(<ins>in der Reihenfolge der Spalten der DB-Tabelle!!</ins>) mitangegeben,   
deren Werte durch update verändert wurden.  
Das man sich aber auskennt, welche Parameter unverändert sind, werden diese durch einen Doppelpunkt im markiert.
Beispiel: "Tabellenname UPDATE primarykey : Attribut2 : : Attribut4 Attribut5"
Bei DELETE werden im Gegensatz zu UPDATE ausnahmslos alle Parameter angegeben, 
dass man den gelöschten Eintrag durch UNDO wieder 100%-ig rekreieren kann.
(Es hängt von der Generierung des Primary-Key ab, ob dieser mitgespeichert werden soll oder nicht
(also neu generieren oder alten verwenden))
