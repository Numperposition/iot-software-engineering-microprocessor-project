
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Title      : BillGUI.java
 * Description: This class describe an interface to show the bill of the current purchase.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class BillGUI
{
		JFrame frame;
		CurrentPurchase cp;
		public static String startTime = null;
		public  BillGUI()
		     {
			
			frame = new JFrame();
			cp = new CurrentPurchase();
			cp.calTotalPrice();
			int sflag = 0;
	       // int k = 0;
			switch(CurrentPurchase.screenNum)
			{  
			    case 1: 
			    	    while(true)
			          {
			    	     if(CurrentPurchase.filmName.equals(Screen1.filmList.get(sflag)) == true)
			    	     {
			    	    	 break;
			    	     }
			    	     sflag++;	 
			          }
			        startTime = Screen1.startTime.get(sflag).get(CurrentPurchase.startTime-1);
			        break;
			    case 2:
		    	    while(true)
		          {
		    	     if(CurrentPurchase.filmName.equals(Screen2.filmList.get(sflag)) == true)
		    	     {
		    	    	 break;
		    	     }
		    	     sflag++;	 
		          }
		        startTime = Screen2.startTime.get(sflag).get(CurrentPurchase.startTime-1);
		        break;
			    case 3:
		    	    while(true)
		          {
		    	     if(CurrentPurchase.filmName.equals(Screen3.filmList.get(sflag)) == true)
		    	     {
		    	    	 break;
		    	     }
		    	     sflag++;	 
		          }
		        startTime = Screen3.startTime.get(sflag).get(CurrentPurchase.startTime-1);
		        break;
			}
			String f = "<html>"+CurrentPurchase.filmName+"<br>"+
			"Screen "+CurrentPurchase.screenNum + " For about: "+
					CurrentPurchase.lastTime+"min"+"<br>" + "Start time: " + startTime + "<html>";
			JLabel label = new JLabel(f,JLabel.CENTER);
			label.setFont(new Font("Baskerville", Font.PLAIN, 25));
                 label.setOpaque(true);
                 label.setBackground(new java.awt.Color(240,255,240));
			JPanel panel1 = new JPanel(new GridLayout(3,2));
			JPanel panel3 = new JPanel(new GridLayout(1,3));
			JLabel[][] label11=new JLabel[3][2];
		
		
			label11[0][0]= new JLabel("Total ticket(s)",JLabel.CENTER);
			label11[0][1]= new JLabel(CurrentPurchase.totalTicket() + "",JLabel.CENTER);
			label11[1][0]= new JLabel("Total price",JLabel.CENTER);
			label11[1][1]= new JLabel(CurrentPurchase.totalPrice + "$",JLabel.CENTER);
			label11[2][0]= new JLabel("Student ticket(s)", JLabel.CENTER);
			label11[2][1]= new JLabel(CurrentPurchase.studTicketNum + "", JLabel.CENTER);
			for(int i = 0;i<3;i++)
				{
					for(int j=0;j<2;j++)
					{
						//label11[i][j].setFont(new Font("", Font.PLAIN, 30));
				        label11[i][j].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245,255,250)));
                        label11[i][j].setOpaque(true);
                        label11[i][j].setBackground(new java.awt.Color(240,255,240));
                        label11[i][j].setFont(new Font("Birch Std", Font.PLAIN, 20));
						panel1.add(label11[i][j]);
					}
					
				}
                 panel1.setBackground(new java.awt.Color(240,255,240));
			JButton l = new JButton("BACK"), n = new JButton("EXIT"), b = new JButton("Purchase");
                 l.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
                 n.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
                 b.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
			panel3.add(l);panel3.add(n);panel3.add(b);panel3.setBackground(new java.awt.Color(240,255,255));
			      l.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						switch(CurrentPurchase.screenNum)
						{
						case 1: new Screen1GUI("Screen 1");
						        break;
						case 2: new Screen2GUI("Screen 2");
						        break;
						case 3: new Screen3GUI();
						        break;
						default: ; 
						}
					    frame.dispose();
					}});	                                              	
                 n. addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
                        System.exit(0);
                     }});
		          b. addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							if(CurrentPurchase.studTicketNum > 0)
								new IdentifyStudIdGUI(frame);
							else
								new PayBillGUI(frame);
						}});
			frame.getContentPane().add(BorderLayout.NORTH,label);
			frame.getContentPane().add(BorderLayout.SOUTH,panel3);frame.getContentPane().add(BorderLayout.CENTER,panel1);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			frame.setSize(800,600);
			frame.setVisible(true);
	}
		

}

