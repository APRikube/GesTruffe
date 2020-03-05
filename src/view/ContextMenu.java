package view;

import constants.Actions;
import constants.ViewConstants;
import controler.AbstractController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Date;

//http://www.java2s.com/Code/Java/2D-Graphics-GUI/Mousedraganddroptodraw.htm
public class ContextMenu extends JPopupMenu {

    private JMenuItem newTree;
    private JMenuItem addTruffle;
    private JMenuItem seeTruffles;
    private JMenuItem modify;
    private JMenuItem delete;
    private Panel panel;
    private AbstractController controller;

    public ContextMenu(Panel panel, AbstractController controller) {
        this.panel = panel;
        this.controller = controller;
        newTree = new JMenuItem(new AbstractAction(ViewConstants.newTree) {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateTreeWindow tw = new CreateTreeWindow(panel, controller, new Point(panel.getMousePosition()));
            }
        });
        this.add(newTree);

        addTruffle = new JMenuItem(ViewConstants.addTruffle);
        this.add(addTruffle);

        seeTruffles = new JMenuItem(ViewConstants.seeTruffles);
        this.add(seeTruffles);

        modify = new JMenuItem(ViewConstants.modify);
        this.add(modify);


        delete = new JMenuItem(ViewConstants.delete);
        this.add(delete);
    }

    public void showContextMenu(Actions action, MouseEvent e) {
        switch (action) {
            case CLICK:
                newTree.setVisible(true);
                addTruffle.setVisible(false);
                seeTruffles.setVisible(false);
                modify.setVisible(false);
                delete.setVisible(false);
                break;
            case CLICK_ON_TREE:
                newTree.setVisible(false);
                addTruffle.setAction(new AbstractAction(ViewConstants.addTruffle) {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        new CreateTruffleWindow(panel, controller, panel.getSelectedTree().getId());
                    }
                });
                addTruffle.setVisible(true);
                seeTruffles.setAction(new AbstractAction(ViewConstants.seeTruffles) {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        new ShowTrufflesWindow(controller, panel.getSelectedTree().getId());
                    }
                });
                seeTruffles.setVisible(true);
                modify.setVisible(true);
                delete.setVisible(true);
                break;
            default:
        }
        this.show(e.getComponent(), e.getX(), e.getY());
    }

}
