
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * Title      : Thanks.java
 * Description: This class contains the definition of Thanks service
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class Thanks 
{
	JFrame frame = new JFrame();
	 JButton buton = new JButton("ok");
public Thanks()
{
	JLabel label = new JLabel("Thanks for your patronage!!",JLabel.CENTER);
	label.setOpaque(true);
	label.setBackground(new java.awt.Color(240,255,240));
	label.setFont(new Font("Rosewood Std", Font.PLAIN, 20));
	buton.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
	buton.setOpaque(true);
	buton.setBackground(new java.awt.Color(240,255,240));
	buton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			 new CoreGUI();
			
		    frame.dispose();
		}});
	frame.getContentPane().add(BorderLayout.CENTER,label);
	frame.getContentPane().add(BorderLayout.SOUTH,buton);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	frame.setSize(500,500);
	frame.setVisible(true);
	
	
	
}


}
