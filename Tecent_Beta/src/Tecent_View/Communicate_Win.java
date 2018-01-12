package Tecent_View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputAdapter;

import Common.*;
import Tools.*;


public class Communicate_Win extends JFrame{
     
	
	public void onTop(){
		toFront();
	}
	 public MyTextArea JT1;
	 public Communicate_Win(String adr,final String name,final String owner) {
	    	super();
	    	ImageIcon image = new ImageIcon("Image3/15.jpg");  
		    JLabel background = new JLabel(image); 
		    background.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  
		    getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));  
		    JPanel contentPanel = (JPanel)getContentPane();  
		    contentPanel.setOpaque(false);  
	    	
			Container CP = getContentPane(); 
			CP.setLayout(null);
			
			JButton JB1 = new JButton(new ImageIcon("Image3/15_1.jpg"));
			JB1.setRolloverIcon(new ImageIcon("Image3/15_1_1.jpg"));  
			JB1.setPressedIcon(new ImageIcon("Image3/15_1_2.jpg"));  
			JB1.setPreferredSize(new Dimension(70, 24));
			JB1.setBorderPainted(false); 

			JButton JB2 = new JButton(new ImageIcon("Image3/15_2.jpg"));
			JB2.setRolloverIcon(new ImageIcon("Image3/15_2_1.jpg"));  
			JB2.setPressedIcon(new ImageIcon("Image3/15_2_2.jpg"));  
			JB2.setPreferredSize(new Dimension(62, 24));
			JB2.setBorderPainted(false);  

			JButton JB3 = new JButton(new ImageIcon("Image3/15_3.jpg"));
			JB3.setRolloverIcon(new ImageIcon("Image3/15_3_1.jpg"));  
			JB3.setPressedIcon(new ImageIcon("Image3/15_3_2.jpg"));  
			JB3.setPreferredSize(new Dimension(29, 29));
			JB3.setBorderPainted(false);  
			JB3.setToolTipText("关闭");
			
			JButton JB4 = new JButton(new ImageIcon("Image3/15_4.jpg"));
			JB4.setRolloverIcon(new ImageIcon("Image3/15_4_1.jpg"));  
			JB4.setPressedIcon(new ImageIcon("Image3/15_4_2.jpg"));  
			JB4.setPreferredSize(new Dimension(29, 29));
			JB4.setBorderPainted(false);  
			JB4.setToolTipText("最大化");
			
			JButton JB5 = new JButton(new ImageIcon("Image3/15_5.jpg"));
			JB5.setRolloverIcon(new ImageIcon("Image3/15_5_1.jpg"));  
			JB5.setPressedIcon(new ImageIcon("Image3/15_5_2.jpg"));  
			JB5.setPreferredSize(new Dimension(29, 29));
			JB5.setBorderPainted(false);  
			JB5.setToolTipText("最小化");
			
			JB3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					ManageCommunicate_Win.deleteCommunicates(owner,name);
				}
			});
            
			JB5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setExtendedState(JFrame.ICONIFIED);
				}
			});
			
            JB1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					ManageCommunicate_Win.deleteCommunicates(owner,name);
				}
			});
			
            
			JT1 = new MyTextArea();
	    	JT1.owner=owner;
	    	JT1.name=name;
			JT1.setEditable(false);//默认为可修改的编辑框
			final JTextArea JT2 = new JTextArea();
			JT1.setOpaque(false);
			JT2.setOpaque(false);//透明化
			JT1.setLineWrap(true);//自动换行
			JScrollPane jsp1=new JScrollPane(JT1);//出现滚轴	
			JT2.setLineWrap(true);//自动换行
			JScrollPane jsp2=new JScrollPane(JT2);//出现滚轴	
			jsp1.setBorder(BorderFactory.createEmptyBorder());//去边框
			jsp2.setBorder(BorderFactory.createEmptyBorder());
			jsp1.setOpaque(false);
			jsp1.getViewport().setOpaque(false);//透明化
			jsp2.setOpaque(false);
			jsp2.getViewport().setOpaque(false);
			JB1.setBounds(279, 474, 70, 24);
			JB2.setBounds(353, 474, 62, 24);
			JB3.setBounds(550, 0, 29, 29);
			JB4.setBounds(521, 0, 29, 29);
			JB5.setBounds(492, 0, 29, 29);
			jsp1.setBounds(3, 80, 440, 288);
			jsp2.setBounds(3, 402, 440, 67);
			CP.add(jsp2);
			CP.add(jsp1);
			CP.add(JB1);
			CP.add(JB2);
			CP.add(JB3);
			CP.add(JB4);
			CP.add(JB5);
			
			JT2.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {


					if(e.getKeyChar() == KeyEvent.VK_ENTER){
						Date date = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						String d = sdf.format(date);
					    JT1.append(d+":\n"+owner+" : "+JT2.getText()+"\n");					  
					    Message m=new Message();
						m.setMessage(MessageType.message_comm_mes);
						m.setSender(owner);
						m.setGetter(name);
						m.setPhoto_adr(Friend_Photo.find_Photo(owner));
						m.setContain(JT2.getText());
						m.setSendTime(d);
						JT2.setText("");
						//发送给服务器.
						try {
							ObjectOutputStream oos=new ObjectOutputStream
							(ManageClientConServerThread.getClientConServerThread(
									owner).getS().getOutputStream());
							oos.writeObject(m);
						} catch (Exception e1) {
							e1.printStackTrace();
							// TODO: handle exception
						}
					}
				
					
				
				}
				
				@Override
				public void keyReleased(KeyEvent e) {}
				
				@Override
				public void keyPressed(KeyEvent e) {}
			});
			
			 JB2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Date date = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						String d = sdf.format(date);
					    JT1.append(d+":\n"+owner+" : "+JT2.getText()+"\n"+"\n");					  
					    Message m=new Message();
						m.setMessage(MessageType.message_comm_mes);
						m.setSender(owner);
						m.setGetter(name);
						m.setPhoto_adr(Friend_Photo.find_Photo(owner));
						m.setContain(JT2.getText()+"\n");
						m.setSendTime(d);
						JT2.setText("");
						//发送给服务器.
						try {
							ObjectOutputStream oos=new ObjectOutputStream
							(ManageClientConServerThread.getClientConServerThread(
									owner).getS().getOutputStream());
							oos.writeObject(m);
						} catch (Exception e1) {
							e1.printStackTrace();
							// TODO: handle exception
						}
					}
				});
			 
			
		    JLabel JL1 = new JLabel(new ImageIcon(adr));
			JL1.setBounds(6, 2, 42, 42);  
			JL1.addMouseListener(new showMes(name));
			CP.add(JL1);
			JLabel JL2 = new JLabel(name);
			JL2.setFont(new Font("宋体", 0, 18));
			JL2.setBounds(54, 3, 150, 20);
			CP.add(JL2);
			
			MouseOperate mo = new MouseOperate(); 
			CP.addMouseListener(mo); 
			CP.addMouseMotionListener(mo);
			setUndecorated(true);
			setLocation(300, 100);
			setSize(579, 504);
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

