//package coursework;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * A class to show the customer welcome interface.
 * @author Group 78
 *
 */
public class InterfaceGUI 
{
private String k = "BoxOffice";
private String l = "OnlineOffice";
private String j = "CorePlatform";
JFrame frame ; 
public InterfaceGUI(){
	frame = new JFrame();
JPanel panel1 = new JPanel(new GridLayout(1,2));
    panel1.setBackground(new java.awt.Color(245,255,250));
    JButton buton = new JButton(k);
    buton.setFont(new Font("Britannic Bold", Font.PLAIN, 30));
    JButton buton1 = new JButton(l);
    buton1.setFont(new Font("Britannic Bold", Font.PLAIN, 30));
    JButton buton2 = new JButton(j);
    buton2.setFont(new Font("Britannic Bold", Font.PLAIN, 30));
ImageIcon icon = new ImageIcon("tnt.jpg");
JButton buton3 = new JButton();
buton3.setIcon(icon);
buton3=new JButton(new ImageIcon("tnt.jpg"));
buton3.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
panel1.add(buton);
panel1.add(buton1);
panel1.add(buton2);
    JLabel h = new JLabel("Welcome to the Group78's cinema's kiosk!!!",JLabel.CENTER);
    //JLabel k = new JLabel();
    //k.setOpaque(true);
    //k.setBackground(new java.awt.Color(245,255,250));
    h.setFont(new Font("Apple Chancery", Font.PLAIN, 30));
    h.setOpaque(true);
    h.setBackground(new java.awt.Color(245,255,250));frame.getContentPane().add(BorderLayout.NORTH,h);
    frame.getContentPane().add(BorderLayout.CENTER,buton3);
    frame.getContentPane().add(BorderLayout.SOUTH,panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    frame.setSize(800,600);
    frame.setVisible(true);

       buton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			CurrentPurchase.day = 0;
			 new Movies();
		    frame.dispose();
		}});
    buton2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            new CoreGUI();
            frame.dispose();
        }});
    buton1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            new Choosedate(0);
            
            frame.dispose();
        }});
}

}
