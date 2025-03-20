//welcome
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class Mainpage implements ActionListener{
    JButton button,button1,button2;
    JPanel panel;
    JFrame frame;
    JLabel label,label1,label2;
    JTextField text1;
    JPasswordField pass;
    
    Connection dbcon;
    Statement stmt;
    ResultSet rs;
    String query;
    Connection connection;
    
    void GUI() {
        frame=new JFrame("welcome page");
        frame.setSize(500,500);
        
        panel=new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.lightGray);
        panel.setLayout(new GridLayout(0, 3, 10, 10));
        
        button=new JButton("Login");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUITest3 gui2 = new GUITest3();
                gui2.GUI();
                frame.dispose();
            }
        });
        button1=new JButton("Sign in");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUITest2 gui2 = new GUITest2();
                gui2.GUI(); 
                frame.dispose();
            }
        });
        button2=new JButton("Admin-Login");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUITest4 gui2 = new GUITest4();
                gui2.GUI(); 
                frame.dispose();
            }
        });
        
        
        label=new JLabel("                   WELCOME");
        label1=new JLabel("Name");
        label2=new JLabel("password");
        
        text1=new JTextField(30);
        pass=new JPasswordField(5);
        pass.setEchoChar('*');
        
        panel.add(new JLabel());
        panel.add(label);
        
        panel.add(new JLabel());
        panel.add(label1);
        panel.add(text1);
        panel.add(new JLabel());
        panel.add(label2);
        panel.add(pass);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(button);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(button1);
        panel.add(button2);
        
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
	{
            
            String username = text1.getText();
            String password = new String(pass.getPassword());

            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                dbcon = DriverManager.getConnection("jdbc:mysql://localhost/GUITestdb","root","root");
                stmt = dbcon.createStatement();
            
                
                PreparedStatement query = dbcon.prepareStatement("SELECT * FROM employee WHERE username=? AND password=?");
                query.setString(1, username);
                query.setString(2, password);
                rs = query.executeQuery();
                
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                }
            }

            catch(Exception ae)
            {
                System.out.println("Sorry failed to connect to the database.." + ae.getMessage());
            }
        }
    
    public static void main (String[] args){
        Mainpage n1=new Mainpage();
        n1.GUI();
    }
}