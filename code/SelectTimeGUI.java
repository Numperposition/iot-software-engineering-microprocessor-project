
//package coursework;

import java.awt.*;
import javax.swing.*;

//import coursework.Movies.BtListener;

import java.awt.event.*;
import java.util.Calendar;
import java.util.StringTokenizer;
/**
 * Title      : SelectTimeGUI.java
 * Description: A class shows all the start time and allows user select the start time of a specific film.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class SelectTimeGUI
{
	JFrame frame;
	public  SelectTimeGUI()
	{
		int lineNum = 0;
		int s1flag = -1;
		int s2flag = -1;
		int s3flag = -1;
		Reader reader = new Reader();
		System.out.println("current day: " + CurrentPurchase.day);
		reader.readScreenSchedule(CurrentPurchase.day);
		for(String s : Screen1.filmList)
		{
			//System.out.println(s);
			if(s.equals(CurrentPurchase.filmName))
			{
				s1flag = Screen1.filmList.indexOf(s);
				break;
			}
		}
		
		for(String s : Screen2.filmList)
		{
			System.out.println(s);
			if(s.equals(CurrentPurchase.filmName))
			{
				s2flag = Screen2.filmList.indexOf(s);
				break;
			}			
		}
				
		
		for(String s : Screen3.filmList)
		{
			//System.out.println(s);
			if(s.equals(CurrentPurchase.filmName))
			{
				s3flag = Screen3.filmList.indexOf(s);
				break;
			}
		}
			
		
		 if(s1flag != -1)
		     lineNum += Screen1.startTime.get(s1flag).size();
		 if(s2flag != -1)
		     lineNum += Screen2.startTime.get(s2flag).size();
		 if(s3flag != -1)
		     lineNum += Screen3.startTime.get(s3flag).size();
		 
	

		frame = new JFrame();
		String str = "Please choose the time for " + CurrentPurchase.filmName ;
		JLabel label = new JLabel(str,JLabel.CENTER);
             label.setOpaque(true);
             label.setBackground(new java.awt.Color(240,255,255));
             label.setFont(new Font("Apple Chancery", Font.PLAIN, 30));
		JPanel panel1 = new JPanel(new GridLayout(lineNum,3));
		JPanel panel2 = new JPanel(new GridLayout(lineNum,1)), 
				panel3 = new JPanel(new GridLayout(1,3));
		JLabel[][] label11=new JLabel[lineNum][3];
		JButton[] buton = new JButton[lineNum];
		int i = 0;
			    if(s1flag != -1)
			    {
			    	//System.out.println("-----ok");
			    	int s1TicketCount = 0;
			    	while(i < Screen1.startTime.get(s1flag).size())  
			    	{
			    		label11[i][0] = new JLabel("Screen 1", JLabel.CENTER);
				    	label11[i][0].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245,255,250)));
                        label11[i][0].setOpaque(true);
                        label11[i][0].setBackground(new java.awt.Color(240,255,240));
                        label11[i][0].setFont(new Font("American Typewriter", Font.PLAIN, 20));
						panel1.add(label11[i][0]);
				    	label11[i][1] = new JLabel(Screen1.startTime.get(s1flag).get(i), JLabel.CENTER);
				    	label11[i][1].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245,255,250)));
                        label11[i][1].setOpaque(true);
                        label11[i][1].setBackground(new java.awt.Color(240,255,240));
                        label11[i][1].setFont(new Font("American Typewriter", Font.PLAIN, 20));
						panel1.add(label11[i][1]);
						s1TicketCount = reader.readScreen(1, i+1, CurrentPurchase.filmName, CurrentPurchase.day);
						label11[i][2] = new JLabel("rest ticket: " + s1TicketCount, JLabel.CENTER);
				    	label11[i][2].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245,255,250)));
                        label11[i][2].setOpaque(true);
                        label11[i][2].setBackground(new java.awt.Color(240,255,240));
                        label11[i][2].setFont(new Font("American Typewriter", Font.PLAIN, 20));
				    	panel1.add(label11[i][2]);
				    	buton[i] = new JButton("select");
                        buton[i].setOpaque(true);
                        buton[i].setBackground(new java.awt.Color(240,255,240));
                        buton[i].setFont(new Font("Britannic Bold", Font.PLAIN, 15));
				    	if(checkCurrentTime(Screen1.startTime.get(s1flag).get(i)) == true)
				    	{
				    		buton[i].addActionListener(new BtListener(1, i + 1, s1TicketCount));
				    		buton[i].setBackground(Color.green);
				    	}
				    	 
				    	
				    	panel2.add(buton[i]);
			    	    i++;
			    	}			    	
			    }
			    if(s2flag != -1)
			    {
			    	int j = 0;
			    	int s2TicketCount = 0;
			    	while(j < Screen2.startTime.get(s2flag).size())  
			    	{
			    		label11[i][0] = new JLabel("Screen 2", JLabel.CENTER);
				    	label11[i][0].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245,255,250)));
                        label11[i][0].setOpaque(true);
                        label11[i][0].setBackground(new java.awt.Color(240,255,240));
                        label11[i][0].setFont(new Font("American Typewriter", Font.PLAIN, 20));
						panel1.add(label11[i][0]);
				    	label11[i][1] = new JLabel(Screen2.startTime.get(s2flag).get(j), JLabel.CENTER);
				    	label11[i][1].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245,255,250)));
                        label11[i][1].setOpaque(true);
                        label11[i][1].setBackground(new java.awt.Color(240,255,240));
                        label11[i][1].setFont(new Font("American Typewriter", Font.PLAIN, 20));
						panel1.add(label11[i][1]);
						s2TicketCount = reader.readScreen(2, j+1, CurrentPurchase.filmName, CurrentPurchase.day);
						label11[i][2] = new JLabel("rest ticket: " + s2TicketCount, JLabel.CENTER);
				    	label11[i][2].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245,255,250)));
                        label11[i][2].setOpaque(true);
                        label11[i][2].setBackground(new java.awt.Color(240,255,240));
                        label11[i][2].setFont(new Font("American Typewriter", Font.PLAIN, 20));
				    	panel1.add(label11[i][2]);
				    	buton[i] = new JButton("select");
                        buton[i].setOpaque(true);
                        buton[i].setBackground(new java.awt.Color(240,255,240));
                        buton[i].setFont(new Font("Britannic Bold", Font.PLAIN, 15));
                        if(checkCurrentTime(Screen2.startTime.get(s2flag).get(j)) == true)
                        {
                        	buton[i].addActionListener(new BtListener(2, j + 1, s2TicketCount));
                        	buton[i].setBackground(Color.green);
                        }
				    	
				    	panel2.add(buton[i]);
				    	j++;
			    	    i++;
			    	}			    	
			    }
			    if(s3flag != -1)
			    {
			    	int s3TicketCount = 0;
			    	int j = 0;
			    	while(j < Screen3.startTime.get(s3flag).size())  
			    	{
			    		label11[i][0] = new JLabel("Screen 3", JLabel.CENTER);
				    	label11[i][0].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245,255,250)));
                        label11[i][0].setOpaque(true);
                        label11[i][0].setBackground(new java.awt.Color(240,255,240));
                        label11[i][0].setFont(new Font("American Typewriter", Font.PLAIN, 20));
						panel1.add(label11[i][0]);
				    	label11[i][1] = new JLabel(Screen3.startTime.get(s3flag).get(j), JLabel.CENTER);
				    	label11[i][1].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245,255,250)));
                        label11[i][1].setOpaque(true);
                        label11[i][1].setBackground(new java.awt.Color(240,255,240));
                        label11[i][1].setFont(new Font("American Typewriter", Font.PLAIN, 20));
						panel1.add(label11[i][1]);
						s3TicketCount = reader.readScreen(3, j+1, CurrentPurchase.filmName, CurrentPurchase.day);
						label11[i][2] = new JLabel("rest ticket: " + s3TicketCount, JLabel.CENTER);
				    	label11[i][2].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245,255,250)));
                        label11[i][2].setOpaque(true);
                        label11[i][2].setBackground(new java.awt.Color(240,255,240));
                        label11[i][2].setFont(new Font("American Typewriter", Font.PLAIN, 20));
				    	panel1.add(label11[i][2]);
				    	buton[i] = new JButton("select");
                        buton[i].setOpaque(true);
                        buton[i].setBackground(new java.awt.Color(240,255,240)); 
                        buton[i].setFont(new Font("Britannic Bold", Font.PLAIN, 15));
                        if(checkCurrentTime(Screen3.startTime.get(s3flag).get(j)) == true)
                        {
                        	buton[i].addActionListener(new BtListener(3, j + 1, s3TicketCount));
                        	buton[i].setBackground(Color.green);
                        }
				    	   
				    	panel2.add(buton[i]);
				    	j++;
			    	    i++;
			    	}			    	
			    }
				
		JButton l = new JButton("BACK"), n = new JButton("EXIT");
               l.setFont(new Font("Britannic Bold", Font.PLAIN, 15));  n.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		panel3.add(l);
		panel3.add(n);
             panel3.setBackground(new java.awt.Color(240,255,255));
             l.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                     new FilmIntro();
                     frame.setVisible(false);
                 }});
             n. addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                     new Thanks();
                     frame.setVisible(false);
                 }});

		frame.getContentPane().add(BorderLayout.NORTH,label);
		frame.getContentPane().add(BorderLayout.SOUTH,panel3);
		frame.getContentPane().add(BorderLayout.EAST,panel2);
		frame.getContentPane().add(BorderLayout.CENTER,panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(800,600);
		frame.setVisible(true);
   }
  /**
   * A method to compare the film start time and system current time. Not allow user to buy out-time film.
   * @param time the start time of a session. 
   * @return whether this session can be chosen or not.
   */
   private boolean checkCurrentTime(String time)
   {
	   if(CurrentPurchase.day != 0)
		   return true;
	   
	   Calendar cal = Calendar.getInstance(); 
	   
	   StringTokenizer token = new StringTokenizer(time, ":");
	   int hour = Integer.parseInt(token.nextToken());
	   int min = Integer.parseInt(token.nextToken());
	   int curHour = cal.get(Calendar.HOUR_OF_DAY);
	   int curMin = cal.get(Calendar.MINUTE);
	   if(curHour > hour)
		   return false;
	   else if(curHour == hour && curMin > min)
		   return false;
	   else 
		   return true;
   }
	public class BtListener implements ActionListener{
		private int screenNum = 0;
		private int startTime = 0;
		private int ticketCount = 0;
		
		public BtListener(int sn, int st, int tc)
		{
			screenNum = sn;
			startTime = st;
			ticketCount = tc;
		}
		public void actionPerformed(ActionEvent e)
		{
			CurrentPurchase.screenNum = screenNum;
    		CurrentPurchase.startTime = startTime;
    		CurrentPurchase.ticketCount = ticketCount;
    		System.out.println("screen " + CurrentPurchase.screenNum + 
    				",startTime: " + CurrentPurchase.startTime +
    				", ticketCount:" + CurrentPurchase.ticketCount);
    		new TicketTypesGUI();
    		frame.dispose();
		}
		
	}
}
