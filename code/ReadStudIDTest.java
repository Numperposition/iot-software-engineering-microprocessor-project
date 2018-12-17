/**
 * Title      : ReadStudIDTest.java
 * Description: A class to test the ReadStudID class
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */

public class ReadStudIDTest {
     public static void main(String args[])
     {
    	 Boolean flag = false;
    	 ReadStudID rid = new ReadStudID();
    	 rid.readStudID("BUPT");
    	 for(String str : rid.getID())
    	 {
    		 System.out.println(str);
    	 }
    	 flag = rid.checkStudID("2015676415");
    	 System.out.println("flag = " + flag);
    	 for(String str : rid.getID())
    	 {
    		 System.out.println(str);
    	 }
     }
}
