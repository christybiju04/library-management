//admin login
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.sql.DriverManager;

class GUITest4 {
    JButton button,button1;
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
        frame=new JFrame("ADMIN");
        frame.setSize(500,500);
        
        panel=new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.lightGray);
        panel.setLayout(new GridLayout(0, 3, 10, 10));
        
        button=new JButton("Login");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformedLogin(e);
            }
        });
        
        
        
        
        label=new JLabel("                   ADMIN-LOGIN");
        label1=new JLabel("Name");
        label2=new JLabel("password");
        
        text1=new JTextField(30);
        pass=new JPasswordField(6);
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
      
        
        
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public void actionPerformedLogin(ActionEvent e)
	{
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                dbcon = DriverManager.getConnection("jdbc:mysql://localhost/GUITestdb","root","root");
                stmt = dbcon.createStatement();
                
                String username=text1.getText();
                String password=new String(pass.getPassword());
                if (username.equals("admin") && password.equals("admin123")) {
                    JOptionPane.showMessageDialog(panel, "Login successful!");
                    frame.setVisible(false);
                    GUITest5 menuPage = new GUITest5();
                    menuPage.GUI();
                    frame.setVisible(true);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid username or password. Please try again.");
                }
            }

            catch(Exception ae)
            {
                System.out.println("Sorry failed to connect to the database.." + ae.getMessage());
            }
        }

    
    public static void main (String[] args){
        GUITest4 n1=new GUITest4();
        n1.GUI();
    }
}