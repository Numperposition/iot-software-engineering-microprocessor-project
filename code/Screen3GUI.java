

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * Title      : Screen3GUI.java
 * Description: A class to create the interface of screen3 and complete the seat choose of user.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class Screen3GUI {
	private int sumNum = CurrentPurchase.totalTicket();
	JFrame frame;
	JButton[][] label11;
	public  Screen3GUI()
	     {
		int num = 0;
		frame = new JFrame();
		String f = "Screen 3";
		JLabel label = new JLabel(f,JLabel.CENTER); 
		label.setFont(new Font("", Font.PLAIN, 26));
		label.setOpaque(true);label.setBackground(Color.BLUE);
		JLabel[][] label2 = new JLabel[9][1],label3 = new JLabel[9][1];
		JPanel panel1 = new JPanel(new GridLayout(9,8)), 
				panel2 = new JPanel(new GridLayout(1,3)),
				panel3 = new JPanel(new GridLayout(9,1)),
				panel4 = new JPanel(new GridLayout(9,1));
		label11 = new JButton[9][8];
		String[] s = {"E","D","C","B","A"};
		Reader reader = new Reader();
	    reader.readScreen(CurrentPurchase.screenNum, CurrentPurchase.startTime, CurrentPurchase.filmName, CurrentPurchase.day);
             String[] m ={"1","2","3","4","5","6","7","8"};
             String[] w ={"1","2","*","3","4","*","5","6"};
             for(int j=0;j<8;j++)
             {
                 label11[0][j] = new JButton(m[j]);
                 //panel1.add(label11[i][j]);
             }
		for(int i = 1; i < 9;i++)
			{
				for(int j=0;j<8;j++)
				{
					label11[i][j] = new JButton(w[j]);
					//panel1.add(label11[i][j]);
				}	
			}
             for(int i = 0; i < 9;i++)
             {
                 for(int j=0;j<8;j++)
                 {
                     //label11[i][j] = new JButton(w[j]);
                     panel1.add(label11[i][j]);
                 }	
             }
              panel1.setBackground(new java.awt.Color(240,255,255));
		for(int i = 0;i<9;i++)
		{
			if(i%2 == 0)
			{   String k = s[num];
				label2[i][0] = new JLabel(k,JLabel.CENTER);
				label2[i][0].setFont(new Font("", Font.PLAIN, 20));
				label3[i][0] = new JLabel(k,JLabel.CENTER);
				label3[i][0].setFont(new Font("", Font.PLAIN, 20));
				num++;
			}
			else
			{
				label2[i][0]= new JLabel();
				label3[i][0]= new JLabel();
			}
		}
		for(int i = 0;i<9;i++)
		{
			panel3.add(label2[i][0]);
			panel4.add(label3[i][0]);
		}
              panel3.setBackground(new java.awt.Color(240,255,255));
              panel4.setBackground(new java.awt.Color(240,255,255));
		for(int i = 0; i < 8; i++)
		{
			if(Screen3.getScreen3_E()[i] == 1)
				label11[0][i].setBackground(Color.gray);
			else
			{
				label11[0][i].addActionListener(new BtListener(0, i));
			}
		}
		for(int i = 1; i <= 7; i += 2)
			for(int j = 0; j < 8; j++)
				label11[i][j].setVisible(false);
		
		int p = 0, q = 0;
		for(int i = 2; i <= 8; i += 2)
		{
			p = (i - 2) / 2;
			for(int j = 0; j < 8; j++)
			{
				if(j == 2 || j == 5)
					label11[i][j].setVisible(false);
				else
				{
					if(j >= 3 && j <= 4)
						q = j - 1;
					else if(j >= 6 && j <= 7)
						q = j - 2;
					else
						q = j;
					if(Screen3.getScreen3_rest()[p][q] == 1) //if the seat is not available, set its color to grey.
						label11[i][j].setBackground(Color.gray);
					else
						label11[i][j].addActionListener(new BtListener(i, j));
				}
			}
		}
		
		JButton l = new JButton("BACK"),
				n = new JButton("EXIT"),
				r = new JButton("OK");
             r.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
             l.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
             n.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		panel2.add(l);
		panel2.add(n);
		panel2.add(r);
              panel2.setBackground(new java.awt.Color(240,255,255));
		r.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(sumNum == 0)
				{
					new BillGUI();
					frame.dispose();
				}
					
				else
					new ErrorGUI("Please complete your seat choice", frame);
			
			}
		});
		      l.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					CurrentPurchase cp = new CurrentPurchase();
					cp.setChildTicketNum(0);
					cp.setAdultTicketNum(0);
					cp.setElderTicketNum(0);
					cp.setStudTicketNum(0);
					new TicketTypesGUI();
				    frame.dispose();
				}});	                                              	
	          n. addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				//	new Thanks();
				  //  frame.setVisible(false);
					System.exit(0);
				}});	     
		frame.getContentPane().add(BorderLayout.NORTH, panel2);
        frame.getContentPane().add(BorderLayout.EAST,panel4);
        frame.getContentPane().add(BorderLayout.WEST,panel3);
        frame.getContentPane().add(BorderLayout.SOUTH,label);
        frame.getContentPane().add(BorderLayout.CENTER,panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(800,600);
		frame.setVisible(true);
   }
	/**
	  * A class used to listen user's seat choose
	  * @author Group 78
	  *
	  */
	public class BtListener implements ActionListener
	{
		private int i = 0;
		private int j = 0;
		private int p = 0;
		private int q = 0;
		private int k = 0;
		/**
		 * A constructor used to acquire the seat and convert it to actual matrix in file. 
		 * @param i the row of the seat 
		 * @param j the column of the seat
		 */
		public BtListener(int i, int j)
		{
			this.i = i;
			this.j = j;
			if(this.i == 0)
			{
				k = this.j;
			}
			else
			{
				p = (i - 2) / 2;
			    if(j >= 3 && j <= 4)
				  q = j - 1;
			    else if(j >= 6 && j <= 7)
				  q = j - 2;
			    else
				  q = j;
			}
			
		}
		public void actionPerformed(ActionEvent e)
		{
			if(this.i == 0)
			{
				if(label11[i][j].getBackground() == Color.red )
				{
					label11[i][j].setBackground(null);
					sumNum++;
					Screen3.setScreen3_E(k, 0);
				}
					
				else if(label11[i][j].getBackground() != Color.red && sumNum > 0)
				{
					label11[i][j].setBackground(Color.red);
					sumNum--;
					Screen3.setScreen3_E(k, 1);
				}
				else ;	
			}
			else
			{
				if(label11[i][j].getBackground() == Color.red )
				{
					label11[i][j].setBackground(null);
					sumNum++;
					Screen3.setScreen3_rest(p, q, 0);
				}
					
				else if(label11[i][j].getBackground() != Color.red && sumNum > 0)
				{
					label11[i][j].setBackground(Color.red);
					sumNum--;
					Screen3.setScreen3_rest(p, q, 1);
				}
				else ;	
			}
			System.out.println("sumNum = " + sumNum);
			for(int i = 0; i < 8; i++)
				System.out.print(Screen3.getScreen3_E()[i] + " ");
			System.out.println();
			for(int i = 0; i < 4; i++)
			{
				for(int j = 0; j < 6; j++)
				{
					System.out.print(Screen3.getScreen3_rest()[i][j] + " ");
				}
				System.out.println();
			}
			
		}
	}
}
