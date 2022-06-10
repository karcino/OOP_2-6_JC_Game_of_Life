package com.paulfiedler.mup2.JCGoL2_6;

import java.util.*;

public class GameOfLife {
    private final int anzahlRunden;
    private final String type;
    private final int size;
    public int startBelegungProzent;
    private List<Feld> feldZustaende;

    public GameOfLife(int anzahlRunden, String type, int startBelegungProzent, int size) {
        this.anzahlRunden = anzahlRunden;
        this.type = type;
        this.startBelegungProzent = startBelegungProzent;
        this.size = size;
    }

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

    public Feld neueRunde() {
        Feld neuesFeld = new Feld(this.size, this.type);
        Feld letztesFeld = feldZustaende.get(feldZustaende.size() - 1);
        neuesFeld.setConwayBelegung(letztesFeld);
        printFeld(neuesFeld);
        return neuesFeld;
    }


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

    public void printFeld(Feld feld) {
        System.out.print(String.format("\033[2J"));
        System.out.println(feld.toString());
    }







}
