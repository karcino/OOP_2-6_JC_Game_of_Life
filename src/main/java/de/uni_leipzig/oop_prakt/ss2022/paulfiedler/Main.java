package de.uni_leipzig.oop_prakt.ss2022.paulfiedler;

/**
 * Die Klasse main beinhaltet die Main Methode.
 *
 * @author Fiedler, Paul, 3726896
 */
public class Main {

    /**
     * Die main()-Methode instanziiert und Objekte der Klasse GameOfLife und lässt diese ablaufen entsprechend der Testvorgaben.
     *
     * @param args
     */
    public static void main(String[] args) {

        GameOfLife game = new GameOfLife(80, "zyklisch", 50, 10);
        game.spielen();

        GameOfLife game1 = new GameOfLife(80, "offen", 10, 10);
        game1.spielen();

        GameOfLife game2 = new GameOfLife(80, "zyklisch", 10, 20);
        game2.spielen();

        GameOfLife game3 = new GameOfLife(80, "offen", 10, 20);
        game3.spielen();

        GameOfLife game4 = new GameOfLife(80, "zyklisch", 10, 50);
        game4.spielen();

        GameOfLife game5 = new GameOfLife(80, "offen", 10, 50);
        game5.spielen();

    }
}
