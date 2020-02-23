package view;

import constants.ViewConstants;
import controler.AbstractController;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateTruffleWindow {

    Panel mainWindow;
    AbstractController controller;
    DateFormat formatFR = new SimpleDateFormat("dd/MM/yyyy");
    JTextField plantedOn = new JFormattedTextField(formatFR);

    JTextField weight = new JTextField(20);

    public CreateTruffleWindow(Panel panel, AbstractController controller, int treeId) throws NumberFormatException{
        this.mainWindow = panel;
        this.controller = controller;

        JPanel treeWindow = new JPanel();

        treeWindow.add(new JLabel(ViewConstants.harvestedOn));
        treeWindow.add(plantedOn);
        treeWindow.setLayout(new BoxLayout(treeWindow, BoxLayout.Y_AXIS));
        treeWindow.add(new JLabel(ViewConstants.weight));
        treeWindow.add(weight);

        int result = JOptionPane.showConfirmDialog(null, treeWindow,
                ViewConstants.trufflePopupTitle, JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                controller.createTruffle(treeId, Integer.parseInt(weight.getText()), new Date());
            } catch (NumberFormatException e) {
                // Popoup d'erreur "Le poids doit être un nombre"
                System.out.println("NaN");
            }
        }
    }
}
