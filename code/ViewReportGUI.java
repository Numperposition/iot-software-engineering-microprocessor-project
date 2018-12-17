
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 * Title      : ViewReportGUI.java
 * Description: This class contains the definition of ViewReportGUI
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class ViewReportGUI {
    private JFrame frame;
    /**
     * Constructor 
     * A constructor used to generate the interface of statistic report.
     * @param d which day's report
     */
    public ViewReportGUI(int d)
    {
    	Reader reader = new Reader();
    	ArrayList <String> content = reader.readInfo(d - 1 + "_statistic_report");
    	frame = new JFrame("Admin");
   	    JLabel head1 = new JLabel("No." + d + " Statistic Report", JLabel.CENTER);
    	head1.setFont(new Font("serif", Font.BOLD, 35));
    	JPanel centerPanel = new JPanel();
    	JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
    	JTextArea reportContentArea = new JTextArea();
    	reportContentArea.setWrapStyleWord(true);
    	reportContentArea.setEditable(false);
    	JScrollPane scroll = new JScrollPane(reportContentArea);
    	reportContentArea.setFont(new Font("serif", Font.ROMAN_BASELINE, 17));
    	for(String line : content)
    	  {
    	    reportContentArea.append(line);
    	    reportContentArea.append("\r\n");
    	  }
    	centerPanel.add(scroll);
        centerPanel.setBackground(new java.awt.Color(240,255,255));
    	JButton back = new JButton("Back");
   	    back.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
    			frame.dispose();
    			new AdminGUI();
    		}
    	});
    	 JButton exit = new JButton("Exit");
    	exit.addActionListener(new ActionListener(){
   		public void actionPerformed(ActionEvent e)
   		{
   			System.exit(0);
   		}
     	});
    	 JButton sendEmail = new JButton("Send email");
    	 back.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
     	  exit.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
     	 sendEmail.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
     	 sendEmail.addActionListener(new ActionListener(){
       		public void actionPerformed(ActionEvent e)
       		{
       			new ErrorGUI("Email has been sent", frame);
       		}
         	});
     	 bottomPanel.add(back);
    	 bottomPanel.add(exit);
    	 bottomPanel.add(sendEmail);
         bottomPanel.setBackground(new java.awt.Color(240,255,255));
    	 frame.getContentPane().add(BorderLayout.NORTH, head1);
    	 frame.getContentPane().add(BorderLayout.CENTER, scroll);
    	 frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
    	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 frame.setSize(800,600);
		 frame.setVisible(true);
    }
    /* public static void main(String args[])
    {
   	 new ViewReportGUI();
    }*/
}
