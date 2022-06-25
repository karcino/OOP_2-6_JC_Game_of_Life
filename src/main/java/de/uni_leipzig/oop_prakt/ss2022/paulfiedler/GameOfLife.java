package de.uni_leipzig.oop_prakt.ss2022.paulfiedler;

import java.util.*;

/**
 * Die Klasse Game of Life implementiert dieses.
 *
 * @author Fiedler, Paul
 */
public class GameOfLife {
    private final int anzahlRunden;
    private final String type;
    private final int size;
    public int startBelegungProzent;
    private List<Feld> feldZustaende;

    /**
     * Konstruktor GameOfLife
     *
     * @param anzahlRunden Anzahl der Runden, die das Game of Life laufen soll.
     * @param type Art des Spieles, entweder "zyklisch" oder "offen".
     * @param startBelegungProzent Prozentuale Belegung des Game of Life.
     * @param size Seitenlänge des quadratischen Spielfelds.
     */
    public GameOfLife(int anzahlRunden, String type, int startBelegungProzent, int size) {
        this.anzahlRunden = anzahlRunden;
        this.type = type;
        this.startBelegungProzent = startBelegungProzent;
        this.size = size;
    }

    /**
     * Startet den Spielablauf für die gesetzte Anzahl von Runden.
     */
    public void spielen() {
        Feld erstesFeld = new Feld(this.size, this.type);
        erstesFeld.generateRandomBelegung(startBelegungProzent);
        feldZustaende = new ArrayList<Feld>();
        feldZustaende.add(erstesFeld);
        printLatest();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        int counter = 1;
        while (counter < anzahlRunden) {

            if (feldZustaende.size() > 3 && feldZustaende.get(feldZustaende.size() - 2).toString().equals(feldZustaende.get(feldZustaende.size() - 1).toString())) {
                System.out.println("Abbruch: Keine Veränderung mehr.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                break;
            } else {
                feldZustaende.add(neueRunde());
                System.out.println(feldZustaende.size());
                printLatest();

                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                counter++;
            }
        }
    }

    /**
     * Hilfsmethode für spielen(), die die Belegung für die neue Runde ausgibt.
     *
     * @return neuesFeld das neue Feld, das sich aus der veränderten Belegung der Nachbarn ergibt.
     */
    public Feld neueRunde() {
        Feld neuesFeld = new Feld(this.size, this.type);
        Feld letztesFeld = feldZustaende.get(feldZustaende.size() - 1);
        neuesFeld.setConwayBelegung(letztesFeld);
        printFeld(neuesFeld);
        return neuesFeld;
    }


    /**
     * Gibt aktuelle Größe, Startbelegungsprozent, Typ und Anzahl der Runden n aus.
     */
    public void printLatest() {
        System.out.print(String.format("\033[2J"));



        //        Scanner myObj = new Scanner(System.in);
        //myObj.nextLine();


        System.out.printf("\n Size:" + size + " x " + size + " px,   ");
        System.out.printf(" Startbelegung:" + startBelegungProzent + " Prozent");
        System.out.printf(" type:" + type);
        System.out.printf(",    n:" + feldZustaende.size());
        System.out.println();
        System.out.println(feldZustaende.get(feldZustaende.size() - 1).toString());
    }

    /**
     * Gibt das Spielfeld auf der Konsole aus.
     *
     * @param feld
     */
    public void printFeld(Feld feld) {
        System.out.print(String.format("\033[2J"));
        System.out.println(feld.toString());
    }
}
