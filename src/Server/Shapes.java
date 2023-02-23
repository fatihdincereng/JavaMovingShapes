package Server;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import javax.swing.JPanel;

// #region Shape
abstract class Shape implements Serializable {
    protected Point point;
    protected int deltaX;
    protected JPanel panel;

    public Shape(Point point, int deltaX, JPanel panel) {
        this.point = point;
        this.deltaX = deltaX;
        this.panel = panel;
    }

    public abstract void draw(Graphics g);

    public abstract void move();
}
// #endregion

// #region Circle
class Circle extends Shape {
    private int diameter;
    Color color;

    public Circle(Point point, int deltaX, JPanel panel, int diameter, Color color) {

        super(point, deltaX, panel);
        this.diameter = diameter;
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.fillOval(point.x, point.y, diameter, diameter);
        g.setColor(color);
    }

    @Override
    public void move() {
        point.x += deltaX;
        if (point.x + diameter > panel.getWidth() || point.x < 0) {
            deltaX = -deltaX;
        }

    }
}
// #endregion

// #region Square
class Square extends Shape {
    private int sideLength;
    Color color;

    public Square(Point point, int deltaX, JPanel panel, int sideLength, Color color) {
        super(point, deltaX, panel);
        this.sideLength = sideLength;
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(point.x, point.y, sideLength, sideLength);
        g.setColor(color);

    }

    @Override
    public void move() {
        point.x += deltaX;
        if (point.x + sideLength > panel.getWidth() || point.x < 0) {
            deltaX = -deltaX;
        }

    }
}
// #endregion

// #region Rectangle
class Rectangle extends Shape {

    private int width;
    private int height;
    Color color;

    public Rectangle(Point point, int deltaX, JPanel panel, int width, int height, Color color) {
        super(point, deltaX, panel);
        this.width = width;
        this.height = height;
        this.color = color;

    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(point.x, point.y, width, height);
        g.setColor(color);
    }

    @Override
    public void move() {
        point.x += deltaX;
        if (point.x + width > panel.getWidth() || point.x < 0) {
            deltaX = -deltaX;
        }
    }
}
// #endregion
