package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class TruffleTree {

    private double posX;
    private double posY;
    private Date plantedOn;
    private String specie;
    private static int count;
    private int id;
    private Vector<Truffle> truffles = new Vector<>();

    public TruffleTree(double posX, double posY, Date plantedOn, String specie) {
        this.posX = posX;
        this.posY = posY;
        this.plantedOn = plantedOn;
        this.specie = specie;
        this.id = count++;
    }

    // Setters
    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public void setPlantedOn(Date plantedOn) {
        this.plantedOn = plantedOn;
    }

    public void addTruffles(Truffle truffle) {
        truffles.add(truffle);
    }

    // Getters
    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public Date getPlantedOn() {
        return plantedOn;
    }

    public Vector<Truffle> getTruffles() {
        return truffles;
    }

    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder data = new StringBuilder();
        data.append("\t<TruffleOak>\n");
        data.append("\t\t<posX>").append(posX).append("</posX>\n");
        data.append("\t\t<posY>").append(posY).append("</posY>\n");
        data.append("\t\t<plantedOn>").append(formatter.format(plantedOn)).append("</plantedOn>\n");
        data.append("\t\t<specie>").append(specie).append("</specie>\n");
        data.append("\t\t<Truffles>\n");
        for(Truffle t:truffles) {
            data.append(t.toString());
        }
        data.append("\t\t</Truffles>\n");
        data.append("\t</TruffleOak>\n");
        return data.toString();
    }

}
