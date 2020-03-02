package controler;

import java.awt.*;
import java.io.IOException;
import java.util.Date;

import model.AbstractModel;
import model.Truffle;
import model.TruffleTree;

public abstract class AbstractController {

    protected AbstractModel model;
    private String openedFile;

    public AbstractController(AbstractModel model) {
        this.model = model;
    }

    public void createTree(Point clickedArea, Date plantedOn, String specie) {
        model.getTruffleField().addTruffleOaks(new TruffleTree(clickedArea.getX(), clickedArea.getY(), plantedOn, specie));
    }

    public void createTruffle(int truffleOakId, double weight, Date date) {
        model.getTruffleField().getTruffleOakWithId(truffleOakId).addTruffles(new Truffle(weight, date));
        //System.out.println(model.getTruffleField().getTruffleOakWithId(truffleOakId).toString());
    }

    public void save() throws IOException {
        model.save(openedFile);
    }

    public void open(String file) throws IOException {
        openedFile = file;
        model.open(openedFile);
    }

    public AbstractModel getModel() {
        return model;
    }

    //Efface
    public void reset() {
        this.model.reset();
    }

    //Méthode de contrôle
    abstract void control();
}