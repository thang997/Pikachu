/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pikachu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Thang
 */
public class ingame extends javax.swing.JFrame implements ActionListener {

    private Algorithm algorithm;
    private JButton[][] btn;
    private static int total = 144;
    Point p1 = null;
    Point p2 = null;
    private static int r;
    private static int c;
    private boolean blnPause;
    private float count = 100;
    private Timer t;
    private GridLayout grid;

    /*
     * Creates new form ingame
     */
    public ingame() {
        initComponents();
        setSize(850, 600);
        setResizable(false);
        setTitle("Pikachu Game");
        setLocationRelativeTo(null);
        MyGridLayout();
        MyButtons();
        MyLabel();
        //newgame.setEnabled(false);
//        reset.setEnabled(false);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ingame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ingame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ingame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ingame.class.getName()).log(Level.SEVERE, null, ex);
        }
        progesstime.setValue((int) count);
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!blnPause) {
                    count = (float) (count - 0.2);
                    progesstime.setValue((int) count);
                }
                if (count == 0) {
                    int click = JOptionPane.showConfirmDialog(null, "Do you wanna play again?", "Question", JOptionPane.YES_NO_OPTION);
                    if (click == JOptionPane.YES_OPTION) {
                        count = 100;
                        progesstime.setValue((int) count);
                        t.start();
                    }
                    if (click == JOptionPane.NO_OPTION) {
                        System.exit(0);
                    }
                }
            }
        });
        t.start();
    }

    public void MyGridLayout() {
        layoutpikachu.removeAll();
        algorithm = new Algorithm();
        Change();
        btn = new JButton[13][20];
        grid = new GridLayout(9, 16, 2, 2);
        layoutpikachu.setLayout(grid);
        for (int i = 2; i < 11; i++) {
            for (int j = 2; j < 18; j++) {
                int a = algorithm.level1.getValue(i, j);
                btn[i][j] = new JButton();
                btn[i][j].setActionCommand(i + "," + j);
                btn[i][j].addActionListener(this);
                btn[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/imgpikachu/" + a + ".jpg")));
                layoutpikachu.add(btn[i][j]);
            }
        }
        layoutpikachu.setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnIndex = e.getActionCommand();
        int indexDot = btnIndex.lastIndexOf(",");
        int x = Integer.parseInt(btnIndex.substring(0, indexDot));
        int y = Integer.parseInt(btnIndex.substring(indexDot + 1,
                btnIndex.length()));
        if (p1 == null) {
            for (int i = 2; i < 11; i++) {
                for (int j = 2; j < 18; j++) {
                    btn[i][j].setBorder(null);
                }
            }
            p1 = new Point(x, y);
            btn[p1.x][p1.y].setBorder(new LineBorder(Color.red, 5));
        } else {
            for (int i = 2; i < 11; i++) {
                for (int j = 2; j < 18; j++) {
                    btn[i][j].setBorder(null);
                }
            }
            p2 = new Point(x, y);
            if (algorithm.checkTwoPoint(p1, p2) && !p1.equals(p2)) {
                btn[p2.x][p2.y].setBorder(new LineBorder(Color.red, 5));
                algorithm.settohide(p1, p2);
                total -= 2;
                StaticFinalvariable.TotalPoint += 10;
                diem.setText("Score: " + StaticFinalvariable.TotalPoint);

                if (StaticFinalvariable.Level == 1) {
                    btn[p1.x][p1.y].setVisible(false);
                    btn[p2.x][p2.y].setVisible(false);
                }

                if (StaticFinalvariable.Level == 2) {
                    algorithm.level1.settinglevel2();
                    for (int i = 2; i < 11; i++) {
                        for (int j = 2; j < 18; j++) {
                            int a = algorithm.level1.getValue(i, j);
                            if (a == 0) {
                                btn[i][j].setVisible(false);
                            } else {
                                btn[i][j].setActionCommand(i + "," + j);
                                btn[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/imgpikachu/" + a + ".jpg")));

                            }
                        }
                    }
                }

                if (StaticFinalvariable.Level == 3) {
                    algorithm.level1.settinglevel3();
                    for (int i = 2; i < 11; i++) {
                        for (int j = 2; j < 18; j++) {
                            int a = algorithm.level1.getValue(i, j);
                            if (a == 0) {
                                btn[i][j].setVisible(false);
                            } else {
                                btn[i][j].setActionCommand(i + "," + j);
                                btn[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/imgpikachu/" + a + ".jpg")));

                            }
                        }
                    }
                }

            }
            btn[p1.x][p1.y].setBorder(null);
            btn[p2.x][p2.y].setBorder(null);
            p1 = null;
            p2 = null;
        }
        if (total != 0) {
            Change();
        }
        if (total == 0) {
            StaticFinalvariable.TotalPoint += (count * 5);
            diem.setText("Score: " + StaticFinalvariable.TotalPoint);
            StaticFinalvariable.Level++;
            if (StaticFinalvariable.Level <= 3) {
                level.setText("Level:" + StaticFinalvariable.Level);
                layout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/" + StaticFinalvariable.Level + ".jpg")));
                total = 144;
                count = 100;
                progesstime.setValue((int) count);
                t.start();
                algorithm = new Algorithm();
                Change();
                for (int i = 2; i < 11; i++) {
                    for (int j = 2; j < 18; j++) {
                        btn[i][j].setVisible(true);
                        int a = algorithm.level1.getValue(i, j);
                        btn[i][j].setActionCommand(i + "," + j);
                        btn[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/imgpikachu/" + a + ".jpg")));
                    }
                }
            } else {
                int click = JOptionPane.showConfirmDialog(null, "Do you wanna play again?", "Question", JOptionPane.YES_NO_OPTION);
                if (click == JOptionPane.YES_OPTION) {
                    for (int i = 2; i < 11; i++) {
                        for (int j = 2; j < 18; j++) {
                            btn[i][j].setBorder(null);
                        }
                    }
                    total = 144;
                    StaticFinalvariable.Level = 1;
                    StaticFinalvariable.hintNumber = 3;
                    StaticFinalvariable.TotalPoint = 0;
                    level.setText("Level:" + StaticFinalvariable.Level);
                    diem.setText("Score: " + StaticFinalvariable.TotalPoint);
                    counthint.setText(String.valueOf(StaticFinalvariable.hintNumber));
                    count = 100;
                    progesstime.setValue((int) count);
                    t.start();
                    algorithm = new Algorithm();
                    Change();
                    for (int i = 2; i < 11; i++) {
                        for (int j = 2; j < 18; j++) {
                            btn[i][j].setVisible(true);
                            int a = algorithm.level1.getValue(i, j);
                            btn[i][j].setActionCommand(i + "," + j);
                            btn[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/imgpikachu/" + a + ".jpg")));
                        }
                    }
                }
                if (click == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }
        }
    }

    private void Change() {
        if (!algorithm.checkToChange()) {
            ArrayList<Point> listPoint = new ArrayList<>();
            ArrayList<Integer> listValue = new ArrayList<>();
            for (int i = 2; i < 11; i++) {
                for (int j = 2; j < 18; j++) {
                    if (algorithm.level1.getValue(i, j) != 0) {
                        listPoint.add(new Point(i, j));
                        listValue.add(algorithm.level1.getValue(i, j));
                    }
                }
            }
            int countNumber = listPoint.size();
            Random random = new Random();
            do {
                int number = random.nextInt(countNumber);
                algorithm.level1.setValuewhenChange(listPoint.get(countNumber - 1).x,
                        listPoint.get(countNumber - 1).y, listValue.get(number));
                listPoint.remove(countNumber - 1);
                listValue.remove(number);
                countNumber--;
            } while (countNumber > 0);
            for (int i = 2; i < 11; i++) {
                for (int j = 2; j < 18; j++) {
                    if (algorithm.level1.getValue(i, j) != 0) {
                        int a = algorithm.level1.getValue(i, j);
                        btn[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/imgpikachu/" + a + ".jpg")));
                    }
                }
            }
            Change();
        }
    }

    public void MyButtons() {

    }

    public void MyLabel() {
        layout.setSize(850, 600);
        layoutpikachu.setBackground(null);
        layoutpikachu.setSize(700, 400);
        diem.setLocation(600, -7);
        layouttroll.setVisible(false);
        layouttroll.setSize(300, 300);
        layouttroll.setLocation(250, 150);
        layouttroll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/troll.jpg")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layoutpikachu = new javax.swing.JPanel();
        newgame = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        time = new javax.swing.JLabel();
        score = new javax.swing.JButton();
        diem = new javax.swing.JLabel();
        hint = new javax.swing.JButton();
        progesstime = new javax.swing.JProgressBar();
        counthint = new javax.swing.JLabel();
        layouttroll = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        layout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout layoutpikachuLayout = new javax.swing.GroupLayout(layoutpikachu);
        layoutpikachu.setLayout(layoutpikachuLayout);
        layoutpikachuLayout.setHorizontalGroup(
            layoutpikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        layoutpikachuLayout.setVerticalGroup(
            layoutpikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        getContentPane().add(layoutpikachu);
        layoutpikachu.setBounds(130, 80, 410, 340);

        newgame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/new.png"))); // NOI18N
        newgame.setBorder(null);
        newgame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newgameActionPerformed(evt);
            }
        });
        getContentPane().add(newgame);
        newgame.setBounds(10, 150, 80, 30);

        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/pause.png"))); // NOI18N
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });
        getContentPane().add(pause);
        pause.setBounds(10, 190, 80, 30);

        time.setFont(new java.awt.Font("MV Boli", 0, 40)); // NOI18N
        time.setText("Time");
        getContentPane().add(time);
        time.setBounds(20, 0, 110, 50);

        score.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/score.png"))); // NOI18N
        score.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreActionPerformed(evt);
            }
        });
        getContentPane().add(score);
        score.setBounds(10, 230, 80, 30);

        diem.setFont(new java.awt.Font("MV Boli", 0, 40)); // NOI18N
        diem.setText("Score:0");
        getContentPane().add(diem);
        diem.setBounds(0, 20, 590, 65);

        hint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/hint.png"))); // NOI18N
        hint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintActionPerformed(evt);
            }
        });
        getContentPane().add(hint);
        hint.setBounds(10, 320, 80, 30);
        getContentPane().add(progesstime);
        progesstime.setBounds(130, 10, 450, 30);

        counthint.setFont(new java.awt.Font("MV Boli", 0, 20)); // NOI18N
        counthint.setText("3");
        getContentPane().add(counthint);
        counthint.setBounds(40, 340, 60, 40);
        getContentPane().add(layouttroll);
        layouttroll.setBounds(60, 320, 90, 110);

        level.setFont(new java.awt.Font("MV Boli", 0, 30)); // NOI18N
        level.setText("Level:1");
        getContentPane().add(level);
        level.setBounds(10, 80, 120, 40);

        layout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/Sleep-Pikachu-Pokemon-Wallpaper.png"))); // NOI18N
        getContentPane().add(layout);
        layout.setBounds(0, 0, 610, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreActionPerformed
        // TODO add your handling code here:
        scorerank sr = new scorerank();
        sr.setVisible(true);

    }//GEN-LAST:event_scoreActionPerformed

    private void newgameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newgameActionPerformed
        // TODO add your handling code here:

        int click = JOptionPane.showConfirmDialog(null, "Do you wanna play a new game", "Question", JOptionPane.YES_NO_OPTION);
        if (click == JOptionPane.YES_OPTION) {
            for (int i = 2; i < 11; i++) {
                for (int j = 2; j < 18; j++) {
                    btn[i][j].setBorder(null);
                }
            }
            total = 144;
            StaticFinalvariable.Level = 1;
            StaticFinalvariable.hintNumber = 3;
            StaticFinalvariable.TotalPoint = 0;
            level.setText("Level:" + StaticFinalvariable.Level);
            diem.setText("Score: " + StaticFinalvariable.TotalPoint);
            counthint.setText(String.valueOf(StaticFinalvariable.hintNumber));
            count = 100;
            progesstime.setValue((int) count);
            t.start();
            algorithm = new Algorithm();
            Change();
            for (int i = 2; i < 11; i++) {
                for (int j = 2; j < 18; j++) {
                    btn[i][j].setVisible(true);
                    int a = algorithm.level1.getValue(i, j);
                    btn[i][j].setActionCommand(i + "," + j);
                    btn[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/imgpikachu/" + a + ".jpg")));
                }
            }
        }
    }//GEN-LAST:event_newgameActionPerformed

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
        // TODO add your handling code here:
        blnPause = !blnPause;
        if (blnPause) {
            pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/resume.png")));
            layoutpikachu.setVisible(false);
            layouttroll.setVisible(true);
        } else {
            pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/pause.png")));
            layoutpikachu.setVisible(true);
            layouttroll.setVisible(false);
        }

    }//GEN-LAST:event_pauseActionPerformed

    private void hintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hintActionPerformed
        // TODO add your handling code here:
        if (StaticFinalvariable.hintNumber > 0) {
            p1 = null;
            p2 = null;
            for (int i = 2; i < 11; i++) {
                for (int j = 2; j < 18; j++) {
                    btn[i][j].setBorder(null);
                }
            }
            StaticFinalvariable.hintNumber--;
            int hint = 0;
            for (int i = 2; i < 11; i++) {
                for (int j = 2; j < 18; j++) {
                    if (algorithm.level1.getValue(i, j) != 0) {
                        for (int a = 2; a < 11; a++) {
                            for (int b = 2; b < 18; b++) {
                                if ((i != a || j != b) && algorithm.checkTwoPoint(new Point(i, j), new Point(a, b))) {
                                    btn[a][b].setBorder(new LineBorder(Color.red, 5));
                                    btn[i][j].setBorder(new LineBorder(Color.red, 5));
                                    System.out.println("(" + i + "," + j + ")," + "(" + a + "," + b + ")");
                                    hint++;
                                    counthint.setText(String.valueOf(StaticFinalvariable.hintNumber));
                                    break;
                                }
                            }
                            if (hint != 0) {
                                break;
                            }
                        }
                    }
                    if (hint != 0) {
                        break;
                    }
                }
                if (hint != 0) {
                    break;
                }
            }
        }
        if (StaticFinalvariable.hintNumber == 0) {
            hint.setEnabled(false);
            counthint.setVisible(false);
        }

    }//GEN-LAST:event_hintActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ingame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ingame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ingame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ingame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ingame().setVisible(true);
//
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel counthint;
    private javax.swing.JLabel diem;
    private javax.swing.JButton hint;
    private javax.swing.JLabel layout;
    private javax.swing.JPanel layoutpikachu;
    private javax.swing.JLabel layouttroll;
    private javax.swing.JLabel level;
    private javax.swing.JButton newgame;
    private javax.swing.JButton pause;
    private javax.swing.JProgressBar progesstime;
    private javax.swing.JButton score;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

}
