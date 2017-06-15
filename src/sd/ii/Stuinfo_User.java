/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd.ii;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Ayon
 */
public class Stuinfo_User extends javax.swing.JFrame {

    private static String fname, lname, dept, year, semester, roll, age;
    private static int id;
    Connection conn = null;
    ResultSet rs = null, rs1 = null;
    PreparedStatement pst = null, pst1 = null;

    String s;
    Object[] data = new Object[10];

    //DefaultTableModel model;
    public Stuinfo_User(String fname, String lname, String dept, String year, String semester, String age, String roll, int id) throws SQLException, ClassNotFoundException {
        super("Student Information");
        this.fname = fname;
        this.lname = lname;
        this.dept = dept;
        this.year = year;
        this.semester = semester;
        this.age = age;
        this.roll = roll;
        this.id = id;
        X();

        //Show_Table();
        //model = (DefaultTableModel) PersonalResultTable.getModel();
        //PersonalResultTable.setModel(model);
        initComponents();
        Retrieve();
    }

    //Show grades to Student Individually
    public String convertMarks(String str) {
        double d = Double.parseDouble(str);

        if (d > 80) {
            return "A+";
        }
        if (d >= 75 && d < 80) {
            return "A";
        }
        if (d >= 70 && d < 75) {
            return "A-";
        }
        if (d >= 65 && d < 70) {
            return "B+";
        }
        if (d >= 60 && d < 65) {
            return "B";
        }
        if (d >= 55 && d < 60) {
            return "B-";
        }
        if (d >= 50 && d < 55) {
            return "C+";
        }
        if (d >= 45 && d < 50) {
            return "C";
        }
        if (d >= 40 && d < 45) {
            return "D";
        }

        return "F";
    }

    public Stuinfo_User() {

    }

    //Select the marks of a particular student from database
    public void X() throws SQLException, ClassNotFoundException {
        if (DatabaseTest.c == null || DatabaseTest.c.isClosed()) {
            DatabaseTest.c = new DatabaseTest().getConnection();
            conn = DatabaseTest.c;
        } else {
            conn = DatabaseTest.c;
        }

        System.out.println(this.id);
        String sql = "SELECT MATH2101, CSE2103, CSE2105, EEE2141, HUM2109, CSE2106, CSE2104, EEE2142, CSE2100 FROM result WHERE Roll = '" + this.roll + "';";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();

        /*String sql1 = "SELECT CSE2103 FROM result WHERE Roll = '" + this.roll + "';";
        pst1 = conn.prepareStatement(sql);
        rs1 = pst.executeQuery();
        //System.out.println(data[0]);*/
        if (rs.next()) {
            data[0] = convertMarks(rs.getString("MATH2101"));
            data[1] = convertMarks(rs.getString("CSE2103"));
            data[2] = convertMarks(rs.getString("CSE2105"));
            data[3] = convertMarks(rs.getString("EEE2141"));
            data[4] = convertMarks(rs.getString("HUM2109"));
            data[5] = convertMarks(rs.getString("CSE2106"));
            data[6] = convertMarks(rs.getString("CSE2104"));
            data[7] = convertMarks(rs.getString("EEE2142"));
            data[8] = convertMarks(rs.getString("CSE2100"));
        }
    }

    //Inner Table
    public class Table extends JFrame {

        JTable jt;

        Object[] columnTitle = {"CourseNo", "CourseName", "Credit", "Grade"};

        Object[][] values;

        public Table() throws SQLException, ClassNotFoundException {
            this.values = new Object[][]{{"MATH2101", "Mathematics-III", "3.0", data[0]}, {"CSE2103", "Data Structure", "3.0", data[1]}, {"CSE2105", "Digital Logic & Design", "3.0", data[2]}, {"EEE2141", "Electronic Devices & Circuits", "3.0", data[3]}, {"HUM2109", "Society, Ethics & Technology", "3.0", data[4]}, {"CSE2106", "Data Structure Lab", "1.5", data[5]}, {"CSE2104", "Digital Logic & Design Lab", "1.5", data[6]}, {"EEE2142", "Electronic Devices & Circuits Lab", "1.5", data[7]}, {"CSE2100", "Software Development-II", "0.75", data[8]}};
            jt = new JTable(values, columnTitle);
            jt.setBounds(300, 200, 200, 300);
            JScrollPane js = new JScrollPane(jt);
            this.add(js);
            this.setSize(500, 300);
            this.setBackground(new Color(204, 204, 204));
            this.setForeground(new Color(51, 51, 51));
            //this.setFont(Century);
            this.setVisible(true);
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
        jPanel1 = new javax.swing.JPanel();
        labrollshow = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cg = new javax.swing.JLabel();
        labsemestershow = new javax.swing.JLabel();
        labsemester = new javax.swing.JLabel();
        labdepartment = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lablnameshow = new javax.swing.JLabel();
        lablname = new javax.swing.JLabel();
        labfnameshow = new javax.swing.JLabel();
        labdepartmentshow = new javax.swing.JLabel();
        labyearshow = new javax.swing.JLabel();
        labageshow = new javax.swing.JLabel();
        labyear = new javax.swing.JLabel();
        imageShow = new javax.swing.JLabel();
        browse = new javax.swing.JButton();
        labroll = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        resultbutton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(225, 225, 225));

        jPanel1.setBackground(new java.awt.Color(225, 225, 225));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 24))); // NOI18N
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(null);
        jPanel1.add(labrollshow);
        labrollshow.setBounds(1146, 403, 99, 30);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        cg.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        cg.setForeground(new java.awt.Color(204, 204, 204));
        cg.setText("Age:");

        labsemestershow.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labsemestershow.setForeground(new java.awt.Color(204, 204, 204));
        labsemestershow.setText(semester);

        labsemester.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        labsemester.setForeground(new java.awt.Color(204, 204, 204));
        labsemester.setText("Semester:");

        labdepartment.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        labdepartment.setForeground(new java.awt.Color(204, 204, 204));
        labdepartment.setText("Department:");

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("First Name:");

        lablnameshow.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lablnameshow.setForeground(new java.awt.Color(204, 204, 204));
        lablnameshow.setText(lname);
        lablnameshow.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lablnameshowInputMethodTextChanged(evt);
            }
        });

        lablname.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        lablname.setForeground(new java.awt.Color(204, 204, 204));
        lablname.setText("Last Name:");

        labfnameshow.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labfnameshow.setForeground(new java.awt.Color(204, 204, 204));
        labfnameshow.setText(fname);

        labdepartmentshow.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labdepartmentshow.setForeground(new java.awt.Color(204, 204, 204));
        labdepartmentshow.setText(dept);

        labyearshow.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labyearshow.setForeground(new java.awt.Color(204, 204, 204));
        labyearshow.setText(year);

        labageshow.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labageshow.setForeground(new java.awt.Color(204, 204, 204));
        labageshow.setText(age
        );

        labyear.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        labyear.setForeground(new java.awt.Color(204, 204, 204));
        labyear.setText("Year:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labdepartment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labfnameshow, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(labdepartmentshow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labyear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labyearshow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lablname, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lablnameshow, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cg, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labageshow, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labsemester, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labsemestershow, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labfnameshow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lablname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lablnameshow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labageshow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labyear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labsemester, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labdepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labdepartmentshow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labyearshow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labsemestershow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(50, 90, 743, 150);

        imageShow.setToolTipText("");
        jPanel1.add(imageShow);
        imageShow.setBounds(810, 30, 239, 296);

        browse.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        browse.setForeground(new java.awt.Color(51, 51, 51));
        browse.setText("Browse");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        jPanel1.add(browse);
        browse.setBounds(830, 430, 90, 35);

        labroll.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        labroll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labroll.setText("ID: " + roll);
        jPanel1.add(labroll);
        labroll.setBounds(880, 360, 115, 32);

        save.setBackground(new java.awt.Color(204, 204, 204));
        save.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        save.setForeground(new java.awt.Color(51, 51, 51));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save);
        save.setBounds(960, 429, 80, 35);

        resultbutton.setBackground(new java.awt.Color(130, 157, 134));
        resultbutton.setForeground(new java.awt.Color(132, 158, 139));
        resultbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sd/ii/Icons/results-button.png"))); // NOI18N
        resultbutton.setBorder(null);
        resultbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(resultbutton);
        resultbutton.setBounds(300, 270, 100, 100);

        jButton1.setBackground(new java.awt.Color(130, 157, 134));
        jButton1.setForeground(new java.awt.Color(133, 158, 139));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sd/ii/Icons/unnamed.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(450, 270, 100, 100);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sd/ii/Icons/Apps-session-logout-icon.png"))); // NOI18N
        jButton2.setToolTipText("Log Out!");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(30, 410, 50, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sd/ii/DesktopBackground/d3.jpg"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 1100, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        // TODO add your handling code here:
        JFileChooser filechooser = new JFileChooser();
        filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        filechooser.addChoosableFileFilter(filter);

        int res = filechooser.showSaveDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filechooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            imageShow.setIcon(ResizeImage(path));
            s = path;
        } else if (res == JFileChooser.CANCEL_OPTION) {
            System.out.println("No data");
        }
    }//GEN-LAST:event_browseActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {
            // TODO add your handling code here:
            if (DatabaseTest.c == null || DatabaseTest.c.isClosed()) {
                DatabaseTest.c = new DatabaseTest().getConnection();
                conn = DatabaseTest.c;
            } else {
                //DatabaseTest.c = new DatabaseTest().getConnection();
                conn = DatabaseTest.c;
            }
            byte[] person_image = null;
            if (s == null) {
                JOptionPane.showMessageDialog(null, "No Image Inserted");
            } else {
                pst = conn.prepareStatement("update student set Image = ? WHERE ID = " + id + ";");
                FileInputStream is = new FileInputStream(s);

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];

                try {
                    for (int readNum; (readNum = is.read(buf)) != -1;) {
                        bos.write(buf, 0, readNum);
                    }
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
                person_image = bos.toByteArray();
                pst.setBytes(1, person_image);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Image inserted");
            }

        } catch (SQLException | ClassNotFoundException | FileNotFoundException | HeadlessException ex) {
            Logger.getLogger(Stuinfo_User.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Stuinfo_User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveActionPerformed

    private void lablnameshowInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lablnameshowInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lablnameshowInputMethodTextChanged

    private void resultbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultbuttonActionPerformed
        try {
            new Table();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Stuinfo_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_resultbuttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (DatabaseTest.c == null || DatabaseTest.c.isClosed()) {
                DatabaseTest.c = new DatabaseTest().getConnection();
                conn = DatabaseTest.c;
            } else {
                //DatabaseTest.c = new DatabaseTest().getConnection();
                conn = DatabaseTest.c;
            }
            String sql = "select CGPA from result where Roll  = '" + this.roll + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Your CGPA : " + rs.getString("CGPA"));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Stuinfo_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        StudentLogIn stu = null;
        try {
            stu = new StudentLogIn();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Stuinfo_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        stu.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    public void Retrieve() {
        try {
            if (DatabaseTest.c == null || DatabaseTest.c.isClosed()) {
                DatabaseTest.c = new DatabaseTest().getConnection();
                conn = DatabaseTest.c;
            } else {
                conn = DatabaseTest.c;
            }

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from student where Roll = '" + roll + "'");
            if (rs.next()) {
                byte[] img = rs.getBytes("Image");
                //Resize The ImageIcon
                if (img != null) {
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(imageShow.getWidth(), imageShow.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    imageShow.setIcon(newImage);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No Data");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public ImageIcon ResizeImage(String imgPath) {
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(imageShow.getWidth(), imageShow.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stuinfo_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Stuinfo_User(fname, lname, dept, year, semester, age, roll, id).setVisible(true);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(Stuinfo_User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse;
    private javax.swing.JLabel cg;
    private javax.swing.JLabel imageShow;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labageshow;
    private javax.swing.JLabel labdepartment;
    private javax.swing.JLabel labdepartmentshow;
    private javax.swing.JLabel labfnameshow;
    private javax.swing.JLabel lablname;
    private javax.swing.JLabel lablnameshow;
    private javax.swing.JLabel labroll;
    private javax.swing.JLabel labrollshow;
    private javax.swing.JLabel labsemester;
    private javax.swing.JLabel labsemestershow;
    private javax.swing.JLabel labyear;
    private javax.swing.JLabel labyearshow;
    private javax.swing.JButton resultbutton;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
