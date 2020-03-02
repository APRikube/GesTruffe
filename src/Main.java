import controler.*;
import model.*;
import view.*;

public class Main {

    public static void main(String[] args) {
        //Instanciation de notre modèle
        AbstractModel model = new Model();
        //Création du contrôleur
        AbstractController controler = new Controller(model);
        //Création de notre fenêtre avec le contrôleur en paramètre
        MainScreen mainScreen = new MainScreen(controler);
        //Ajout de la fenêtre comme observer de notre modèle
        model.addObserver(mainScreen);
    }
}