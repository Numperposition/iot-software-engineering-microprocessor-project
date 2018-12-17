

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Title      : PayBillGUI.java
 * Description: A class to let user enter the bank card id.
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class PayBillGUI extends JPanel{
	private static final long serialVersionUID = 1834511718758119719L;
    static final int WIDTH=350;
    static final int HEIGHT=200;
    JFrame loginframe;
    String m = "Payment",a = "Please input correct No", b ="E-CNo",c="Bank";
    String[] str1 = {"Bank of China","Union Bank of Switzerland",
    		"Postal Savings Bank of China","China Construction Bank",
    		"Agricultural Bank of China"};
 
    private ReadStudID readStud;
    String[] str2 = new String[100];
    public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h)

    {

        constraints.gridx=x;
        constraints.gridy=y;
        constraints.gridwidth=w;
        constraints.gridheight=h;
        add(c,constraints);

     }
 
	@SuppressWarnings("rawtypes")
	public PayBillGUI(JFrame tempFrame)

    {        
		readStud = new ReadStudID();
        readStud.readStudID("Bank of China");
        loginframe=new JFrame(m); 
        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout lay=new GridBagLayout();  
        setLayout(lay);
        loginframe.add(this, BorderLayout.WEST);
        loginframe.setSize(WIDTH,HEIGHT);
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int width=screenSize.width,height=screenSize.height,x=(width-WIDTH)/2,y=(height-HEIGHT)/2;
        loginframe.setLocation(x,y);
        final JTextField nameinput = new JTextField(15);
        
        JButton ok=new JButton("Next"), cancel=new JButton("Back");
        cancel.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		loginframe.dispose();
        		tempFrame.setEnabled(true);
        	}
        });
        ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//new PayBillGUI();
				Boolean flag = readStud.checkStudID(nameinput.getText());
				 if(flag)
				 {
					
					 new ConfirmGUI(loginframe, tempFrame);
					
				 }
				 else
				 {
					 //loginframe.setVisible(false);
					 new ErrorGUI("The card ID not exist.",loginframe);
					 nameinput.setText("");
				 }
						 
			}});
       
        JLabel title=new JLabel(a),name=new JLabel(b),password=new JLabel(c);
       
        title.setFont(new Font("Apple Chancery", Font.PLAIN, 10));
       
        name.setFont(new Font("Apple Chancery", Font.PLAIN, 10));
        
        password.setFont(new Font("Apple Chancery", Font.PLAIN, 10));
       
        @SuppressWarnings("unchecked")
		JComboBox passwordinput=new JComboBox(str1);
        passwordinput.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		readStud.readStudID(passwordinput.getSelectedItem().toString());

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
