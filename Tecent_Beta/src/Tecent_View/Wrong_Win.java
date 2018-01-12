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


public class Wrong_Win {
        
	public  void wrong(){
        	new Login_2(); 
        }
}
class Login_2 extends JFrame {
	

	public Login_2() {
    	super();
    	ImageIcon image = new ImageIcon("Image/6_3.jpg");  
	    JLabel background = new JLabel(image);   
	    background.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  
	    getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));  
	    JPanel contentPanel = (JPanel)getContentPane();  
	    contentPanel.setOpaque(false);  
    	
		Container CP = getContentPane(); 
		CP.setLayout(null);
		JPanel JP1 = new JPanel();
		JP1.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		JButton JB1 = new JButton(new ImageIcon("Image/12.jpg"));
		JB1.setRolloverIcon(new ImageIcon("Image/12_1.jpg"));  
		JB1.setPressedIcon(new ImageIcon("Image/12_2.jpg"));  
		JB1.setPreferredSize(new Dimension(28, 31));
		JB1.setBorderPainted(false); 
		JB1.setToolTipText("最小化");
		JButton JB2 = new JButton(new ImageIcon("Image/11.jpg"));
		JB2.setRolloverIcon(new ImageIcon("Image/11_1.jpg"));  
		JB2.setPressedIcon(new ImageIcon("Image/11_2.jpg"));  
		JB2.setPreferredSize(new Dimension(28, 31));
		JB2.setBorderPainted(false);  
		JB2.setToolTipText("关闭");
		JLabel JL1 = new JLabel(new ImageIcon("Image/6_1.jpg"));
		JLabel JL2 = new JLabel(new ImageIcon("Image/13.jpg"));
		JLabel JL3 = new JLabel(new ImageIcon("Image/6.jpg"));
		JButton JB3 = new JButton(new ImageIcon("Image/6_2.jpg"));
		JB3.setRolloverIcon(new ImageIcon("Image/6_2_1.jpg"));  
		JB3.setPressedIcon(new ImageIcon("Image/6_2.jpg"));  
		JB3.setPreferredSize(new Dimension(82, 24));
		JB3.setBorderPainted(false); 
		JP1.add(JL2);
		JP1.add(JB1);
		JP1.add(JB2);
		CP.add(JP1);
		CP.add(JL1);
		CP.add(JL3);
		CP.add(JB3);
		JP1.setBounds(0, 0, 430, 31);
		JL1.setBounds(0, 31, 430, 20);  
		JL3.setBounds(0, 51, 430, 249);
		JB3.setBounds(340, 305, 82, 24);
		
		JB3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				return;
			}
		});
		
		JB2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				System.exit(0);
			}
		});
		
		JB1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		

		   addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
	              setVisible(false);
				
			}
		});
		MouseOperate mo = new MouseOperate(); 
		CP.addMouseListener(mo); 
		CP.addMouseMotionListener(mo);
		setUndecorated(true);
		setAlwaysOnTop(true);
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