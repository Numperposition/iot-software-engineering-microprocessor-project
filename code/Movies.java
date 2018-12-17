//package coursework;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * A class to create the interface of movie list(start time and price).
 * @author Group 78
 *
 */
public class Movies extends JFrame {
	JFrame frame;
	ArrayList<String> filmList;
	
public Movies()
  {
	frame = new JFrame();
	Reader reader = new Reader();
	filmList = reader.readMovieList();
	JLabel label = new JLabel("No." + CurrentPurchase.day + "Films",JLabel.CENTER);
    label.setOpaque(true);
    label.setBackground(new java.awt.Color(240,255,255));
    label.setFont(new Font("Apple Chancery", Font.PLAIN, 30));
	JPanel panel1 = new JPanel(new GridLayout(filmList.size(),3));
	JPanel panel2 = new JPanel(new GridLayout(filmList.size(),1)), panel3 = new JPanel(new GridLayout(1,2));
	JLabel[][] label11=new JLabel[filmList.size()][3];
	JButton[] button = new JButton[filmList.size()];
	
	for(int i = 0;i<filmList.size();i++)
		{
			for(int j=0;j<3;j++)
			{
				if(j == 0)
				   label11[i][j] = new JLabel(filmList.get(i),JLabel.CENTER);
				if(j == 1)
				   label11[i][j] = new JLabel(reader.lastTimeList.get(i) + "min",JLabel.CENTER);
				if(j == 2)
				{
					label11[i][j] = new JLabel("", JLabel.CENTER);
					label11[i][j].setIcon(new ImageIcon(i + ".png" ));
				}
				   
		           //label11[i][j].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                label11[i][j].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
                label11[i][j].setOpaque(true);
                label11[i][j].setBackground(new java.awt.Color(240,255,240));
                label11[i][j].setFont(new Font("American Typewriter", Font.PLAIN, 20));
				panel1.add(label11[i][j]);
			}
			
		}
	for(int k = 0; k < filmList.size(); k++)
	{
			button[k] = new JButton("select");
            button[k].setOpaque(true);
            button[k].setBackground(new java.awt.Color(240,255,240));
            button[k].setFont(new Font("Britannic Bold", Font.PLAIN, 15));
			button[k].addActionListener(new BtListener(k));
        
			panel2.add(button[k]);
	}
	
         JButton l = new JButton("BACK");
         l.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
         JButton n = new JButton("EXIT");
         n.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
	     panel3.add(l);
	     panel3.add(n);
         panel3.setBackground(new java.awt.Color(240,255,255));
         l.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 new InterfaceGUI();
                 frame.dispose();
             }});
         n. addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 new Thanks();
                 frame.dispose();
             }});

	frame.getContentPane().add(BorderLayout.NORTH,label);
	frame.getContentPane().add(BorderLayout.SOUTH,panel3);
	frame.getContentPane().add(BorderLayout.EAST,panel2);
	frame.getContentPane().add(BorderLayout.CENTER,panel1);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	frame.setSize(800,600);
	frame.setVisible(true);
	
	}
    public class BtListener implements ActionListener
    {
    	private int k = 0;
    	public BtListener(int k)
    	{
    		this.k = k;
    	}
    	public void actionPerformed(ActionEvent e)
    	{
			
			CurrentPurchase.filmName = filmList.get(k);
			
			new FilmIntro();
			frame.dispose();
		
		    
		}
    }

}


