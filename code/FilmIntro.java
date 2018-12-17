/**
 * Title      : FilmIntro.java
 * Description: This class contains the create the GUI of film introduction.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FilmIntro extends JFrame
{       JFrame frame = new JFrame();
	public FilmIntro() { 
		init();
		frame.setSize(800,600); 
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		} 
	 public void init()  
	    {  
		    String sb = null;
		    sb = new String("<html>");
		    Reader reader = new Reader();
		    reader.readMovieInfo(CurrentPurchase.filmName);
		    CurrentPurchase.lastTime = reader.getLastTime();
		    for(String s : reader.getFilmIntro())
		    {
		    	
		    	if(s != null)
		    	{
		    		sb = sb + s + "<br/>";
		    		
		    	}
		    	
		    }
		    
		    sb += "price: " + reader.getPrice() + "<br/>";
		    sb += "last time: " + reader.getLastTime() + "</html>";
		    
		    JPanel j4, j1;
            
		    JLabel j9 = new JLabel(sb,JLabel.CENTER);
            j9.setOpaque(true);
            j9.setBackground(new java.awt.Color(240,255,240));
            j9.setFont(new Font("American Typewriter", Font.PLAIN, 20));
			JLabel lab = new JLabel(CurrentPurchase.filmName + " picture",JLabel.CENTER), lab1 = new JLabel();
			lab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245,255,250)));
            lab.setOpaque(true);lab1.setOpaque(true);
            lab.setBackground(new java.awt.Color(240,255,255));
            lab1.setBackground(new java.awt.Color(240,255,255));
			//j9.setText(sb);
			j1 = new JPanel(new GridLayout(1,2));
			JButton j2 = new JButton("Purchase"),j5 = new JButton("BACK");
            j2.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
            j5.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
			j1.add(j5);j1.add(j2);
		    j4 =new JPanel(new GridLayout(3,1)); 
		    j4.add(lab);
		    j4.add(lab1);
		    j4.add(j1);
            //j4.setBackground(new java.awt.Color(240,255,255));
            j1.setBackground(new java.awt.Color(240,255,255));
		    j9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245,255,250)));;
		GridBagLayout layout = new GridBagLayout(); 
		     frame.setLayout(layout); 
		     frame.add(j4); 
		     frame.add(j9); 
		GridBagConstraints s= new GridBagConstraints();
		
		    s.fill = GridBagConstraints.BOTH; 
		    s.gridwidth=50;
		    s.weightx = 0;
		    s.weighty=1; 
		    layout.setConstraints(j4, s) ;
		    s.gridwidth=100; 
		    s.weightx = 1; 
		    s.weighty=1; 
		    layout.setConstraints(j9, s); 
		   j5.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					 new Movies();
					
				    frame.dispose();
				}});
	                                              	
	       j2. addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					CurrentPurchase.filmPrice = reader.getPrice();
					System.out.println(CurrentPurchase.filmName + " price: " + CurrentPurchase.filmPrice);
					 new SelectTimeGUI();

				    frame.dispose();
				}});
}
	 }

