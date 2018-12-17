

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * Title      : IdentifyStudIdGUI.java
 * Description: A class create a interface to check student id.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class IdentifyStudIdGUI extends JPanel{
	private static final long serialVersionUID = 1834511718758119719L;
	private ArrayList<String> temp = new ArrayList<String>();
    private int studCount = CurrentPurchase.studTicketNum;
    private ReadStudID readStud;
    static final int WIDTH=300;
    static final int HEIGHT=150;
    JFrame loginframe;
    @SuppressWarnings("rawtypes")
	JComboBox passwordinput;
    String m = "Identify studentsInfo",a = "Input inform", b ="sID",c="University";
    String[] str = {"BUPT",
    		"Tsinghua University","Peking University", "Beijing Normal University"
    		, "Xiamen University"}; 
    //String[] str2 = new String[100];
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void add(String[] str)
    {    this.str = str;
    	 passwordinput = new JComboBox(str);
    }
    public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h)

    {

        constraints.gridx=x;
        constraints.gridy=y;
        constraints.gridwidth=w;
        constraints.gridheight=h;
        add(c,constraints);

     }
    /**
     * A method to check whether the id is valid.
     * @param str a id to be checked
     * @return id valid or not
     */
    private Boolean checkRepeat(String str)
    {
    	for(String s : temp)
    	{
    		if(s.equals(str) == true)
    		{
    			return false;
    		}
    	}
    	return true;
    }
    public IdentifyStudIdGUI(JFrame tempFrame)
    {
        loginframe=new JFrame(m); 
        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        readStud = new ReadStudID();
        readStud.readStudID("BUPT");
        
        GridBagLayout lay=new GridBagLayout();  
        setLayout(lay);
        loginframe.add(this, BorderLayout.WEST);
        loginframe.setSize(WIDTH,HEIGHT);
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int width=screenSize.width,height=screenSize.height,x=(width-WIDTH)/2,y=(height-HEIGHT)/2;
        loginframe.setLocation(x,y);
        JButton ok=new JButton("Next"), cancel=new JButton("Back");
        
        JLabel title=new JLabel(a),name=new JLabel(b),password=new JLabel(c);
        JTextField nameinput=new JTextField(15);
       
        ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//new PayBillGUI();
				String inputID = nameinput.getText();
				Boolean flag = readStud.checkStudID(inputID);
				Boolean flag2 = checkRepeat(inputID);
				//System.out.println("flag = " + flag);	
				//System.out.println("flag2 = " + flag2);	

				 if(flag && flag2 && studCount > 1)
				 { 
					 new ErrorGUI("<html>Student ID checked Successfully.<br/>Please enter next student ID", loginframe);
					 temp.add(inputID);
					 nameinput.setText("");
					 studCount--;	
				 }
				 else if(flag && flag2 && studCount == 1)
				 {
					 temp.add(inputID);
					 CurrentPurchase.studIDList = temp;
					 new PayBillGUI(tempFrame);
					 loginframe.dispose();
				 }
				 else 
				 {
					 //loginframe.setVisible(false);
					 new ErrorGUI("Your student id is error, please enter again.",loginframe);
					 nameinput.setText("");
					 //loginframe.setEnabled(false);
				 }
				
			}});
        cancel.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		tempFrame.setEnabled(true);
        		loginframe.dispose();
        	}
        });
        add(str);
        readStud.readStudID("BUPT");
        passwordinput.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		// int index = passwordinput.getSelectedIndex();
        		 readStud.readStudID(passwordinput.getSelectedItem().toString());
     		     System.out.println(passwordinput.getSelectedItem().toString());
     		    for(String str : readStud.getID())
     	    	 {
     	    		 System.out.println(str);
     	    	 }

        	}});
        GridBagConstraints constraints=new GridBagConstraints();
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.EAST;
        constraints.weightx=3;
        constraints.weighty=4;
        add(title,constraints,0,0,3,1);                
        add(name,constraints,0,1,1,1);
        add(password,constraints,0,2,1,1);
        add(nameinput,constraints,2,1,1,1);
        add(passwordinput,constraints,2,2,1,1);
        add(ok,constraints,0,3,1,1);
        add(cancel,constraints,2,3,1,1);
        loginframe.setVisible(true);  
        loginframe.setAlwaysOnTop(true);
        tempFrame.setEnabled(false);

    }
}
