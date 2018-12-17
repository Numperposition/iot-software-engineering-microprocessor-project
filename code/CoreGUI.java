
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
 * A class to show the main platform of the software, both for administrators and customers
 * @author Group 78
 * @version 1.8
 */
public class CoreGUI 
{
private String k = "Custermer Entrence";
private String l = "Administor Entrence";
JFrame frame ; 
public CoreGUI(){
	frame = new JFrame();
JPanel panel1 = new JPanel(new GridLayout(1,2));
    panel1.setBackground(new java.awt.Color(245,255,250));
    JButton buton = new JButton(k);
    buton.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
    JButton buton1 = new JButton(l);
    buton1.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
ImageIcon icon = new ImageIcon("ntn.jpg");
JButton buton2 = new JButton();
buton2.setIcon(icon);
buton2=new JButton(new ImageIcon("ntn.jpg"));
buton2.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
panel1.add(buton);
panel1.add(buton1);
    JLabel h = new JLabel("Group 78's Cinema Tickets SellPlatform",JLabel.CENTER);
    //JLabel k = new JLabel();
    //k.setOpaque(true);
    //k.setBackground(new java.awt.Color(245,255,250));
    h.setFont(new Font("Apple Chancery", Font.PLAIN, 30));
    h.setOpaque(true);
    h.setBackground(new java.awt.Color(245,255,250));frame.getContentPane().add(BorderLayout.NORTH,h);
    frame.getContentPane().add(BorderLayout.CENTER,buton2);
    frame.getContentPane().add(BorderLayout.SOUTH,panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    frame.setSize(800,600);
    frame.setVisible(true);

       buton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			new InterfaceGUI();
		    frame.dispose();
		}});
    buton1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            new AdminGUI();
            
            frame.dispose();
        }});
}

}

