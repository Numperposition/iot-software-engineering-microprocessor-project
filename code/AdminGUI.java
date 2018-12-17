
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Title      : AdminGUI.java
 * Description: This class create the interface of the administrator.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class AdminGUI {
    public AdminGUI()
    {
    	JFrame frame = new JFrame("Admin");
    	JLabel head = new JLabel("Administrator Interface", JLabel.CENTER);
        head.setOpaque(true);
        head.setBackground(new java.awt.Color(240,255,255));
        head.setFont(new Font("Apple Chancery", Font.PLAIN, 30));
    	
    	JPanel centerPanel = new JPanel(new GridLayout(1, 3, 20, 20));
         centerPanel.setBackground(new java.awt.Color(240,255,255));
    	JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
         bottomPanel.setBackground(new java.awt.Color(240,255,255));
    	JButton b1 = new JButton("Add schedule");
         b1.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
    	JButton b2 = new JButton("Delete schedule");
         b2.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
    	JButton b3 = new JButton("View statistic Report");
         b3.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
    	b1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
    			//new AddScheduleGUI();
    			new Choosedate(1);
    			frame.dispose();
    		}
    	});
    	b2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
    			//new DeleteChooseScreen();
    			new Choosedate(2);
    			frame.dispose();
    		}
    	});
    	b3.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
    			//new ViewReportGUI();
    			new Choosedate(3);
    			frame.dispose();
    		}
    	});
    	JButton back = new JButton("Back");
    	back.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
                new CoreGUI();
                frame.dispose();
    		}
    	});
    	JButton exit = new JButton("Exit");
    	exit.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
                new CoreGUI();
                frame.dispose();
    		}
    	});
    	         back.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
        
    	
         exit.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
         //back.setOpaque(true);
    	b1.setFont(new Font("serif", Font.BOLD, 20));
    	b2.setFont(new Font("serif", Font.BOLD, 20));
    	b3.setFont(new Font("serif", Font.BOLD, 20));
    	centerPanel.add(b1);
    	centerPanel.add(b2);
    	centerPanel.add(b3);
    	bottomPanel.add(back);
    	bottomPanel.add(exit);
    	frame.getContentPane().add(BorderLayout.NORTH, head);
    	frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
    	frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(800,600);
		frame.setVisible(true);
        
    }
   /* public static void main(String args[])
    {
    	new AdminGUI();
    }*/
}
