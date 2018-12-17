
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 * Title      : AddNewFilm.java
 * Description: This class build the GUI of adding new film as well as file operation.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class AddNewFilm {
     private JFrame frame;
     private String filmName;
     private JTextField lastTimeText;
     private JTextField priceText;
     private JTextArea filmInfoArea;
     private int day;
     /**
      * Constructor
      * @param name the name of the film
      * @param d the day of schedule
      */
     public AddNewFilm(String name, int d)
     {
    	 day = d;
    	 filmName = name;
    	 frame = new JFrame("Admin");
    	 JLabel head1 = new JLabel("Add New Film", JLabel.CENTER);
     	 head1.setFont(new Font("serif", Font.BOLD, 35));
     	 JLabel head2 = new JLabel(filmName, JLabel.CENTER);
     	 head2.setFont(new Font("serif", Font.BOLD, 25));
     	 JLabel c1 = new JLabel("Last Time:", JLabel.CENTER);
     	 c1.setFont(new Font("serif", Font.BOLD, 20));
     	 JLabel c2 = new JLabel("Price:", JLabel.CENTER);
    	 c2.setFont(new Font("serif", Font.BOLD, 20));
    	 JLabel c3 = new JLabel("$");
    	 c3.setFont(new Font("serif", Font.BOLD, 20));
    	 JLabel c5 = new JLabel("min");
    	 c5.setFont(new Font("serif", Font.BOLD, 20));
    	 JLabel c4 = new JLabel("This is a new film. Please enter the introduction of this film below:");
    	 c4.setFont(new Font("serif", Font.BOLD, 16));
    	 lastTimeText = new JTextField();
    	 lastTimeText.setFont(new Font("serif", Font.BOLD, 20));
    	 priceText = new JTextField();
    	 priceText.setFont(new Font("serif", Font.BOLD, 20));
    	 filmInfoArea = new JTextArea();
    	 filmInfoArea.setFont(new Font("serif", Font.ROMAN_BASELINE, 16));
    	 JButton back = new JButton("Back");
    	 back.addActionListener(new ActionListener(){
     		public void actionPerformed(ActionEvent e)
     		{
     			frame.dispose();
     			new AddScheduleGUI(day);
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
     	 JButton ok = new JButton("OK");
     	 ok.addActionListener(new OKListener());
     	 back.setFont(new Font("serif", Font.BOLD, 15));
     	 exit.setFont(new Font("serif", Font.BOLD, 15));
     	 ok.setFont(new Font("serif", Font.BOLD, 15));
    	 JPanel centerPanel = new JPanel(new GridLayout(2, 1));
    	 JPanel subCenterPanel = new JPanel(new GridLayout(3, 1));
    	 JPanel subPanel = new JPanel(new GridLayout(1, 6));
    	 JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
    	 subPanel.add(c1);
    	 subPanel.add(lastTimeText);
    	 subPanel.add(c5);
    	 subPanel.add(c2);
    	 subPanel.add(priceText);
    	 subPanel.add(c3);
    	 subCenterPanel.add(head2);
    	 subCenterPanel.add(subPanel);
    	 subCenterPanel.add(c4);
    	 centerPanel.add(subCenterPanel);
    	 centerPanel.add(filmInfoArea);
    	 bottomPanel.add(back);
     	 bottomPanel.add(exit);
     	 bottomPanel.add(ok);
         bottomPanel.setBackground(new java.awt.Color(240,255,255));
         centerPanel.setBackground(new java.awt.Color(240,255,255));
         subPanel.setBackground(new java.awt.Color(240,255,255));
         subCenterPanel.setBackground(new java.awt.Color(240,255,255));
     	 frame.getContentPane().add(BorderLayout.NORTH, head1);
    	 frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
    	 frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
    	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 frame.setSize(800,600);
		 frame.setVisible(true);
    	 
     }
     /**
      * This class deals with the event of the buttons.
      * @author Group 78
      * @version 1.0
      */
     public class OKListener implements ActionListener
     {
    	 public void actionPerformed(ActionEvent e)
    	 {
    		 Writer wt = new Writer();
    		 Reader rd = new Reader();
    		 ArrayList<String> content = new ArrayList<String>();
    		 ArrayList<String> info = rd.readInfo("movies");
    		 String price = priceText.getText();
    		 String lastTime = lastTimeText.getText();
    		 info.add(filmName + "," + lastTime + "," + price);
    		 content.add("Title:" + filmName);
    		 content.add(price);
    		 content.add(lastTime);
    		 String[] strs = filmInfoArea.getText().split("\n");
    		 for(String s : strs)
    			 content.add(s);
    		 wt.writeInfo(filmName + "_info", content);
    		 wt.writeInfo("movies", info);
    		 System.out.println("done!");
    		 new AdminChooseScreens(filmName, info.size() - 1, day);
    		 frame.dispose();
    	 }
     }
    /* public static void main(String args[])
     {
    	 new AddNewFilm("Herry Potten");
     }*/
}
