package de.uni_leipzig.oop_prakt.ss2022.paulfiedler;

import java.util.List;

/**
 * Die Klasse Zelle respräsentiert eine Zelle im Game of Life.
 *
 * @author Fiedler, Paul
 */
public class Zelle {

    private int xValue;
    private int yValue;
    private boolean state;
    private List<Zelle> nachbarn;

    /**
     * Konstruktor Zelle
     *
     * @param xValue x-Wert im Raster
     * @param yValue y-Wert im Raster
     * @param type
     */
    public Zelle(int xValue, int yValue, String type) {
        this.xValue = xValue;
        this.yValue = yValue;

        state = false;
        nachbarn = null;
    }

    /**
     * Getter für Attribut state.
     *
     * @return state gibt den state (belegt/nichtbelegt) der Zelle zurück.
     */
    public boolean getState() { return state; }

    /**
     * Setter für Attribut State weisst state einen boolean zu.
     *
     * @param belegt Boolean wird state zugewiesen.
     */
    public void setState(boolean belegt) { this.state = belegt; }

    public void setNachbarn(List<Zelle> nachbarn) {
        this.nachbarn = nachbarn;
    }

    /**
     * Gibt die anzahl belegter Nachbarn zurück.
     *
     * @return counter Anzahl belegter Nachbarn.
     */
    public int anzahlBelegteNachbarn() {
        int counter = 0;
        for (Zelle n : nachbarn) {
            if(n.getState()) counter ++;
        }
        return counter;
    }

    /**
     * Gibt den Status des Feldes als String aus ︎. "◼︎" bedeutet belegt, " .︎" bedeutet nicht belegt.
     *
     * @return String Feldstatus visualisiert als String.
     */
    public String printBelegung(){
        return this.state ? " ◼︎" : " .︎";
    }

}

