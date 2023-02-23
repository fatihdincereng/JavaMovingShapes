package Server;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MovingShapesControl extends JPanel {

    private static final long serialVersionUID = 1L;
    private List<Shape> shapes = new ArrayList<>();
    public ArrayList<Point> rectanglePoints = new ArrayList<Point>();
    public ArrayList<Point> squarePoints = new ArrayList<Point>();
    public ArrayList<Point> circlePoints = new ArrayList<Point>();

    public MovingShapesControl() {

    }

    public MovingShapesControl(int portSayisi, int countSquare, int countCircle, int countRectangle) {
        this.shapeCreation(countSquare, countCircle, countRectangle);
    }

    private void shapeCreation(int countSquare, int countCircle, int countRectangle) {
        Random random = new Random();
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(800, 600));

        // Şekillerin Yaratıldığı Kısım
        for (int i = 0; i < countCircle; i++) {
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            int circleSpeed = random.nextInt(11) + 5;
            int circleSize = random.nextInt(61) + 20;
            shapes.add(new Circle(new Point(i * 50 + 50, (i + 1) * 50 + 100), circleSpeed, this, circleSize, color));
        }
        for (int i = 0; i < countSquare; i++) {
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            int squareSpeed = random.nextInt(11) + 5;
            int squareSize = random.nextInt(61) + 20;
            shapes.add(new Square(new Point(i * 50 + 50, (i + 1) * 50 + 100), squareSpeed, this, squareSize, color));
        }
        for (int i = 0; i < countRectangle; i++) {
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            int rectangleSpeed = random.nextInt(11) + 5;
            int rectangleWidth = random.nextInt(41) + 20;
            int rectangleHeight = random.nextInt(61) + 20;
            shapes.add(new Rectangle(new Point(i * 50 + 50, (i + 1) * 50 + 100), rectangleSpeed, this, rectangleWidth,
                    rectangleHeight, color));
        }
    }

    // Create Shapes
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    // Start Animation
    public void startAnimation() {
        Timer timer = new Timer(20, new TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Shape shape : shapes) {
                shape.move();
            }
            repaint();
        }
    }

}
