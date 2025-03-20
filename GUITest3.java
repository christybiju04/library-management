//Login
import javax.swing.*;
import java.awt.*;
class GUITest3 {
    
    JFrame frame1;
    JPanel panel1;
    JCheckBox c1,c2,c3,c4,c5;
    JLabel label1;
    JMenuBar menubar;
    JMenu menu1,menu2,menu3;
    JMenuItem item1,item2,item3,item4,item5,item6;
    JPasswordField pass1;
    JTextArea area1;
    JScrollPane scrollpane1;
    // img on label, colors on background, handle events
    
    ButtonGroup G = new ButtonGroup(); //for gender
    ButtonGroup S= new ButtonGroup(); //for status

    void GUI(){
        
        frame1= new JFrame("Login form");
	frame1.setSize(600,400);
	panel1=new JPanel();
        //panel display sets
        panel1.setLayout(new FlowLayout());
        //panel1.setBackground(Color.lightGray);
        panel1.setLayout(new GridLayout(0, 3, 10, 10));
		
                c1=new JCheckBox("Update the files");
                c2=new JCheckBox("Check the assigned work");
                c3=new JCheckBox("Meetings");
                c4=new JCheckBox("Checking of the unused files");
                c5=new JCheckBox("Work on new project");
                
		
	label1=new JLabel("WORK FOR THE DAY: ");
        
        area1=new JTextArea(0, 15);
        scrollpane1=new JScrollPane(area1);
        
	menubar=new JMenuBar();
	menu1=new JMenu("File");
	menu2=new JMenu("Edit");
	menu3=new JMenu("Help");
               	
		item1=new JMenuItem("New");
		item2=new JMenuItem("Open");
		item3=new JMenuItem("Save As");
                item4=new JMenuItem("Undo");
                item5=new JMenuItem("Redo");
                item6=new JMenuItem("About");
		
        
		pass1=new JPasswordField(30);
		pass1.setEchoChar('*');
        
        panel1.add(new JLabel());
        panel1.add(label1);  //name
        panel1.add(new JLabel());
        panel1.add(new JLabel());
	panel1.add(c1);
        panel1.add(new JLabel());
	panel1.add(new JLabel());
	panel1.add(c2);
        panel1.add(new JLabel());
        panel1.add(new JLabel());
	panel1.add(c3);  
        panel1.add(new JLabel());
        panel1.add(new JLabel());
        panel1.add(c4);
        panel1.add(new JLabel());
        panel1.add(new JLabel());
        panel1.add(c5);
       
        
	
	    //menu 
	    menu1.add(item1);
            menu1.add(item2);
            menu1.add(item3);
            menu2.add(item4);
            menu2.add(item5);
            menu3.add(item6);
                    
                menubar.add(menu1);
                menubar.add(menu2);
                menubar.add(menu3);
                frame1.setJMenuBar(menubar);
                /*
                item4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                GUITest gui = new GUITest();
                gui.GUI();
                frame1.dispose();
                }
                });
                item5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                GUITest3 gui = new GUITest3();
                gui.GUI();
                frame1.dispose();
                }
                });
    */
                 
                frame1.add(panel1); 
                frame1.setVisible(true);
                
    }

    
    public static void main(String[] args) {
        GUITest3 h1=new GUITest3();
	h1.GUI();
        System.out.println("GUI accessed successfully!!");
    }

  
}