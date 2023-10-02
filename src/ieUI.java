
import java.sql.*;

public class ieUI extends javax.swing.JFrame {

    public infoUI infoUI;
    public Connection cn;
    public Statement st;
    
    public ieUI() {
        
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        initComponents();  
        setLocationRelativeTo(null);
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_admin","root","");
            st=cn.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        whiteBG = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        mgbcarLabel = new javax.swing.JLabel();
        mgbcarLabel1 = new javax.swing.JLabel();
        msesddLabel = new javax.swing.JLabel();
        isLabel = new javax.swing.JLabel();
        engineersButton = new javax.swing.JButton();
        inspectorsButton = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MGB-CAR");

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("MGB-CAR");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        whiteBG.setBackground(new java.awt.Color(255, 255, 255));
        whiteBG.setForeground(new java.awt.Color(255, 255, 255));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download.png"))); // NOI18N

        mgbcarLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        mgbcarLabel.setForeground(new java.awt.Color(0, 0, 0));
        mgbcarLabel.setText("Mines and Geosciences Bureau");

        mgbcarLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        mgbcarLabel1.setForeground(new java.awt.Color(0, 0, 0));
        mgbcarLabel1.setText("Cordillera Administrative Region");

        msesddLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        msesddLabel.setForeground(new java.awt.Color(0, 0, 0));
        msesddLabel.setText("Mine Safety, Environment and Social Development Division");

        isLabel.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        isLabel.setForeground(new java.awt.Color(0, 0, 0));
        isLabel.setText("    Engineers/Inspectors Information System");

        engineersButton.setBackground(new java.awt.Color(255, 255, 255));
        engineersButton.setForeground(new java.awt.Color(0, 0, 0));
        engineersButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/worker (1).png"))); // NOI18N
        engineersButton.setText("ENGINEERS");
        engineersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engineersButtonActionPerformed(evt);
            }
        });

        inspectorsButton.setBackground(new java.awt.Color(255, 255, 255));
        inspectorsButton.setForeground(new java.awt.Color(0, 0, 0));
        inspectorsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inspector (1).png"))); // NOI18N
        inspectorsButton.setText("INSPECTORS");
        inspectorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inspectorsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout whiteBGLayout = new javax.swing.GroupLayout(whiteBG);
        whiteBG.setLayout(whiteBGLayout);
        whiteBGLayout.setHorizontalGroup(
            whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, whiteBGLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inspectorsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(engineersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(231, 231, 231))
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(whiteBGLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(msesddLabel)
                            .addGroup(whiteBGLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(whiteBGLayout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(mgbcarLabel1))
                                    .addComponent(mgbcarLabel)))))
                    .addGroup(whiteBGLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(isLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(whiteBGLayout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(logoLabel)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        whiteBGLayout.setVerticalGroup(
            whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mgbcarLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mgbcarLabel1)
                .addGap(18, 18, 18)
                .addComponent(msesddLabel)
                .addGap(18, 18, 18)
                .addComponent(isLabel)
                .addGap(18, 18, 18)
                .addComponent(engineersButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inspectorsButton)
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whiteBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(whiteBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void engineersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engineersButtonActionPerformed
        String selectedUI = "infotable2";

        infoUI = new infoUI(selectedUI);
        infoUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_engineersButtonActionPerformed

    private void inspectorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inspectorsButtonActionPerformed
        String selectedUI = "infotable";

        infoUI = new infoUI(selectedUI);
        infoUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_inspectorsButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton engineersButton;
    private javax.swing.JButton inspectorsButton;
    private javax.swing.JLabel isLabel;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel mgbcarLabel;
    private javax.swing.JLabel mgbcarLabel1;
    private javax.swing.JLabel msesddLabel;
    private javax.swing.JPanel whiteBG;
    // End of variables declaration//GEN-END:variables
}
