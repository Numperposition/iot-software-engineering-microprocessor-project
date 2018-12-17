
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Title      : Screen2GUI.java
 * Description: A class to create the interface of screen2 and complete the seat choose of user.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.3
 */
public class Screen2GUI  {
    protected int sumNum = CurrentPurchase.totalTicket();
    //protected String f = "Screen 1";
    JFrame frame;
    JLabel label;
    JButton[][] label11;
    JLabel[][] label2,label3;
    JPanel panel1,panel2,panel3,panel4;
	public Screen2GUI(String str)
	{
		//super(str);
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
        reader.readScreen(CurrentPurchase.screenNum, CurrentPurchase.startTime, CurrentPurchase.filmName, CurrentPurchase.day);
        
        String[] s = {"D","C","B","A"};
        //this.sendData();
        String[] m ={"1","2","3","4","*","5","6","7","8"};
        String[] w ={"*","1","2","3","*","4","5","6","*"};
        for(int i =0;i<9;i++)
        {
            label11[0][i] = new JButton(m[i]);
        }
        for(int i = 1;i<7;i++)
        {
        
            for(int j=0;j<9;j++)
            {
                label11[i][j] = new JButton(w[j]);
               
            }
        }
        for(int i = 0;i<7;i++)
        {
            
            for(int j=0;j<9;j++)
            {
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
        panel2.add(l);panel2.add(n);panel2.add(b); panel2.setBackground(new java.awt.Color(240,255,255));
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
                //	new Thanks();
                System.exit(0);
                //  frame.setVisible(false);
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
	public void modify()
	{
		
		int p = 0;
		for(int j = 0; j < 9; j++)
		{
			label11[0][4].setVisible(false);
			if(j != 4)
			{
				if(j < 4)
					p = j;
				else 
					p = j - 1;
				if(Screen2.getScreen2_D()[p] == 1)
				  label11[0][j].setBackground(Color.gray);
			    else
				  label11[0][j].addActionListener(new BtListener(0, j));
			}
			
			
		}
		for(int i = 1; i <= 5; i += 2)
			for(int j = 0; j < 9; j++)
			label11[i][j].setVisible(false);
		
		p = 0;
		int q = 0;
		for(int i = 2; i <= 6; i += 2)
		{
			for(int j = 0; j < 9; j++)
			{
				label11[i][4].setVisible(false);
				label11[i][0].setVisible(false);
				label11[i][8].setVisible(false);
				
				if(j != 0 && j != 4 && j != 8)				
				{
					switch(i){
					case 2: p = 0;
							break;
					case 4: p = 1;
					        break;
					default:p = 2;
					         }
					if(j <= 3)  //1 <= j <= 3
						q = j - 1;   //0 <= q <= 2
					else if(j <= 7)  //5 <= j <= 7
						q = j - 2;   //3 <= q <= 5
					else ;
					
					if(Screen2.getScreen2_rest()[p][q] == 1)
						label11[i][j].setBackground(Color.gray);
					else
						label11[i][j].addActionListener(new BtListener(i, j));
				}
			    
			   
		    }	
	    }
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
		private int k = 0;
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
			if(this.i == 0)
			{
				if(this.j < 4)
					k = this.j;
				else 
					k = this.j - 1;

			}
			else
			{
				switch(i){
				case 2: p = 0;
						break;
				case 4: p = 1;
				        break;
				default:p = 2;
				         }
				if(j <= 3)
					q = j - 1;   
				else if(j <= 7)  //5 <= j <= 7
					q = j - 2;   //3 <= q <= 5
				else ;
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
					Screen2.setScreen2_D(k, 0);
				}
					
				else if(label11[i][j].getBackground() != Color.red && sumNum > 0)
				{
					label11[i][j].setBackground(Color.red);
					sumNum--;
					Screen2.setScreen2_D(k, 1);
				}
				else ;	
			}
			else
			{
				if(label11[i][j].getBackground() == Color.red )
				{
					label11[i][j].setBackground(null);
					sumNum++;
					Screen2.setScreen2_rest(p, q, 0);
				}
					
				else if(label11[i][j].getBackground() != Color.red && sumNum > 0)
				{
					label11[i][j].setBackground(Color.red);
					sumNum--;
					Screen2.setScreen2_rest(p, q, 1);
				}
				else ;	
			}
			System.out.println("sumNum = " + sumNum);
			for(int i = 0; i < 8; i++)
				System.out.print(Screen2.getScreen2_D()[i] + " ");
			System.out.println();
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 6; j++)
				{
					System.out.print(Screen2.getScreen2_rest()[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
