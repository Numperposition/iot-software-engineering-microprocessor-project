import java.io.*;
import java.util.*;
import gnu.io.*; 
/**
 * A class to connect, send or receive data to or from 8051 microprocessor.
 * @author Group 78, reference from Matthew Tang
 * @version 1.0
 */
public class MicropTxRx {
	static CommPortIdentifier portId;
    static CommPort com;
    static SerialPort ser;
    /**
     * This is the method to initial the port, including setting baud rate and port number.
     */
    public void initial()
    {
    	try {
			// TODO: identify the COM port from Windows' control panel
            portId = CommPortIdentifier.getPortIdentifier("COM5");

            com = portId.open("MCS51COM", 2000);
            ser = (SerialPort)com;
			// Baud rate = 9600, Data bits = 8, 1 stop bit, Parity OFF
            ser.setSerialPortParams(9600, SerialPort.DATABITS_8, 
                                    SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
    /**
     * This method is to receive ticket number from 8051.
     * @return a string ticket number
     */
    public String getTicketID()
    {
    	String studentID ="";
    	try
    	{
    		InputStream comIn = ser.getInputStream();
    		for (int i = 0; i < 8; i++)
    		{
                while (comIn.available() == 0);
                char ch = (char)comIn.read();
                System.out.print(ch);
                studentID = studentID + ch;
            }
    		Thread.sleep(1000);
    		comIn.close();
    	}catch(Exception e) {
            e.printStackTrace(System.out);
        }
    	return studentID;
    }
    /**
     * A method to send chars to make 8051 show "Please wait..."
     */
    public void sendWait()
    {
    	try
    	{
    		OutputStream comOut = ser.getOutputStream();
    		comOut.write('2');
    		comOut.write('0');
    		comOut.close();
    	}catch(Exception ex){ex.printStackTrace();}
    }
    /**
     * A method to send chars to tell 8051 there's a invalid ticket.
     */
    public void sendError()
    {
    	try
    	{
    		OutputStream comOut = ser.getOutputStream();
    		comOut.write('3');
    		comOut.write('0');
    		comOut.close();
    	}catch(Exception ex){ex.printStackTrace();}
    }
    /**
     * A method to receive administrator's password from 8051
     * @return the password 
     */
    public String getPassword()
    {
    	String pw ="";
    	try
    	{
    		InputStream comIn = ser.getInputStream();
    		for (int i = 0; i < 4; i++)
    		{
                while (comIn.available() == 0);
                char ch = (char)comIn.read();
                System.out.print(ch);
                pw = pw + ch;
            }
  
    		comIn.close();
    	}catch(Exception e) {
            e.printStackTrace(System.out);
        }
    	return pw;
    }
    /**
     * A method to send ticket information to 8051
     * @param filmName
     * @param screenName
     * @param sleepTime
     */
    public void printNormVaildTicket(String filmName, String screenName, int sleepTime)
    {
    	String str = screenName + ":" + filmName + "0";
    	try
    	{
    		OutputStream comOut = ser.getOutputStream();
    		comOut.write('1');
    		for(int i = 0; i < str.length(); i++)
    		{
    			char b = str.charAt(i);
  		        Thread.sleep(sleepTime);
  		        comOut.write(b);
    		}
    		comOut.close();
    	}catch(Exception ex){ex.printStackTrace();}
    }
    
}
