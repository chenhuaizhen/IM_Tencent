package Tecent_View;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.MouseInputAdapter;

import Common.*;


public class TheUser_Win {

	
	public  void open_User_Win(TheUser user){
		new User_Win (user);
	}
}
class User_Win extends JFrame {
	
	
    public User_Win(final TheUser user) {
    	super();
    	ImageIcon image = new ImageIcon("Image/4_4.jpg");  
	    JLabel background = new JLabel(image);   
	    background.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  
	    getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));  
	    JPanel contentPanel = (JPanel)getContentPane();  
	    contentPanel.setOpaque(false);  
    	
		final Container CP = getContentPane(); 
		CP.setLayout(null);
		

		JButton JB1 = new JButton(new ImageIcon("Image2/4_3.jpg"));
		JB1.setRolloverIcon(new ImageIcon("Image2/4_3_1.jpg"));  
 		JB1.setPressedIcon(new ImageIcon("Image2/4_3_2.jpg"));  
 		JB1.setPreferredSize(new Dimension(22, 24));
 		JB1.setBorderPainted(false); 
 		JB1.setBounds(231, 0, 22, 24);
 		JB1.setToolTipText("最小化");
 		
		JButton JB2 = new JButton(new ImageIcon("Image2/4_2.jpg"));
		JB2.setRolloverIcon(new ImageIcon("Image2/4_2_1.jpg"));  
 		JB2.setPressedIcon(new ImageIcon("Image2/4_2_2.jpg"));  
 		JB2.setPreferredSize(new Dimension(22, 24));
 		JB2.setBorderPainted(false);  
 		JB2.setBounds(253, 0, 22, 24);
 		JB2.setToolTipText("关闭");
 		
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
 		
		CP.add(JB1);
		CP.add(JB2);
		
		final JButton JB3 = new JButton(new ImageIcon("Image2/2_1_1.jpg"));
		JB3.setRolloverIcon(new ImageIcon("Image2/2_1_2.jpg"));  
 		JB3.setPressedIcon(new ImageIcon("Image2/2_1.jpg"));  
 		JB3.setPreferredSize(new Dimension(56, 36));
 		JB3.setBorderPainted(false);  
 		JB3.setBounds(0, 167, 56, 36);
 		CP.add(JB3);
 		
		final JButton JB4 = new JButton(new ImageIcon("Image2/2_2_1.jpg"));
		JB4.setRolloverIcon(new ImageIcon("Image2/2_2_2.jpg"));  
 		JB4.setPressedIcon(new ImageIcon("Image2/2_2.jpg"));  
 		JB4.setPreferredSize(new Dimension(57, 36));
 		JB4.setBorderPainted(false);  
 		JB4.setBounds(56, 167, 57, 36);
 		CP.add(JB4);
 		
		final JButton JB5 = new JButton(new ImageIcon("Image2/2_3_1.jpg"));
		JB5.setRolloverIcon(new ImageIcon("Image2/2_3_2.jpg"));  
 		JB5.setPressedIcon(new ImageIcon("Image2/2_3.jpg"));  
 		JB5.setPreferredSize(new Dimension(57, 36));
 		JB5.setBorderPainted(false);  
 		JB5.setBounds(113, 167, 57, 36);
 		CP.add(JB5);
 		
		final JButton JB6 = new JButton(new ImageIcon("Image2/2_4_1.jpg"));
		JB6.setRolloverIcon(new ImageIcon("Image2/2_4_2.jpg"));  
 		JB6.setPressedIcon(new ImageIcon("Image2/2_4.jpg"));  
 		JB6.setPreferredSize(new Dimension(56, 36));
 		JB6.setBorderPainted(false);  
 		JB6.setBounds(170, 167, 56, 36);
 		CP.add(JB6);
 		
		final JButton JB7 = new JButton(new ImageIcon("Image2/2_5_1.jpg"));
		JB7.setRolloverIcon(new ImageIcon("Image2/2_5_2.jpg"));  
 		JB7.setPressedIcon(new ImageIcon("Image2/2_5.jpg"));  
 		JB7.setPreferredSize(new Dimension(49, 36));
 		JB7.setBorderPainted(false);  
 		JB7.setBounds(226, 167, 49, 36);
 		CP.add(JB7);
 		
		//空面板
 		final JPanel JP1 = new JPanel();
 		
	 	final JLabel JL1 = new JLabel("该功能还没实现");
	 	JL1.setFont(new java.awt.Font("宋体",1,15));
		//JL1.setForeground(Color.black);
		//JL1.setSize(275,  432);
 		JP1.setBounds(0, 203, 275, 432);
 		CP.add(JP1);
 		JB3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JB3.setIcon(new ImageIcon("Image2/2_1.jpg"));
				JB4.setIcon(new ImageIcon("Image2/2_2_1.jpg"));
				JB5.setIcon(new ImageIcon("Image2/2_3_1.jpg"));
				JB6.setIcon(new ImageIcon("Image2/2_4_1.jpg"));
				JB7.setIcon(new ImageIcon("Image2/2_5_1.jpg"));
				
				JP1.removeAll();
		 		JP1.add(JL1);
		 		JP1.validate();//是JP1有效化
		 		repaint();
			}
		});
 		
         JB4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JB3.setIcon(new ImageIcon("Image2/2_1_1.jpg"));
				JB4.setIcon(new ImageIcon("Image2/2_2.jpg"));
				JB5.setIcon(new ImageIcon("Image2/2_3_1.jpg"));
				JB6.setIcon(new ImageIcon("Image2/2_4_1.jpg"));
				JB7.setIcon(new ImageIcon("Image2/2_5_1.jpg"));
				
				JTree jtree = Tree.jTree(user.getName());
				JScrollPane sp = new JScrollPane(jtree);
				
				//sp.setSize(276,  433);
				//sp.setBounds(0, 203, 276, 433);
				//sp.setBorder(BorderFactory.createEmptyBorder());//去边框
				sp.setOpaque(false);
				sp.getViewport().setOpaque(false);//透明化
				JP1.removeAll();
		 		JP1.add(jtree,BorderLayout.WEST);
		 		JP1.validate();
		 		repaint();
			}
		});
         
         JB5.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				JB3.setIcon(new ImageIcon("Image2/2_1_1.jpg"));
 				JB4.setIcon(new ImageIcon("Image2/2_2_1.jpg"));
 				JB5.setIcon(new ImageIcon("Image2/2_3.jpg"));
 				JB6.setIcon(new ImageIcon("Image2/2_4_1.jpg"));
 				JB7.setIcon(new ImageIcon("Image2/2_5_1.jpg"));
 				
 				JP1.removeAll();
 		 		JP1.add(JL1);
 		 		JP1.validate();//是JP1有效化
 		 		repaint();
 			}
 		});
         
         JB6.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				JB3.setIcon(new ImageIcon("Image2/2_1_1.jpg"));
 				JB4.setIcon(new ImageIcon("Image2/2_2_1.jpg"));
 				JB5.setIcon(new ImageIcon("Image2/2_3_1.jpg"));
 				JB6.setIcon(new ImageIcon("Image2/2_4.jpg"));
 				JB7.setIcon(new ImageIcon("Image2/2_5_1.jpg"));
 				
 				JTree jtree = Group_Tree.jGroupTree(user.getName());
				JScrollPane sp = new JScrollPane(jtree);
				
				//sp.setSize(276,  433);
				//sp.setBounds(0, 203, 276, 433);
				//sp.setBorder(BorderFactory.createEmptyBorder());//去边框
				sp.setOpaque(false);
				sp.getViewport().setOpaque(false);//透明化
				JP1.removeAll();
		 		JP1.add(jtree,BorderLayout.WEST);
		 		JP1.validate();
		 		repaint();
 			}
 		});
         
         JB7.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				JB3.setIcon(new ImageIcon("Image2/2_1_1.jpg"));
 				JB4.setIcon(new ImageIcon("Image2/2_2_1.jpg"));
 				JB5.setIcon(new ImageIcon("Image2/2_3_1.jpg"));
 				JB6.setIcon(new ImageIcon("Image2/2_4_1.jpg"));
 				JB7.setIcon(new ImageIcon("Image2/2_5.jpg"));
 				
 				JP1.removeAll();
 		 		JP1.add(JL1);
 		 		JP1.validate();//是JP1有效化
 		 		repaint();
 			}
 		});
 		
 		JLabel JLL = new JLabel();
 		JLabel JLR = new JLabel(user.getName());
 		JLL.setIcon(new ImageIcon(user.getAdr()));
 		JLR.setFont(new Font("宋体", 0, 18));
 		JLR.setForeground(Color.WHITE);
 		JLL.setBounds(2, 35, 53 ,53);
 		JLR.setBounds(57, 35, 150, 20);
 		CP.add(JLL);
 		CP.add(JLR);
 		
 		
		MouseOperate mo = new MouseOperate(); 
		CP.addMouseListener(mo); 
		CP.addMouseMotionListener(mo);
		setUndecorated(true);
		setLocation(800, 0);
		setSize(275, 695);
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

