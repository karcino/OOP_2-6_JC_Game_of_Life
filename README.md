# Aufgabe 2.6: John Conways Game of Life 

## Beschreibung
Das "Spiel des Lebens" von John Conway basiert auf einem rechteckigen Spielfeld, das in Felder unterteilt ist. Die Ränder des Spielfeldes können als Grenzen betrachtet werden, sodass die Randfelder
weniger Nachbarn haben als die anderen Felder. Alternativ können rechter und linker Rand sowie obe rer und unterer Rand miteinander verbunden werden, sodass ein zyklisches Spielfeld entsteht, auf dem
jedes Feld die gleiche Anzahl von Nachbarn hat. Jedes Feld ist entweder belegt oder leer.
Zu Beginn sind alle Felder leer. Dann werden bestimmte Felder belegt, entweder zufällig oder
gezielt mit Mustern. Das Spiel selbst läuft in mehreren Runden ab. In jeder Runde wird für alle Felder
bestimmt, ob das Feld belegt wird (oder bleibt) oder ob das Feld geleert wird (oder leer bleibt). Die
Regeln hierfür sind folgende:
- Wenn eine belegte Zelle 0 oder 1 belegte Nachbarn hat, wird sie geleert.
- Wenn eine belegte Zelle 2 oder 3 belegte Nachbarn hat, bleibt sie belegt.
- Wenn eine belegte Zelle 4, 5, 6, 7 oder 8 belegte Nachbarn hat, wird sie geleert.
- Wenn eine Zelle leer ist und mindestens 3 belegte Nachbarn hat, wird sie belegt.
- Ansonsten bleibt die Zelle leer.
## Aufgabenstellung
Schreiben Sie ein Program, welches zu einer gegebenen Anfangsbelegung des Spielfeldes das Spiel
über eine Anzahl von Runden simuliert und den Zustand des Spielfeldes nach jeder Runde ausgibt.
## Testprogramm
Testen Sie das Programm mit mehreren Spielfeldgrößen (10, 20, 50), zyklisch und offen, sowie zufälliger
Anfangsbelegung, wobei 10%, 25%, 50% oder 75% des Spielfeldes belegt sind.
Charakterisieren Sie die entstehenden Muster.

### Eingabe
Spielfeldgröße, Anfangsbelegung.
### Ausgabe
Zustand des Spielfeldes nach jeder Runde
### Abbruch
Das Programm kann nach jeder Runde beendet werden. Ansonsten beendet sich das Programm,
falls das Spielfeld leer ist.
## Hinweise zum Programm
Keine.


