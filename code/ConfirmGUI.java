
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
* Title      : ConfirmGUI.java
* Description: This class creates the confirm interface to ensure user's choice.
* Copyright  : Copyright (c) 2905-2017 All rights reserved
* @author      Group 78
* @version     1.8
*/
public class ConfirmGUI extends JPanel{
    private JFrame sureFrame;
    
    public ConfirmGUI(JFrame tempFrame, JFrame billGUI)
    {
    	sureFrame = new JFrame();
		sureFrame.setTitle("ensure");
		JPanel upPanel = new JPanel();
		upPanel.setBackground(new java.awt.Color(240,255,255));
		Font big = new Font("serif", Font.BOLD, 23);
		JLabel lb = new JLabel("Are you sure to pay?");
        lb.setOpaque(true);
        lb.setBackground(new java.awt.Color(240,255,255));
        lb.setFont(new Font("Apple Chancery", Font.PLAIN, 30));
		upPanel.add(lb);
        
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1,2));
		south.setBackground(Color.yellow);
		JButton left = new JButton("CANCEL");
        left.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		JButton right = new JButton("SURE");
        right.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
        south.setBackground(new java.awt.Color(240,255,255));
		south.add(left);
		south.add(right);
		sureFrame.getContentPane().add(BorderLayout.CENTER, upPanel);
		sureFrame.getContentPane().add(BorderLayout.SOUTH, south);
		sureFrame.setSize(WIDTH,HEIGHT);
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();  
        int width=screenSize.width,height=screenSize.height,x=(width-WIDTH)/2,y=(height-HEIGHT)/2;
        sureFrame.setLocation(x,y);
        sureFrame.setVisible(true);
		sureFrame.setSize(400, 200);
		sureFrame.setAlwaysOnTop(true);
		tempFrame.setEnabled(false);
		right.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				//Writer writer = new Writer();
				//writer.writeScreen(CurrentPurchase.screenNum, CurrentPurchase.startTime, CurrentPurchase.filmName);
				new SuccessPurchasedGUI();
				tempFrame.dispose();
				sureFrame.dispose();
				billGUI.dispose();
			}
		});
		left.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				tempFrame.setEnabled(true);
				sureFrame.dispose();
			}
		});
    }
}
