package Tecent_View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;


public class Wait_Win {
	
	private static Login_3 login = null;
	
	
    public void waiting(){
	  login = new Login_3();
   }
   
   public  void disposing(){
	   login.setVisible(false);
   }
}

class Login_3 extends JFrame {
	

	public Login_3() {
    	super();
    	ImageIcon image = new ImageIcon("Image/5_2.jpg");  
	    JLabel background = new JLabel(image);   
	    background.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  
	    getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));  
	    JPanel contentPanel = (JPanel)getContentPane();  
	    contentPanel.setOpaque(false);  
    	
		Container CP = getContentPane(); 
		CP.setLayout(null);
		
		JButton JB1 = new JButton(new ImageIcon("Image/5_1.jpg"));
		JB1.setRolloverIcon(new ImageIcon("Image/5_1_1.jpg"));  
		JB1.setPressedIcon(new ImageIcon("Image/5_1.jpg"));  
		JB1.setBounds(117, 293, 195, 31);
		JB1.setPreferredSize(new Dimension(195, 31));
		JB1.setBorderPainted(false); 
		
		
		CP.add(JB1);
		MouseOperate mo = new MouseOperate(); 
		CP.addMouseListener(mo); 
		CP.addMouseMotionListener(mo);
		setUndecorated(true);
		setLocation(497, 242);
		setSize(430, 333);
   	    setVisible(true);
   	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

private class MouseOperate extends MouseInputAdapter { 
	private Point point1; 
	public void mousePressed(MouseEvent e) { 
		point1 = e.getPoint(); 
		} 
	public void mouseDragged(MouseEvent e) { 
		Point point2 = new Point(); 
		point2 = e.getPoint(); 
		int dx = point2.x - point1.x; 
		int dy = point2.y - point1.y; 
		int x = getX(); 
		int y = getY(); 
		setLocation(x+dx,y+dy); } } 
}