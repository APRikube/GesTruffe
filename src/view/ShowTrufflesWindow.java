package view;

import controler.AbstractController;
import model.Truffle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.Vector;

//https://stackoverflow.com/questions/10346449/scrolling-a-jpanel

public class ShowTrufflesWindow {

    //Panel mainWindow;
    AbstractController controller;

    //public ShowTrufflesWindow(Panel mainWindow, AbstractController controller, int treeId) {
    public ShowTrufflesWindow(AbstractController controller, int treeId) {
        //this.mainWindow = mainWindow;
        this.controller = controller;

        Vector<Truffle> trufflesToShow = controller.getModel().getTruffleField().getTruffleOakWithId(treeId).getTruffles();

        JFrame frame = new JFrame();
        JPanel showTruffleWindow = new JPanel();
        showTruffleWindow.setLayout(new BoxLayout(showTruffleWindow, BoxLayout.Y_AXIS));
        for(Truffle truffle : trufflesToShow) {
            String textButton = truffle.getHarvedstedOn().getYear() + " " + truffle.getWeight() + "g";
            showTruffleWindow.add(new JButton(new AbstractAction(textButton) {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        new TruffleInfoWindow(truffle);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
        JScrollPane scrollPane = new JScrollPane(showTruffleWindow);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(10, 10, 480, 380);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500, 400));
        contentPane.add(scrollPane);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

}
