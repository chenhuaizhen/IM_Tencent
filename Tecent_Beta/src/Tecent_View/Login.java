package Tecent_View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;

import Tecent_Logic.ClientUser;
import Tools.ManageClientConServerThread;
import Common.*;


public	class Login extends JFrame {
	
	    public Login(final String IP) {
	    	super();
	    	ImageIcon image = new ImageIcon("Image/background_blue.jpg");  
		    JLabel background = new JLabel(image);   
		    background.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  
		    getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));  
		    JPanel contentPanel = (JPanel)getContentPane();  
		    contentPanel.setOpaque(false);  
		    final TheUser user = new TheUser();
		    final Wait_Win waiting =new Wait_Win();
		    
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
			JLabel JL1 = new JLabel(new ImageIcon("Image/14.jpg"));
			JLabel JL2 = new JLabel(new ImageIcon("Image/13.jpg"));
			JP1.add(JL2);
			JP1.add(JB1);
			JP1.add(JB2);
			CP.add(JP1);
			CP.add(JL1);
			JP1.setBounds(0, 0, 430, 31);
			JL1.setBounds(0, 31, 430, 151);  
			
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
			
			JPanel JP2 = new JPanel();
			JP2.setLayout(new BorderLayout());
			
		
			JLabel JL3 = new JLabel(new ImageIcon("Image/10.jpg"));
			JL3.setBounds(0, 182, 141, 149);  
			
			
			JButton JB3 = new JButton(new ImageIcon("Image/9.jpg"));
			JB3.setBounds(141, 292, 194, 31);
			JB3.setRolloverIcon(new ImageIcon("Image/9_1.jpg"));  
			JB3.setPressedIcon(new ImageIcon("Image/9_2.jpg"));  
			JB3.setPreferredSize(new Dimension(194, 31));
			JB3.setBorderPainted(false);  
			
			
			final JTextField JT1 = new JTextField("用户名");
			final JPasswordField JT2 = new JPasswordField("密码");
			JT2.setEchoChar('\0');
			JT1.setBounds(141,194,192,30);
			JT2.setBounds(141,225,192,30);
			LineBorder lin = new LineBorder(Color.WHITE,3,true);  
		    JT1.setBorder(lin);  
		    JT2.setBorder(lin);  
            JT1.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					JT1.setBorder(new LineBorder(Color.WHITE,3,true)); 
					if(JT1.getText().equals("")){
						JT1.setText("用户名");
					}
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
				    JT1.setBorder(new LineBorder(Color.gray,1,true)); 
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					JT1.setText("");
					
				}
			});
			 
                JT2.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					JT2.setBorder(new LineBorder(Color.WHITE,3,true));
					if((new String(JT2.getPassword())).equals("")){
						JT2.setText("密码");
						JT2.setEchoChar('\0');
					}
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
				    JT2.setBorder(new LineBorder(Color.gray,1,true)); 
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					JT2.setText("");
					JT2.setEchoChar('*');
				}
			});
                 
            
            JButton JB4 = new JButton(new ImageIcon("Image/7.jpg"));
    		JB4.setBounds(344,194,50,29);
    		JB4.setRolloverIcon(new ImageIcon("Image/7_1.jpg"));  
    		JB4.setPressedIcon(new ImageIcon("Image/7.jpg"));  
    		JB4.setPreferredSize(new Dimension(50, 29));
    		JB4.setBorderPainted(false);  
    		JB4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
    		
    		JButton JB5 = new JButton(new ImageIcon("Image/8.jpg"));
     		JB5.setBounds(344,226,50,29);
     		JB5.setRolloverIcon(new ImageIcon("Image/8_1.jpg"));  
     		JB5.setPressedIcon(new ImageIcon("Image/8.jpg"));  
     		JB5.setPreferredSize(new Dimension(50, 29));
     		JB5.setBorderPainted(false);  
     		JB5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     		
     		final JButton JB6 = new JButton(new ImageIcon("Image/5.jpg"));
			JB6.setRolloverIcon(new ImageIcon("Image/5_0.jpg"));  
			JB6.setPressedIcon(new ImageIcon("Image/5_0_1.jpg"));  
			JB6.setPreferredSize(new Dimension(86, 86));
			JB6.setBorderPainted(false); 
			JB6.setToolTipText("更换头像");
			JB6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     		JB6.setBounds(43, 191, 86, 86);
			CP.add(JB6);
		
			JB6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new Card_Photo(user,JB6);
					repaint();
				}
			});
			
			
			
	        JCheckBox jch1 = new JCheckBox("记住密码");  
	        jch1.setFocusPainted(false); //选中时没有边框  
	        jch1.setFont(new Font("宋体",0,12));//字体  
	        jch1.setBounds(139, 261, 75, 15);  
	        CP.add(jch1);  
	        JCheckBox jch2 = new JCheckBox("自动登录");  
	        jch2.setFocusPainted(false);  
	        jch2.setFont(new Font("宋体",0,12));  
	        jch2.setBounds(267, 261, 75, 15);  
	        CP.add(jch2);  
	        //设置复选框透明  
	        jch1.setOpaque(false);  
	        jch2.setOpaque(false);  
	        
	       JB3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//waiting.waiting();
				
				user.setName(JT1.getText());
				user.setPassword(new String(JT2.getPassword()));
				if(new ClientUser().checkUser(user,IP)){
					//waiting.disposing();
					setVisible(false);
					Tree.name_Icon.put("chen", Tree.chen);
					Tree.name_Icon.put("wang", Tree.wang);
					Tree.name_Icon.put("ou", Tree.ou);
					Tree.name_Icon.put("cheng", Tree.cheng);
					Tree.name_Icon.put("wu", Tree.wu);
					//发送一个要求返回在线好友的请求包.
					ObjectOutputStream oos;
					try {
						oos = new ObjectOutputStream(
								ManageClientConServerThread.getClientConServerThread(
								user.getName()).getS().getOutputStream());
						//做一个Message
						Message m=new Message();
						m.setMessage(MessageType.message_get_onLineFriend);
						//指明我要的是这个qq号的好友情况.
						m.setSender(user.getName());
						oos.writeObject(m);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					new TheUser_Win().open_User_Win(user);					
				}else{
					
					//waiting.disposing();
				}
				
			}
		});
	        
	        CP.add(JB4);
	        CP.add(JB5);
			CP.add(JL3);
			CP.add(JB3);
			CP.add(JT1);
			CP.add(JT2);
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

	