/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pikachu;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author Hp Pavilion
 */
public class DrawLine extends JPanel {

    private Point p1;
    private Point p2;
    private Point p3= new Point(0,0);
    private Point p4= new Point(0,0);
    private int number;

    public DrawLine(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        number=2;
        setPreferredSize(new Dimension(700, 400));
    }

    public DrawLine(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        number=3;
        setPreferredSize(new Dimension(700, 400));
    }
    
    

    public DrawLine(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        number=4;
        setPreferredSize(new Dimension(700, 400));

    }
    public void paint(Graphics g) {
        setForeground(Color.red);
        int[] xs = {p1.x+20, p2.x+20, p3.x+20, p4.x+20};
        int[] ys = {p1.y+20, p2.y+20, p3.y+20, p4.y+20};
        g.drawPolyline(xs, ys, number);


    }

}
