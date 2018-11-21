/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pikachu;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.InetAddress;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Thang
 */
public class InGame extends javax.swing.JFrame implements ActionListener {

    private JLayeredPane pane;
    private DrawLine drawLine;
    private Algorithm algorithm;
    private JButton[][] btn;
    private static int total = 144;
    private Point p1 = null;
    private Point p2 = null;
    private boolean blnPause;
    private int count = 100;
    private Timer t;
    private GridLayout grid;
    private String url;
    private final String user = "admin";
    private final String password = "123456";
    java.sql.Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pStmt = null;
    InetAddress ip;

    /*
     * Creates new form ingame
     */
    public InGame() {
        initComponents();
        setSize(1000, 600);
        setResizable(false);
        setTitle("Pikachu Game");
        setLocationRelativeTo(null);
        MyGridLayout();
        MyLabel();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(InGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        progessTime.setValue((int) count);
        t = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!blnPause) {
                    count = count - 1;
                    progessTime.setValue(count);
                }
                if (count == 0) {
                    try {
                        ip = InetAddress.getLocalHost();
                        url = "jdbc:mysql://" + ip.getHostAddress() + "/scorerank?useSSL=false";
                        connection = DriverManager
                                .getConnection(url, user, password);
                        String sql = "INSERT INTO diem(ten,diem) VALUES(?,?);";
                        pStmt = connection.prepareStatement(sql);
                        pStmt.setString(1, StaticFinalvariable.user.getUser());
                        pStmt.setInt(2, StaticFinalvariable.TotalPoint);
                        pStmt.executeUpdate();
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, error);
                    }
                    int click = JOptionPane.showConfirmDialog(null, "\t"
                            + "You Lose!!!!\n"
                            + "Do you wanna play again?", "Question", JOptionPane.YES_NO_OPTION);
                    if (click == JOptionPane.YES_OPTION) {
                        count = 100;
                        progessTime.setValue((int) count);
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
        layoutPikachu.removeAll();
        algorithm = new Algorithm();
        Change();
        btn = new JButton[13][20];

        grid = new GridLayout(11, 18, 2, 2);
        layoutPikachu.setLayout(grid);
        for (int i = 1; i < 12; i++) {
            for (int j = 1; j < 19; j++) {
                btn[i][j] = new JButton();
                if (i == 1 || i == 11 || j == 1 || j == 18) {
                    btn[i][j].setVisible(false);
                } else {
                    int a = algorithm.level1.getValue(i, j);
                    btn[i][j].setActionCommand(i + "," + j);
                    btn[i][j].addActionListener(this);
                    btn[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/imgpikachu/" + a + ".jpg")));
                }

                layoutPikachu.add(btn[i][j]);
            }
        }

        layoutPikachu.setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StaticFinalvariable.p1 = null;
        StaticFinalvariable.p2 = null;
        StaticFinalvariable.p3 = null;
        StaticFinalvariable.p4 = null;
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
            int countBorder = 0;
            for (int i = 2; i < 11; i++) {
                for (int j = 2; j < 18; j++) {
                    if (btn[i][j].getBorder() != null) {
                        countBorder++;
                    }
                }
            }
            if (countBorder > 1) {
                for (int i = 2; i < 11; i++) {
                    for (int j = 2; j < 18; j++) {
                        btn[i][j].setBorder(null);
                    }
                }
            }
            countBorder = 0;
            p2 = new Point(x, y);
            if (algorithm.checkTwoPoint(p1, p2) && !p1.equals(p2)) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Point point1 = null;
                        Point point2 = null;
                        Point point3 = null;
                        Point point4 = null;

                        point1 = btn[StaticFinalvariable.p1.x][StaticFinalvariable.p1.y].getLocation();
                        point2 = btn[StaticFinalvariable.p2.x][StaticFinalvariable.p2.y].getLocation();
                        if (StaticFinalvariable.p3 != null) {
                            point3 = btn[StaticFinalvariable.p3.x][StaticFinalvariable.p3.y].getLocation();
                        }
                        if (StaticFinalvariable.p4 != null) {
                            point4 = btn[StaticFinalvariable.p4.x][StaticFinalvariable.p4.y].getLocation();
                        }
                        if (point3 == null && point4 == null) {
                            drawLine = new DrawLine(point1, point2);
                        } else if (point4 == null) {
                            drawLine = new DrawLine(point1, point2, point3);
                        } else {
                            drawLine = new DrawLine(point1, point2, point3, point4);
                        }

                        drawLine.setSize(800, 500);
                        drawLine.setBounds(130, 50, 930, 580);
                        drawLine.setOpaque(false);
                        pane.add(drawLine, new Integer(2));

                        try {
                            Thread.sleep(300);
                            drawLine.setVisible(false);
                            pane.remove(drawLine);

                        } catch (InterruptedException ex) {
                            Logger.getLogger(InGame.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                });
                thread.start();
                Toolkit.getDefaultToolkit().beep();
                btn[p2.x][p2.y].setBorder(new LineBorder(Color.red, 5));
                total -= 2;
                StaticFinalvariable.TotalPoint += 10;
                Score.setText("Score: " + StaticFinalvariable.TotalPoint);
                algorithm.settohide(p1, p2);
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

            } else {
               
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
            Score.setText("Score: " + StaticFinalvariable.TotalPoint);
            StaticFinalvariable.Level++;
            if (StaticFinalvariable.Level <= 3) {
                level.setText("Level:" + StaticFinalvariable.Level);
                layout.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/pikachu/image/" + StaticFinalvariable.Level + ".jpg")).getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT)));
                total = 144;
                count = 100;
                progessTime.setValue((int) count);
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
                try {
                    ip = InetAddress.getLocalHost();
                    url = "jdbc:mysql://" + ip.getHostAddress() + "/scorerank?useSSL=false";
                    connection = DriverManager
                            .getConnection(url, user, password);
                    String sql = "INSERT INTO diem(ten,diem) VALUES(?,?);";
                    pStmt = connection.prepareStatement(sql);
                    pStmt.setString(1, StaticFinalvariable.user.getUser());
                    pStmt.setInt(2, StaticFinalvariable.TotalPoint);
                    pStmt.executeUpdate();
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, error);
                }
                victory.setVisible(true);
                int click = JOptionPane.showConfirmDialog(null, "\tYou Win\n"
                        + "Do you wanna play again?", "Question", JOptionPane.YES_NO_OPTION);
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
                    Score.setText("Score: " + StaticFinalvariable.TotalPoint);
                    countHint.setText(String.valueOf(StaticFinalvariable.hintNumber));
                    count = 100;
                    progessTime.setValue((int) count);
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

    public void MyLabel() {
        pane = getLayeredPane();
        time.setLocation(180, 0);
        progessTime.setLocation(280, 10);
        victory.setSize(600, 400);
        victory.setLocation(150, 150);
        victory.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/pikachu/image/phaohoa.gif")).getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT)));
        victory.setVisible(false);
        name.setText(StaticFinalvariable.user.getUser());
        name.setLocation(40, 210);
        level.setLocation(20, 5);
        avatar.setSize(100, 100);
        avatar.setLocation(30, 100);
        avatar.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(StaticFinalvariable.user.getLink())).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        layout.setSize(1000, 600);
        layout.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/pikachu/image/Sleep-Pikachu-Pokemon-Wallpaper.png")).getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT)));
        layoutPikachu.setBackground(null);
        layoutPikachu.setSize(800, 500);
        Score.setLocation(750, -7);
        pane.add(layoutPikachu, new Integer(1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layoutPikachu = new javax.swing.JPanel();
        newGame = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        time = new javax.swing.JLabel();
        score = new javax.swing.JButton();
        Score = new javax.swing.JLabel();
        hint = new javax.swing.JButton();
        progessTime = new javax.swing.JProgressBar();
        countHint = new javax.swing.JLabel();
        layoutTroll = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        avatar = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        victory = new javax.swing.JLabel();
        layout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        javax.swing.GroupLayout layoutPikachuLayout = new javax.swing.GroupLayout(layoutPikachu);
        layoutPikachu.setLayout(layoutPikachuLayout);
        layoutPikachuLayout.setHorizontalGroup(
            layoutPikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        layoutPikachuLayout.setVerticalGroup(
            layoutPikachuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        getContentPane().add(layoutPikachu);
        layoutPikachu.setBounds(130, 50, 410, 340);

        newGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/new.png"))); // NOI18N
        newGame.setBorder(null);
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        getContentPane().add(newGame);
        newGame.setBounds(30, 280, 80, 30);

        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/pause.png"))); // NOI18N
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });
        getContentPane().add(pause);
        pause.setBounds(30, 320, 80, 30);

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
        score.setBounds(30, 360, 80, 30);

        Score.setFont(new java.awt.Font("MV Boli", 0, 40)); // NOI18N
        Score.setText("Score:0");
        getContentPane().add(Score);
        Score.setBounds(0, 20, 590, 65);

        hint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/hint.png"))); // NOI18N
        hint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hintMouseClicked(evt);
            }
        });
        hint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintActionPerformed(evt);
            }
        });
        getContentPane().add(hint);
        hint.setBounds(30, 400, 80, 30);
        getContentPane().add(progessTime);
        progessTime.setBounds(130, 10, 450, 30);

        countHint.setFont(new java.awt.Font("MV Boli", 0, 20)); // NOI18N
        countHint.setText("3");
        getContentPane().add(countHint);
        countHint.setBounds(60, 430, 60, 40);
        getContentPane().add(layoutTroll);
        layoutTroll.setBounds(50, 320, 90, 110);

        level.setFont(new java.awt.Font("MV Boli", 0, 40)); // NOI18N
        level.setText("Level:1");
        getContentPane().add(level);
        level.setBounds(10, 80, 160, 40);
        getContentPane().add(avatar);
        avatar.setBounds(10, 380, 80, 70);

        name.setFont(new java.awt.Font("MV Boli", 0, 20)); // NOI18N
        getContentPane().add(name);
        name.setBounds(10, 450, 60, 30);
        getContentPane().add(victory);
        victory.setBounds(360, 50, 0, 0);

        layout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/Sleep-Pikachu-Pokemon-Wallpaper.png"))); // NOI18N
        getContentPane().add(layout);
        layout.setBounds(0, 0, 610, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreActionPerformed
        // TODO add your handling code here:
        ScoreRank sr = new ScoreRank();
        sr.setVisible(true);
    }//GEN-LAST:event_scoreActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
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
            Score.setText("Score: " + StaticFinalvariable.TotalPoint);
            countHint.setText(String.valueOf(StaticFinalvariable.hintNumber));
            count = 100;
            progessTime.setValue((int) count);
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
    }//GEN-LAST:event_newGameActionPerformed

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
        // TODO add your handling code here:
        blnPause = !blnPause;
        if (blnPause) {
            pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/resume.png")));
            layoutPikachu.setVisible(false);
            layoutTroll.setVisible(true);
        } else {
            pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu/image/pause.png")));
            layoutPikachu.setVisible(true);
            layoutTroll.setVisible(false);
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
                                    countHint.setText(String.valueOf(StaticFinalvariable.hintNumber));
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
            countHint.setVisible(false);
        }

    }//GEN-LAST:event_hintActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        int click = JOptionPane.showConfirmDialog(this, "Do you wanna exit game?", "Question", JOptionPane.YES_NO_OPTION);
        if (click == JOptionPane.YES_OPTION) {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
        if (click == JOptionPane.NO_OPTION) {

        }
    }//GEN-LAST:event_formWindowClosing

    private void hintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hintMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_hintMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Score;
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel countHint;
    private javax.swing.JButton hint;
    private javax.swing.JLabel layout;
    private javax.swing.JPanel layoutPikachu;
    private javax.swing.JLabel layoutTroll;
    private javax.swing.JLabel level;
    private javax.swing.JLabel name;
    private javax.swing.JButton newGame;
    private javax.swing.JButton pause;
    private javax.swing.JProgressBar progessTime;
    private javax.swing.JButton score;
    private javax.swing.JLabel time;
    private javax.swing.JLabel victory;
    // End of variables declaration//GEN-END:variables

}
