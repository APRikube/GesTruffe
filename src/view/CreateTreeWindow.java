package view;

import constants.ViewConstants;
import controler.AbstractController;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//https://stackoverflow.com/questions/6555040/multiple-input-in-joptionpane-showinputdialog/6555051
//https://stackoverflow.com/questions/12655811/how-to-make-a-jtextfield-having-a-fixed-date-format

public class CreateTreeWindow{

    Panel mainWindow;
    AbstractController controller;
    DateFormat formatFR = new SimpleDateFormat("dd/MM/yyyy");
    JTextField plantedOn = new JFormattedTextField(formatFR);

    JTextField specie = new JTextField(20);

    public CreateTreeWindow(Panel panel, AbstractController controller, Point mousePosition) {
        this.mainWindow = panel;
        this.controller = controller;

        JPanel treeWindow = new JPanel();

        treeWindow.add(new JLabel(ViewConstants.plantedOn));
        treeWindow.add(plantedOn);
        treeWindow.setLayout(new BoxLayout(treeWindow, BoxLayout.Y_AXIS));
        treeWindow.add(new JLabel(ViewConstants.specie));
        treeWindow.add(specie);

        int result = JOptionPane.showConfirmDialog(null, treeWindow,
                ViewConstants.treePopupTitle, JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            new DrawTree(mousePosition, 100, 100, (Graphics2D) panel.getGraphics(), panel);
            controller.createTree(mousePosition, new Date(), specie.getText());
        }
    }

}
