import java.util.Scanner;

/**
 * Title      : mainGUI.java
 * Description: This class contains the definition of mainGUI
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */

public class MainGUI {

	/**
	 * A method to begin the program
	 * @param args
	 */
	public static void main(String[] args) {
		MainGUI mainGUI = new MainGUI();
		MainGUI.CheckTicketTask task = mainGUI.new CheckTicketTask();
		Thread checkTicket = new Thread(task); //create a thread
		checkTicket.start(); //run the task in thread
        new CoreGUI();

	}
	/**
	 * A class to create a thread to check tickets by using 8051 microprocessor
	 * @author Group 78
	 * @version 1.0
	 */
    class CheckTicketTask implements Runnable
    {
    	public void run()
    	{
    		ReadTicket ticketReader = new ReadTicket();
    		MicropTxRx micro = new MicropTxRx();
    		micro.initial();
    		while(true)
    		{
    			System.out.println("please enter ticket id");
    			//Scanner sc = new Scanner(System.in);
    			String str = micro.getTicketID();
    			
    			if(ticketReader.checkFileExist(str))
    			{
    				System.out.println("ticket exist!");
    	    		if(ticketReader.checkTicket(str))
    	    		{
    	    			System.out.println("It is student ticket.");
    	    			micro.sendWait();
    	    			String password = micro.getPassword();
    	    			if(password.equals("1212")) //set the password "1212".
    	    			{
        	    			micro.printNormVaildTicket(ticketReader.getFilmName(), ticketReader.getScreenName(), 5);
        	    			System.out.println(ticketReader.getScreenName());
        	    		    System.out.println(ticketReader.getFilmName());
    	    			}
    	    			else
    	    			{
    	    				micro.sendError();
    	    			}
    	    		}
    	    		else
    	    		{
    	    			System.out.println("not student ticket.");
    	    			micro.printNormVaildTicket(ticketReader.getFilmName(), ticketReader.getScreenName(), 20);
    	    			System.out.println(ticketReader.getScreenName());
    	    		    System.out.println(ticketReader.getFilmName());
    	    		}
    	    			
    	    		
    			}
    			else
    			{
    				System.out.println("ticket not exist!");
    				micro.sendError();
    			}
    				
    			
    		}
    	}
    }
}
