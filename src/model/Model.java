package model;

import constants.ModelConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList truffleOaks = doc.getElementsByTagName("TruffleOak");
            for(int i = 0; i < truffleOaks.getLength() ; i++) {
                Node node = truffleOaks.item(i);
                //System.out.println(node.getNodeName());
                if(node.getNodeType() == node.ELEMENT_NODE) {
                    Element truffleOak = (Element) node;
                    System.out.println("Pos x " + truffleOak.getElementsByTagName("posX").item(0).getTextContent());
                    System.out.println("Pos y " + truffleOak.getElementsByTagName("posY").item(0).getTextContent());
                    System.out.println("Planted on " + truffleOak.getElementsByTagName("plantedOn").item(0).getTextContent());
                    System.out.println("Specie " + truffleOak.getElementsByTagName("specie").item(0).getTextContent());
                    NodeList truffles = truffleOak.getElementsByTagName(ModelConstants.truffle);
                    for(int j = 0 ; j < truffles.getLength() ; j++) {
                        Node node1 = truffles.item(j);
                        if(node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element truffle = (Element) node1;
                            System.out.println("Weight " + truffle.getElementsByTagName(ModelConstants.weight).item(0).getTextContent());
                            System.out.println("Harvested on " + truffle.getElementsByTagName(ModelConstants.harvestedOn).item(0).getTextContent());
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();;
        }
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