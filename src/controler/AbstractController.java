package controler;

import java.awt.*;
import java.io.IOException;
import java.util.Date;

import model.AbstractModel;
import model.Truffle;
import model.TruffleOak;

public abstract class AbstractController {

    protected AbstractModel model;

    public AbstractController(AbstractModel model) {
        this.model = model;
    }

    public void createTree(Point clickedArea, Date plantedOn, String specie) {
        TruffleOak truffleOak = new TruffleOak(clickedArea.getX(), clickedArea.getY(), plantedOn, specie);
        model.getTruffleField().addTruffleOaks(truffleOak);
    }

    public void createTruffle(int truffleOakId, int weight, Date date) {
        model.getTruffleField().getTruffleOakWithId(truffleOakId).addTruffles(new Truffle(weight, date));
        //System.out.println(model.getTruffleField().getTruffleOakWithId(truffleOakId).toString());
    }

    public void save(String file) throws IOException {
        model.save(file);
    }

    public void open(String file) throws IOException {
        model.open(file);
    }

    //Efface
    public void reset() {
        this.model.reset();
    }

    //Méthode de contrôle
    abstract void control();
}