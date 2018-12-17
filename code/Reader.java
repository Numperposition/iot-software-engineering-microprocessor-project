
import java.util.*;
import java.io.*;
/**
 * Title      : Reader.java
 * Description: A class to read the file about films from files.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class Reader {
    private ArrayList<String> movies = new ArrayList<String>();
    private ArrayList<String> filmIntro = new ArrayList<String>();
    public ArrayList<String> lastTimeList = new ArrayList<String>();
    public ArrayList<Double> priceList = new ArrayList<Double>();
    private double price = 0.0;
    private int lastTime = 0;
    /**
     * A method to get the film introduction list.
     * @return film introduction list
     */
    public ArrayList<String> getFilmIntro()
    {
    	return filmIntro;
    }
    /**
     * A method to get the price of the film.
     * @return the price of film.
     */
    public double getPrice()
    {
    	return price;
    }
    /**
     * A method to read the information of specific day report.
     * @param day which day's report.
     * @return the list of objects of Film type. 
     */
    public ArrayList<Film> readReport(int day)
    {
    	
    	ArrayList<Film> films = new ArrayList<Film>();
    	String fileName = day + "_statistic_report.txt";
    	int num = readMovieList().size();
    	if(day == 0)
    		num = 5;
    	File file = new File(fileName);
    	try
    	{
			if(file.exists() == false)
				return films;
    		BufferedReader reader = new BufferedReader(new FileReader(file));
    		int i = 0;
    		while(i < num)  
    		{
    			Film film = new Film();
    			String line = null;
    			int j = 0;
    			while((line = reader.readLine()).equals("-------------------------------------------------------------------") == false)
    			{
    				StringTokenizer token = new StringTokenizer(line, ":");
    				token.nextToken();
    				switch(j){
    				case 0: film.setFilmName(token.nextToken()); break;
    				case 1: film.setTotalAdultTicketNum(Integer.parseInt(token.nextToken())); break;
    				case 3: film.setTotalChildTicketNum(Integer.parseInt(token.nextToken())); break;
    				case 5: film.setTotalSeniorTicketNum(Integer.parseInt(token.nextToken())); break;
    				case 7: film.setTotalStudTicketNum(Integer.parseInt(token.nextToken())); break;
    				default: ;
    				}
    				j++;
    			}
    			films.add(film);
    			i++;
    		}
    		reader.close();
    	}catch(Exception ex){ex.printStackTrace();}
    	return films;
    	
    }
    /**
     * A method to read the schedules of all three screens respectively.
     * @param day which day's schedule.
     */
    public void readScreenSchedule(int day)
    {
    	Screen1.filmList = new ArrayList<String>();
    	Screen1.startTime = new ArrayList<ArrayList<String>>();
    	Screen2.filmList = new ArrayList<String>();
    	Screen2.startTime = new ArrayList<ArrayList<String>>();
    	Screen3.filmList = new ArrayList<String>();
    	Screen3.startTime = new ArrayList<ArrayList<String>>();
    	for(int i = 1; i <= 3; i++)
    	{
    	  String fileName = day + "_screen" + i + "_schedule.txt";
    	  File file = new File(fileName);
    	   try
    		{
    		    if((i == 1 || i == 2) && file.exists() == false)
    		    {
    		    	continue;
    		    }
    		    if(i == 3 && file.exists() == false)
    		    	return ;
    			BufferedReader reader = new BufferedReader(new FileReader(file));
    			
	        	String line = null;
	        	switch(i){
	        	 case 1:
	        		
	        		 while((line = reader.readLine()) != null)
	        		 {
	        			 StringTokenizer token = new StringTokenizer(line, ",");
	        			 Screen1.filmList.add(token.nextToken());
	        			 ArrayList<String> stTime = new ArrayList<String>();
	        			 while(token.hasMoreTokens())
	        			 {
	        				 String part = token.nextToken();
	        				 stTime.add(part);
	        			 }
	        			 Screen1.startTime.add(stTime);
	        		 }
	        		 reader.close();
	        		 break;
	        	  case 2:
	        		  while((line = reader.readLine()) != null)
		        		 {
		        			 StringTokenizer token = new StringTokenizer(line, ",");
		        			 Screen2.filmList.add(token.nextToken());
		        			 ArrayList<String> stTime = new ArrayList<String>();
		        			 while(token.hasMoreTokens())
		        			 {
		        				 String part = token.nextToken();
		        				 stTime.add(part);
		        			 }
		        			 Screen2.startTime.add(stTime);
		        		 }
		        		 reader.close();
		        		 break;
	        	   case 3:
	        		   while((line = reader.readLine()) != null)
		        		 {
		        			 StringTokenizer token = new StringTokenizer(line, ",");
		        			 Screen3.filmList.add(token.nextToken());
		        			 ArrayList<String> stTime = new ArrayList<String>();
		        			 while(token.hasMoreTokens())
		        			 {
		        				 String part = token.nextToken();
		        				 stTime.add(part);
		        			 }
		        			 Screen3.startTime.add(stTime);
		        		 }
		        		 reader.close();
		        		 break;
	        		  
	        	}
    		}catch(Exception ex){ex.printStackTrace();}
    	}
    	
    }
    /**
     * A method to read the information from a given file.
     * @param name the file name to read.
     * @return the list that contains all information of the file
     */
    public ArrayList<String> readInfo(String name)
	{
		String fileName = name + ".txt";
		File file = new File(fileName);
		ArrayList<String> info = new ArrayList<String>();
		try
		{
			if(file.exists() == false)
				return info;
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null && line.equals("") == false)
			{
				info.add(line);
			}
			reader.close();
		}catch(Exception e){e.printStackTrace();}
		return info;
	}
    /**
     * A method to read the seat information of specific screen at specific time.
     * @param screenNum which screen
     * @param startNo the turn number of a specific film
     * @param filmName the name of the film
     * @param day which day
     * @return the number of the rest tickets.
     */
    public int readScreen(int screenNum, int startNo, String filmName, int day)
    {
    	String fileName = day + "_screen" + screenNum +"_" + filmName + "_" + startNo + ".txt";
    	File file = new File(fileName);
    	int ticketCount = 0;
    	switch(screenNum){
    	  case 1: 
    	          
    	          try
    	          {
    	        	  BufferedReader reader = new BufferedReader(new FileReader(file));
    	        	  String line = null;
    	        	  int i = 0;
    	        	  while((line = reader.readLine()) != null)
    	        	  {
    	        		  for(int j = 0; j < line.length(); j++)
    	        		  {
    	        			Screen1.getScreen1()[i][j] = Character.getNumericValue(line.charAt(j));
    	        			if(Screen1.getScreen1()[i][j] == 0)
    	        				ticketCount++;
    	        		  }
    	        		    
    	        		 // System.out.println("line length:" + line.length());
    	        		  /*Screen1.getScreen1()[i][0] = Integer.parseInt(line.substring(0,1));
    	        		  */
    	        		  i++;
    	        	  }
    	        	  reader.close();
    	          }catch(Exception ex){ex.printStackTrace();}
    	          break;
    	          
    	  case 2: 
    		      try
    		      {
    		    	  BufferedReader reader = new BufferedReader(new FileReader(file));
    		    	  String line = reader.readLine();
    		    	  for(int i = 0; i < line.length(); i++)
    		    	  {
    		    		Screen2.getScreen2_D()[i] = Character.getNumericValue(line.charAt(i));
    		    		if(Screen2.getScreen2_D()[i] == 0)
	        				ticketCount++;
    		    	  }
    		    		 
    		    	  
    		    	  int i = 0;
    		    	  while((line = reader.readLine()) != null)
    		    	  {
    
    		    		  for(int j = 0; j < line.length(); j++)
    		    		  {
    		    			Screen2.getScreen2_rest()[i][j] = Character.getNumericValue(line.charAt(j));
    		    			if(Screen2.getScreen2_rest()[i][j] == 0)
    	        				ticketCount++;
    		    		  }
    		    			  
    		    		  i++;
    		    	  }
    		    	  reader.close();
    		      }catch(Exception ex){ex.printStackTrace();}
    		      break;
    	  case 3: 
    		    try
		       {
		    	  BufferedReader reader = new BufferedReader(new FileReader(file));
		    	  String line = reader.readLine();
		    	  for(int i = 0; i < line.length(); i++)
		    	  {
		    		Screen3.getScreen3_E()[i] = Character.getNumericValue(line.charAt(i));
		    		if(Screen3.getScreen3_E()[i] == 0)
        				ticketCount++;
		    	  }
		    	
		    	  int i = 0;
		    	  while((line = reader.readLine()) != null)
		    	  {

		    		  for(int j = 0; j < line.length(); j++)
		    		  {
		    			Screen3.getScreen3_rest()[i][j] = Character.getNumericValue(line.charAt(j));
		    			if(Screen3.getScreen3_rest()[i][j] == 0)
	        			   ticketCount++;
		    		  }
		    			  
		    		  i++;
		    	  }
		    	  reader.close();
		       }catch(Exception ex){ex.printStackTrace();}
		      break;
    	}
    	return ticketCount;
    }
    
    public int getLastTime()
    {
    	return lastTime;
    }
    /**
     * A method to read the list of all movies.
     * @return the list of movie
     */
    public ArrayList<String> readMovieList()
    {
    	
    	File  file = new File("movies.txt");
    	try
    	{
    		BufferedReader reader = new BufferedReader(new FileReader(file));
    		String line = null;
    		while((line = reader.readLine()) != null && line.equals("") == false)
    		{
    			StringTokenizer token = new StringTokenizer(line, ",");
    			while(token.hasMoreTokens())
    			{
    			   movies.add(token.nextToken());
    			   lastTimeList.add(token.nextToken());
    			   priceList.add(Double.parseDouble(token.nextToken()));
    			}
    			
    		}
    		reader.close();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	return movies;
    }
    /**
     * A method to read film information
     * @param filmName the name of film
     */
    public void readMovieInfo(String filmName)
    {
    	String fileName = filmName + "_info.txt";
    	String s = "";
    	int line = 0;
    	int priceLineNum = 1;
    	int lastTimeNum = 2;  
    	File file = new File(fileName);
    	try
    	{
    		BufferedReader reader = new BufferedReader(new FileReader(file)); 
    		while(s != null)
    		{
    			s = reader.readLine();
    			//System.out.println("-------s:" + s);
    			if(priceLineNum - line == 0)
    			{
    				try
    				{
    					price = Double.parseDouble(s);
    				}catch(Exception e){e.printStackTrace();}
    				
    			}
    			else if(lastTimeNum - line == 0)
    			{
    				try
    				{
    					lastTime = Integer.parseInt(s);
    				}catch(Exception e){e.printStackTrace();}
    			}
    			else
    				filmIntro.add(s);
    			line++;
    		}
    		reader.close();
    	}catch(Exception ex){ex.printStackTrace();}
    }
}
