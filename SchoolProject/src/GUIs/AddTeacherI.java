/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUIs;


import Helper.DBConnection;
import Model.Teacher;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kerem
 */
public class AddTeacherI extends javax.swing.JInternalFrame {
static Teacher teacher=new Teacher();
    /**
     * Creates new form AddTeacherI
     */
    public AddTeacherI() {
        initComponents();
         this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        
        

       
         teachData=new Object[6];
            teachModel=(DefaultTableModel) tGuiTable.getModel();
            for(int i=0;i<teacher.getTeacherList().size();i++){
            teachData[0]=teacher.getTeacherList().get(i).getId();
            teachData[1]=teacher.getTeacherList().get(i).getName();
            teachData[2]=teacher.getTeacherList().get(i).getTcno();
            teachData[3]=teacher.getTeacherList().get(i).getPassword();
            teachData[4]=teacher.getTeacherList().get(i).getBranch();
            teachModel.addRow(teachData);
            
            teachSel();
            comboxLesson();
            }
            teacherSelUpdate();
    }
    
    public void comboxLesson(){
            try {
        st=con.createStatement();
        rs=st.executeQuery("SELECT*FROM lesson");
        while(rs.next()){
        mGuiAddBranchCB.addItem(rs.getString("lessonName"));
    }
    }catch (SQLException ex) {
        Logger.getLogger(AddTeacherI.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void updateTeachTable(){
    DefaultTableModel clearTable=(DefaultTableModel) tGuiTable.getModel();
    clearTable.setRowCount(0);
    for(int i=0;i<teacher.getTeacherList().size();i++){
            teachData[0]=teacher.getTeacherList().get(i).getId();
            teachData[1]=teacher.getTeacherList().get(i).getName();
            teachData[2]=teacher.getTeacherList().get(i).getTcno();
            teachData[3]=teacher.getTeacherList().get(i).getPassword();
            teachData[4]=teacher.getTeacherList().get(i).getBranch();
            teachModel.addRow(teachData);
        }
}
    
    
    public void teachSel(){
        tGuiTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try{
                    teachLbl.setVisible(false);
               teachLbl.setText(tGuiTable.getValueAt(tGuiTable.getSelectedRow(), 0).toString()) ;
            }catch(Exception ex){
            }  
            }
        });
    }
    
    
    
  public void teacherSelUpdate(){
        tGuiTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if(e.getType()==TableModelEvent.UPDATE){
                    int selID=Integer.parseInt(tGuiTable.getValueAt(tGuiTable.getSelectedRow(), 0).toString());
                String selName=tGuiTable.getValueAt(tGuiTable.getSelectedRow(), 1).toString();
               
                String selTcno=tGuiTable.getValueAt(tGuiTable.getSelectedRow(), 2).toString();
                 String selPass=tGuiTable.getValueAt(tGuiTable.getSelectedRow(), 3).toString();
                String selBranch=tGuiTable.getValueAt(tGuiTable.getSelectedRow(), 4).toString();
               
                teacher.updateTeacher(selID,selName, selTcno,selPass,selBranch);
                }
                
            }
                
            
                
        });
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        addTeachPnl = new javax.swing.JPanel();
        mGuiAddTeachNameTxt = new javax.swing.JTextField();
        mGuiAddTeachBranchLbl = new javax.swing.JLabel();
        mGuiAddTeachMangerRB = new javax.swing.JRadioButton();
        mGuiAddTeachWomanRB = new javax.swing.JRadioButton();
        mGuiAddTeachNameLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tGuiTable = new javax.swing.JTable();
        mGuiAddTeachBtn = new javax.swing.JButton();
        mGuiAddTeachTcnoLbl = new javax.swing.JLabel();
        mGuiAddTeachPassLbl = new javax.swing.JLabel();
        mGuiAddTeachTcnoTxt = new javax.swing.JTextField();
        mGuiAddTeachPassTxt = new javax.swing.JTextField();
        mGuiAddTeachManRB = new javax.swing.JRadioButton();
        mGuiAddTeachAkaRB = new javax.swing.JRadioButton();
        mGuiDelTeachBtn = new javax.swing.JButton();
        teachLbl = new javax.swing.JLabel();
        mGuiAddBranchCB = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(102, 0, 0));
        setForeground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(500, 400));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addTeachPnl.setBackground(new java.awt.Color(255, 51, 51));
        addTeachPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mGuiAddTeachNameTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addTeachPnl.add(mGuiAddTeachNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 100, 30));

        mGuiAddTeachBranchLbl.setBackground(new java.awt.Color(255, 51, 51));
        mGuiAddTeachBranchLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mGuiAddTeachBranchLbl.setText("BRANŞ");
        addTeachPnl.add(mGuiAddTeachBranchLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 100, 30));

        buttonGroup2.add(mGuiAddTeachMangerRB);
        mGuiAddTeachMangerRB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mGuiAddTeachMangerRB.setText("MÜDÜR");
        mGuiAddTeachMangerRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mGuiAddTeachMangerRBActionPerformed(evt);
            }
        });
        addTeachPnl.add(mGuiAddTeachMangerRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, -1));

        buttonGroup1.add(mGuiAddTeachWomanRB);
        mGuiAddTeachWomanRB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mGuiAddTeachWomanRB.setText("KADIN");
        mGuiAddTeachWomanRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mGuiAddTeachWomanRBActionPerformed(evt);
            }
        });
        addTeachPnl.add(mGuiAddTeachWomanRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        mGuiAddTeachNameLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mGuiAddTeachNameLbl.setText("ADI SOYADI");
        addTeachPnl.add(mGuiAddTeachNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, 30));

        jScrollPane1.setBackground(new java.awt.Color(255, 51, 51));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        tGuiTable.setBackground(new java.awt.Color(102, 0, 0));
        tGuiTable.setForeground(new java.awt.Color(255, 255, 255));
        tGuiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Adı Soyadı", "TC Numarası", "Password","Branş"
            }
        ));
        tGuiTable.setGridColor(new java.awt.Color(102, 0, 0));
        tGuiTable.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tGuiTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tGuiTable);

        addTeachPnl.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 180));

        mGuiAddTeachBtn.setBackground(new java.awt.Color(102, 0, 0));
        mGuiAddTeachBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mGuiAddTeachBtn.setText("EKLE");
        mGuiAddTeachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mGuiAddTeachBtnActionPerformed(evt);
            }
        });
        addTeachPnl.add(mGuiAddTeachBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 180, 30));

        mGuiAddTeachTcnoLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mGuiAddTeachTcnoLbl.setText("T.C. NUMARASI");
        addTeachPnl.add(mGuiAddTeachTcnoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 100, 30));

        mGuiAddTeachPassLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mGuiAddTeachPassLbl.setText("ŞİFRE");
        addTeachPnl.add(mGuiAddTeachPassLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 100, 30));

        mGuiAddTeachTcnoTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addTeachPnl.add(mGuiAddTeachTcnoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 100, 30));

        mGuiAddTeachPassTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addTeachPnl.add(mGuiAddTeachPassTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 100, 30));

        buttonGroup1.add(mGuiAddTeachManRB);
        mGuiAddTeachManRB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mGuiAddTeachManRB.setText("ERKEK");
        mGuiAddTeachManRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mGuiAddTeachManRBActionPerformed(evt);
            }
        });
        addTeachPnl.add(mGuiAddTeachManRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        buttonGroup2.add(mGuiAddTeachAkaRB);
        mGuiAddTeachAkaRB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mGuiAddTeachAkaRB.setText("ASİSTAN");
        mGuiAddTeachAkaRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mGuiAddTeachAkaRBActionPerformed(evt);
            }
        });
        addTeachPnl.add(mGuiAddTeachAkaRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, -1, -1));

        mGuiDelTeachBtn.setBackground(new java.awt.Color(102, 0, 0));
        mGuiDelTeachBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mGuiDelTeachBtn.setText("SİL");
        mGuiDelTeachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mGuiDelTeachBtnActionPerformed(evt);
            }
        });
        addTeachPnl.add(mGuiDelTeachBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 180, 30));
        addTeachPnl.add(teachLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 40, 20));

        addTeachPnl.add(mGuiAddBranchCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 140, -1));

        getContentPane().add(addTeachPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mGuiAddTeachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGuiAddTeachBtnActionPerformed
       if(mGuiAddTeachNameTxt.getText().equals("")||mGuiAddTeachPassTxt.getText().equals("")||mGuiAddTeachTcnoTxt.getText().equals("")){
           Helper.OptionPane.showMessage("fill");
       }
       else{
          
          
           boolean control=teacher.addTeacher(mGuiAddTeachNameTxt.getText(),mGuiAddTeachTcnoTxt.getText(), mGuiAddTeachPassTxt.getText(), (String) mGuiAddBranchCB.getSelectedItem(),Bg2,Bg1);
           if(control==true){
               Helper.OptionPane.showMessage("success");
               mGuiAddTeachNameTxt.setText(null);
               mGuiAddTeachTcnoTxt.setText(null);
               mGuiAddTeachPassTxt.setText(null);
                
                mGuiAddTeachManRB.setSelected(false);
                mGuiAddTeachWomanRB.setSelected(false);
                mGuiAddTeachMangerRB.setSelected(false);
               mGuiAddTeachAkaRB.setSelected(false);
                
                updateTeachTable();
           }
       }
    }//GEN-LAST:event_mGuiAddTeachBtnActionPerformed

    private void mGuiDelTeachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGuiDelTeachBtnActionPerformed
        
       teachLbl.setVisible(false);
        if(teachLbl.getText().length()==0){
            Helper.OptionPane.showMessage("select");
        }
        else{
             int selID=Integer.parseInt(teachLbl.getText());
         
       boolean control=teacher.delTeacher(selID);
        if(control==true){
            Helper.OptionPane.showMessage("success");
            teachLbl.setText("");
            updateTeachTable();
        }
   
        }
       
    }//GEN-LAST:event_mGuiDelTeachBtnActionPerformed

    private void mGuiAddTeachManRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGuiAddTeachManRBActionPerformed
        Bg2="ERKEK";
    }//GEN-LAST:event_mGuiAddTeachManRBActionPerformed

    private void mGuiAddTeachWomanRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGuiAddTeachWomanRBActionPerformed
     Bg2="KADIN";
    }//GEN-LAST:event_mGuiAddTeachWomanRBActionPerformed

    private void mGuiAddTeachMangerRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGuiAddTeachMangerRBActionPerformed
       Bg1="MÜDÜR";
    }//GEN-LAST:event_mGuiAddTeachMangerRBActionPerformed

    private void mGuiAddTeachAkaRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGuiAddTeachAkaRBActionPerformed
      Bg1="ASİSTAN";
    }//GEN-LAST:event_mGuiAddTeachAkaRBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addTeachPnl;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> mGuiAddBranchCB;
    private javax.swing.JRadioButton mGuiAddTeachAkaRB;
    private javax.swing.JLabel mGuiAddTeachBranchLbl;
    private javax.swing.JButton mGuiAddTeachBtn;
    private javax.swing.JRadioButton mGuiAddTeachManRB;
    private javax.swing.JRadioButton mGuiAddTeachMangerRB;
    private javax.swing.JLabel mGuiAddTeachNameLbl;
    private javax.swing.JTextField mGuiAddTeachNameTxt;
    private javax.swing.JLabel mGuiAddTeachPassLbl;
    private javax.swing.JTextField mGuiAddTeachPassTxt;
    private javax.swing.JLabel mGuiAddTeachTcnoLbl;
    private javax.swing.JTextField mGuiAddTeachTcnoTxt;
    private javax.swing.JRadioButton mGuiAddTeachWomanRB;
    private javax.swing.JButton mGuiDelTeachBtn;
    private javax.swing.JTable tGuiTable;
    private javax.swing.JLabel teachLbl;
    // End of variables declaration//GEN-END:variables
        Object[] teachData=null;
       DefaultTableModel teachModel=null;
       private String Bg1="ASİSTAN";
       private String Bg2="ERKEK";
      private  DBConnection conn=new DBConnection();
       private Connection con=conn.connDB();
      private  Statement st=null;
       private ResultSet rs=null;
      private  PreparedStatement pt=null;
}
