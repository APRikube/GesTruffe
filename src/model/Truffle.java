package model;

import constants.ModelConstants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Truffle {
    private int weight;
    private Date harvedstedOn;

    public Truffle(int weight, Date harvedstedOn) {
        this.weight = weight;
        this.harvedstedOn = harvedstedOn;
    }

    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder data = new StringBuilder();
        data.append("\t\t\t<").append(ModelConstants.truffle).append(">\n");
        data.append("\t\t\t\t<").append(ModelConstants.weight).append(">").append(weight).append("</" + ModelConstants.weight + ">\n");
        data.append("\t\t\t\t<").append(ModelConstants.harvestedOn).append(">").append(formatter.format(harvedstedOn))
                .append("</").append(ModelConstants.harvestedOn).append(">\n");
        data.append("\t\t\t</").append(ModelConstants.truffle).append(">\n");
        return data.toString();
    }
}
