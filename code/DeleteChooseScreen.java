
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
/**
 * Title      : DeleteChooseScreen.java
 * Description: A class to choose screen for delete schedule.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class DeleteChooseScreen {
    private JFrame frame;
    private int screenNum = 1;
    private JComboBox box;
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public DeleteChooseScreen(int d)
    {
    	frame = new JFrame("Admin");
    	JLabel head = new JLabel("Delete Schedule", JLabel.CENTER);
        head.setOpaque(true);
        head.setBackground(new java.awt.Color(240,255,240));
        head.setFont(new Font("American Typewriter", Font.PLAIN, 20));
    	
    	JButton back = new JButton("Back");
    	JButton exit = new JButton("Exit");
    	JButton ok = new JButton("OK");
    	ok.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
    			new DeleteScheduleGUI(screenNum, d);
    			frame.dispose();
    		}
    	});
    	back.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
    			new AdminGUI();
    			frame.dispose();
    		}
    	});
    	exit.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
                new CoreGUI();
                frame.dispose();
    		}
    	});
    	back.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
    	exit.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
    	ok.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
    	JLabel centerLabel = new JLabel("Please choose the screen number: ");
    	//centerLabel.setFont(new Font("serif", Font.BOLD, 20));
        centerLabel.setOpaque(true);
        centerLabel.setBackground(new java.awt.Color(240,255,240));
        centerLabel.setFont(new Font("American Typewriter", Font.PLAIN, 20));
    	JPanel centerPanel = new JPanel(new GridLayout(4, 1));
    	JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
    	String[] str = {"Screen1", "Screen2", "Screen3"};
		box = new JComboBox(str);
		box.setFont(new Font("serif", Font.BOLD, 25));
		box.addItemListener(new BoxItemListener());
		centerPanel.add(centerLabel);
		centerPanel.add(box);
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
     * A class to listen to which screen to choose
     * @author Group 78
     *
     */
    public class BoxItemListener implements ItemListener
    {
    	public void itemStateChanged(ItemEvent e)
    	{
    		if(e.getStateChange() == ItemEvent.SELECTED)
    		{
    			String s = (String)box.getSelectedItem();
    			if(s.equals("Screen1"))
    				screenNum = 1;
    			else if(s.equals("Screen2"))
    				screenNum = 2;
    			else 
    				screenNum = 3;
    		}
    	}
    }
   
}
