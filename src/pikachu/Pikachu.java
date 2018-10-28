/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pikachu;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Thang
 */
public class Pikachu extends Canvas{  
      
    public void paint(Graphics g) {  
        g.drawString("Hello",40,40);  
        setBackground(Color.WHITE);  
        g.fillRect(130, 30,100, 80);  
        g.drawOval(30,130,50, 60);  
        setForeground(Color.RED);  
        g.fillOval(130,130,50, 60);  
        g.drawArc(30, 200, 40,50,90,60);  
        g.fillArc(30, 130, 40,50,180,40);  
          
    }  
        public static void main(String[] args) {  
        Pikachu m=new Pikachu();  
        JFrame f=new JFrame();  
        f.add(m);  
        f.setSize(400,400);  
        //f.setLayout(null);  
        f.setVisible(true);  
        
        
        
        //Choi trn console
        Algorithm algorithm = new Algorithm();
        
        Point p1= new Point();
        Point p2= new Point();
        int total=144;
        while(total>0){
            algorithm.getLevel1().printfBoard();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the P1.x");
            p1.x = sc.nextInt();
            System.out.println("Enter the P1.y");
            p1.y = sc.nextInt();
            System.out.println("Enter the P2.x");
            p2.x = sc.nextInt();
            System.out.println("Enter the P2.x");
            p2.y = sc.nextInt();
            if(algorithm.checkTwoPoint(p1, p2)){
                algorithm.settohide(p1,p2);
                total-=2;
            }
        }
        
        System.out.println("You are win!!!");
    }  
  
}  
