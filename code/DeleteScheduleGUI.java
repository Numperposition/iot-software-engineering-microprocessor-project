

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * Title      : DeleteScheduleGUI.java
 * Description: A class to delete the schedule when user choose
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class DeleteScheduleGUI {
	private JFrame frame;
	private ArrayList<String> screenFilmList = null;
	private ArrayList<ArrayList<String>> startTime = null;
	private int DAY;
	private int initial(int screenNum, int day)
	{
		DAY = day;
		int count = 0;
		Reader reader = new Reader();
    	reader.readScreenSchedule(day);
    	switch(screenNum)
    	{
    	case 1: screenFilmList = Screen1.filmList;
    	        startTime = Screen1.startTime;
    	        break;
    	case 2: screenFilmList = Screen2.filmList;
                startTime = Screen2.startTime;
                break;
    	case 3: screenFilmList = Screen3.filmList;
                startTime = Screen3.startTime;
                break;
    	}
    	for(int i = 0; i < startTime.size(); i++)
    	{
    		count += startTime.get(i).size();
    	}
    	return count;
	}
    public DeleteScheduleGUI(int screenNum, int d)
    {
    	int num = initial(screenNum, d);
    	frame = new JFrame("Admin");
    	JLabel head1 = new JLabel("Delete Schedule",JLabel.CENTER);
    	JLabel head2 = new JLabel("Screen" + screenNum, JLabel.CENTER);
        head1.setOpaque(true);
        head1.setBackground(new java.awt.Color(240,255,240));
        head1.setFont(new Font("American Typewriter", Font.PLAIN, 20));
        head2.setOpaque(true);
        head2.setBackground(new java.awt.Color(240,255,240));
        head2.setFont(new Font("American Typewriter", Font.PLAIN, 20));
    	JPanel panel0 = new JPanel(new GridLayout(2, 1));
    	JPanel panel1 = new JPanel(new GridLayout(num + 1, 2));
    	JPanel panel2 = new JPanel(new GridLayout(num + 1, 1));
    	JPanel panel3 = new JPanel(new GridLayout(1, 2));
    	JButton back = new JButton("Back");
    	back.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
    			new DeleteChooseScreen(DAY);
    			frame.dispose();
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
    	back.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
    	exit.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
    	panel0.add(head1);
    	panel0.add(head2);
    	panel1.add(new JLabel("film name", JLabel.CENTER));
    	panel1.add(new JLabel("start time", JLabel.CENTER));
        panel1.setBackground(new java.awt.Color(240,255,255));
    	panel2.add(new JLabel("Operation", JLabel.CENTER));
        panel2.setBackground(new java.awt.Color(240,255,255));
    	panel3.add(back);
    	panel3.add(exit);
        panel3.setBackground(new java.awt.Color(240,255,255));
    	JLabel[][] labels=new JLabel[num][2];
    	JButton [] buttons = new JButton[num];
    	int k = 0;
    	for(int i = 0; i < screenFilmList.size(); i++)
    	{
    		for(int j = 0; j < startTime.get(i).size(); j++)
    		{
    			labels[k][0] = new JLabel(screenFilmList.get(i), JLabel.CENTER);
    			labels[k][1] = new JLabel(startTime.get(i).get(j), JLabel.CENTER);
    			panel1.add(labels[k][0]);
    			panel1.add(labels[k][1]);
    			buttons[k] = new JButton("Delete");
    			buttons[k].addActionListener(new ButtonListener(i, j, screenNum, screenFilmList.get(i))); 
    			panel2.add(buttons[k]);
    			k++;
    		}
    	}
    	frame.getContentPane().add(BorderLayout.NORTH, panel0);
    	frame.getContentPane().add(BorderLayout.SOUTH, panel3);
    	frame.getContentPane().add(BorderLayout.EAST, panel2);
    	frame.getContentPane().add(BorderLayout.CENTER,panel1);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    	frame.setSize(800,600);
    	frame.setVisible(true);
    	
    }
    public class ButtonListener implements ActionListener
    {
    	private int filmCount;
    	private int startTimeCount;
    	private int screenNum;
    	private String filmName;
    	public ButtonListener(int i, int j, int screenNo, String name)
    	{
    		filmCount = i;
    		startTimeCount = j;
    		screenNum = screenNo;
    		filmName = name;
    		//System.out.println("filmName: " + filmName);
    		//System.out.println("startTime: " + startTimeCount);
    	}
    	/**
    	 * A method to judge whether the schedule can be deleted or not
    	 * @return can be deleted or not
    	 */
    	private boolean checkDelete()
    	{
    		Reader rd = new Reader();
    		int count = rd.readScreen(screenNum, startTimeCount + 1, filmName, DAY);
    		//System.out.println("count: " + count);
    		switch(screenNum)
    		{
    		case 1: if(count < 32)
    			    return false; break;
    		case 2: if(count < 26)
    			    return false; break;
    		case 3: if(count < 32)
    			    return false; break;
    		}
    		return true;
    	}
    	/**
    	 * A method to delete the schedule
    	 * @return whether the file is deleted successfully or not
    	 */
    	private boolean deleteSchedule()
    	{
    		Writer wt = new Writer();
    		int subsize = startTime.get(filmCount).size();
    		startTime.get(filmCount).remove(startTimeCount);
    		
    		if(startTime.get(filmCount).size() == 0)
    			screenFilmList.remove(filmCount);
    		
    		wt.writeScreenSchdule(screenNum, DAY);
    		if(!wt.deleteFile(filmName, screenNum, startTimeCount + 1, DAY))
    			return false;
    		 
    		if(startTimeCount != subsize - 1)
    		{
    			int t = 0;
    			String preName = "";
    			String newName = "";
    			for(t = startTimeCount; t < subsize - 1;  )
    			{
    				preName = DAY + "_screen" + screenNum + "_" + filmName + "_" + (t+2);
    				newName = DAY + "_screen" + screenNum + "_" + filmName + "_" + (t+1);
    				//System.out.println("preName = " + preName);
    			    //System.out.println("newName = " + newName);
    			    
    				if(wt.checkFileExist(preName))
    				{
    					wt.modifyFileName(preName, newName);
    					
    				}
    				else
    					return false;
    				t++;
    			}
    		}
    		return true;
    	}
    	public void actionPerformed(ActionEvent e)
    	{
    		if(checkDelete())
    		{
    			if(deleteSchedule())
    			{
    				new ErrorGUI("You have delete the schedule", frame);
    				frame.dispose();
    				new DeleteScheduleGUI(screenNum, DAY);
    				
    			}
    				
    			else
    				new ErrorGUI("Fail to delete in file!", frame);
    		}
    		else
    		new ErrorGUI("<html>Can't delete this schedule.<br/> Someone has booked the ticket.</html>", frame);
    	}
    }
   /* public static void main(String [] args)
    {
    	new DeleteScheduleGUI(2);
    }*/
}
