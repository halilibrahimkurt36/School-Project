/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import Helper.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.PasswordView;

/**
 *
 * @author Kerem
 */
public class LoginGUI extends javax.swing.JFrame {

    /**
     * Creates new form LoginGUI
     */
    public LoginGUI() {
        initComponents();
    }
   
    
    static Object[] managerData =new Object[7];
//0-id
//1-name
//2-tcno
//3-password
//4-branch
//5-gender
//6-type
public boolean accessManagerLogin(String tcno,String password){
     String query="SELECT * FROM teacher WHERE type='MÜDÜR' AND tcno='"+tcno+"'AND password='"+password+"'";
     boolean key=false;
        try {
           
            st=con.createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
                managerData[0]=rs.getInt("id");
                managerData[1]=rs.getString("name");
                managerData[2]=rs.getString("tcno");
                managerData[3]=rs.getString("password");
                managerData[4]=rs.getString("branch");
                managerData[5]=rs.getString("gender");
                managerData[6]=rs.getString("type");
                
                if(tcno.equals(managerData[2])&&password.equals(managerData[3])){
                key=true;
                }
                else{
                    key=false;
                  
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }if(key)
           return true;
        else 
            return false;
}

static Object[] teacherData =new Object[7];
public boolean accessTeacherLogin(String tcno,String password){
     String query="SELECT * FROM teacher WHERE type='ASİSTAN' AND tcno='"+tcno+"'AND password='"+password+"'";
     boolean key=false;
        try {
           
            st=con.createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
                teacherData[0]=rs.getInt("id");
                teacherData[1]=rs.getString("name");
                teacherData[2]=rs.getString("tcno");
                teacherData[3]=rs.getString("password");
                teacherData[4]=rs.getString("branch");
                teacherData[5]=rs.getString("gender");
                teacherData[6]=rs.getString("type");
                
                if(tcno.equals(teacherData[2])&&password.equals(teacherData[3])){
                key=true;
              
                }
                else{
                    key=false;
                  
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }if(key)
           return true;
        else 
            return false;
}


static Object[] studentData=new Object[7];
public boolean accessStudentLogin(String tcno,String password){
        boolean key=false;
        try {
            String query="SELECT*FROM student WHERE tcno='"+tcno+"'AND password='"+password+"'";
            st=con.createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
                studentData[0]=rs.getInt("id");
                studentData[1]=rs.getString("name");
                studentData[2]=rs.getString("tcno");
                studentData[3]=rs.getString("password");
                studentData[4]=rs.getString("shNumber");
                studentData[5]=rs.getString("classes");
                studentData[6]=rs.getString("gender");
               
                
                if(tcno.equals(studentData[2])&&password.equals(studentData[3])){
                     key=true;
                }
                else{
                    key=false;
                }
                }
        } catch (SQLException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    if(key)
        return true;
    else
        return false;
}
   /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        RightPanel = new javax.swing.JPanel();
        LoginTabMenu = new javax.swing.JTabbedPane();
        LoginTeacherTab = new javax.swing.JPanel();
        lgnTeachTcnoLbl = new javax.swing.JLabel();
        lgnTeachPassLbl = new javax.swing.JLabel();
        lgnTeachTcnoTxt = new javax.swing.JTextField();
        lgnTeachBtn = new javax.swing.JButton();
        lgnTeachPassFld = new javax.swing.JPasswordField();
        lgnTeachIcon2Lbl = new javax.swing.JLabel();
        lgnTeachIcon1Lbl = new javax.swing.JLabel();
        lgnTeachCB = new javax.swing.JCheckBox();
        LoginStudentTab = new javax.swing.JPanel();
        lgnStuTcnoLbl = new javax.swing.JLabel();
        lgnStuIcon1Lbl = new javax.swing.JLabel();
        lgnStuTcnoTxt = new javax.swing.JTextField();
        lgnStuPassLbl = new javax.swing.JLabel();
        lgnStuIcon2Lbl = new javax.swing.JLabel();
        lgnStuPassFld = new javax.swing.JPasswordField();
        lgnStuBtn = new javax.swing.JButton();
        lgnTeachCB1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN_GUI");
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPanel.setBackground(new java.awt.Color(153, 0, 0));
        MainPanel.setMinimumSize(new java.awt.Dimension(600, 400));
        MainPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        leftPanel.setBackground(new java.awt.Color(255, 0, 0));
        leftPanel.setPreferredSize(new java.awt.Dimension(300, 400));
        leftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIs/Images/logo.png"))); // NOI18N
        leftPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 150, 150));

        MainPanel.add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        RightPanel.setMinimumSize(new java.awt.Dimension(300, 400));
        RightPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        MainPanel.add(RightPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

        LoginTabMenu.setBackground(new java.awt.Color(153, 0, 0));
        LoginTabMenu.setForeground(new java.awt.Color(255, 255, 255));
        LoginTabMenu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LoginTabMenu.setOpaque(true);

        LoginTeacherTab.setBackground(new java.awt.Color(153, 0, 0));
        LoginTeacherTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lgnTeachTcnoLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lgnTeachTcnoLbl.setText("T.C. KİMLİK NUMARASI");
        LoginTeacherTab.add(lgnTeachTcnoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 200, 30));

        lgnTeachPassLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lgnTeachPassLbl.setText("ŞİFRE");
        LoginTeacherTab.add(lgnTeachPassLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 200, 30));

        lgnTeachTcnoTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LoginTeacherTab.add(lgnTeachTcnoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 200, 30));

        lgnTeachBtn.setBackground(new java.awt.Color(0, 0, 0));
        lgnTeachBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lgnTeachBtn.setForeground(new java.awt.Color(255, 255, 255));
        lgnTeachBtn.setText("GİRİŞ");
        lgnTeachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lgnTeachBtnActionPerformed(evt);
            }
        });
        LoginTeacherTab.add(lgnTeachBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 200, 30));

        lgnTeachPassFld.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LoginTeacherTab.add(lgnTeachPassFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 200, 30));

        lgnTeachIcon2Lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lgnTeachIcon2Lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIs/Images/icons8_grand_master_key_32px.png"))); // NOI18N
        LoginTeacherTab.add(lgnTeachIcon2Lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 40, 30));

        lgnTeachIcon1Lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lgnTeachIcon1Lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIs/Images/icons8_collaborator_male_32px.png"))); // NOI18N
        LoginTeacherTab.add(lgnTeachIcon1Lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 40, 30));

        lgnTeachCB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lgnTeachCB.setText("Şifreyi Göster");
        lgnTeachCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lgnTeachCBActionPerformed(evt);
            }
        });
        LoginTeacherTab.add(lgnTeachCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        LoginTabMenu.addTab("Öğretmen Girişi", LoginTeacherTab);

        LoginStudentTab.setBackground(new java.awt.Color(153, 0, 0));
        LoginStudentTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lgnStuTcnoLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lgnStuTcnoLbl.setText("T.C. KİMLİK NUMARASI");
        LoginStudentTab.add(lgnStuTcnoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 200, 30));

        lgnStuIcon1Lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lgnStuIcon1Lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIs/Images/icons8_collaborator_male_32px.png"))); // NOI18N
        LoginStudentTab.add(lgnStuIcon1Lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 40, 30));

        lgnStuTcnoTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LoginStudentTab.add(lgnStuTcnoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 200, 30));

        lgnStuPassLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lgnStuPassLbl.setText("ŞİFRE");
        LoginStudentTab.add(lgnStuPassLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 200, 30));

        lgnStuIcon2Lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lgnStuIcon2Lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIs/Images/icons8_grand_master_key_32px.png"))); // NOI18N
        LoginStudentTab.add(lgnStuIcon2Lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 40, 30));

        lgnStuPassFld.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LoginStudentTab.add(lgnStuPassFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 200, 30));

        lgnStuBtn.setBackground(new java.awt.Color(0, 0, 0));
        lgnStuBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lgnStuBtn.setForeground(new java.awt.Color(255, 255, 255));
        lgnStuBtn.setText("GİRİŞ");
        lgnStuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lgnStuBtnActionPerformed(evt);
            }
        });
        LoginStudentTab.add(lgnStuBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 200, 30));

        lgnTeachCB1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lgnTeachCB1.setText("Şifreyi Göster");
        lgnTeachCB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lgnTeachCB1ActionPerformed(evt);
            }
        });
        LoginStudentTab.add(lgnTeachCB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        LoginTabMenu.addTab("Öğrenci Girişi", LoginStudentTab);

        MainPanel.add(LoginTabMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 300, 380));

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lgnTeachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lgnTeachBtnActionPerformed
               
        boolean control=accessTeacherLogin(lgnTeachTcnoTxt.getText(),lgnTeachPassFld.getText());
        boolean control2=accessManagerLogin(lgnTeachTcnoTxt.getText(),lgnTeachPassFld.getText());
        if(lgnTeachTcnoTxt.getText().equals("")||lgnTeachPassFld.getText().equals("")){
           Helper.OptionPane.showMessage("fill");
       }
        else{
            if(control==true){
                try {
                    st=con.createStatement(); 
                    rs=st.executeQuery("SELECT*FROM teacher WHERE type='ASİSTAN'");
               while(rs.next()){
                    Helper.OptionPane.showMessage("Hoşgeldiniz SAYIN "+ teacherData[1] );
                      break;
               }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
               lgnTeachTcnoTxt.setText(null);
               lgnTeachPassFld.setText(null);
               TeacherGUI tGUI=new TeacherGUI();
               tGUI.setVisible(true);
               dispose();
               }
              
                 
          
        else if(control2==true){
            
            try {
                    st=con.createStatement(); 
                    rs=st.executeQuery("SELECT*FROM teacher WHERE type='MÜDÜR'");
               while(rs.next()){
                    Helper.OptionPane.showMessage("Hoşgeldiniz SAYIN "+ managerData[1] );
                      break;
               }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            lgnTeachTcnoTxt.setText(null);
            lgnTeachPassFld.setText(null);
            
            ManagerGUI MGui=new ManagerGUI();
            MGui.setVisible(true);
            dispose();
            }
        
                else{
                Helper.OptionPane.showMessage("wrongPassword");
                }
        }
    }//GEN-LAST:event_lgnTeachBtnActionPerformed

    private void lgnTeachCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lgnTeachCBActionPerformed
        if(lgnTeachCB.isSelected()){
            lgnTeachPassFld.setEchoChar((char) 0 );
                }
        else{
            lgnTeachPassFld.setEchoChar('*');
        }
    }//GEN-LAST:event_lgnTeachCBActionPerformed

    private void lgnStuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lgnStuBtnActionPerformed
       boolean control=accessStudentLogin(lgnStuTcnoTxt.getText(), lgnStuPassFld.getText());
        if(lgnStuTcnoTxt.getText().equals("")||lgnStuPassFld.getText().equals("")){
            Helper.OptionPane.showMessage("fill");
        }
        else{
            if(control==true){
                
                    try {
                    st=con.createStatement(); 
                    rs=st.executeQuery("SELECT*FROM student");
               while(rs.next()){
                    Helper.OptionPane.showMessage("Hoşgeldiniz SAYIN "+ studentData[1] );
                    break;
               }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                lgnStuTcnoTxt.setText(null);
                lgnStuPassFld.setText(null);
                StudentGUI sGUI = new StudentGUI();
                sGUI.setVisible(true);
                dispose();
                }
            
            else{
                Helper.OptionPane.showMessage("wrongPassword");
            }
        }
    }//GEN-LAST:event_lgnStuBtnActionPerformed

    private void lgnTeachCB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lgnTeachCB1ActionPerformed
         if(lgnTeachCB1.isSelected()){
            lgnStuPassFld.setEchoChar((char) 0 );
                }
        else{
            lgnStuPassFld.setEchoChar('*');
        }
    }//GEN-LAST:event_lgnTeachCB1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoginStudentTab;
    private javax.swing.JTabbedPane LoginTabMenu;
    private javax.swing.JPanel LoginTeacherTab;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton lgnStuBtn;
    private javax.swing.JLabel lgnStuIcon1Lbl;
    private javax.swing.JLabel lgnStuIcon2Lbl;
    private javax.swing.JPasswordField lgnStuPassFld;
    private javax.swing.JLabel lgnStuPassLbl;
    private javax.swing.JLabel lgnStuTcnoLbl;
    private javax.swing.JTextField lgnStuTcnoTxt;
    private javax.swing.JButton lgnTeachBtn;
    private javax.swing.JCheckBox lgnTeachCB;
    private javax.swing.JCheckBox lgnTeachCB1;
    private javax.swing.JLabel lgnTeachIcon1Lbl;
    private javax.swing.JLabel lgnTeachIcon2Lbl;
    private javax.swing.JPasswordField lgnTeachPassFld;
    private javax.swing.JLabel lgnTeachPassLbl;
    private javax.swing.JLabel lgnTeachTcnoLbl;
    private javax.swing.JTextField lgnTeachTcnoTxt;
    // End of variables declaration//GEN-END:variables
     private DBConnection conn=new DBConnection();
   private Connection con=conn.connDB();
   private Statement st=null;
   private ResultSet rs=null;
   private PreparedStatement pt=null;
   // ImageIcon teachMan = new ImageIcon("/yerkek.png");
   // ImageIcon teachWoman = new ImageIcon("/ykadin.png");
   // ImageIcon stuMan = new ImageIcon("erkek.png");
   // ImageIcon stuWoman = new ImageIcon("kadin.png");



}
