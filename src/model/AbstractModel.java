package model;

import java.util.ArrayList;

import observer.Observer;
import observer.Observable;

public abstract class AbstractModel implements Observable {

    protected double result = 0;
    protected String operateur = "", operande = "";
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();
    protected TruffleField truffleField = new TruffleField();

    //Efface
    public abstract void reset();

    public abstract TruffleField getTruffleField();
    public abstract void save();

    //Implémentation du pattern observer
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }

    public void notifyObserver(String str) {
        if (str.matches("^0[0-9]+"))
            str = str.substring(1, str.length());

        for (Observer obs : listObserver)
            obs.update(str);
    }

    public void removeObserver() {
        listObserver = new ArrayList<Observer>();
    }
}