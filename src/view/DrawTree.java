package view;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DrawTree extends Ellipse2D {
    private double x;
    private double y;
    private double width;
    private double height;
    private static int count;
    private int id;
    private DrawTree selectedTree = null;

    public DrawTree(Point clickedArea, double width, double height, Graphics2D g2d, Panel panel) {
        this.x = clickedArea.getX();
        this.y = clickedArea.getY();
        this.width = width;
        this.height = height;
        this.id = count++;
        g2d.setPaint(Color.RED);
        g2d.setStroke(new BasicStroke(5.0f));
        g2d.draw(this);
        panel.addTrees(this);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setFrame(double v, double v1, double v2, double v3) {

    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    public int getId() {
        return id;
    }

}
