package view;

import controler.AbstractController;
import observer.Observer;

import javax.swing.*;
import java.awt.event.*;

public class MainScreen extends JFrame implements Observer {

    private MenuBar menuBar;// = new MenuBar();
    private JLabel screen = new JLabel();

    public MainScreen(AbstractController controller) {
        this.setSize(1920, 1080);
        this.setTitle("GesTruffe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        Panel container = new Panel(controller);
        menuBar = new MenuBar(controller);
        initComposant();
        this.setContentPane(container);
        this.setVisible(true);
    }

    private void initComposant() {
        setJMenuBar(menuBar);
    }

    //Implémentation du pattern observer
    public void update(String str) {
        screen.setText(str);
    }

}