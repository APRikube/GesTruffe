package view;

import constants.ViewConstants;
import controler.AbstractController;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MenuBar extends JMenuBar {

    private String openedFile = "";

    public MenuBar(AbstractController controller) {
        JMenu file = new JMenu(ViewConstants.file);

        JMenuItem newP = new JMenuItem(ViewConstants.newP);
        newP.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        file.add(newP);

        JMenuItem open = new JMenuItem(new AbstractAction(ViewConstants.open) {
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers CSV", "xml", "XML");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    //Process d'ouverture du fichier
                    openedFile = chooser.getSelectedFile().getName();
                    System.out.println("Vous avez choisi d'ouvrir le fichier : " + openedFile);
                }
            }
        });
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        file.add(open);

        JMenuItem save = new JMenuItem(new AbstractAction(ViewConstants.save) {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    controller.save(openedFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        file.add(save);

        /*JMenuItem saveAs = new JMenuItem(new AbstractAction(ViewConstants.saveAs) {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.save(openedFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        file.add(saveAs);*/

        this.add(file);

        JMenu home = new JMenu(ViewConstants.home);
        JMenuItem paste = new JMenuItem(ViewConstants.paste);
        JMenuItem copy = new JMenuItem(ViewConstants.copy);
        JMenuItem cut = new JMenuItem(ViewConstants.cut);

        home.add(paste);
        home.add(copy);
        home.add(cut);
        this.add(home);
    }
}
