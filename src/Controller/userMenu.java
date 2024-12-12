package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class userMenu {
    private JFrame frameLogin, frameHome;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, buyBookButton;

    public userMenu(){
        loginMenu();
    }

    public void loginMenu(){
        frameLogin = new JFrame("Login Form");
        frameLogin.setSize(500, 400);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setLocationRelativeTo(null);
        frameLogin.setLayout(new BorderLayout());

        JLabel judulForm =  new JLabel("Login", SwingConstants.CENTER);
        frameLogin.add(judulForm, BorderLayout.NORTH);

        JPanel panelDataInput = new JPanel(new GridLayout(21, 2));
        panelDataInput.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        JLabel emailLabel = new JLabel("Email :");
        emailField = new JTextField();
        panelDataInput.add(emailLabel);
        panelDataInput.add(emailField);
  
        JLabel passwordLabel = new JLabel("Password :");
        passwordField = new JPasswordField();
        panelDataInput.add(passwordLabel);
        panelDataInput.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(400, 35));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = String.valueOf(passwordField.getPassword());
                boolean cekEmail = searchEmail(email);
                System.out.println(cekEmail);
                boolean cekPassword = searchPassword(password);
                if (cekEmail && cekPassword) {
                    JOptionPane.showMessageDialog(null, "Login Berhasil!!", "Login", 1);
                    HomePage(email);
                }
            }
        });
        frameLogin.add(loginButton, BorderLayout.SOUTH);
        frameLogin.add(panelDataInput);
        frameLogin.setVisible(true);
    }

    public boolean searchEmail(String email){
        Connection conn = DatabaseManager.connect();
        boolean found = false;
        if (conn != null) {
            try {
                String sql = "SELECT * FROM users WHERE email = '" + email + "'";
                Statement stmt = conn.createStatement();
            
                if (stmt.execute(sql)) {
                    JOptionPane.showMessageDialog(null, "Email Anda ditemukan", "Periksa Email", 1);
                    found = true;
                }else{
                    JOptionPane.showMessageDialog(null, "Login Gagal, periksa email Anda", "Periksa Email", 0);
                }
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
;        }
        return found;
    }

    public boolean searchPassword(String password){
        Connection conn = DatabaseManager.connect();
        boolean found = false;
        if (conn != null) {
            try {
                String sql = "SELECT * FROM users WHERE password = '" + password + "'";
                Statement stmt = conn.createStatement();
            
                if (stmt.execute(sql)) {
                    JOptionPane.showMessageDialog(null, "Password Anda ditemukan", "Periksa Password", 1);
                    found = true;
                }else{
                    JOptionPane.showMessageDialog(null, "Login Gagal, periksa password Anda", "Periksa Password", 0);
                }
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
;        }
        return found;
    }

    public void HomePage(String email){
        frameLogin.dispose();
        
        frameHome = new JFrame("Home From");
        frameHome.setSize(500, 400);
        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameHome.setLocationRelativeTo(null);
        frameHome.setLayout(new BorderLayout());

        JLabel judulForm =  new JLabel("Welcome\nTo\nDimasukin Keranjang", SwingConstants.CENTER);
        frameLogin.add(judulForm, BorderLayout.NORTH);

        // JPanel panelDataInput = new JPanel(new GridLayout(21, 2));
        // panelDataInput.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        buyBookButton = new JButton("Login");
        buyBookButton.setPreferredSize(new Dimension(400, 35));
        buyBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = String.valueOf(passwordField.getPassword());
                boolean cekEmail = searchEmail(email);
                System.out.println(cekEmail);
                boolean cekPassword = searchPassword(password);
                if (cekEmail && cekPassword) {
                    JOptionPane.showMessageDialog(null, "Login Berhasil!!", "Login", 1);
                }
            }
        });
        frameLogin.add(buyBookButton, BorderLayout.SOUTH);
        frameLogin.setVisible(true);
    }

    public void showBook(String email){
        Connection conn = DatabaseManager.connect();
        if (conn!= null) {
            try {
                String sql = "SELECT * FROM books";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
                while(rs.next()){
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new userMenu();
    }
}
