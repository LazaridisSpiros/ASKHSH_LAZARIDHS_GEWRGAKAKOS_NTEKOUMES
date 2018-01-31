import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import javax.swing.JOptionPane;



public class nav_Frame extends javax.swing.JFrame {

   
    private BufferedImage img;
    public static JDesktopPane jdpDesktop;
    public nav_Frame(login log)
    {
        log.setVisible(false);
        initComponents();
        this.setLocationRelativeTo(null);
        try
        {
            img = ImageIO.read(new File("src\\cloud.jpg"));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        jdpDesktop = new JDesktopPane(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                double scaleFactor = Math.min(1d, getScaleFactorToFit(new Dimension(img.getWidth(), img.getHeight()), getSize()));
                int scaleWidth = (int) Math.round(img.getWidth() * scaleFactor);
                int scaleHeight = (int) Math.round(img.getHeight() * scaleFactor);
                Image scaled = img.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH);
                int width = getWidth() - 1;
                int height = getHeight() - 1;
                int x = (width - scaled.getWidth(this)) / 2;
                int y = (height - scaled.getHeight(this)) / 2;
                g.drawImage(scaled, x, y, this);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(img.getWidth(), img.getHeight());
            }
        };
        this.setContentPane(jdpDesktop);
    }
    public double getScaleFactor(int iMasterSize, int iTargetSize)
    {
        double dScale = 1;
        if (iMasterSize > iTargetSize)
        {
            dScale = (double) iTargetSize / (double) iMasterSize;
        } 
        else
        {
            dScale = (double) iTargetSize / (double) iMasterSize;
        }
        return dScale;
    }
    public double getScaleFactorToFit(Dimension original, Dimension toFit)
    {
        double dScale = 1d;
        if (original != null && toFit != null)
        {
            double dScaleWidth = getScaleFactor(original.width, toFit.width);
            double dScaleHeight = getScaleFactor(original.height, toFit.height);
            dScale = Math.min(dScaleHeight, dScaleWidth);
        }
        return dScale;
    }
    //CONSTRUCTOR
    @SuppressWarnings("unchecked")
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        settingMenu = new javax.swing.JMenu();
        staffMenuItem = new javax.swing.JMenuItem();
        aircraftMenuItem = new javax.swing.JMenuItem();
        sectorAsMenuItem = new javax.swing.JMenuItem();
        flightMenuItem = new javax.swing.JMenuItem();
        operationMenu = new javax.swing.JMenu();
        searchMenuItem = new javax.swing.JMenuItem();
        bookMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Airways - Ticket Reservation System");

        settingMenu.setMnemonic('s');
        settingMenu.setText("Setting");

        staffMenuItem.setMnemonic('t');
        staffMenuItem.setText("Staff");
        settingMenu.add(staffMenuItem);

        aircraftMenuItem.setMnemonic('a');
        aircraftMenuItem.setText("Aircraft");
        settingMenu.add(aircraftMenuItem);

        sectorAsMenuItem.setMnemonic('c');
        sectorAsMenuItem.setText("Sector");
        settingMenu.add(sectorAsMenuItem);

        flightMenuItem.setMnemonic('f');
        flightMenuItem.setText("Flight");
        flightMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightMenuItemActionPerformed(evt);
            }
        });
        settingMenu.add(flightMenuItem);

        menuBar.add(settingMenu);

        operationMenu.setMnemonic('o');
        operationMenu.setText("Operation");

        searchMenuItem.setMnemonic('r');
        searchMenuItem.setText("Search");
        searchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMenuItemActionPerformed(evt);
            }
        });
        operationMenu.add(searchMenuItem);

        bookMenuItem.setMnemonic('b');
        bookMenuItem.setLabel("Quick Book");
        bookMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookMenuItemActionPerformed(evt);
            }
        });
        operationMenu.add(bookMenuItem);

        pasteMenuItem.setMnemonic('u');
        pasteMenuItem.setText("Scheduling");
        operationMenu.add(pasteMenuItem);

        menuBar.add(operationMenu);

        exitMenu.setText("Exit");
        exitMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMenuMouseClicked(evt);
            }
        });
        menuBar.add(exitMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        pack();
    }

    private void flightMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void searchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        
        jdpDesktop.add(login.sf);
        login.sf.setVisible(true);
        
    }

    private void exitMenuMouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void bookMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        jdpDesktop.add(login.bookfrm);
        login.bookfrm.setVisible(true);
    }    
    
    // Variables 
    private javax.swing.JMenuItem aircraftMenuItem;
    private javax.swing.JMenuItem bookMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu exitMenu;
    private javax.swing.JMenuItem flightMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu operationMenu;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem searchMenuItem;
    private javax.swing.JMenuItem sectorAsMenuItem;
    private javax.swing.JMenu settingMenu;
    private javax.swing.JMenuItem staffMenuItem;
    }