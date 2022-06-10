package com.paulfiedler.mup2.JCGoL2_6;

import java.util.List;

public class Zelle {

    private int xValue;
    private int yValue;
    private boolean state;
    private List<Zelle> nachbarn;

    public Zelle(int xValue, int yValue, String type) {
        this.xValue = xValue;
        this.yValue = yValue;

        state = false;
        nachbarn = null;
    }

    public boolean getState() { return state; }

    public void setState(boolean belegt) { this.state = belegt; }

    public void setNachbarn(List<Zelle> nachbarn) {
        this.nachbarn = nachbarn;
    }
    public int anzahlBelegteNachbarn() {
        int counter = 0;
        for (Zelle n : nachbarn) {
            if(n.getState()) counter ++;
        }
        return counter;
    }

    public String printBelegung(){
        return this.state ? " ◼︎" : " .︎";
    }

}

