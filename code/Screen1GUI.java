//package coursework;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * A class to create the interface of screen1 and complete the seat choose of user.
 * @author Group 78
 * @version 1.3
 */
public class Screen1GUI 
{
	protected int sumNum = CurrentPurchase.totalTicket();
	//protected String f = "Screen 1";
	JFrame frame;
	JLabel label;
	JButton[][] label11;
	JLabel[][] label2,label3;
	JPanel panel1,panel2,panel3,panel4;
	public  Screen1GUI(String str)
	 {
		int y = 0;
		frame = new JFrame();
	    label = new JLabel(str,JLabel.CENTER); 
		label.setFont(new Font("", Font.PLAIN, 26));
		label.setOpaque(true);
		label.setBackground(Color.BLUE);
		label2 = new JLabel[7][1];
		label3 = new JLabel[7][1];
	    panel1 = new JPanel(new GridLayout(7,9));
	    panel2 = new JPanel(new GridLayout(1,3));
	    panel3 = new JPanel(new GridLayout(7,1));
	    panel4 = new JPanel(new GridLayout(7,1));
	    label11=new JButton[7][9];
	    Reader reader = new Reader();
	    reader.readScreen(CurrentPurchase.screenNum, 
	    		CurrentPurchase.startTime, CurrentPurchase.filmName, CurrentPurchase.day);
	    
		String[] s = {"D","C","B","A"};
         //this.sendData();
        String[] m ={"1","2","3","4","*","5","6","7","8"};
		for(int i = 0;i<7;i++)
			{
				for(int j=0;j<9;j++)
				{
					label11[i][j] = new JButton(m[j]);
					panel1.add(label11[i][j]);
				}	
			}
         panel1.setBackground(new java.awt.Color(240,255,255));
		for(int i = 0;i<7;i++)
		{
			if(i%2 == 0)
			{   String k = s[y];
				label2[i][0] = new JLabel(k,JLabel.CENTER);
				label2[i][0].setFont(new Font("American Typewriter", Font.PLAIN, 20));
				label3[i][0] = new JLabel(k,JLabel.CENTER);
				label3[i][0].setFont(new Font("American Typewriter", Font.PLAIN, 20));
				y++;
			}
			else
			{
				label2[i][0]= new JLabel();
				label3[i][0]= new JLabel();
			}
		}
		for(int i = 0;i<7;i++)
		{
			panel3.add(label2[i][0]);
			panel4.add(label3[i][0]);
		}
         panel3.setBackground(new java.awt.Color(240,255,255));
         panel4.setBackground(new java.awt.Color(240,255,255));
		this.modify();
		JButton l = new JButton("BACK"), n = new JButton("EXIT"),b = new JButton("OK");
         b.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
         l.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
         n.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		panel2.add(l);panel2.add(n);panel2.add(b);panel2.setBackground(new java.awt.Color(240,255,255));
		b.addActionListener(new ActionListener(){
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
				
					System.exit(0);
				  
				}});	     
		frame.getContentPane().add(BorderLayout.NORTH,panel2);
        frame.getContentPane().add(BorderLayout.EAST,panel4);
        frame.getContentPane().add(BorderLayout.WEST,panel3);
        frame.getContentPane().add(BorderLayout.SOUTH,label);
        frame.getContentPane().add(BorderLayout.CENTER,panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(800,600);
		frame.setVisible(true);
     }
	/**
	 * A method to set suitable GUI.
	 */
	public void modify()
	{
		
		int p = 0, q = 0; 
		Boolean flag = true;
		for(int i = 0; i < 7; i++)
		{
			
			//p = i;
			for(int j=0;j<9;j++)
			{ 
			   //q = j;
			   if(j == 4 || i%2 != 0)
			   {
				  label11[i][j].setVisible(false);
			   }
			   else
			   {
				  switch(i){
				   case 0: p = i;
				           break;
				   case 2: p = 1;
				           break;
				   case 4: p = 2;
						   break;
				   case 6: p = 3;
				           break;
				   default: flag = false;
				           }
				  switch(j){
				   case 4: flag = false;
				           break;
				   case 5: q = 4;
				           break;
				   case 6: q = 5;
						   break;
				   case 7: q = 6;
						   break;
				   case 8: q = 7;
				           break;
				   default: q = j;
				  }
				  if(flag)
				  {
					  if(Screen1.getScreen1()[p][q] == 1)
                      {
                          label11[i][j].setOpaque(true);
					    label11[i][j].setBackground(Color.gray);
                      }
					  else
                      
                          //label11[i][j].setOpaque(true);
						label11[i][j].addActionListener(new BtListener(i, j));
                      
				  }
				  flag = true;  
			   }
			  
			}	
		}
	}
 /**
  * A class used to listen user's seat choose
  * @author Group 78
  *
  */
	public class BtListener implements ActionListener{
		private int i = 0;
		private int j = 0;
		private int p = 0;
		private int q = 0;
		/**
		 * A constructor used to acquire the seat and convert it to actual matrix in file. 
		 * @param i the row of the seat 
		 * @param j the column of the seat
		 */
		public BtListener(int i, int j)
		{
			this.i = i;
			this.j = j;
			switch(i){
			   case 0: p = this.i;
			           break;
			   case 2: p = 1;
			           break;
			   case 4: p = 2;
					   break;
			   case 6: p = 3;
			           break;
			   default: ;
			           }
			  switch(j){
			   case 5: q = 4;
			           break;
			   case 6: q = 5;
					   break;
			   case 7: q = 6;
					   break;
			   case 8: q = 7;
			           break;
			   default: q = this.j;
			  }
		}
		public void actionPerformed(ActionEvent e)
		{
			if(label11[i][j].getBackground() == Color.red )
			{
                label11[i][j].setOpaque(true);
				label11[i][j].setBackground(null);
				sumNum++;
				Screen1.setScreen1(p, q, 0);
			}
				
			else if(label11[i][j].getBackground() != Color.red && sumNum > 0)
			{
                label11[i][j].setOpaque(true);
				label11[i][j].setBackground(Color.red);
				sumNum--;
				Screen1.setScreen1(p, q, 1);
			}
			else ;	
			
			for(int i = 0; i < 4; i++)
			{
				for(int j = 0; j < 8; j++)
					System.out.print(Screen1.getScreen1()[i][j] + " ");
				System.out.println();
			}
			System.out.println("sumNum = "+ sumNum);
		}
	}
}
