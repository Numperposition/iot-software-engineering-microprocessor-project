
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.*;

/**
 * Title      : AdminChooseScreens.java
 * Description: This class allows the administrator to choose which screen, enter start time to add the schedule.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class AdminChooseScreens {
    @SuppressWarnings({ "rawtypes" })
    private JComboBox box;
    private int screenNum = 1;
    private String filmName;
    private JTextField hourText;
    private JTextField minText;
    private JFrame frame;
    private int day;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	/**
	 * Constructor
	 * @param name film name that administrator choose previously
	 * @param flag index of the film in the file
	 * @param d the date
	 */
	public AdminChooseScreens(String name, int flag, int d)
    {
		day = d;
    	filmName = name;
    	frame = new JFrame("Admin");
    	JLabel head = new JLabel("Add Schedule", JLabel.CENTER);
    	head.setFont(new Font("serif", Font.BOLD, 35));
    	JButton back = new JButton("Back");
    	back.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
    			frame.dispose();
    			new AdminGUI();
    		}
    	});
    	JButton exit = new JButton("Exit");
    	exit.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
                new CoreGUI();
                frame.dispose();
    		}
    	});
    	JButton ok = new JButton("OK");
    	back.setFont(new Font("serif", Font.BOLD, 15));
    	exit.setFont(new Font("serif", Font.BOLD, 15));
    	ok.setFont(new Font("serif", Font.BOLD, 15));
    	JLabel label = new JLabel("Film name: " + name);
    	JLabel centerLabel = new JLabel("Please choose the screen and enter the start time: ");
    	centerLabel.setFont(new Font("serif", Font.BOLD, 20));
    	label.setFont(new Font("serif", Font.BOLD, 20));
    	JPanel centerPanel = new JPanel(new GridLayout(5, 1));
    	JPanel subPanel = new JPanel(new GridLayout(1, 5));
    	JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
        centerPanel.setBackground(new java.awt.Color(240,255,255));
        subPanel.setBackground(new java.awt.Color(240,255,255));
        bottomPanel.setBackground(new java.awt.Color(240,255,255));
    	//JPanel panel2 = new JPanel();
    	JLabel s1 = new JLabel("  Start hour(Ex:12, 23..): ");
    	//s1.setFont(new Font("serif", Font.BOLD, 14));
        s1.setOpaque(true);
        s1.setBackground(new java.awt.Color(240,255,240));
        s1.setFont(new Font("American Typewriter", Font.PLAIN, 14));
    	JLabel s2 = new JLabel(" Start minute(Ex:00,50): ");
    	//s2.setFont(new Font("serif", Font.BOLD, 14));
        s2.setOpaque(true);
        s2.setBackground(new java.awt.Color(240,255,240));
        s2.setFont(new Font("American Typewriter", Font.PLAIN, 14));
    	hourText = new JTextField();
    	hourText.setFont(new Font("American Typewriter", Font.BOLD, 18));
    	minText = new JTextField();
    	minText.setFont(new Font("American Typewriter", Font.BOLD, 18));
    	String[] str = {"Screen1", "Screen2", "Screen3"};
		box = new JComboBox(str);
		box.addItemListener(new BoxItemListener());
		ok.addActionListener(new ButtonListener(flag));
    	subPanel.add(box);
    	subPanel.add(s1);
    	subPanel.add(hourText);
    	subPanel.add(s2);
    	subPanel.add(minText);
    	centerPanel.add(label);
    	centerPanel.add(centerLabel);
    	centerPanel.add(subPanel);
    	bottomPanel.add(back);
    	bottomPanel.add(exit);
    	bottomPanel.add(ok);
    	frame.getContentPane().add(BorderLayout.NORTH, head);
    	frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
    	frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(800,600);
		frame.setVisible(true);
    }
	public class ButtonListener implements ActionListener
	{
		int flag;
		public ButtonListener(int f)
		{
			flag = f;
		}
		/**
		 * A event handle method to add schedule, also save the schedule in files.
		 */
		public void actionPerformed(ActionEvent e)
		{
			String sshour = hourText.getText();
			String ssmin = minText.getText();
			int shour = Integer.parseInt(sshour);
			int smin = Integer.parseInt(ssmin);
			//System.out.println("ss hour: " + sshour);
			//System.out.println("ss min: " + ssmin);
			Reader reader = new Reader();
	    	Writer wt = new Writer();
	    	reader.readScreenSchedule(day);
	    	ArrayList<String> films = reader.readMovieList();
	    	String lastTime = reader.lastTimeList.get(flag); 
	    	switch(screenNum)
	    	{
	    	case 1: 
	    		if(checkStartTime(Integer.parseInt(lastTime), Screen1.startTime, shour, smin, films, reader.lastTimeList, Screen1.filmList))
	    		{
	    			System.out.println("you can add");
	        		int filmLoca = findFilm(Screen1.filmList, filmName);
	        		if(filmLoca == -1)
	        		{
	        			Screen1.filmList.add(filmName);
	        			ArrayList<String> time = new ArrayList<String>();
	        			time.add(sshour + ":" + ssmin);
	        			Screen1.startTime.add(time);
	        			wt.writeScreen1(1, filmName, day);
	        		}
	        		else
	        		{
	        			Screen1.startTime.get(filmLoca).add(sshour + ":" + ssmin);
	        			wt.writeScreen1(Screen1.startTime.get(filmLoca).size(), filmName, day);
	        			
	        		}
	        		wt.writeScreenSchdule(1, day);
	        		if(wt.checkFileExist(day + "_statistic_report") == false)
	        		{
	        		    ArrayList<Film> movies = new ArrayList<Film>();
	        		   for(String str : films)
	        		   {
	        			 Film movie = new Film();
	        			 movie.setFilmName(str);
	        			 movies.add(movie);
	        		   }
	        		    wt.writeReport(movies, day);
	        		}
	        		
	        	    new ErrorGUI("You have successfully added the schedule!", frame);
	    		}
	    		else
	    			new ErrorGUI("Conflict to other schedule! Fail to add!", frame);
	    		break;
	    	case 2:
	    		if(checkStartTime(Integer.parseInt(lastTime), Screen2.startTime, shour, smin, films, reader.lastTimeList, Screen2.filmList))
	    		{
	    			System.out.println("you can add");
	        		int filmLoca = findFilm(Screen2.filmList, filmName);
	        		if(filmLoca == -1)
	        		{
	        			Screen2.filmList.add(filmName);
	        			ArrayList<String> time = new ArrayList<String>();
	        			time.add(sshour + ":" + ssmin);
	        			Screen2.startTime.add(time);
	        			wt.writeScreen2(1, filmName, day);
	        		}
	        		else
	        		{
	        			Screen2.startTime.get(filmLoca).add(sshour + ":" + ssmin);
	        			wt.writeScreen2(Screen2.startTime.get(filmLoca).size(), filmName, day);
	        			
	        		}
	        		wt.writeScreenSchdule(2, day);
	        		if(wt.checkFileExist(day + "_statistic_report") == false)
	        		{
	        			ArrayList<Film> movies = new ArrayList<Film>();
	        		    for(String str : films)
	        		   {
	        			Film movie = new Film();
	        			movie.setFilmName(str);
	        			movies.add(movie);
	        		   }
	        		    wt.writeReport(movies, day);
	        		}
	        		
	        	    new ErrorGUI("You have successfully added the schedule!", frame);
	    		}
	    		else
	    			new ErrorGUI("Conflict to other schedule! Fail to add!", frame);
	    		break;
	    	case 3:
	    		if(checkStartTime(Integer.parseInt(lastTime), Screen3.startTime, shour, smin, films, reader.lastTimeList, Screen3.filmList))
	    		{
	    			System.out.println("you can add");
	        		int filmLoca = findFilm(Screen3.filmList, filmName);
	        		if(filmLoca == -1)
	        		{
	        			Screen3.filmList.add(filmName);
	        			ArrayList<String> time = new ArrayList<String>();
	        			time.add(sshour + ":" + ssmin);
	        			Screen3.startTime.add(time);
	        			wt.writeScreen3(1, filmName, day);
	        		}
	        		else
	        		{
	        			Screen3.startTime.get(filmLoca).add(sshour + ":" + ssmin);
	        			wt.writeScreen3(Screen3.startTime.get(filmLoca).size(), filmName, day);
	        			
	        		}
	        		wt.writeScreenSchdule(3, day);	
	        		if(wt.checkFileExist(day + "_statistic_report") == false)
	        		{
	        			ArrayList<Film> movies = new ArrayList<Film>();
		        		for(String str : films)
		        		{
		        			Film movie = new Film();
		        			movie.setFilmName(str);
		        			movies.add(movie);
		        		}
		        		wt.writeReport(movies, day);
	        		}
	        		
	        	    new ErrorGUI("You have successfully added the schedule!", frame);
	    		}
	    		else
	    			new ErrorGUI("Conflict to other schedule! Fail to add!", frame);
	    		break;
	    	}
	    	
		}
		 private int findFilm(ArrayList<String> films, String filmName)
		    {
			    if (films == null)
			    	return -1;
		    	for(int i = 0; i < films.size(); i++)
		    	{
		    		if(filmName.equals(films.get(i)) == true)
		    			return i;
		    	}
		    	return -1;
		    }
		 /**
		  * A method to check whether the entering time conflict to the previous schedule or not.
		  * @param lastTime the last time of the current choose film.
		  * @param stSched the start time list of the current screen.
		  * @param shour the start hour that user enter.
		  * @param smin the start minute that user enter.
		  * @param films the whole film list.
		  * @param lastTimeList the last time list of 
		  * @param screenFilmListTemp the film list of current screen.
		  * @return whether there is a conflict or not.
		  */
		 private boolean checkStartTime(int lastTime, ArrayList<ArrayList<String>> stSched, 
				 int shour, int smin, ArrayList<String> films, 
				 ArrayList<String> lastTimeList, ArrayList<String> screenFilmListTemp)
		    {
			    if (stSched.size() == 0)
			    	return true;
		    	int lastHour = lastTime / 60;
		    
		    	int minHour = 100;
		    	int mstHour = 0;
		    	int mstMin = 0;
		    	int maxH = 0;
		    	int maxM = 0;
		    	int maxFilmCount = 0;
     //This loop is to find the largest time interval between the current time and previous schedule.
		    	for(int i = 0; i < stSched.size(); i++)
		    	{
		    		for(int j = 0; j < stSched.get(i).size(); j++)
		    		{
		    			StringTokenizer token = new StringTokenizer(stSched.get(i).get(j), ":");
		    			int h = Integer.parseInt(token.nextToken());
		    			int m = Integer.parseInt(token.nextToken());
		    			if(minHour > Math.abs(h - shour))
		    			{
		    				minHour = Math.abs(h - shour);
		    				mstHour = h;   
		    				mstMin = m;
		    			}
		    			if(h > maxH)
		    			{
		    				maxH = h;
		    				maxM = m;
		    				maxFilmCount = i; 
		    			}
		    		}
		    	}
		    	
		    	int last = 0; //to save the value of the final film.
		    	
		    	for(int i = 0; i < films.size(); i++)
		    	{
		    		if(screenFilmListTemp.get(maxFilmCount).equals(films.get(i)) == true)
		    		{
		    			last = Integer.parseInt(lastTimeList.get(i));
		    			break;
		    		}
		    	}
		    	
		   // 	System.out.println("last time:" + last);
		    	if(shour > maxH)
		    	{
		    		if( (smin + (shour - maxH - 1) * 60 + (60 - maxM)) > last + 15) //suppose 15min for cleaning up the cinema.
		    			return true;
		    		else
		    			return false;
		    	}
		    	
		    	int differ = 0;
		    	if(lastHour > minHour)
		    		return false;
		    	
		    	if(shour > mstHour)
		    		differ = smin + (shour - mstHour - 1) * 60 + (60 - mstMin);  
		    	else
		    		differ = mstMin + (mstHour - shour - 1) * 60 + (60 - smin);
		    	if(differ > lastTime + 15)    //suppose 15min for cleaning up the cinema.
		    		return true;
		    	return false;
		    }
	}
    public class BoxItemListener implements ItemListener
    {
        /**
         * This method is to listen to the choose of which screen
         */
    	public void itemStateChanged(ItemEvent e)
    	{
    		if(e.getStateChange() == ItemEvent.SELECTED)
    		{
    			String s = (String)box.getSelectedItem();
    			if(s.equals("Screen1"))
    				screenNum = 1;
    			else if(s.equals("Screen2"))
    				screenNum = 2;
    			else 
    				screenNum = 3;
    		}
    	}
    }
   
}
