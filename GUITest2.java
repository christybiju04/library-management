//Sign in
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class GUITest2 implements ActionListener{
    
    JFrame frame1;
    JPanel panel1;
    JButton button1,button2;
    JRadioButton r1,r2,s1,s2;
    JLabel label1,label2,label3,label4,label5,label6,label7;
    JMenuBar menubar;
    JMenu menu1,menu2,menu3;
    JMenuItem item1,item2,item3,item4,item6;
    JTextField text1,text2,text3;
    JPasswordField pass1;
    JTextArea area1;
    JScrollPane scrollpane1;
    // img on label, colors on background, handle events
    
    ButtonGroup G = new ButtonGroup(); //for gender
    ButtonGroup S= new ButtonGroup(); //for status
    
    Connection dbcon;
    Statement stmt;
    ResultSet rs;
    String query;
    Connection connection;

    void GUI(){
        
        frame1= new JFrame("Login form");
	frame1.setSize(600,500);
	panel1=new JPanel();
        //panel display sets
        panel1.setLayout(new FlowLayout());
        //panel1.setBackground(Color.lightGray);
        panel1.setLayout(new GridLayout(0, 3, 10, 10));
        
		
	button1=new JButton("INSERT");
	button2=new JButton("CLEAR");
	button1.addActionListener(this);
	button2.addActionListener(this);
        
                /*button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                GUITest3 gui = new GUITest3();
                gui.GUI();
                frame1.dispose();
                } 
                });
		*/
                
		r1=new JRadioButton("Female");
		r2=new JRadioButton("Male");
                s1=new JRadioButton("Part-Time");
                s2=new JRadioButton("Full-Time");
                
		
	label1=new JLabel("Name: ");
	label2=new JLabel("Password: ");
	label3=new JLabel("phone No.:");
	label4=new JLabel("Gender:");
        label5=new JLabel("Email:");
        label6=new JLabel("EMPLOYEE REGISTERATION");
        label7=new JLabel("Status");
        
        area1=new JTextArea(0, 15);
        scrollpane1=new JScrollPane(area1);
        
	menubar=new JMenuBar();
	menu1=new JMenu("File");
	menu2=new JMenu("GoTo");
	menu3=new JMenu("Help");
               	
		item1=new JMenuItem("New");
		item2=new JMenuItem("Open");
		item3=new JMenuItem("Save As");
                item4=new JMenuItem("Previous Page");
                item6=new JMenuItem("About");
		
        text1=new JTextField(30);
        text2=new JTextField(11);
        text3=new JTextField(30);
		pass1=new JPasswordField(30);
		pass1.setEchoChar('*');
        
        panel1.add(new JLabel());
        panel1.add(label6); // employee registration
        panel1.add(new JLabel());
        panel1.add(label1);  //name
	panel1.add(text1);
        panel1.add(new JLabel());
	panel1.add(label2);  //password
	panel1.add(pass1);
        panel1.add(new JLabel());
	panel1.add(label3);  //phone no.
        panel1.add(text2);
        panel1.add(new JLabel());
        panel1.add(label4); //radio button
	panel1.add(r1);
	panel1.add(r2);	
		G.add(r1);
		G.add(r2);
        panel1.add(label5);
        panel1.add(text3); //address
        panel1.add(new JLabel());
        panel1.add(label7);  //radio button
        panel1.add(s1); 
	panel1.add(s2);
                S.add(s1);
                S.add(s2);
        
	panel1.add(button1);
	panel1.add(button2);
        
        
	    //menu 
	    menu1.add(item1);
            menu1.add(item2);
            menu1.add(item3);
            menu2.add(item4);
            menu3.add(item6);
                    
                menubar.add(menu1);
                menubar.add(menu2);
                menubar.add(menu3);
                frame1.setJMenuBar(menubar);
                
                item4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                Mainpage gui = new Mainpage();
                gui.GUI();
                frame1.dispose();
                }
                });
                 
    
                 
                frame1.add(panel1); 
                frame1.setVisible(true);
                
    }

    
    //for database
    public void actionPerformed(ActionEvent e)
	{
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                dbcon = DriverManager.getConnection("jdbc:mysql://localhost/GUITestdb","root","root");
                stmt = dbcon.createStatement();
               
                if (e.getSource() == button1)
                {
                    String gender = r1.isSelected() ? "Female" : "Male";
                    String status = s1.isSelected() ? "Part-Time":"Full-Time";
                    query = "insert into employee values('"+text1.getText()+"', '"+pass1.getText()+"','"+text2.getText()+"','"+gender+"','" +text3.getText()+ "','" +status+ "')"; 
                    stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(panel1,"record inserted");
                }
                
                if (e.getSource() == button2)
                {
                    text1.setText("");
                    pass1.setText("");
                    text2.setText("");
                    text3.setText("");
                }
                

            }
            catch(Exception ae)
            {
                System.out.println("Sorry failed to connect to the database.." + ae.getMessage());
            }
            
            G.clearSelection();
            S.clearSelection();
        }
    
    
    
    public static void main(String[] args) {
        GUITest2 h1=new GUITest2();
	h1.GUI();
        System.out.println("GUI accessed successfully!!");
    }
    
}