package model;

public class Model extends AbstractModel{

    @Override
    public TruffleField getTruffleField() {
        return truffleField;
    }

    public void save() {
        // Save in file
        System.out.println(truffleField.toString());
    }

    //Réinitialise tout
    public void reset(){
        this.result = 0;
        this.operande = "0";
        this.operateur = "";
        //Mise à jour !
        notifyObserver(String.valueOf(this.result));
    }

}