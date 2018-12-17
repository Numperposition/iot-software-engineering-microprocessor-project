

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Title      : TicketTypesGUI.java
 * Description: This class to show and allow user to choose the type of ticket.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class TicketTypesGUI {
	
	private JFrame frame;
	@SuppressWarnings("rawtypes")
	private JComboBox[] box;
	private CurrentPurchase cp;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public  TicketTypesGUI()
	     {
		
		frame = new JFrame();
		String f = "<html>Please choose the types of ticket of " + CurrentPurchase.filmName +
				"<br/>tickets remain:" + CurrentPurchase.ticketCount;
		
		JLabel label = new JLabel(f, JLabel.CENTER);
             label.setOpaque(true);
             label.setBackground(new java.awt.Color(240,255,255));
             label.setFont(new Font("Apple Chancery", Font.PLAIN, 20));
		JPanel panel1 = new JPanel(new GridLayout(5,4));
		JPanel panel2 = new JPanel(new GridLayout(5,1));
		JPanel panel3 = new JPanel(new GridLayout(1,3));
		JLabel[][] label11=new JLabel[5][4];
		//TextField[][] Field = new TextField[5][1];
		box = new JComboBox[5];
		String[] str = {"0", "1", "2", "3", "4", "5"};
		cp = new CurrentPurchase();
		label11[0][0] = new JLabel("Type", JLabel.CENTER);
		label11[0][1] = new JLabel("Discription", JLabel.CENTER);
		label11[0][2] = new JLabel("Discount", JLabel.CENTER);
		label11[0][3] = new JLabel("Actual Price", JLabel.CENTER);
		label11[1][0] = new JLabel("Child", JLabel.CENTER);
		label11[1][1] = new JLabel("2 to 17 yeas old", JLabel.CENTER);
		label11[1][2] = new JLabel(cp.childDiscount +"%", JLabel.CENTER);
		label11[1][3] = new JLabel(cp.childUnitprice()+"", JLabel.CENTER);
		label11[2][0] = new JLabel("Adult", JLabel.CENTER);
		label11[2][1] = new JLabel("18 years and older", JLabel.CENTER);
		label11[2][2] = new JLabel("None", JLabel.CENTER);
		label11[2][3] = new JLabel(CurrentPurchase.filmPrice+"", JLabel.CENTER);
		label11[3][0] = new JLabel("Senior", JLabel.CENTER);
		label11[3][1] = new JLabel("55 years and older", JLabel.CENTER);
		label11[3][2] = new JLabel(cp.seniorDiscount+"%", JLabel.CENTER);
		label11[3][3] = new JLabel(cp.seniorUnitprice()+"", JLabel.CENTER);
		label11[4][0] = new JLabel("Student", JLabel.CENTER);
		label11[4][1] = new JLabel("<html>18 years and older<br/>"
				+ "in full time education<br/>need Student ID", JLabel.CENTER);
		label11[4][2] = new JLabel(cp.studDiscount+"%", JLabel.CENTER);
		label11[4][3] = new JLabel(cp.studUnitprice()+"", JLabel.CENTER);
			
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 4; j++)
			{
			  label11[i][j].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245,255,250)));
                label11[i][j].setOpaque(true);
                label11[i][j].setBackground(new java.awt.Color(240,255,240));
                label11[i][j].setFont(new Font("Birch Std", Font.PLAIN, 20));
			  panel1.add(label11[i][j]);
			}
			
		}
		panel2.add(new JLabel("number"));
		panel2.setBackground(new java.awt.Color(240,255,240));
		
		for(int i = 1; i < 5; i++) //can choose up to five ticket for each type of ticket
		{
			
			box[i-1] = new JComboBox(str);
            box[i-1].setOpaque(true);
            box[i-1].setBackground(new java.awt.Color(240,255,240));
			box[i-1].addItemListener(new BoxItemListener(i - 1));
				panel2.add(box[i-1]);
			
		}
		JButton l = new JButton("BACK"), n = new JButton("exit");
		JButton r = new JButton("ok");
             l.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
             n.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
             r.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		      l.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
			//		new Introduction(); 
					
					cp.setChildTicketNum(0);
					cp.setAdultTicketNum(0);
					cp.setElderTicketNum(0);
					cp.setStudTicketNum(0);
					new SelectTimeGUI();
				    frame.dispose();
				}});	                                              	
             n. addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                	 cp.setChildTicketNum(0);
 					 cp.setAdultTicketNum(0);
 					 cp.setElderTicketNum(0);
 					 cp.setStudTicketNum(0);
                     new Thanks();
                     frame.dispose();
                 }});
	          r.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//cp.setAdultTicketNum(box[0]);
						if(CurrentPurchase.totalTicket() == 0)
						{
							new ErrorGUI("Please choose the number of ticket.",frame);
						}
						else if(cp.check() == false)
						{
							new ErrorGUI("There's no enough tickets.",frame);
						}
						else
						{
							switch (CurrentPurchase.screenNum)
						   {
						       case 1:new Screen1GUI("Screen 1");
						              break;
						       case 2:new Screen2GUI("Screen 2");
						              break;
						       case 3:new Screen3GUI();
						              break;
						       default: ;
						   }
							 frame.dispose();
						}
						
					
					   
					}});
	    panel3.add(l);
	    panel3.add(n);
	    panel3.add(r);
             panel3.setBackground(new java.awt.Color(240,255,255));
		frame.getContentPane().add(BorderLayout.NORTH,label);
        frame.getContentPane().add(BorderLayout.EAST,panel2);
        frame.getContentPane().add(BorderLayout.CENTER,panel1);
        frame.getContentPane().add(BorderLayout.SOUTH,panel3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(800,600);
		frame.setVisible(true);
}
	public class BoxItemListener implements ItemListener
	{
		private int i = 0;
		public BoxItemListener(int j)
		{
			i = j;
		}
		public void itemStateChanged(ItemEvent e)
		{
			if(e.getStateChange() == ItemEvent.SELECTED)
			{
				
				String s = (String)box[i].getSelectedItem();
				switch(i)
				{
				  case 0:
					  cp.setChildTicketNum(Integer.parseInt(s));
					  break;
				  case 1:
					  cp.setAdultTicketNum(Integer.parseInt(s));
					  break;
				  case 2:
					  cp.setElderTicketNum(Integer.parseInt(s));
					  break;
				  default:
					  cp.setStudTicketNum(Integer.parseInt(s));
				  			         
				}
				
			}
			System.out.println("childNum = " + CurrentPurchase.childTicketNum);
			System.out.println("adultNum = " + CurrentPurchase.adultTicketNum);
			System.out.println("seniorNum = " + CurrentPurchase.elderTicketNum);
			System.out.println("studNum = " + CurrentPurchase.studTicketNum);
		}
	}
}
