

import java.util.ArrayList;
/**
 * Title      : Screen2.java
 * Description: This class contains the definition of Screen2
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class Screen2 {
     private static int [] screen2_D = new int[8];
     private int [] screen2_D_temp = new int[8];
     private static int [][] screen2_rest = new int[3][6];
     private int [][] screen2_rest_temp = new int[3][6];
     public static ArrayList<String> filmList; 
     public static ArrayList<ArrayList<String>> startTime; //= new ArrayList<ArrayList<String>>();
    // public static int ticketCount = 0;
     
     public int [][] getScreen2_rest_temp()
     {
     	return screen2_rest_temp;
     }
     
     public int [] getScreen2_D_temp()
     {
     	return screen2_D_temp;
     }
     
     public void saveCurrentScreen2() 
     {
     	for(int i = 0; i < 3; i++)
     	{
     		for(int j = 0; j < 6; j++)
     			screen2_rest_temp[i][j] = screen2_rest[i][j];
     	}
     	for(int i = 0; i < 8; i++)
     		screen2_D_temp[i] = screen2_D[i];
     }
     
     public void saveStaticScreen2() 
     {
     	for(int i = 0; i < 3; i++)
     	{
     		for(int j = 0; j < 6; j++)
     			screen2_rest[i][j] = screen2_rest_temp[i][j];
     	}
     	for(int i = 0; i < 8; i++)
     		screen2_D[i] = screen2_D_temp[i];
     }
     
     public static int [] getScreen2_D()
     {
    	 return screen2_D;
     }
     public static void setScreen2_D(int k, int num)
     {
    	 screen2_D[k] = num;
     }
     public static int [][] getScreen2_rest()
     {
    	 return screen2_rest;
     }
     public static void setScreen2_rest(int p, int q, int num)
     {
    	 screen2_rest[p][q] = num;
     }
}
