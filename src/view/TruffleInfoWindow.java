package view;

import constants.ViewConstants;
import model.Truffle;

import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TruffleInfoWindow {

    JTextField harvestedOn = new JTextField(20);
    JTextField specie = new JTextField(20);

    DateFormat formatFR = new SimpleDateFormat("dd/MM/yyyy");

    public TruffleInfoWindow(Truffle truffle) throws ParseException {
        JPanel showTruffleWindow = new JPanel();
        showTruffleWindow.setLayout(new BoxLayout(showTruffleWindow, BoxLayout.Y_AXIS));

        showTruffleWindow.add(new JLabel(ViewConstants.plantedOn));
        harvestedOn.setText(formatFR.format(truffle.getHarvedstedOn()));
        showTruffleWindow.add(harvestedOn);

        showTruffleWindow.setLayout(new BoxLayout(showTruffleWindow, BoxLayout.Y_AXIS));

        showTruffleWindow.add(new JLabel(ViewConstants.specie));
        specie.setText(String.valueOf(truffle.getWeight()));
        showTruffleWindow.add(specie);

        int result = JOptionPane.showConfirmDialog(null, showTruffleWindow,
                ViewConstants.truffleInfoTitle, JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            truffle.setHarvestedOn(formatFR.parse(harvestedOn.getText()));
            truffle.setWeight(Double.parseDouble(specie.getText()));
        }
    }
}
