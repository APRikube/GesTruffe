package model;

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
        data.append("<Truffle>\n");
        data.append("<weight>").append(weight).append("</weight>\n");
        data.append("<harvedstedOn>").append(formatter.format(harvedstedOn)).append("</harvedstedOn>\n");
        data.append("</Truffle>\n");
        return data.toString();
    }
}
