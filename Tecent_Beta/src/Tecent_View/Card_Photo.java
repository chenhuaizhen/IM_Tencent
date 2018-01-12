package Tecent_View;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import Common.*;

public class Card_Photo {

	public Card_Photo(final TheUser user,final JButton JB){
	final JFrame Frame = new JFrame("选择头像");
	Container CP = Frame.getContentPane();
	JButton JB1 = new JButton(new ImageIcon("Photo/0_1.jpg"));
	JB1.setRolloverIcon(new ImageIcon("Photo/0_1_1.jpg"));  
	JB1.setPressedIcon(new ImageIcon("Photo/0_1_2.jpg"));  
	JB1.setPreferredSize(new Dimension(86, 86));
	JB1.setBorderPainted(false); 
	JB1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
	JButton JB2 = new JButton(new ImageIcon("Photo/0_2.jpg"));
	JB2.setRolloverIcon(new ImageIcon("Photo/0_2_1.jpg"));  
	JB2.setPressedIcon(new ImageIcon("Photo/0_2_2.jpg"));  
	JB2.setPreferredSize(new Dimension(86, 86));
	JB2.setBorderPainted(false); 
	JB2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
	JButton JB3 = new JButton(new ImageIcon("Photo/0_3.jpg"));
	JB3.setRolloverIcon(new ImageIcon("Photo/0_3_1.jpg"));  
	JB3.setPressedIcon(new ImageIcon("Photo/0_3_2.jpg"));  
	JB3.setPreferredSize(new Dimension(86, 86));
	JB3.setBorderPainted(false); 
	JB3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
	JButton JB4 = new JButton(new ImageIcon("Photo/0_4.jpg"));
	JB4.setRolloverIcon(new ImageIcon("Photo/0_4_1.jpg"));  
	JB4.setPressedIcon(new ImageIcon("Photo/0_4_2.jpg"));  
	JB4.setPreferredSize(new Dimension(86, 86));
	JB4.setBorderPainted(false); 
	JB4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
	JButton JB5 = new JButton(new ImageIcon("Photo/0_5.jpg"));
	JB5.setRolloverIcon(new ImageIcon("Photo/0_5_1.jpg"));  
	JB5.setPressedIcon(new ImageIcon("Photo/0_5_2.jpg"));  
	JB5.setPreferredSize(new Dimension(86, 86));
	JB5.setBorderPainted(false); 
	JB5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
    JButton JB6 = new JButton(new ImageIcon("Photo/5.jpg"));
	JB6.setRolloverIcon(new ImageIcon("Photo/5_0.jpg"));  
	JB6.setPressedIcon(new ImageIcon("Photo/5_0_1.jpg"));  
	JB6.setPreferredSize(new Dimension(86, 86));
	JB6.setBorderPainted(false); 
	JB6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	

	JB1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			user.setAdr("Image2/0_3.png");
			Frame.setVisible(false);
			JB.setIcon(new ImageIcon("Photo/0_1.jpg"));
			JB.setRolloverIcon(new ImageIcon("Photo/0_1_1.jpg"));  
			JB.setPressedIcon(new ImageIcon("Photo/0_1_2.jpg"));  
			JB.setPreferredSize(new Dimension(86, 86));
			JB.setBorderPainted(false); 
			JB.setToolTipText("更换头像");
			JB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     		JB.setBounds(43, 191, 86, 86);
		}
	});
	
    JB2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			user.setAdr("Image2/0_4.png");
			Frame.setVisible(false);
			JB.setIcon(new ImageIcon("Photo/0_2.jpg"));
			JB.setRolloverIcon(new ImageIcon("Photo/0_2_1.jpg"));  
			JB.setPressedIcon(new ImageIcon("Photo/0_2_2.jpg"));  
			JB.setPreferredSize(new Dimension(86, 86));
			JB.setBorderPainted(false); 
			JB.setToolTipText("更换头像");
			JB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     		JB.setBounds(43, 191, 86, 86);
		}
	});
    
    JB3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			user.setAdr("Image2/0_5.png");
			Frame.setVisible(false);
			JB.setIcon(new ImageIcon("Photo/0_3.jpg"));
			JB.setRolloverIcon(new ImageIcon("Photo/0_3_1.jpg"));  
			JB.setPressedIcon(new ImageIcon("Photo/0_3_2.jpg")); 
			JB.setPreferredSize(new Dimension(86, 86));
			JB.setBorderPainted(false); 
			JB.setToolTipText("更换头像");
			JB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     		JB.setBounds(43, 191, 86, 86);
		}
	});
    
    JB4.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			user.setAdr("Image2/0_6.png");
			Frame.setVisible(false);
			JB.setIcon(new ImageIcon("Photo/0_4.jpg"));
			JB.setRolloverIcon(new ImageIcon("Photo/0_4_1.jpg"));  
			JB.setPressedIcon(new ImageIcon("Photo/0_4_2.jpg"));  
			JB.setPreferredSize(new Dimension(86, 86));
			JB.setBorderPainted(false); 
			JB.setToolTipText("更换头像");
			JB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     		JB.setBounds(43, 191, 86, 86);
		}
	});
    
    JB5.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			user.setAdr("Image2/0_7.png");
			Frame.setVisible(false);
			JB.setIcon(new ImageIcon("Photo/0_5.jpg"));
			JB.setRolloverIcon(new ImageIcon("Photo/0_5_1.jpg"));  
			JB.setPressedIcon(new ImageIcon("Photo/0_5_2.jpg")); 
			JB.setPreferredSize(new Dimension(86, 86));
			JB.setBorderPainted(false); 
			JB.setToolTipText("更换头像");
			JB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     		JB.setBounds(43, 191, 86, 86);
		}
	});
    
     JB6.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			user.setAdr("Image2/0_2.png");
			Frame.setVisible(false);
			JB.setIcon(new ImageIcon("Photo/5.jpg"));
			JB.setRolloverIcon(new ImageIcon("Photo/5_0.jpg"));  
			JB.setPressedIcon(new ImageIcon("Photo/5_0_1.jpg")); 
			JB.setPreferredSize(new Dimension(86, 86));
			JB.setBorderPainted(false); 
			JB.setToolTipText("更换头像");
			JB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     		JB.setBounds(43, 191, 86, 86);
			
		}
	});
    //设置Frame的布局为GridLayout，4行3列间距为5
	CP.setLayout(new GridLayout(2,3,5,5));
	CP.add(JB1);
	CP.add(JB2);
	CP.add(JB3);
	CP.add(JB4);
	CP.add(JB5);
	CP.add(JB6);
	Frame.setLocation(497, 242);
	Frame.setSize(290,223);
	Frame.setVisible(true);

  }
}