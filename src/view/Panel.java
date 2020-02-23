package view;

import constants.Actions;
import controler.AbstractController;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel {

    private List<DrawTree> trees = new ArrayList<>();
    //private AbstractController controller;
    private ContextMenu contextMenu;
    private DrawTree selectedTree;

    public Panel(AbstractController controller) {//MainScreen mainScreen, AbstractController controller) {
        super();
        this.addMouseListener(new JPanelObserver());
        //this.controller = controller;
        this.contextMenu = new ContextMenu(this, controller);
        this.selectedTree = null;
    }

    public void addTrees(DrawTree drawTree) {
        trees.add(drawTree);
    }

    public DrawTree getSelectedTree() {
        return selectedTree;
    }


    private class JPanelObserver extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            boolean isTreeClicked = false;
            for (int i = trees.size() - 1; i >= 0; i--) {
                if(trees.get(i).contains(e.getPoint())) {
                    isTreeClicked = true;
                    selectedTree = trees.get(i);
                }
            }
            if (isTreeClicked && SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
                contextMenu.showContextMenu(Actions.CLICK_ON_TREE, e);
            } else if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
                contextMenu.showContextMenu(Actions.CLICK, e);
            } else if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {

            }

        }
    }
}