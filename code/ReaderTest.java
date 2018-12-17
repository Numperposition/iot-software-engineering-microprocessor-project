/**
 * Title      : ReaderTest.java
 * Description: This class used to test the Reader class
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
import java.util.*;
public class ReaderTest {
     public static void main(String args[]){
    	 Reader rd = new Reader();
    /*----------------movies.txt reading file text-------------------------
    	 ArrayList<String> filmList = rd.readMovieList();  
    	 for(String str : filmList)
    	 {
    		 System.out.println(str);
    	 }
    */
    /*---------------movieName_info.txt reading file test-------------------
   
    	 rd.readMovieInfo("KONG SKULL ISLAND");
    	 for(String s : rd.getFilmIntro())
    	 {
    		 if(s != null)
    		   System.out.println(s);
    	 }
    	// System.out.println(rd.getFilmIntro());
    	 System.out.println("price: " + rd.getPrice() + "$");
    	 System.out.println("Last Time: " + rd.getLastTime() + "min");
    */ 
    /*---------------screen n_x.txt reading file test------------------------
    	//-------screen1 test--------
    	 rd.readScreen(1, 1);
    	 for(int i = 0; i < 4; i++){
    		 for(int j = 0; j < 8; j++){
    			 System.out.print(Screen1.getScreen1()[i][j] + " ");
    		 }
    		 System.out.println();
    	 }
    	 System.out.println("screen 1_1 rest number: " + Screen1.ticketCount);*/
    	//------screen2 test---------
    /*	 rd.readScreen(2, 1, "KONG SKULL ISLAND");
    	 System.out.println("Screen 2: D: ");
    	 for(int i = 0; i < 8; i++)
    		 System.out.print(Screen2.getScreen2_D()[i] + " ");
    	 System.out.println();
    	 for(int i = 0; i < 3; i++){
    		 for(int j = 0; j < 6; j++)
    			 System.out.print(Screen2.getScreen2_rest()[i][j] + " ");
    		 System.out.println();
    	 }
    	 System.out.println("screen 2_1_KONG SKULL ISLAND rest num: " + Screen2.ticketCount);*/
    	 
  /*      //-------screen3 test--------
    	rd.readScreen(3, 1);
        System.out.println("Screen 3: E: ");
        for(int i = 0; i < 8; i++)
        	System.out.print(Screen3.getScreen3_E()[i] + " ");
        System.out.println();
        for(int i = 0; i < 4; i++){
        	for(int j = 0; j < 6; j++)
        		System.out.print(Screen3.getScreen3_rest()[i][j] + " ");
        		 System.out.println(); 
    	 }
        System.out.println("screen 3_1 rest num: " + Screen3.ticketCount);
     */
     /*--------------screen_schedule reading file test------------------------*/
    /*	 rd.readScreenSchedule();
    	 int i = 0;
    	 for(String filmName : Screen3.filmList)
    	 {
    		 System.out.println("filmName: " + filmName);
    		 for(String time : Screen3.startTime.get(i))
    			 System.out.println(time);
    		 i++;
    	 }
     */
     /*---------------readReport reading file test----------------------------*/
    /*	 ArrayList<Film> films = rd.readReport(0);
    	 for(Film film : films)
    	 {
    		 System.out.println("filmName: " + film.getFilmName());
    		 System.out.println("adult: " + film.getTotalAdultTicketNum());
    		 System.out.println("Child " + film.getTotalChildTicketNum());
    		 System.out.println("senior " + film.getTotalSeniorTicketNum());
    		 System.out.println("student: " + film.getTotalStudTicketNum());
    	 }
    */
   }
     
}
