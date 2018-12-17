

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 * Title      : AddScheduleGUI.java
 * Description: This class describes the interface to allow user enter the film name.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class AddScheduleGUI {
	private JTextField filmNameText;
	private JFrame frame;
	private int day;
    public AddScheduleGUI(int d){
    	this.day = d;
    	frame = new JFrame("Admin");
    	JLabel head = new JLabel("Add Schedule", JLabel.CENTER);
    	head.setFont(new Font("serif", Font.BOLD, 35));
    	JButton back = new JButton("Back");
    	JButton exit = new JButton("Exit");
    	JButton ok = new JButton("OK");
    	back.setFont(new Font("serif", Font.BOLD, 15));
    	back.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
    			new AdminGUI();
    			frame.dispose();
    		}
    	});
    	exit.setFont(new Font("serif", Font.BOLD, 15));
    	exit.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
                new CoreGUI();
                frame.dispose();

    		}
    	});
    	ok.setFont(new Font("serif", Font.BOLD, 15));
    	ok.addActionListener(new OKListener());
    	JLabel centerLabel = new JLabel("Please enter the film name: ");
        centerLabel.setOpaque(true);
        centerLabel.setBackground(new java.awt.Color(240,255,240));
        centerLabel.setFont(new Font("American Typewriter", Font.PLAIN, 20));
    	//centerLabel.setFont(new Font("serif", Font.BOLD, 20));
    	JPanel centerPanel = new JPanel(new GridLayout(4, 1));
    	JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
    	filmNameText = new JTextField();
    	filmNameText.setFont(new Font("serif", Font.BOLD, 20));
    	centerPanel.add(centerLabel);
    	centerPanel.add(filmNameText);
    	bottomPanel.add(back);
    	bottomPanel.add(exit);
    	bottomPanel.add(ok);
        centerPanel.setBackground(new java.awt.Color(240,255,255));
        bottomPanel.setBackground(new java.awt.Color(240,255,255));
    	frame.getContentPane().add(BorderLayout.NORTH, head);
    	frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
    	frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(800,600);
		frame.setVisible(true);
    }
    /**
     * This class is to acquire the film name and execute corresponding operations.
     * @author Group 78
     * @version 1.0
     */
    public class OKListener implements ActionListener
    {
    	private String filmName;
    	public void actionPerformed(ActionEvent e)
    	{
    		filmName = filmNameText.getText();
    		int flag = checkExist();
    		if(flag == -1)
    		{
    			//System.out.println("Film not exist, do you want to add this film?");
    			new AddNewFilm(filmName, day);
    			frame.dispose();
    		}
    		else
    		{
    			new AdminChooseScreens(filmName, flag, day);
    			frame.dispose();
    		}
    		filmNameText.setText("");
    	}
       /**
        * This method is to check whether the film is existed in the file or not.
        * @return the index of the film. If not exist, return -1
        */
    	private int checkExist()
    	{
    		Reader reader = new Reader();
    		ArrayList<String> films = reader.readMovieList();
    		for(int i = 0; i < films.size(); i++)
        	{
        		if(films.get(i).equals(filmName) == true)
        		{
        			return i;
        		}
        	}
    		return -1;
    	}
    }
   /* public static void main(String args[])
    {
    	new AddScheduleGUI();
    }*/
}
