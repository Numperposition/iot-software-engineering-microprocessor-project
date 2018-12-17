
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * Title      : SuccessPurchasedGUI.java
 * Description: This class contains the definition of SuccessPurchasedGUI
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     2.0
 */
public class SuccessPurchasedGUI {
	  private ArrayList<String> total;	
	  private ArrayList<String> temp = new ArrayList<String>();
	  private ArrayList<String> seatNum = new ArrayList<String>();
	//char chars[] = new char[8];
	  private Writer writer;
	  JFrame frame = new JFrame();
	  private int sumNum = CurrentPurchase.totalTicket(); 
	  JPanel panel1 = new JPanel(new GridLayout(sumNum + 1, 1));
	  JPanel panel3 = new JPanel(new GridLayout(1,2));
	  JPanel upPanel = new JPanel();
	  JButton buton = new JButton("exit");
	  JButton buton1 = new JButton("Back");
	  JLabel m = new JLabel("Your tickedt numbers are shown below :",JLabel.CENTER);
    
	  JLabel[] label11=new JLabel[sumNum];
	  StringBuilder  str = new StringBuilder();
	  /**
	   * this method is to update the current seat choice to file, as well as statistic report. Also seat number of each ticket is generated.
	   */
	  private void initial()
	  {
		  boolean flag = false;
		  ReadStudID rd = new ReadStudID();
		  Reader rd2 = new Reader();
		  writer = new Writer();
		  //rd2.readMovieList();
		  ArrayList<Film> films = rd2.readReport(CurrentPurchase.day);
		  int count = 0;
		  for(Film film : films)
		  {
			  //System.out.println("price: " + rd2.priceList.get(count));
			  film.setFilmPrice(rd2.priceList.get(count));
	          
			  if(film.getFilmName().equals(CurrentPurchase.filmName))
			  {
				  film.setFilmPrice(CurrentPurchase.filmPrice);
				  film.setTotalAdultTicketNum(film.getTotalAdultTicketNum() + CurrentPurchase.adultTicketNum);
				  film.setTotalChildTicketNum(film.getTotalChildTicketNum() + CurrentPurchase.childTicketNum);
				  film.setTotalSeniorTicketNum(film.getTotalSeniorTicketNum() + CurrentPurchase.elderTicketNum);
				  film.setTotalStudTicketNum(film.getTotalStudTicketNum() + CurrentPurchase.studTicketNum);
				  flag = true;
			  }
			  count++;
		  }
		  if(flag == false)
		  {
			  Film newFilm = new Film();
			  newFilm.setFilmName(CurrentPurchase.filmName);
			  newFilm.setFilmPrice(CurrentPurchase.filmPrice);
			  newFilm.setTotalAdultTicketNum(CurrentPurchase.adultTicketNum);
			  newFilm.setTotalChildTicketNum(CurrentPurchase.childTicketNum);
			  newFilm.setTotalSeniorTicketNum(CurrentPurchase.elderTicketNum);
			  newFilm.setTotalStudTicketNum(CurrentPurchase.studTicketNum);
			  films.add(newFilm);
		  }
		  writer.writeReport(films, CurrentPurchase.day);
		  
		  rd.readStudID("ticket_id"); 
		  total = rd.getID();
		  switch(CurrentPurchase.screenNum)
		  {
		  case 1:
			  Screen1 s1 = new Screen1();
			  s1.saveCurrentScreen1();
			  rd2.readScreen(CurrentPurchase.screenNum, CurrentPurchase.startTime, CurrentPurchase.filmName, CurrentPurchase.day);
			  for(int i = 0; i < 4; i++)
			  {
				  for(int j = 0; j < 8; j++)
				  {
					  if(s1.getScreen1_temp()[i][j] != Screen1.getScreen1()[i][j])
					  {
						  String s = "";
						  switch(i){
						  case 0: s = s + "D" + (j + 1);
						          break;
						  case 1: s = s + "C" + (j + 1);
						          break;
						  case 2: s = s + "B" + (j + 1);
						          break;
						  case 3: s = s + "A" + (j + 1);
						          break;
						  }
						  seatNum.add(s);
					  }
				  }
			  }
			  s1.saveStaticCurrentScreen1();
			  break;
		  case 2:
			  Screen2 s2 = new Screen2();
			  s2.saveCurrentScreen2();
			  rd2.readScreen(CurrentPurchase.screenNum, CurrentPurchase.startTime, CurrentPurchase.filmName, CurrentPurchase.day);
			  for(int i = 0; i < 8; i++)
				  if(s2.getScreen2_D_temp()[i] != Screen2.getScreen2_D()[i])
				  {
					  String s = "D" + (i + 1);
					  seatNum.add(s);
				  }

			  for(int i = 0; i < 3; i++)
			  {
				  for(int j = 0; j < 6; j++)
					  if(s2.getScreen2_rest_temp()[i][j] != Screen2.getScreen2_rest()[i][j])
					  {
						  String s = "";
						  switch(i){
						  case 0: s = "C" + (j + 1); break;
						  case 1: s = "B" + (j + 1); break;
						  case 2: s = "A" + (j + 1); break;
						  }
						  seatNum.add(s);
					  }
			  }
			  s2.saveStaticScreen2();
			  break;
		  case 3: 
			  Screen3 s3 = new Screen3();
			  s3.saveCurrentScreen3();
			  rd2.readScreen(CurrentPurchase.screenNum, CurrentPurchase.startTime, CurrentPurchase.filmName, CurrentPurchase.day);
              for(int i = 0; i < 8; i++)
            	  if(s3.getScreen3_E_temp()[i] != Screen3.getScreen3_E()[i])
				  {
					  String s = "E" + (i + 1);
					  seatNum.add(s);
				  }
              for(int i = 0; i < 4; i++)
			  {
				  for(int j = 0; j < 6; j++)
					  if(s3.getScreen3_rest_temp()[i][j] != Screen3.getScreen3_rest()[i][j])
					  {
						  String s = "";
						  switch(i){
						  case 0: s = "D" + (j + 1); break;
						  case 1: s = "C" + (j + 1); break;
						  case 2: s = "B" + (j + 1); break;
						  case 3: s = "A" + (j + 1); break;
						  }
						  seatNum.add(s);
					  }
			  }
			  s3.saveStaticCurrentScreen3();
			  break;
			  
		  }
		  writer.writeScreen(CurrentPurchase.screenNum, CurrentPurchase.startTime, CurrentPurchase.filmName, CurrentPurchase.day);
	  }
	  /**
	   * A method to generate random 8-digit ticket number.
	   */
	  private void randomNumGenerate()
	  {
		 
	  	 for(int j = 0; j < 8; j++)
	        { 
	  		    Random random = new Random();
	        	str.append(random.nextInt(4)+1);
	        }   
	  }
	  /**
	   * A method to check whether the ticket number is repeated or not.
	   * @return whether the ticket no is repeated
	   */
	  private Boolean check1()
	  {
		  for(String temp : total)
			{
				 if(temp.equals(str.toString()))
				    return false;		 
			}
		  return true;
	  }
	  /**
	   * A method used to print ticket information
	   * @param ticketID ticket no
	   * @param studTicketID student id if it is a student ticket
	   * @param seatNo seat no for the ticket
	   */
	  private void printTicket(String ticketID, String studTicketID, String seatNo)
	  {
		  Calendar cal = Calendar.getInstance();
		  ArrayList<String> ticketInfo = new ArrayList<String>();
		  ticketInfo.add("Film Name:" + CurrentPurchase.filmName);
		  ticketInfo.add("Start Time:" + BillGUI.startTime);
		  ticketInfo.add("Last Time:" + CurrentPurchase.lastTime + "min");
		  ticketInfo.add("Screen:" + CurrentPurchase.screenNum);
		  ticketInfo.add("Seat No.:" + seatNo);
		  ticketInfo.add("Ticket ID:" + ticketID);
		  ticketInfo.add("Date:" + (cal.get(Calendar.MONTH) + 1)+"-"+(cal.get(Calendar.DAY_OF_MONTH)+CurrentPurchase.day));

		  if(studTicketID != null)
		  {
			  ticketInfo.add("Student ID: " + studTicketID);
		  }
		  writer.writeInfo(ticketID, ticketInfo);
	  }
	  
	  public SuccessPurchasedGUI(){
	    	 initial();
          m.setOpaque(true);
          m.setBackground(new java.awt.Color(240,255,255));
          m.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
	    	 panel1.add(m);
	    	 for(int i = 0; i < sumNum; i++)
		 	    {    str.delete(0, str.length());
		 	        randomNumGenerate();	
				    while(!check1()) 
				    {
				    	str.delete(0, str.length());
				    	randomNumGenerate();	
				    }
				 	   total.add(str.toString());
				 	   temp.add(str.toString());  
				    
		 	        label11[i] = new JLabel(str.toString() + " : " + seatNum.get(i), JLabel.CENTER);
                    label11[i].setOpaque(true);
                    label11[i].setBackground(new java.awt.Color(240,255,255));
                    label11[i].setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		 	        panel1.add(label11[i]);
		 	        
		 	    }
          panel1.setBackground(new java.awt.Color(240,255,255));
	    	 //CurrentPurchase.ticketIDList = temp;
	    	 writer = new Writer();
	    	 writer.writeInfo("ticket_id", total); 
	    	 
	    	   for(int i = 0; i < temp.size(); i++)
	    	  {
	    		 if(i < CurrentPurchase.studTicketNum)
	    		    printTicket(temp.get(i), CurrentPurchase.studIDList.get(i), seatNum.get(i));
	    		 else
	    			 printTicket(temp.get(i), null, seatNum.get(i));
	    	  }
	    	
	           JLabel b = new JLabel("Purchase successfully",JLabel.CENTER);
               b.setOpaque(true);
               b.setBackground(new java.awt.Color(240,255,255));
               b.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
	            upPanel.add(b);
                upPanel.setBackground(new java.awt.Color(240,255,255));
	           panel3.add(buton);
	           panel3.add(buton1);
               panel3.setBackground(new java.awt.Color(240,255,255));
	           frame.getContentPane().add(BorderLayout.CENTER,panel1);
	           frame.getContentPane().add(BorderLayout.SOUTH,panel3);
	           frame.getContentPane().add(BorderLayout.NORTH,upPanel);
		       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		       frame.setSize(800,600);
		       frame.setVisible(true);
          buton. addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
            	   CurrentPurchase.adultTicketNum = 0;
	    		   CurrentPurchase.childTicketNum = 0;
	    		   CurrentPurchase.studTicketNum = 0;
	    		   CurrentPurchase.elderTicketNum = 0;
                  new Thanks();
                  frame.dispose();
              }});
		       buton1.addActionListener(new ActionListener(){
		    	   public void actionPerformed(ActionEvent e)
		    	   {
		    		   CurrentPurchase.adultTicketNum = 0;
		    		   CurrentPurchase.childTicketNum = 0;
		    		   CurrentPurchase.studTicketNum = 0;
		    		   CurrentPurchase.elderTicketNum = 0;
		    		   frame.dispose();
		    		   new Movies();
		    		   
		    	   }
		       });
	     }
}
