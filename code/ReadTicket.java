import java.io.*;
import java.util.StringTokenizer;

public class ReadTicket {
    private String filmName = new String();
    private String screen = new String();
    public String getFilmName()
    {
    	return filmName;
    }
    public String getScreenName()
    {
    	return screen;
    }
    /**
	 * A method to check whether the file exist or not
	 * @param name file name
	 * @return whether the file exist or not
	 */
	public boolean checkFileExist(String name)
	{
		String fileName = name + ".txt";
		File file = new File(fileName);
		if(file.exists())
			return true;
		return false;
	}
    /**
     * judge the ticket is student ticket all not. Also read the film name and screen number to String objects.
     * @param ticketNo the ticket number entered from 8051
     * @return whether is student ticket or not.
     */
    public boolean checkTicket(String ticketNo)  // 
    {
    	File file = new File(ticketNo + ".txt");
    	int i = 0;
    	try
    	{
    		BufferedReader reader = new BufferedReader(new FileReader(file));
    		String line = null;
    		while((line = reader.readLine()) != null && line.equals("") == false)
    		{
    			if(i == 0)
    			{
    				StringTokenizer token = new StringTokenizer(line, ":");
    				token.nextToken();
    				filmName = token.nextToken();
    			}
    			if(i == 3)	 
    			{
    				StringTokenizer token = new StringTokenizer(line, ":");
    				screen = token.nextToken() + " " + token.nextToken();
    			}
    			i++;
    		}
    		reader.close();
    	}catch(Exception ex){ex.printStackTrace();}
    	if(i == 8)
    		return true;
    	return false;
    }
   /* public static void main(String args[])
    {
    	ReadTicket ticketReader = new ReadTicket();
    	String str = "33441314";
    	if(ticketReader.checkFileExist(str))
    	{
    		System.out.println("ticket exist!");
    		if(ticketReader.checkTicket(str))
    		{
    			System.out.println("It is student ticket.");
    		}
    		else
    			System.out.println("not student ticket.");
    		System.out.println(ticketReader.screen);
    		System.out.println(ticketReader.filmName);
    	}
    	else
    		System.out.println("ticket not exist!");
    }*/
}
