

import java.util.ArrayList;
/**
 * Title      : Screen3 .java
 * Description: This class contains the definition of Screen3 
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class Screen3 {
     private static int [] screen3_E = new int[8];
     private static int [][] screen3_rest = new int[4][6];
     public static ArrayList<String> filmList;
     public static ArrayList<ArrayList<String>> startTime; 
     private int [] screen3_E_temp = new int[8];
     private int [][] screen3_rest_temp = new int[4][6];
  
     public int [][] getScreen3_rest_temp()
     {
     	return screen3_rest_temp;
     }
     
     public int [] getScreen3_E_temp()
     {
     	return screen3_E_temp;
     }
     
     public void saveCurrentScreen3() 
     {
     	for(int i = 0; i < 4; i++)
     	{
     		for(int j = 0; j < 6; j++)
     			screen3_rest_temp[i][j] = screen3_rest[i][j];
     	}
     	for(int i = 0; i < 8; i++)
     		screen3_E_temp[i] = screen3_E[i];
     }
     
     public void saveStaticCurrentScreen3() 
     {
     	for(int i = 0; i < 4; i++)
     	{
     		for(int j = 0; j < 6; j++)
     			screen3_rest[i][j] = screen3_rest_temp[i][j];
     	}
     	for(int i = 0; i < 8; i++)
     		screen3_E[i] = screen3_E_temp[i];
     }
     
     public static int [] getScreen3_E()
     {
    	 return screen3_E;
     }
     public static void setScreen3_E(int k, int num)
     {
    	 screen3_E[k] = num;
     }
     public static int [][] getScreen3_rest()
     {
    	 return screen3_rest;
     }
     public static void setScreen3_rest(int p, int q, int num)
     {
    	 screen3_rest[p][q] = num;
     }
}
