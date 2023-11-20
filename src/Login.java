
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;




public class Login extends javax.swing.JFrame {

    public Connection cn;
    public Statement st;
    
    public Login() {
        initComponents(); 
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        jLabel3.show();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_admin","root","");
            st=cn.createStatement();
            JOptionPane.showMessageDialog(null, "Connected");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Not Connected");
        }
    }

   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        usertxt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        signupButton = new javax.swing.JLabel();
        passtxt = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hide (1).png"))); // NOI18N
        jLabel3.setAlignmentY(0.0F);
        jLabel3.setAutoscrolls(true);
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 470, -1, 20));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/[removal.ai]_ff84a59c-a52a-4604-bf9a-b0036c7319a9-242750298_199368732295405_1125875582474652414_n.png"))); // NOI18N
        jLabel15.setText("jLabel1");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 32, 149, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Business-Management-System-MarsHub-PhotoRoom.png-PhotoRoom.png"))); // NOI18N
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 180, 463, 428));

        jLabel17.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 153));
        jLabel17.setText("Mines and Geosciences Bureau - CAR");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 242, -1, -1));

        jLabel18.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 153));
        jLabel18.setText("MSESDD Information System");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 180, -1, -1));

        jLabel19.setFont(new java.awt.Font("Gadugi", 0, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 153));
        jLabel19.setText("Don't have an account?");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 555, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 153));
        jLabel20.setText("Username");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 344, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 153, 153));
        jLabel21.setText("Password");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 434, -1, -1));
        jPanel3.add(usertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 373, 259, 31));

        jLabel22.setFont(new java.awt.Font("Gadugi", 0, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 153));
        jLabel22.setText("Log in to your account");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 303, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Log in");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(667, 529, 102, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user (1).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 342, 25, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pass (1).png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 428, 25, -1));

        signupButton.setFont(new java.awt.Font("Gadugi", 0, 15)); // NOI18N
        signupButton.setForeground(new java.awt.Color(0, 153, 153));
        signupButton.setText("Sign up here!");
        signupButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signupButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signupButtonMouseExited(evt);
            }
        });
        jPanel3.add(signupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 555, -1, -1));

        passtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passtxtKeyPressed(evt);
            }
        });
        jPanel3.add(passtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 465, 259, 31));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1020, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jLabel3.show();
        try{
            String sql = "SELECT * FROM admin WHERE Username = '" + usertxt.getText() + "' AND Password = '" + String.valueOf(passtxt.getPassword()) + "'";
            ResultSet rrs = st.executeQuery(sql);
            if(rrs.next()){
                infoUI infoUI = new infoUI();
                infoUI.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this,"Invalid Username or Password","Error",JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void passtxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passtxtKeyPressed
        jLabel3.show();
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
            try{
                String sql = "SELECT * FROM admin WHERE Username = '" + usertxt.getText() + "' AND Password = '" + String.valueOf(passtxt.getPassword()) + "'";
                ResultSet rrs = st.executeQuery(sql);
                if(rrs.next()){
                    infoUI infoUI = new infoUI();
                    infoUI.setVisible(true);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this,"Invalid Username or Password","Error",JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception e){

            }
        }
    }//GEN-LAST:event_passtxtKeyPressed

    private void signupButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupButtonMouseEntered
        jLabel3.show();
        signupButton.setText("<html><u>Sign up here!</u></html>");
        signupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //signupButton.setPreferredSize(new Dimension(signupButton.getWidth(), signupButton.getHeight()));
        signupButton.setForeground(Color.BLUE);
    }//GEN-LAST:event_signupButtonMouseEntered

    private void signupButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupButtonMouseExited
        jLabel3.show();
        signupButton.setText("Sign up here!");
        signupButton.setForeground(new Color(0,153,153));
    }//GEN-LAST:event_signupButtonMouseExited

    private void signupButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupButtonMouseClicked
        jLabel3.show();
        CreateAccount createaccount = new CreateAccount();
        createaccount.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signupButtonMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        ImageIcon hide = new ImageIcon("C:\\Users\\pcuser\\Documents\\NetBeansProjects\\InfoSys\\src\\hide (1).png");
        ImageIcon view = new ImageIcon("C:\\Users\\pcuser\\Documents\\NetBeansProjects\\InfoSys\\src\\view (1).png");
        if(passtxt.getEchoChar() == '*'){
            passtxt.setEchoChar((char)0);
            jLabel3.setIcon(view);
        }else{
            passtxt.setEchoChar('*');
            jLabel3.setIcon(hide);
        }
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField passtxt;
    private javax.swing.JLabel signupButton;
    private javax.swing.JTextField usertxt;
    // End of variables declaration//GEN-END:variables
}
