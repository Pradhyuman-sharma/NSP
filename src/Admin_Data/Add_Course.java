/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_Data;

import Conn.Methods2;
import conn.Methods;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import sun.awt.resources.awt;

/**
 *
 * @author Itsexceptional
 */
public class Add_Course extends javax.swing.JFrame {
    Connection con;
    PreparedStatement psmnt = null;
    ResultSet rs;
    String course_name;
    String combo_name;
    /**
     * Creates new form Add_Quiz
     */
    public Add_Course() {
        initComponents();
         filldata();
          setLocation(280,200);
    }
    public void filldata()
    {
        try {  
     String databasename="bug2db";
     String url="jdbc:mysql://localhost:3306/";
     String user="root";
     String pass="root";
Class.forName("com.mysql.jdbc.Driver");  
con= DriverManager.getConnection(url+databasename,user,pass);  
Statement st = con.createStatement();

 ResultSet r=st.executeQuery("select * from courses");

 while (r.next()) {  

     combo.addItem(r.getString("course_name"));  
 }


    con.close();
    } 
        catch (Exception e) {  
JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
System.exit(0);  
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        c_name = new javax.swing.JTextField();
        combo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADD COURSE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Course Name -");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 87, -1, -1));
        getContentPane().add(c_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 81, 148, -1));

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        getContentPane().add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 142, 148, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Available Courses -");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 147, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Webp.net-resizeimage (1).png"))); // NOI18N
        jButton1.setText("Add New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 81, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Webp.net-resizeimage (2).png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 141, 100, -1));

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 12, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
               new Admin_Dash().setVisible(true);
               dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            Methods2 m=new Methods2();
            course_name=c_name.getText().trim();
            try
            {
                if(m.addCourse(course_name) == 0)
                {
                    JOptionPane.showMessageDialog(null, "Table Created Sucessfully");
                    Add_Course dd=new Add_Course();
                    dd.setVisible(true);
                    dispose();
                    dd.invalidate();
                    dd.validate();
                    dd.repaint();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
          
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_comboActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                Methods2 mm=new Methods2();
                try
                {
                      combo_name=""+combo.getItemAt(combo.getSelectedIndex()).trim();
                   //   System.out.println(""+combo_name);
                     if(mm.deleteCourse(combo_name) == 0 ) 
                        {
                          JOptionPane.showMessageDialog(null,"Delete Course Successfully");
                          Add_Course dd=new Add_Course();
                          dispose();
                          dd.setVisible(true);
                          dd.repaint();
                                
                      }
                      else
                      {
                          JOptionPane.showMessageDialog(null,"Check Course Name");
                      }
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
               
                }
             
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Add_Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</comboeditor-fold>
             
   /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Add_Course().setVisible(true);
                
            }

        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField c_name;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}

