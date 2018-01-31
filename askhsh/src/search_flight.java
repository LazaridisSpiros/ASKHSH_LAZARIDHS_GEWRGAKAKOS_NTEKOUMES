import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
/*
 * Airline Reservation system
 * Designed and Developed by cbsecsnip.in.
 */


public class search_flight extends javax.swing.JFrame {

    
    Connection con;
    Statement smt;
    ResultSet rs;
    DateFormat formatter;
    Date dt,dt7;
    SimpleDateFormat sdf;
    login alllog;
    String origin=null;
    String target=null;
    String fclass=null;
    String sql=null;
    String strdtver1=null;
    String strdtver2=null;
    String strdtver3=null;
    String search = "";
    public search_flight(login log1) {
        alllog=log1;
        log1.setVisible(false);
        
        initComponents();
        this.setLocationRelativeTo(null);
        try
        {
            Class .forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a_r_s","root","");
            jDateChooser1.setDate(Calendar.getInstance().getTime());
            sdf= new SimpleDateFormat("dd-MM-yyyy");
        }
        catch(Exception e)
        {
         System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JAVA AIRWAYS - Search Flight");
        setName("search_flight"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 152, -1));

        jLabel4.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(200, 17, 27));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Airline Reservation System");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 320, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 0));
        jLabel7.setText("--->");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 30, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 0));
        jLabel8.setText("Class:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 40, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "Business", "Executive", "Economy" }));
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 110, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 0));
        jLabel9.setText("Journey Date:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 100, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 0));
        jLabel10.setText("Origin:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select City", "Athens", "Thesaloniki", "Giannena", "Iraklio", "Kalamaria", "Mani", "LamiaDomoko" }));
        jPanel3.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select City", "Athens", "Thesaloniki", "Giannena", "Iraklio", "Kalamaria", "Mani", "LamiaDomoko" }));
        jPanel3.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 170, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 0));
        jLabel11.setText("Destination:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 90, -1));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(102, 102, 0));
        jCheckBox1.setText("Also show next 7 days schedule");
        jPanel3.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, -1));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Filght Name", "Departure Time", "BC Seats Available", "XC Seats Available", "EC Seats Available"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setOpaque(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 770, 220));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Please login for booking process...Click here for Login Window");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, -1));

        jPanel2.add(jPanel3, new java.awt.GridBagConstraints());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/checkin1.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jLabel1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    public void checkSevenDay()
    {
        if(jCheckBox1.isSelected())
        {
            sql="SELECT a.flightno,a.flightdate,a.bcsavailable,a.xcsavailable,a.ecsavailable,b.deptime FROM "
                    + "scheduledflights a,flights b WHERE a.flightno IN (SELECT flightno FROM flights WHERE aircrafttypeID IN "
                    + "(SELECT aircraft.aircrafttypeID FROM aircraft WHERE aircrafttypeID IN "
                    + "(SELECT aircrafttypeID FROM sector, flights WHERE source LIKE '"+ origin
                    + "' AND destination LIKE '" + target + "' AND sector.sectorID = flights.sectorID))) "
                    + "AND flightdate BETWEEN '"+strdtver2+"' AND '"+strdtver3+"' AND a.flightno=b.flightno ORDER BY a.flightdate";   
        }
        else
        {
            sql="SELECT  a.flightno,a.flightdate,a.bcsavailable,a.xcsavailable,a.ecsavailable,b.deptime FROM scheduledflights a,flights b WHERE a.flightno IN"
                + " (SELECT flightno FROM flights WHERE aircrafttypeID IN "
                + "(SELECT aircraft.aircrafttypeID FROM aircraft WHERE aircrafttypeID IN "
                + "(SELECT aircrafttypeID FROM sector,flights WHERE source LIKE '"+ origin 
                + "' AND destination LIKE '" + target + "' AND sector.sectorID=flights.sectorID) "+search
                + ")) AND a.flightno=b.flightno AND DATE(flightdate) = '" + strdtver2 + "'";
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        final Object[] columnNames=new String[] {"Date","Flight Name","Departure Time","BC Seats Available","XC Seats Available","EC Seats Available"};
        DefaultTableModel dtm=new DefaultTableModel(columnNames,0);        
        origin=jComboBox3.getSelectedItem().toString();
        target=jComboBox4.getSelectedItem().toString();
        fclass=jComboBox1.getSelectedItem().toString();
        
        dt=jDateChooser1.getDate();      
        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd");
        strdtver2=(String) sdf1.format(jDateChooser1.getDate());
        /**************************************
        //Seven days flight calendar processing
        **************************************/
        dt7=jDateChooser1.getDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt7);
        cal.add(Calendar.DATE, 7);
        dt7 = cal.getTime();
        strdtver3=(String) sdf1.format(dt7);
        
        /***************************
        //ALL Class Processing
        ***************************/
        if(fclass.equals("ALL"))
        {
            try
            {
                smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                checkSevenDay();
                rs = smt.executeQuery(sql);
                int i = 0;
                boolean empty=true;
                String var1="", var2="", var3="", var4="", var5="";
                while(rs.next())
                {
                    empty=false;
                    var1=rs.getString(1);
                    strdtver1=(String) sdf.format(rs.getDate(2));
                    var2=Integer.toString(rs.getInt(3));
                    var3=Integer.toString(rs.getInt(4));
                    var4=Integer.toString(rs.getInt(5));
                    var5=rs.getString(6);
                    dtm.addRow(new Vector());
                    dtm.setValueAt(strdtver1, i, 0);
                    dtm.setValueAt(var1, i, 1);
                    dtm.setValueAt(var5, i, 2);
                    dtm.setValueAt(var2, i, 3);
                    dtm.setValueAt(var3, i, 4);
                    dtm.setValueAt(var4, i, 5);
                    i++;
                }
                if(empty)
                {
                    dtm.addRow(new Vector());
                    strdtver2=(String) sdf.format(jDateChooser1.getDate());
                    dtm.setValueAt(strdtver2, i, 0);
                    dtm.setValueAt("No Flights", i, 1);
                    dtm.setValueAt("No Flights", i, 2);
                    dtm.setValueAt("0", i, 3);
                    dtm.setValueAt("0", i, 4);
                    dtm.setValueAt("0", i, 5);
                }
                jTable1.setModel(dtm);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
        /***************************
        //Business Class Processing
        ****************************/
        if(fclass.equals("Business"))
        {
            search="AND bseats>0";
        try
        {
           smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
           checkSevenDay();
           rs = smt.executeQuery(sql);
           int i = 0;
           boolean empty=true;
           String var1="", var2="", var3="", var4="", var5="";
           while(rs.next())
           {
               empty=false;
               var1=rs.getString(1);
               strdtver1=(String) sdf.format(rs.getDate(2));
               var2=Integer.toString(rs.getInt(3));
               var3=Integer.toString(rs.getInt(4));
               var4=Integer.toString(rs.getInt(5));
               var5=rs.getString(6);
               dtm.addRow(new Vector());
               dtm.setValueAt(strdtver1, i, 0);
               dtm.setValueAt(var1, i, 1);
               dtm.setValueAt(var5, i, 2);
               dtm.setValueAt(var2, i, 3);
               dtm.setValueAt(var3, i, 4);
               dtm.setValueAt(var4, i, 5);
               i++;
               
           }
           if(empty)
           {
               dtm.addRow(new Vector());
               strdtver2=(String) sdf.format(jDateChooser1.getDate());
               dtm.setValueAt(strdtver2, i, 0);
               dtm.setValueAt("No Flights", i, 1);
               dtm.setValueAt("No Flights", i, 2);
               dtm.setValueAt("0", i, 3);
               dtm.setValueAt("0", i, 4);
               dtm.setValueAt("0", i, 5);
           }
           jTable1.setModel(dtm);
           TableColumnModel m=jTable1.getColumnModel();
           TableColumn col=m.getColumn(4);
           TableColumn col1=m.getColumn(5);
           m.removeColumn(col);
           m.removeColumn(col1);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        }
        /***************************
        //Executive Class Processing
        ****************************/
        if(fclass.equals("Executive"))
        {
            search="AND xseats>0";
            try
            {
                smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                checkSevenDay();
                rs = smt.executeQuery(sql);
                int i = 0;
                boolean empty=true;
                String var1="", var2="", var3="", var4="", var5="";
                while(rs.next())
                {
                    empty=false;
                    var1=rs.getString(1);
                    strdtver1=(String) sdf.format(rs.getDate(2));
                    var2=Integer.toString(rs.getInt(3));
                    var3=Integer.toString(rs.getInt(4));
                    var4=Integer.toString(rs.getInt(5));
                    var5=rs.getString(6);
                    dtm.addRow(new Vector());
                    dtm.setValueAt(strdtver1, i, 0);
                    dtm.setValueAt(var1, i, 1);
                    dtm.setValueAt(var5, i, 2);
                    dtm.setValueAt(var2, i, 3);
                    dtm.setValueAt(var3, i, 4);
                    dtm.setValueAt(var4, i, 5);
                    i++;
                }
                if(empty)
                {
                    dtm.addRow(new Vector());
                    strdtver2=(String) sdf.format(jDateChooser1.getDate());
                    dtm.setValueAt(strdtver2, i, 0);
                    dtm.setValueAt("No Flights", i, 1);
                    dtm.setValueAt("No Flights", i, 2);
                    dtm.setValueAt("0", i, 3);
                    dtm.setValueAt("0", i, 4);
                    dtm.setValueAt("0", i, 5);
                }
                jTable1.setModel(dtm);
                TableColumnModel m=jTable1.getColumnModel();
                TableColumn col=m.getColumn(3);
                TableColumn col1=m.getColumn(5);
                m.removeColumn(col);
                m.removeColumn(col1);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
        
        /***************************
        //Economy Class Processing
        ****************************/
        if(fclass.equals("Economy"))
        {
            search="AND eseats>0";
        try
        {
           smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
           checkSevenDay();
           rs = smt.executeQuery(sql);
           int i = 0;
           boolean empty=true;
           String var1="", var2="", var3="", var4="", var5="";
           while(rs.next())
           {
               empty=false;
               var1=rs.getString(1);
               strdtver1=(String) sdf.format(rs.getDate(2));
               var2=Integer.toString(rs.getInt(3));
               var3=Integer.toString(rs.getInt(4));
               var4=Integer.toString(rs.getInt(5));
               var5=rs.getString(6);
               dtm.addRow(new Vector());
               dtm.setValueAt(strdtver1, i, 0);
               dtm.setValueAt(var1, i, 1);
               dtm.setValueAt(var5, i, 2);
               dtm.setValueAt(var2, i, 3);
               dtm.setValueAt(var3, i, 4);
               dtm.setValueAt(var4, i, 5);
               i++;
           }
           if(empty)
           {
               dtm.addRow(new Vector());
               strdtver2=(String) sdf.format(jDateChooser1.getDate());
               dtm.setValueAt(strdtver2, i, 0);
               dtm.setValueAt("No Flights", i, 1);
               dtm.setValueAt("No Flights", i, 2);
               dtm.setValueAt("0", i, 3);
               dtm.setValueAt("0", i, 4);
               dtm.setValueAt("0", i, 5);
           }
           jTable1.setModel(dtm);
           TableColumnModel m=jTable1.getColumnModel();
           TableColumn col=m.getColumn(3);
           TableColumn col1=m.getColumn(4);
           m.removeColumn(col);
           m.removeColumn(col1);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        }
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        
    }

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
        alllog.setVisible(true);
        this.setVisible(false);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        
    }

    
    
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    
}
