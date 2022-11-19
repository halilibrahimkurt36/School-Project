/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUIs;

import static GUIs.LoginGUI.studentData;
import Helper.DBConnection;
import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kerem
 */
public class StuChangePassI extends javax.swing.JInternalFrame {

    /**
     * Creates new form StuChangePassI
     */
    public StuChangePassI() {
        initComponents();
     this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
    }
    
    public void changeStuPass(int id,String yeni){
         try {
                    st=con.createStatement();
                    pt=con.prepareStatement("UPDATE student SET password=? WHERE id=? ");
                    pt.setString(1, yeni);
                    pt.setInt(2, id);
                    pt.executeUpdate();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(TeachChangePassI.class.getName()).log(Level.SEVERE, null, ex);
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

        stuMainPnl = new javax.swing.JPanel();
        stuOldPassLbl = new javax.swing.JLabel();
        stuOldPassTxt = new javax.swing.JTextField();
        stuNewPassLbl = new javax.swing.JLabel();
        stuNewPassAgainLbl = new javax.swing.JLabel();
        stuNewPassTxt = new javax.swing.JTextField();
        stuNewPassAgainTxt = new javax.swing.JTextField();
        stuChangeBtn = new javax.swing.JButton();
        stuLock3 = new javax.swing.JLabel();
        stuLock1 = new javax.swing.JLabel();
        stuLock2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 0, 0));
        setNormalBounds(new java.awt.Rectangle(0, 0, 100, 200));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stuMainPnl.setBackground(new java.awt.Color(51, 0, 0));
        stuMainPnl.setPreferredSize(new java.awt.Dimension(500, 400));
        stuMainPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stuOldPassLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        stuOldPassLbl.setForeground(new java.awt.Color(255, 255, 255));
        stuOldPassLbl.setText("Eski Şifre");
        stuMainPnl.add(stuOldPassLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 200, 30));

        stuOldPassTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        stuOldPassTxt.setForeground(new java.awt.Color(102, 0, 0));
        stuMainPnl.add(stuOldPassTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 200, 30));

        stuNewPassLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        stuNewPassLbl.setForeground(new java.awt.Color(255, 255, 255));
        stuNewPassLbl.setText("Yeni Şifre");
        stuMainPnl.add(stuNewPassLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 200, 30));

        stuNewPassAgainLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        stuNewPassAgainLbl.setForeground(new java.awt.Color(255, 255, 255));
        stuNewPassAgainLbl.setText("Yeni Şifre Tekrar");
        stuMainPnl.add(stuNewPassAgainLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 200, 30));

        stuNewPassTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        stuNewPassTxt.setForeground(new java.awt.Color(102, 0, 0));
        stuMainPnl.add(stuNewPassTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 200, 30));

        stuNewPassAgainTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        stuNewPassAgainTxt.setForeground(new java.awt.Color(102, 0, 0));
        stuMainPnl.add(stuNewPassAgainTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 200, 30));

        stuChangeBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        stuChangeBtn.setText("DEĞİŞTİR");
        stuChangeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuChangeBtnActionPerformed(evt);
            }
        });
        stuMainPnl.add(stuChangeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 200, 30));

        stuLock3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stuLock3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIs/Images/icons8_lock_32px.png"))); // NOI18N
        stuMainPnl.add(stuLock3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 60, 50));

        stuLock1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stuLock1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIs/Images/icons8_lock_32px.png"))); // NOI18N
        stuMainPnl.add(stuLock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 60, 50));

        stuLock2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stuLock2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIs/Images/icons8_lock_32px.png"))); // NOI18N
        stuMainPnl.add(stuLock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 60, 50));

        getContentPane().add(stuMainPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stuChangeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuChangeBtnActionPerformed
        if(stuOldPassTxt.getText().equals("")||stuNewPassTxt.getText().equals("")||stuNewPassAgainTxt.getText().equals("")){
            Helper.OptionPane.showMessage("fill");
        }
        else{

            if(stuOldPassTxt.getText().equals(studentData[3])){
                if(stuNewPassTxt.getText().equals(stuNewPassAgainTxt.getText())){
                     Helper.OptionPane.showMessage("success");
                        changeStuPass((int) studentData[0],stuNewPassTxt.getText());
                    try {
                       
                        st=con.createStatement();
                        rs=st.executeQuery("SELECT*FROM student WHERE tcno="+studentData[2]);
                        while(rs.next()){
                            studentData[3]=rs.getString("password");
                        }
                        
                        stuOldPassTxt.setText(null);
                        stuNewPassTxt.setText(null);
                        stuNewPassAgainTxt.setText(null);
              
                    } catch (SQLException ex) {
                        Logger.getLogger(StuChangePassI.class.getName()).log(Level.SEVERE, null, ex);
                    }
           
                }
                

                else{
                    JOptionPane.showMessageDialog(null, "Yeni Şifre ile Tekrar Girilen Şifre Eşleşmiyor","HATA!",JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Eski Şifre Yanlış","HATA!",JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_stuChangeBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton stuChangeBtn;
    private javax.swing.JLabel stuLock1;
    private javax.swing.JLabel stuLock2;
    private javax.swing.JLabel stuLock3;
    private javax.swing.JPanel stuMainPnl;
    private javax.swing.JLabel stuNewPassAgainLbl;
    private javax.swing.JTextField stuNewPassAgainTxt;
    private javax.swing.JLabel stuNewPassLbl;
    private javax.swing.JTextField stuNewPassTxt;
    private javax.swing.JLabel stuOldPassLbl;
    private javax.swing.JTextField stuOldPassTxt;
    // End of variables declaration//GEN-END:variables
    private DBConnection conn=new DBConnection();
    private  Connection con=conn.connDB();
    private  Statement st=null;
    private   ResultSet rs=null;
    private   PreparedStatement pt=null;
    LoginGUI lGUI=new LoginGUI();
    StudentGUI sGUI=new StudentGUI();
    Student student=new Student();
   
}
