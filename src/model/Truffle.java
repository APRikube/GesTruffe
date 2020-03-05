package model;

import constants.ModelConstants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Truffle {
    private double weight;
    private Date harvestedOn;

    public Truffle(double weight, Date harvestedOn) {
        this.weight = weight;
        this.harvestedOn = harvestedOn;
    }

    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder data = new StringBuilder();
        data.append("\t\t\t<").append(ModelConstants.truffle).append(">\n");
        data.append("\t\t\t\t<").append(ModelConstants.weight).append(">").append(weight).append("</" + ModelConstants.weight + ">\n");
        data.append("\t\t\t\t<").append(ModelConstants.harvestedOn).append(">").append(formatter.format(harvestedOn))
                .append("</").append(ModelConstants.harvestedOn).append(">\n");
        data.append("\t\t\t</").append(ModelConstants.truffle).append(">\n");
        return data.toString();
    }

    public double getWeight() {
        return weight;
    }

    public Date getHarvedstedOn() {
        return harvestedOn;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHarvestedOn(Date harvestedOn) {
        this.harvestedOn = harvestedOn;
    }
}
