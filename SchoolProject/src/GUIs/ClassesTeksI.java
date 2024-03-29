/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUIs;

import Helper.DBConnection;
import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kerem
 */
public class ClassesTeksI extends javax.swing.JInternalFrame {

    /**
     * Creates new form ClassesTeksI
     */
    public ClassesTeksI() {
        initComponents();
          this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        
        
       teksData=new Object[4];
       teksModel=(DefaultTableModel) TeksTable.getModel();
       for(int i=0;i<getClassesTekslist().size();i++){
           teksData[0]=getClassesTekslist().get(i).getId();
           teksData[1]=getClassesTekslist().get(i).getName();
           teksData[2]=getClassesTekslist().get(i).getshNumber();
           teksData[3]=getClassesTekslist().get(i).getClasses();
           teksModel.addRow(teksData);
           
       }
    }
    public ArrayList<Student> getClassesTekslist(){
        ArrayList<Student> list =new ArrayList<>();
            Student obj;
        try {
            
            String query="SELECT*FROM student WHERE classes='Tekstil'";
            st=con.createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
                obj=new Student(rs.getInt("id"),rs.getString("name"),rs.getString("tcno"),rs.getString("password"),rs.getString("shNumber"),rs.getString("classes"),rs.getString("gender"));
                list.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassesI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TeksPnl = new javax.swing.JPanel();
        Teks = new javax.swing.JScrollPane();
        TeksTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 51, 51));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TeksPnl.setBackground(new java.awt.Color(255, 51, 51));
        TeksPnl.setPreferredSize(new java.awt.Dimension(500, 400));

        Teks.setBackground(new java.awt.Color(255, 51, 51));

        TeksTable.setBackground(new java.awt.Color(255, 51, 51));
        TeksTable.setForeground(new java.awt.Color(255, 255, 255));
        TeksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Adı Soyadı", "Okul NO", "Sınıf"
            }
        ));
        Teks.setViewportView(TeksTable);

        javax.swing.GroupLayout TeksPnlLayout = new javax.swing.GroupLayout(TeksPnl);
        TeksPnl.setLayout(TeksPnlLayout);
        TeksPnlLayout.setHorizontalGroup(
            TeksPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeksPnlLayout.createSequentialGroup()
                .addComponent(Teks, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 110, Short.MAX_VALUE))
        );
        TeksPnlLayout.setVerticalGroup(
            TeksPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Teks, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        getContentPane().add(TeksPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Teks;
    private javax.swing.JPanel TeksPnl;
    private javax.swing.JTable TeksTable;
    // End of variables declaration//GEN-END:variables
    Object[] teksData=null;
    DefaultTableModel teksModel=null;
    
    private DBConnection conn=new DBConnection();
    private  Connection con=conn.connDB();
    private  Statement st=null;
    private   ResultSet rs=null;
    private   PreparedStatement pt=null;
}
