/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pikachu;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thang
 */
public class scoreall extends javax.swing.JFrame {

    /**
     * Creates new form scoreall
     */
    private String url;
    private final String user = "admin";
    private final String password = "123456";
    java.sql.Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pStmt = null;
    DefaultTableModel model;
    InetAddress ip;

    public scoreall() {
        initComponents();
        setSize(300, 400);
        setTitle("High Score");
        setResizable(false);
        setLocationRelativeTo(null);
        jTable1.setSize(200, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jTable1.setLocation(50,50);
        showData();

    }

    private void showData() {
        model = new DefaultTableModel();
        model.addColumn("Rank");
        model.addColumn("Username");
        model.addColumn("Score");
        jTable1.setModel(model);
        jTable1.setAutoCreateRowSorter(true);
        loadDataFromDB();
    }

    void loadDataFromDB() {
        try {
            ip = InetAddress.getLocalHost();
            url = "jdbc:mysql://"+ip.getHostAddress()+"/scorerank?useSSL=false";
            connection = DriverManager.getConnection(url, user, password);
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select ten,diem from diem order by diem desc limit 10");
            int i=1;
            while (rs.next()) {
                Object rows[] = new Object[3];
                rows[0] = i++;
                rows[1] = rs.getString(1);
                rows[2] = rs.getString(2);
                model.addRow(rows);
            }
        } catch (SQLException ex) {
            Logger.getLogger(scorerank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(scorerank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
