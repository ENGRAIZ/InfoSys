import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.*;
import javax.swing.JFileChooser;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;




public final class infoUI extends javax.swing.JFrame {


    public addUI addUI;
    public editUI editUI;
    public Connection cn;
    public Statement st;
    public String selectedUI = "infotable";
    private int[] columnClickCounts; 
    private TableRowSorter<DefaultTableModel> sorter;
    public int checker;
    
    public infoUI() {
        initComponents();
        populateSelectedUI();      
        setLocationRelativeTo(null);
        populateYearSelector();
        chosenUI();
        //infoTable.setVisible(false);
        columnClickCounts = new int[infoTable.getColumnCount()];
        
        infoTable.getTableHeader().addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int columnIndex = infoTable.columnAtPoint(e.getPoint());
            if (columnClickCounts[columnIndex] == 0) {
                sortColumn(columnIndex, true);
            } else if (columnClickCounts[columnIndex] == 1) {
                sortColumn(columnIndex, false);
            } else {
                resetColumnSort(columnIndex);
            }
        }
    });
        
    }
    private void sortColumn(int columnIndex, boolean ascending) {
        if (sorter == null) {
            DefaultTableModel model = (DefaultTableModel) infoTable.getModel();
            sorter = new TableRowSorter<>(model);
            infoTable.setRowSorter(sorter);
        }

        if (columnIndex == 0) {
            // For the ID column, use a custom Comparator to sort as integers
            sorter.setComparator(0, Comparator.comparingInt(id -> Integer.parseInt(id.toString())));
        }

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(columnIndex, ascending ? SortOrder.ASCENDING : SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();

        columnClickCounts[columnIndex]++;
    }

    private void resetColumnSort(int columnIndex) {
         if (sorter == null) return;

        sorter.setComparator(columnIndex, null);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sorter.setSortKeys(sortKeys);
        sorter.sort();

        columnClickCounts[columnIndex] = 0;
    }
    
    public void showTable(String selectedYear){
        try{
        chosenUI();
        Class.forName("com.mysql.cj.jdbc.Driver");
        cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+selectedUI+"","root","");
        st=cn.createStatement();
        String sql = "SELECT * FROM  `"+selectedYear+"`";
        ResultSet rrs = st.executeQuery(sql);
        
        DefaultTableModel model = (DefaultTableModel) infoTable.getModel();
        model.setRowCount(0); // Clear existing rows
        model.setColumnCount(0);
        
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Post Office Address");
        model.addColumn("Age");
        model.addColumn("Civil Status");
        model.addColumn("Place of Birth");
        model.addColumn("Date of Birth");
        model.addColumn("Citizenship");
        model.addColumn("Present Employment");
        model.addColumn("Name of School(College)");
        model.addColumn("Location");
        model.addColumn("Date of Attendance");
        model.addColumn("Degree");
        model.addColumn("Temporary/Permanent");
        model.addColumn("Date Approved");
        model.addColumn("Valid Until");
        
        while (rrs.next()) {
            Object[] row = {
            rrs.getInt("ID"),
            rrs.getString("Name"),
            rrs.getString("Post Office Address"),
            rrs.getString("Age"),
            rrs.getString("Civil Status"),
            rrs.getString("Place of Birth"),
            rrs.getString("Date of Birth"),
            rrs.getString("Citizenship"),
            rrs.getString("Present Employment"),
            rrs.getString("Name of School(College)"),
            rrs.getString("Location"),
            rrs.getString("Date of Attendance"),
            rrs.getString("Degree"),
            rrs.getString("Temporary/Permanent"),
            rrs.getString("Date Approved"),
            rrs.getString("Valid Until")
            
        };
        model.addRow(row);
        }
        rrs.close();
        st.close();
        cn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void showTable2(String selectedYear) {
        try {
            chosenUI();
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + selectedUI + "", "root", "");
            st = cn.createStatement();
            String sql = "SELECT blaster_foreman, company, kind, quantity " +
                         "FROM `" + selectedYear + "`";

            ResultSet rrs = st.executeQuery(sql);

            DefaultTableModel model = (DefaultTableModel) infoTable.getModel();
            model.setRowCount(0); // Clear existing rows
            model.setColumnCount(0);

            model.addColumn("Blaster Foreman");
            model.addColumn("Company");
            model.addColumn("Kind");
            model.addColumn("Quantity");

            HashSet<String> uniqueNames = new HashSet<>();

            while (rrs.next()) {
                String name = rrs.getString("blaster_foreman");
                String company = rrs.getString("company");
                String kind = rrs.getString("kind");
                String quantity = rrs.getString("quantity");

                String nameAndCompany = name + company;

                // Check if the name and company combination already exists in the table
                boolean nameAndCompanyExists = false;
                for (int i = 0; i < model.getRowCount(); i++) {
                    String existingNameAndCompany = (String) model.getValueAt(i, 0) + (String) model.getValueAt(i, 1);
                    if (existingNameAndCompany.equals(nameAndCompany)) {
                        nameAndCompanyExists = true;
                        // Create a new row for kind and quantity
                        Object[] row = {"", "", kind, quantity};
                        model.addRow(row);
                        break;
                    }
                }

                if (!nameAndCompanyExists) {
                    uniqueNames.add(nameAndCompany);
                    Object[] row = {name, company, kind, quantity};
                    model.addRow(row);
                }
            }

            rrs.close();
            st.close();
            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    
    public void readExcel(File file, DefaultTableModel infoTable) {
    try (FileInputStream fis = new FileInputStream(file);
         Workbook workbook = new XSSFWorkbook(fis)) {

        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.iterator();

            Vector<Object> rowData = new Vector<>();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        rowData.add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        double numericValue = cell.getNumericCellValue();
                        int intValue = (int) numericValue;
                        rowData.add(String.valueOf(intValue));
                        break;
                    // Add cases for other cell types as needed
                    default:
                        rowData.add("");
                }
            }
            infoTable.addRow(rowData);

            // Save to database
            saveRowToDatabase(rowData);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void saveRowToDatabase(Vector<Object> rowData) {
        if(checker == 1 || checker == 2){
            try {
                chosenUI();
                String selectedYear = (String) yearSelector.getSelectedItem();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+selectedUI+"", "root", "");
                Statement st = cn.createStatement();

                String sql = "INSERT INTO `"+selectedYear+"` (ID,Name,`Post Office Address`,Age,`Civil Status`,`Place of Birth`,`Date of Birth`,Citizenship,`Present Employment`,`Name of School(College)`,Location,`Date of Attendance`,Degree,`Temporary/Permanent`,`Date Approved`,`Valid Until`)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);

                for (int i = 0; i < rowData.size(); i++) {
                    Object value = rowData.get(i);
                    if (value == null) {
                        pst.setNull(i + 1, Types.NULL);
                    } else {
                        pst.setObject(i + 1, value);
                    }
                }

                pst.executeUpdate();

                pst.close();
                st.close();
                cn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
             try {
                chosenUI();
                String selectedYear = (String) yearSelector.getSelectedItem();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+selectedUI+"", "root", "");
                Statement st = cn.createStatement();

                String sql = "INSERT INTO `"+selectedYear+"` (ID,Name,`Post Office Address`,Age,`Civil Status`,`Place of Birth`,`Date of Birth`,Citizenship,`Present Employment`,`Name of School(College)`,Location,`Date of Attendance`,Degree,`Temporary/Permanent`,`Date Approved`,`Valid Until`)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);

                for (int i = 0; i < rowData.size(); i++) {
                    Object value = rowData.get(i);
                    if (value == null) {
                        pst.setNull(i + 1, Types.NULL);
                    } else {
                        pst.setObject(i + 1, value);
                    }
                }

                pst.executeUpdate();

                pst.close();
                st.close();
                cn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        infoTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        yearSelector = new javax.swing.JComboBox<>();
        yearLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        yearLabel1 = new javax.swing.JLabel();
        uiSelector = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MSESDD");

        infoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Post Office Address", "Age", "Civil Status", "Place of Birth", "Date of Birth", "Citizenship", "Present Employment", "Highest Educ. Attainment", "Location", "Date of Attendance", "Degree", "Temporary/Permanent", "Date Approved", "Valid Until"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        infoTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        infoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(infoTable);
        if (infoTable.getColumnModel().getColumnCount() > 0) {
            infoTable.getColumnModel().getColumn(0).setHeaderValue("ID");
            infoTable.getColumnModel().getColumn(1).setHeaderValue("Name");
            infoTable.getColumnModel().getColumn(2).setHeaderValue("Post Office Address");
            infoTable.getColumnModel().getColumn(3).setHeaderValue("Age");
            infoTable.getColumnModel().getColumn(4).setHeaderValue("Civil Status");
            infoTable.getColumnModel().getColumn(5).setHeaderValue("Place of Birth");
            infoTable.getColumnModel().getColumn(6).setHeaderValue("Date of Birth");
            infoTable.getColumnModel().getColumn(7).setHeaderValue("Citizenship");
            infoTable.getColumnModel().getColumn(8).setHeaderValue("Present Employment");
            infoTable.getColumnModel().getColumn(9).setHeaderValue("Highest Educ. Attainment");
            infoTable.getColumnModel().getColumn(10).setHeaderValue("Location");
            infoTable.getColumnModel().getColumn(11).setHeaderValue("Date of Attendance");
            infoTable.getColumnModel().getColumn(12).setHeaderValue("Degree");
            infoTable.getColumnModel().getColumn(13).setHeaderValue("Temporary/Permanent");
            infoTable.getColumnModel().getColumn(14).setHeaderValue("Date Approved");
            infoTable.getColumnModel().getColumn(15).setHeaderValue("Valid Until");
        }

        searchField.setMaximumSize(new java.awt.Dimension(13, 28));
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });

        yearSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearSelectorActionPerformed(evt);
            }
        });

        yearLabel.setText("YEAR:");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goback (2).png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addInfoico (1).png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search (1).png"))); // NOI18N
        jLabel1.setText("Search");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        yearLabel1.setText("TABLE:");

        uiSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uiSelectorActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("New Table");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Export to Excel");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Import");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(yearLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uiSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yearLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearLabel)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearLabel1)
                    .addComponent(uiSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void infoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoTableMouseClicked
        String selectedYear = (String) yearSelector.getSelectedItem();
        if (evt.getClickCount() == 2) {
            int selectedRow = infoTable.getSelectedRow();
            if (selectedRow != -1) {
                String id = infoTable.getValueAt(selectedRow, 0).toString();
                String name = infoTable.getValueAt(selectedRow, 1).toString();
                String poa = infoTable.getValueAt(selectedRow, 2).toString();
                String age = infoTable.getValueAt(selectedRow, 3).toString();
                String cs = infoTable.getValueAt(selectedRow, 4).toString();
                String pob = infoTable.getValueAt(selectedRow, 5).toString();
                String dob = infoTable.getValueAt(selectedRow, 6).toString();
                String citi = infoTable.getValueAt(selectedRow, 7).toString();
                String pe = infoTable.getValueAt(selectedRow, 8).toString();
                String nos = infoTable.getValueAt(selectedRow, 9).toString();
                String loc = infoTable.getValueAt(selectedRow, 10).toString();
                String doa = infoTable.getValueAt(selectedRow, 11).toString();
                String degree = infoTable.getValueAt(selectedRow, 12).toString();
                String tp = infoTable.getValueAt(selectedRow, 13).toString();
                String da = infoTable.getValueAt(selectedRow, 14).toString();
                String vu = infoTable.getValueAt(selectedRow, 15).toString();
                
                ViewDetailsUI ViewDetailsUI = new ViewDetailsUI(id,name,poa,age,cs,pob,dob,citi,pe,nos,loc,doa,degree,tp,da,vu,selectedYear);
                ViewDetailsUI.setVisible(true);
            }
        }
    }//GEN-LAST:event_infoTableMouseClicked
    private void populateSelectedUI(){
        uiSelector.addItem("Engineers");
        uiSelector.addItem("Inspectors");
        uiSelector.addItem("Blasters");
       
    }
    private void chosenUI(){ 
        String selectedYear = (String) yearSelector.getSelectedItem();
        selectedUI = (String) uiSelector.getSelectedItem();
        if(uiSelector.getSelectedItem() == "Engineers"){
            selectedUI = "infotable2";
            //showTable(selectedYear);
            checker = 1;
        }
        else if(uiSelector.getSelectedItem()=="Inspectors"){
            selectedUI = "infotable";
            //showTable(selectedYear);
            checker = 2;
        }
        else{
            selectedUI = "infotable3";
            checker = 3;
        }
        this.invalidate();
        this.repaint();
    }
    
    private void populateYearSelector() {
        try {
            chosenUI();
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+selectedUI+"","root","");
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("SHOW TABLES");
            
            ArrayList<String> databaseNames = new ArrayList<>();

            while (rs.next()) {
                String dbName = rs.getString(1);
                databaseNames.add(dbName);
            }
            
            // Clear the existing items in yearSelector
            yearSelector.removeAllItems();
            // Sort the database names in ascending order
            Collections.sort(databaseNames, Collections.reverseOrder());

            // Add the sorted names to the JComboBox
            for (String dbName : databaseNames) {
                yearSelector.addItem(dbName);
            }

            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void yearSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearSelectorActionPerformed
        chosenUI();
        String selectedYear = (String) yearSelector.getSelectedItem();
        if(checker == 1 || checker == 2){  
            showTable(selectedYear);
        }else{
            showTable2(selectedYear);
        }
    }//GEN-LAST:event_yearSelectorActionPerformed

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
            try{
                chosenUI();
                String selectedYear = (String) yearSelector.getSelectedItem();
                Class.forName("com.mysql.cj.jdbc.Driver");
                cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+selectedUI+"","root","");
                st=cn.createStatement();
                if(!"".equals(searchField.getText())){
                String sql = "SELECT * FROM `"+selectedYear+"` WHERE Name LIKE '%"+searchField.getText()+"%' OR `Post Office Address` LIKE '%"+searchField.getText()+"%'"
                    + "OR Age LIKE '%"+searchField.getText()+"%' OR `Civil Status` LIKE '%"+searchField.getText()+"%' OR `Place of Birth` LIKE '%"+searchField.getText()+"%'"
                    + "OR `Date of Birth` LIKE '%"+searchField.getText()+"%' OR Citizenship LIKE '%"+searchField.getText()+"%' OR `Present Employment` LIKE '%"+searchField.getText()+"%' OR `Name of School(College)` LIKE '%"+searchField.getText()+"%'"
                    + "OR Location LIKE '%"+searchField.getText()+"%' OR `Date of Attendance` LIKE '%"+searchField.getText()+"%' OR Degree LIKE '%"+searchField.getText()+"%'"
                    + "OR `Temporary/Permanent` LIKE '%"+searchField.getText()+"%' OR `Date Approved` LIKE '%"+searchField.getText()+"%' OR `Valid Until` LIKE '%"+searchField.getText()+"%'";
                ResultSet rrs = st.executeQuery(sql);
                DefaultTableModel model = (DefaultTableModel) infoTable.getModel();
                model.setRowCount(0); // Clear existing rows
                while (rrs.next()) {
                    Object[] row = {
                        rrs.getInt("ID"),
                        rrs.getString("Name"),
                        rrs.getString("Post Office Address"),
                        rrs.getString("Age"),
                        rrs.getString("Civil Status"),
                        rrs.getString("Place of Birth"),
                        rrs.getString("Date of Birth"),
                        rrs.getString("Citizenship"),
                        rrs.getString("Present Employment"),
                        rrs.getString("Name of School(College)"),
                        rrs.getString("Location"),
                        rrs.getString("Date of Attendance"),
                        rrs.getString("Degree"),
                        rrs.getString("Temporary/Permanent"),
                        rrs.getString("Date Approved"),
                        rrs.getString("Valid Until")
                    };
                    model.addRow(row);
                }
                rrs.close();
                st.close();
                cn.close();
        
                }else{
                    chosenUI();
                    showTable(selectedYear);
                }     
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_searchFieldKeyPressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        chosenUI();
        String selectedYear = (String) yearSelector.getSelectedItem();
        int selectedRow = infoTable.getSelectedRow();
        if (selectedRow != -1) {
            String id = infoTable.getValueAt(selectedRow, 0).toString();
            String name = infoTable.getValueAt(selectedRow, 1).toString();
            String poa = infoTable.getValueAt(selectedRow, 2).toString();
            String age = infoTable.getValueAt(selectedRow, 3).toString();
            String cs = infoTable.getValueAt(selectedRow, 4).toString();
            String pob = infoTable.getValueAt(selectedRow, 5).toString();
            String dob = infoTable.getValueAt(selectedRow, 6).toString();
            String citi = infoTable.getValueAt(selectedRow, 7).toString();
            String pe = infoTable.getValueAt(selectedRow, 8).toString();
            String nos = infoTable.getValueAt(selectedRow, 9).toString();
            String loc = infoTable.getValueAt(selectedRow, 10).toString();
            String doa = infoTable.getValueAt(selectedRow, 11).toString();
            String degree = infoTable.getValueAt(selectedRow, 12).toString();
            String tp = infoTable.getValueAt(selectedRow, 13).toString();
            String da = infoTable.getValueAt(selectedRow, 14).toString();
            String vu = infoTable.getValueAt(selectedRow, 15).toString();

            // Create a new EditInfoUI instance and pass the data
            editUI = new editUI(id,name,poa,age,cs,pob,dob,citi,pe,nos,loc,doa,degree,tp,da,vu,selectedYear,selectedUI);
            editUI.setVisible(true);
            this.dispose();
            
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        chosenUI();
        int response = JOptionPane.showConfirmDialog(this, "Do you want to delete?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            String selectedYear = (String) yearSelector.getSelectedItem();
            int[] selectedRows = infoTable.getSelectedRows();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + selectedUI, "root", "");
                st = cn.createStatement();

                for (int selectedRow : selectedRows) {
                    int idToDelete = (int) infoTable.getValueAt(selectedRow, 0);
                    String sql = "DELETE FROM `" + selectedYear + "` WHERE `ID` = " + idToDelete;
                    st.executeUpdate(sql);
                }

                st.close();
                cn.close();
                showTable(selectedYear);
            } catch (Exception e) {
                e.printStackTrace(); // Handle any potential exceptions
            }
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        chosenUI();
        String selectedYear = (String) yearSelector.getSelectedItem();
            addUI = new addUI(selectedYear,selectedUI);
            addUI.setVisible(true);
            
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try{
            chosenUI();
            String selectedYear = (String) yearSelector.getSelectedItem();
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+selectedUI+"","root","");
            st=cn.createStatement();
            if(!"".equals(searchField.getText())){
                String sql = "SELECT * FROM `"+selectedYear+"` WHERE Name LIKE '%"+searchField.getText()+"%' OR `Post Office Address` LIKE '%"+searchField.getText()+"%'"
                        + "OR Age LIKE '%"+searchField.getText()+"%' OR `Civil Status` LIKE '%"+searchField.getText()+"%' OR `Place of Birth` LIKE '%"+searchField.getText()+"%'"
                        + "OR `Date of Birth` LIKE '%"+searchField.getText()+"%' OR Citizenship LIKE '%"+searchField.getText()+"%' OR `Present Employment` LIKE '%"+searchField.getText()+"%' OR `Name of School(College)` LIKE '%"+searchField.getText()+"%'"
                        + "OR Location LIKE '%"+searchField.getText()+"%' OR `Date of Attendance` LIKE '%"+searchField.getText()+"%' OR Degree LIKE '%"+searchField.getText()+"%'"
                        + "OR `Temporary/Permanent` LIKE '%"+searchField.getText()+"%' OR `Date Approved` LIKE '%"+searchField.getText()+"%' OR `Valid Until` LIKE '%"+searchField.getText()+"%'";
                ResultSet rrs = st.executeQuery(sql);
                DefaultTableModel model = (DefaultTableModel) infoTable.getModel();
                model.setRowCount(0); // Clear existing rows
                while (rrs.next()) {
                    Object[] row = {
                    rrs.getInt("ID"),
                    rrs.getString("Name"),
                    rrs.getString("Post Office Address"),
                    rrs.getString("Age"),
                    rrs.getString("Civil Status"),
                    rrs.getString("Place of Birth"),
                    rrs.getString("Date of Birth"),
                    rrs.getString("Citizenship"),
                    rrs.getString("Present Employment"),
                    rrs.getString("Name of School(College)"),
                    rrs.getString("Location"),
                    rrs.getString("Date of Attendance"),
                    rrs.getString("Degree"),
                    rrs.getString("Temporary/Permanent"),
                    rrs.getString("Date Approved"),
                    rrs.getString("Valid Until")
                    };
                    model.addRow(row);
                }
                rrs.close();
                st.close();
                cn.close();
        
            }else{
                chosenUI();
                showTable(selectedYear);
            }     
        }catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(checker == 1 || checker == 2){
            chosenUI();
            String selectedYear = (String) yearSelector.getSelectedItem();
                try {
                    String selectedNewYear = JOptionPane.showInputDialog(this,"Table Name (Recommended to Use Current Year for Table Name)","New Table",JOptionPane.QUESTION_MESSAGE);
                    if(!selectedNewYear.isEmpty()){
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + selectedUI+"", "root", "");
                        st = cn.createStatement();
                        String createTableQuery = "CREATE TABLE `" + selectedNewYear + "` ("
                                + "`ID` INT NOT NULL AUTO_INCREMENT,"
                                + "`Name` VARCHAR(255),"
                                + "`Post Office Address` VARCHAR(255),"
                                + "`Age` VARCHAR(255),"
                                + "`Civil Status` VARCHAR(255),"
                                + "`Place of Birth` VARCHAR(255),"
                                + "`Date of Birth` VARCHAR(255),"
                                + "`Citizenship` VARCHAR(255),"
                                + "`Present Employment` VARCHAR(255),"
                                + "`Name of School(College)` VARCHAR(255),"
                                + "`Location` VARCHAR(255),"
                                + "`Date of Attendance` VARCHAR(255),"
                                + "`Degree` VARCHAR(255),"
                                + "`Temporary/Permanent` VARCHAR(255),"
                                + "`Date Approved` VARCHAR(255),"
                                + "`Valid Until` VARCHAR(255),"
                                + "PRIMARY KEY (`ID`)"
                                + ")";
                        st.executeUpdate(createTableQuery);
                        st.close();
                        cn.close();

                        yearSelector.addItem(selectedNewYear);
                        JOptionPane.showMessageDialog(this, "New table for year " + selectedNewYear + " created successfully.");
                    } else if(selectedNewYear.isEmpty()){
                        JOptionPane.showMessageDialog(this, "Please Input Table Name");
                    } else{
                        chosenUI();
                        showTable(selectedYear);
                    }
                }catch (Exception e) {
                   e.printStackTrace(); // Handle any potential exceptions
                }
        }else{
            chosenUI();
            String selectedYear = (String) yearSelector.getSelectedItem();
                try {
                    String selectedNewYear = JOptionPane.showInputDialog(this,"Table Name (Recommended to Use Current Year for Table Name)","New Table",JOptionPane.QUESTION_MESSAGE);
                    if(!selectedNewYear.isEmpty()){
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + selectedUI+"", "root", "");
                        st = cn.createStatement();
                        String createTableQuery = "CREATE TABLE `" + selectedNewYear + "` ("
                                + "`blaster_foreman` VARCHAR(255),"
                                + "`company` VARCHAR(255),"
                                + "`kind` VARCHAR(255),"
                                + "`quantity` VARCHAR(255))";
                              
                        st.executeUpdate(createTableQuery);
                        st.close();
                        cn.close();

                        yearSelector.addItem(selectedNewYear);
                        JOptionPane.showMessageDialog(this, "New table for year " + selectedNewYear + " created successfully.");
                    } else if(selectedNewYear.isEmpty()){
                        JOptionPane.showMessageDialog(this, "Please Input Table Name");
                    } else{
                        chosenUI();
                        showTable2(selectedYear);
                    }
                }catch (Exception e) {
                   e.printStackTrace(); // Handle any potential exceptions
                }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.endsWith(".xlsx")) {
                fileToSave = new File(filePath + ".xlsx");
            }

            try {
                DefaultTableModel model = (DefaultTableModel) infoTable.getModel();
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Sheet1");

                // Copy data from JTable to Excel sheet
                for (int i = 0; i < model.getRowCount(); i++) {
                    XSSFRow row = sheet.createRow(i); // Use XSSFRow
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);
                        cell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }

                // Save the workbook to the selected file
                try (FileOutputStream out = new FileOutputStream(fileToSave)) {
                    workbook.write(out);
                    System.out.println("Excel file created successfully.");
                    JOptionPane.showMessageDialog(this, "Excel file created successfully.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Excel File");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToImport = fileChooser.getSelectedFile();
            readExcel(fileToImport, (DefaultTableModel) infoTable.getModel());
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void uiSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uiSelectorActionPerformed
        uiSelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED && checker == 1 || checker == 2) {
                    // Populate yearSelector based on the selected database
                    populateYearSelector();
                    String selectedYear = (String) yearSelector.getSelectedItem();
                    showTable(selectedYear);
                }
                else{
                    populateYearSelector();
                    String selectedYear = (String) yearSelector.getSelectedItem();
                    showTable2(selectedYear);
                }
            }
        });  
    }//GEN-LAST:event_uiSelectorActionPerformed

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
            java.util.logging.Logger.getLogger(infoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(infoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(infoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(infoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable infoTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> uiSelector;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JLabel yearLabel1;
    private javax.swing.JComboBox<String> yearSelector;
    // End of variables declaration//GEN-END:variables
}
