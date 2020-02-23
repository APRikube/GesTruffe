package model;

import java.io.*;

public class Model extends AbstractModel{

    @Override
    public TruffleField getTruffleField() {
        return truffleField;
    }

    public void save(String file) throws IOException {
        // Save in file
        String data = "<?xml version = \"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>\n" + truffleField.toString();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(data);
        writer.close();
    }

    public void open(String file) throws IOException {
        /*BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            line = reader.readLine();
            switch (line) {

            }
        }*/
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