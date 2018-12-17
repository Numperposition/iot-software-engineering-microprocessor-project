
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Title      : Choosedate.java
 * Description: This class is used to choose which the date to book, delete or add the schedule.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class Choosedate
{
	JFrame frame;
	private int flag = -1;
	//String k = "f";
	/**
	 * Constructor
	 * This method initial the choose date GUI
	 * @param t Indicates which function to switch to
	 */
	public  Choosedate(int t)
	{
		flag = t;
		frame = new JFrame();
		String f = "Please choose the availible date";
		JLabel label = new JLabel(f, JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(new java.awt.Color(240,255,255));
        label.setFont(new Font("Apple Chancery", Font.PLAIN, 30));
		JPanel panel1 = new JPanel(new GridLayout(2,4));
          panel1.setBackground(new java.awt.Color(240,255,255));
	    JPanel panel3 = new JPanel(new GridLayout(1,3));
          panel3.setBackground(new java.awt.Color(240,255,255));
		JButton[] button = new JButton[7];
		
		for(int i = 0; i < 7; i++)
			{
				button[i] = new JButton(i + 1 + "");
	    
				button[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
				button[i].addActionListener(new BtListener(i));
				panel1.add(button[i]);
			}
		 
		JButton l = new JButton("BACK"), n = new JButton("EXIT");
        l.setFont(new Font("Britannic Bold", Font.PLAIN, 15));n.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		panel3.add(l);panel3.add(n);
		      l.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    new CoreGUI();
				    frame.setVisible(false);
				}});	                                              	
	          n. addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					new Thanks();
				    frame.setVisible(false);
				}});
		frame.getContentPane().add(BorderLayout.NORTH,label);
	    frame.getContentPane().add(BorderLayout.CENTER,panel1); 
	    frame.getContentPane().add(BorderLayout.SOUTH,panel3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(800, 600);
		frame.setVisible(true);
   }
	/**
	 * A class to listen the buttons.
	 * @author Group 78
	 * @version 1.0
	 */
   public class BtListener implements ActionListener
   {
	   private int i = 0;
	   public BtListener(int i)
	   {
		   this.i = i;
	   }
	   /**
	    * A method to switch to other interface according to the value of flag.
	    */
	   public void actionPerformed(ActionEvent e)
		{
		    if(flag == 0)
		    {
		      CurrentPurchase.day =  this.i + 1;
	          new Movies();
		    }
			if(flag == 1)
			{
				new AddScheduleGUI(this.i + 1);
			}
			if(flag == 2)
			{
				new DeleteChooseScreen(this.i);
			}
			if(flag == 3)
			{
				new ViewReportGUI(this.i + 1);
			}
	        frame.dispose();
       }
   }
	
}
