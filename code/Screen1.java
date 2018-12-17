
import java.util.*;
/**
 * Title      : Screen1.java
 * Description: This class contains the definition of Screen1
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class Screen1{
    private static int [][] screen1 = new int[4][8];
    private int [][] screen1_temp = new int[4][8];
    public static ArrayList<String> filmList;
    public static ArrayList<ArrayList<String>> startTime ;
     
   // public static int ticketCount = 0;
    
    public static int [][] getScreen1()
    {
    	return screen1;
    }
    public static void setScreen1(int i, int j, int num)
    {
    	screen1[i][j] = num;
    }
    public int [][] getScreen1_temp()
    {
    	return screen1_temp;
    }
    /**
     * This method is used to save the current information to screen1_temp. 
     */
    public void saveCurrentScreen1() 
    {
    	for(int i = 0; i < 4; i++)
    	{
    		for(int j = 0; j < 8; j++)
    			screen1_temp[i][j] = screen1[i][j];
    	}
    }
    /**
     * This method is used to save the current information back to screen1.
     */
    public void saveStaticCurrentScreen1() 
    {
    	for(int i = 0; i < 4; i++)
    	{
    		for(int j = 0; j < 8; j++)
    			screen1[i][j] = screen1_temp[i][j];
    	}
    }
}
