package com.paulfiedler.mup2.JCGoL2_6;
public class Main {

    public static void main(String[] args) {

        GameOfLife game = new GameOfLife(80, "zyklisch", 10, 10);
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
