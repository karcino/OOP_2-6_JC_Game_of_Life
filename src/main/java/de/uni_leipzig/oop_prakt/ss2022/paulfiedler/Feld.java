package de.uni_leipzig.oop_prakt.ss2022.paulfiedler;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse Feld bildet das Spielfeld ab.
 *
 * @author Fiedler, Paul
 */
public class Feld {

   private final int size;
   private final String type;
   private final Zelle[][] zellen;


    /**
     * Konstruktor der Klasse Feld.
     *
     * Instanziiert die Zellen, aus denen das Feld aufgebaut ist und weisst ihnen entsprechend des typ ihre Nachbarn zu.
     *
     * @param size steht für Seitenlänge des quadratischen Felds.
     * @param type legt fest, ob das Feld zyklisch oder offen ist.
     */
    public Feld(int size, String type) {
        this.size = size;
        this.type = type;
        this.zellen = new Zelle[size][size];

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                this.zellen[x][y] = new Zelle(x, y, type);
            }
        }

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                List<Zelle> nachbarn = new ArrayList<>();

                if (type.equals("offen")) {

                    // MITTE
                    if (x > 0 && y > 0 && x < size - 1 && y < size - 1) {
                        nachbarn.add(this.zellen[x][y - 1]);
                        nachbarn.add(this.zellen[x][y + 1]);
                        nachbarn.add(this.zellen[x + 1][y - 1]);
                        nachbarn.add(this.zellen[x + 1][y]);
                        nachbarn.add(this.zellen[x + 1][y + 1]);
                        nachbarn.add(this.zellen[x - 1][y - 1]);
                        nachbarn.add(this.zellen[x - 1][y]);
                        nachbarn.add(this.zellen[x - 1][y + 1]);
                    }
                    //ECKEN
                    if (x == size - 1 && y == size - 1) {
                        nachbarn.add(this.zellen[x][y - 1]);
                        nachbarn.add(this.zellen[x - 1][y]);
                        nachbarn.add(this.zellen[x - 1][y - 1]);
                    } else if (x == 0 && y == 0) {
                        nachbarn.add(this.zellen[x][y + 1]);
                        nachbarn.add(this.zellen[x + 1][y]);
                        nachbarn.add(this.zellen[x + 1][y + 1]);
                    } else if (x == 0 && y == size - 1) {
                        nachbarn.add(this.zellen[x][y - 1]);
                        nachbarn.add(this.zellen[x + 1][y]);
                        nachbarn.add(this.zellen[x + 1][y - 1]);
                    } else if (x == size - 1 && y == 0) {
                        nachbarn.add(this.zellen[x][y + 1]);
                        nachbarn.add(this.zellen[x - 1][y]);
                        nachbarn.add(this.zellen[x - 1][y + 1]);
                    } else if (x == 0 || y == 0) {
                        //RAND
                        nachbarn.add(this.zellen[x + 1][y + 1]);
                        nachbarn.add(this.zellen[x][y + 1]);
                        nachbarn.add(this.zellen[x + 1][y]);
                        if (x == 0) {
                            nachbarn.add(this.zellen[x + 1][y - 1]);
                            nachbarn.add(this.zellen[x][y - 1]);
                        } else {
                            nachbarn.add(this.zellen[x - 1][y + 1]);
                            nachbarn.add(this.zellen[x - 1][y]);
                        }

                    } else if (x == size - 1 || y == size - 1) {
                        nachbarn.add(this.zellen[x - 1][y - 1]);
                        nachbarn.add(this.zellen[x][y - 1]);
                        nachbarn.add(this.zellen[x - 1][y]);
                        if (x == size - 1) {
                            nachbarn.add(this.zellen[x - 1][y + 1]);
                            nachbarn.add(this.zellen[x][y + 1]);
                        } else {
                            nachbarn.add(this.zellen[x + 1][y - 1]);
                            nachbarn.add(this.zellen[x + 1][y]);
                        }
                    }

                } else {
                    int xPrev = x == 0 ? size - 1 : x - 1;
                    int yPrev = y == 0 ? size - 1 : y - 1;
                    int xNext = x == size - 1 ? 0 : x + 1;
                    int yNext = y == size - 1 ? 0 : y + 1;

                    nachbarn.add(this.zellen[x][yPrev]);
                    nachbarn.add(this.zellen[x][yNext]);
                    nachbarn.add(this.zellen[xNext][yPrev]);
                    nachbarn.add(this.zellen[xNext][y]);
                    nachbarn.add(this.zellen[xNext][yNext]);
                    nachbarn.add(this.zellen[xPrev][yPrev]);
                    nachbarn.add(this.zellen[xPrev][y]);
                    nachbarn.add(this.zellen[xPrev][yNext]);
                }
                this.zellen[x][y].setNachbarn(nachbarn);
            }
        }
    }

    /**
     * Generiert eine zufällige Belegung des Felds entsprechend dem Anteil.
     *
     * @param prozent Anteil der zufällig belegten Zellen am Feld.
     */
    public void generateRandomBelegung(int prozent) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                zellen[x][y].setState(Math.random() * 100 < prozent);
            }
        }
    }

    /**
     *
     *
     * @param vorgaenger
     */
    public void setConwayBelegung(Feld vorgaenger) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int count = vorgaenger.getZellen()[x][y].anzahlBelegteNachbarn();
                if (vorgaenger.getZellen()[x][y].getState()) {
                    if (count <= 1) {
                        zellen[x][y].setState(false);
                    } else zellen[x][y].setState(count <= 3);
                } else {
                    if (count >= 3) {
                        zellen[x][y].setState(true);
                    }
                }


            }
        }
    }

    /**
     * Getter zellen[][]
     *
     * @return zellen ist der 2D Array in dem alle Zellen gespeichert sind.
     */
    public Zelle[][] getZellen() {
        return zellen;
    }

    /**
     * custom  toString
     *
     * @return toString gibt das Feld als String zurück
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int x = 0; x < size - 1; x++) {
            for (int y = 0; y < size - 1; y++) {
                str.append(zellen[x][y].printBelegung());
            }
            str.append("\n");
        }
        return str.toString();
    }
}

// git test