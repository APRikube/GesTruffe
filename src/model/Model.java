package model;

import constants.ModelConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public void open(String file) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList truffleOaks = doc.getElementsByTagName("TruffleOak");
            TruffleField truffleField = new TruffleField();
            for(int i = 0; i < truffleOaks.getLength() ; i++) {
                Node node = truffleOaks.item(i);
                //System.out.println(node.getNodeName());
                if(node.getNodeType() == node.ELEMENT_NODE) {
                    TruffleTree truffleTree;
                    Element truffleOakNode = (Element) node;
                    truffleTree = readTruffleOak(truffleOakNode);
                    NodeList truffles = truffleOakNode.getElementsByTagName(ModelConstants.truffle);
                    for(int j = 0 ; j < truffles.getLength() ; j++) {
                        Node node1 = truffles.item(j);
                        if(node1.getNodeType() == node1.ELEMENT_NODE) {
                            Truffle truffle;
                            Element truffleNode = (Element) node1;
                            truffle = readTruffle(truffleNode);
                            truffleTree.addTruffles(truffle);
                        }
                    }
                    truffleField.addTruffleOaks(truffleTree);
                    this.truffleField = truffleField;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();;
        }
    }

    public TruffleTree readTruffleOak(Element truffleOakNode) throws ParseException {
        DateFormat formatFR = new SimpleDateFormat("dd/MM/yyyy");
        /*System.out.println("Pos x " + truffleOakNode.getElementsByTagName("posX").item(0).getTextContent());
        System.out.println("Pos y " + truffleOakNode.getElementsByTagName("posY").item(0).getTextContent());
        System.out.println("Planted on " + truffleOakNode.getElementsByTagName("plantedOn").item(0).getTextContent());
        System.out.println("Specie " + truffleOakNode.getElementsByTagName("specie").item(0).getTextContent());*/
        return new TruffleTree(Double.parseDouble(truffleOakNode.getElementsByTagName("posX").item(0).getTextContent()),
                Double.parseDouble(truffleOakNode.getElementsByTagName("posY").item(0).getTextContent()),
                formatFR.parse(truffleOakNode.getElementsByTagName("plantedOn").item(0).getTextContent()),
                truffleOakNode.getElementsByTagName("specie").item(0).getTextContent());
    }

    public Truffle readTruffle(Element truffleNode) throws ParseException {
        DateFormat formatFR = new SimpleDateFormat("dd/MM/yyyy");
        /*System.out.println("Weight " + truffleNode.getElementsByTagName(ModelConstants.weight).item(0).getTextContent());
        System.out.println("Harvested on " + truffleNode.getElementsByTagName(ModelConstants.harvestedOn).item(0).getTextContent());*/
        return new Truffle(Double.parseDouble(truffleNode.getElementsByTagName(ModelConstants.weight).item(0).getTextContent()),
                formatFR.parse(truffleNode.getElementsByTagName(ModelConstants.harvestedOn).item(0).getTextContent()));
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