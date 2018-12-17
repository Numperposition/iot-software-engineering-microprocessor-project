
import java.util.*;
import java.io.*;
/**
 * Title      : ReadStudID.java
 * Description: This class used to read the student id from file
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class ReadStudID {
    private ArrayList<String> studIdList;
    
    public ArrayList<String> getID()
    {
    	return studIdList;
    }
    /**
     * A method to read the student id from a specific school
     * @param schoolName school name
     */
    public void readStudID(String schoolName)
    {
    	studIdList = new ArrayList<String>();
    	String fileName = schoolName + ".txt";
    	File file = new File(fileName);
    	if(file.exists() == true)
    	{
    		 try
    	   {
    		 BufferedReader reader = new BufferedReader(new FileReader(file));
    		 String line = null;
    		 while((line = reader.readLine()) != null)
    		 {
    			studIdList.add(line);
    		 }
    		 reader.close();
    	   }catch(Exception e){e.printStackTrace();}
    	}
    	
    	
    }
    /**
     * A method to check whether the id exists or not
     * @param id 
     * @return id exists or not
     */
    public Boolean checkStudID(String id)
    {
    	for(String str : studIdList)
    	{
    		if(str.equals(id) == true)
    		{
    			return true;
    		}
    	}
    	return false;
    }
}
