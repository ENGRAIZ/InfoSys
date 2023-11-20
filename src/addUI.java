
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class addUI extends javax.swing.JFrame {
    public String selectedUI;
    public String selectedYear;
    public infoUI infoUI;
    public Connection cn;
    public Statement st;
    public addUI(String year,String select) {

        selectedUI = select;
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        initComponents();
        setLocationRelativeTo(null);
        selectedYear = year;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usertxt = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        passtxt = new javax.swing.JPasswordField();
        jDialog1 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        poaField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        ageField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        csField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        pobField = new javax.swing.JTextField();
        dobField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        citiField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        peField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        nosField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        locField = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        doaField = new javax.swing.JTextField();
        degreeField = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        tpField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        daField = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        vaField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MGB-CAR");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Information System");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username:");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password:");

        usertxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertxtActionPerformed(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        passtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(loginButton)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(passtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(usertxt, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(usertxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(passtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(loginButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADD INFORMATION");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("New Information");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 22, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Personal Information");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 8, -1, -1));

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Name");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        poaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poaFieldActionPerformed(evt);
            }
        });
        jPanel3.add(poaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 99, 216, 31));

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Post Office Address");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        jPanel3.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 50, 216, 31));

        ageField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageFieldActionPerformed(evt);
            }
        });
        jPanel3.add(ageField, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 148, 216, 31));

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Age");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Civil Status");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        csField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csFieldActionPerformed(evt);
            }
        });
        jPanel3.add(csField, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 197, 216, 31));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Place of Birth");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, -1));

        pobField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pobFieldActionPerformed(evt);
            }
        });
        jPanel3.add(pobField, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 80, 216, 31));

        dobField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobFieldActionPerformed(evt);
            }
        });
        jPanel3.add(dobField, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 129, 216, 31));

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Date of Birth");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, -1, -1));

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Citizenship");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, -1, -1));

        citiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citiFieldActionPerformed(evt);
            }
        });
        jPanel3.add(citiField, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 178, 216, 31));

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Present Employment");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        peField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peFieldActionPerformed(evt);
            }
        });
        jPanel3.add(peField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 216, 31));

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Highest Educ. Attainment");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        nosField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nosFieldActionPerformed(evt);
            }
        });
        jPanel3.add(nosField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 216, 31));

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Location of School");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, -1));

        locField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locFieldActionPerformed(evt);
            }
        });
        jPanel3.add(locField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 216, 31));

        jLabel28.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Date of Attendance");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        doaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doaFieldActionPerformed(evt);
            }
        });
        jPanel3.add(doaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 216, 31));

        degreeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degreeFieldActionPerformed(evt);
            }
        });
        jPanel3.add(degreeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 216, 31));

        jLabel29.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Degree");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, -1, -1));

        tpField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpFieldActionPerformed(evt);
            }
        });
        jPanel3.add(tpField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 220, 31));

        jLabel30.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Temporary/ Permanent");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, -1, -1));

        jLabel31.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Date Approved");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, -1, -1));

        daField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daFieldActionPerformed(evt);
            }
        });
        jPanel3.add(daField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, 220, 31));

        jLabel32.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Valid Until");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, -1, -1));

        vaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaFieldActionPerformed(evt);
            }
        });
        jPanel3.add(vaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 380, 220, 31));

        confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        confirmButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        jPanel3.add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 430, 110, -1));

        cancelButton.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel3.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, 110, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 98, 1070, 520));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1095, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usertxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertxtActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
   

    }//GEN-LAST:event_loginButtonActionPerformed

    private void passtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passtxtActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        infoUI = new infoUI();
        infoUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void poaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_poaFieldActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void ageFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageFieldActionPerformed

    private void csFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_csFieldActionPerformed

    private void pobFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pobFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pobFieldActionPerformed

    private void dobFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobFieldActionPerformed

    private void citiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_citiFieldActionPerformed

    private void peFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peFieldActionPerformed

    private void nosFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nosFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nosFieldActionPerformed

    private void locFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locFieldActionPerformed

    private void doaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doaFieldActionPerformed

    private void degreeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degreeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_degreeFieldActionPerformed

    private void tpFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpFieldActionPerformed

    private void daFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daFieldActionPerformed

    private void vaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vaFieldActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+selectedUI+"","root","");
            st=cn.createStatement();
            String sql = "INSERT INTO `"+selectedYear+"` (Name,`Post Office Address`,Age,`Civil Status`,`Place of Birth`,`Date of Birth`,Citizenship,`Present Employment`,`Name of School(College)`,Location,`Date of Attendance`,Degree,`Temporary/Permanent`,`Date Approved`,`Valid Until`)"
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, nameField.getText());
            pst.setString(2, poaField.getText());
            pst.setString(3, ageField.getText());
            pst.setString(4, csField.getText());
            pst.setString(5, pobField.getText());
            pst.setString(6, dobField.getText());
            pst.setString(7, citiField.getText());
            pst.setString(8, peField.getText());
            pst.setString(9, nosField.getText());
            pst.setString(10, locField.getText());
            pst.setString(11, doaField.getText());
            pst.setString(12, degreeField.getText());
            pst.setString(13, tpField.getText());
            pst.setString(14, daField.getText());
            pst.setString(15, vaField.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Info added successfully");

            this.dispose();

            st.close();
            cn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

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
            java.util.logging.Logger.getLogger(addUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField citiField;
    private javax.swing.JButton confirmButton;
    private javax.swing.JTextField csField;
    private javax.swing.JTextField daField;
    private javax.swing.JTextField degreeField;
    private javax.swing.JTextField doaField;
    private javax.swing.JTextField dobField;
    private javax.swing.JDialog jDialog1;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField locField;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nosField;
    private javax.swing.JPasswordField passtxt;
    private javax.swing.JTextField peField;
    private javax.swing.JTextField poaField;
    private javax.swing.JTextField pobField;
    private javax.swing.JTextField tpField;
    private javax.swing.JTextField usertxt;
    private javax.swing.JTextField vaField;
    // End of variables declaration//GEN-END:variables
    byte[] photo = null;
    String filename = null;
}
