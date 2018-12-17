
import java.util.*;
/**
 * Title      : ModifyScheduleTest.java
 * Description: This class contains the definition of ModifyScheduleTest
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class ModifyScheduleTest {
    public static void main(String args[])
    {
    	ModifyScheduleTest test = new ModifyScheduleTest();
    	Scanner sc = new Scanner(System.in);
    	Reader reader = new Reader();
    	Writer wt = new Writer();
    	reader.readScreenSchedule(0);
    	//System.out.println("Enter the film name: ");
    	String filmName = "KONG SKULL ISLAND";
    	ArrayList<String> films = reader.readMovieList();
    	int flag = -1;
    	String lastTime = null;
    	for(int i = 0; i < films.size(); i++)
    	{
    		if(films.get(i).equals(filmName) == true)
    		{
    			flag = i;
    			System.out.println("Found the film, please select which screen to modify:");
    			break;
    		}
    	}
    	if(flag != -1)
    		lastTime = reader.lastTimeList.get(flag);
    	int input = sc.nextInt();
    	switch(input)
    	{
    	case 1: if(test.findFilm(Screen1.filmList, filmName) != -1)
    		      System.out.println("ok, next");
    	        else  System.out.println("There are no films in this screen"); break;
    	}
    	System.out.println("Please enter the start hour: ");
    	int shour = sc.nextInt();
    	System.out.println("Please enter the start minute: ");
    	int smin = sc.nextInt();
    	if(test.checkStartTime(Integer.parseInt(lastTime), Screen1.startTime, shour, smin, films, reader.lastTimeList))
    	{
    		System.out.println("you can add");
    		int filmLoca = test.findFilm(Screen1.filmList, filmName);
    		Screen1.startTime.get(filmLoca).add(shour + ":" + smin);
    		System.out.println("add time successfully.");
    		wt.writeScreenSchdule(1,0);
    		wt.writeScreen1(Screen1.startTime.get(filmLoca).size(), filmName, 0);
    		System.out.println("write in successfully");
    	}
    		
    	else
    		System.out.println("you can't add");
    	
    }
    private boolean checkStartTime(int lastTime, ArrayList<ArrayList<String>> stSched, int shour, int smin, ArrayList<String> films, ArrayList<String> lastTimeList)
    {
    	int lastHour = lastTime / 60;
    	
    	int minHour = 100;
    	int mstHour = 0;
    	int mstMin = 0;
    	int maxH = 0;
    	int maxM = 0;
    	int maxFilmCount = 0;
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
    	
    	int last = 0;
    	
    	for(int i = 0; i < films.size(); i++)
    	{
    		if(Screen1.filmList.get(maxFilmCount).equals(films.get(i)) == true)
    		{
    			last = Integer.parseInt(lastTimeList.get(i));
    			break;
    		}
    	}
    	
    	System.out.println("last time:" + last);
    	if(shour > maxH)
    	{
    		if( (smin + (shour - maxH - 1) * 60 + (60 - maxM)) > last + 20)
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
    	if(differ > lastTime + 20)    
    		return true;
    	return false;
    }
    private int findFilm(ArrayList<String> films, String filmName)
    {
    	for(int i = 0; i < films.size(); i++)
    	{
    		if(filmName.equals(films.get(i)) == true)
    			return i;
    	}
    	return -1;
    }
}
