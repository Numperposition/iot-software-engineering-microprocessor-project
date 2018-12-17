
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Title      : ErrorGUI.java
 * Description: A class to notice user after execute some operations. 
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class ErrorGUI extends JPanel{
	JFrame frame = new JFrame();
	  JPanel panel1 = new JPanel();
	  JButton buton = new JButton("OK");
	     public ErrorGUI(String str, JFrame tempFrame){
	           JLabel b = new JLabel(str, JLabel.CENTER);
	           b.setFont(new Font("Arial", Font.PLAIN, 15));
	           panel1.add(b);
	           frame.getContentPane().add(BorderLayout.CENTER,panel1);frame.getContentPane().add(BorderLayout.SOUTH,buton);
		       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		       frame.setTitle("Notification");
		       frame.setSize(300,150);
		       frame.setVisible(true);
		       frame.setAlwaysOnTop(true);
		       tempFrame.setEnabled(false);
		       Toolkit kit=Toolkit.getDefaultToolkit();
		        Dimension screenSize=kit.getScreenSize();  
		        int width=screenSize.width,height=screenSize.height,x=(width-WIDTH)/2,y=(height-HEIGHT)/2;
		        frame.setLocation(x,y);
		       buton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//new Purchase();
					    frame.dispose();
					    tempFrame.setEnabled(true);
					    
					}});
	     }
}
