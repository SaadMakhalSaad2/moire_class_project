package moire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class MoirePanel extends JPanel {
    public MoirePanel() {
        this.setBackground(Color.white);
        setupMouseListener();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        AffineTransform scale = new AffineTransform();
        double w = this.getWidth();
        double h = this.getHeight();
        scale.setToScale(w / 2, h / 2);

        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(1.0, 1.0);


        AffineTransform transform = new AffineTransform();
        transform.concatenate(scale);
        transform.concatenate(translate);

        Stroke stroke = new BasicStroke(1);
        graphics2D.setStroke(stroke);
        graphics2D.setColor(Color.MAGENTA);

        int n = 30;
        double length = 0.3;
        double dx = 1.6 / n;
        for (int i = 0; i < n; i++) {
            double x1 = -length + i * dx;
            double y1 = length;
            double x2 = -length + i * dx;
            double y2 = -length;


            Line2D line = new Line2D.Double(x1, y1, x2, y2);
            Shape shape = transform.createTransformedShape(line);

            AffineTransform rotate =
                    AffineTransform.getRotateInstance(
                            Math.toDegrees(90), (line.getX1()+line.getX2())/2, (line.getY1()+line.getY2())/2);
            transform.concatenate(rotate);

            graphics2D.draw(shape);

        }
    }

    private void setupMouseListener() {

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("pressed");
                Point p = MouseInfo.getPointerInfo().getLocation();
                System.out.println("x1: " + p.x + "y1: " + p.y);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("released");
                Point p = MouseInfo.getPointerInfo().getLocation();
                System.out.println("x2: " + p.x + "y1: " + p.y);

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
