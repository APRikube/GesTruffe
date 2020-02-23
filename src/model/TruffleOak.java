package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class TruffleOak {

    private double posX;
    private double posY;
    private Date plantedOn;
    private String specie;
    private static int count;
    private int id;
    private Vector<Truffle> truffles = new Vector<>();

    public TruffleOak(double posX, double posY, Date plantedOn, String specie) {
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
        data.append("<TruffleOak>\n");
        data.append("<posX>").append(posX).append("</posX>\n");
        data.append("<posY>").append(posY).append("</posY>\n");
        data.append("<plantedOn>").append(formatter.format(plantedOn)).append("</plantedOn>\n");
        data.append("<specie>").append(specie).append("</specie>\n");
        data.append("<Truffles>\n");
        for(Truffle t:truffles) {
            data.append(t.toString());
        }
        data.append("</Truffles>\n");
        data.append("</TruffleOak>\n");
        return data.toString();
    }

}
