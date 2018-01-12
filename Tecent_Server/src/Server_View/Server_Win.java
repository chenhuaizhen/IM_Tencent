package Server_View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Common.*;
import Server_Logic.*;


public class Server_Win {
	public static class Action implements Runnable {
		volatile boolean keeprunning = true;
		public void run(){
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
		    Socket socket = null;
		while(keeprunning){
			
				socket = serverSocket.accept();
				ObjectInputStream ois = new ObjectInputStream(
						socket.getInputStream());//�������л�		
				
				
				TheUser user = (TheUser)(ois.readObject());
				//��ȡ�û�����
				TheUserGroup theUserGroup = TheUserGroup.theusergroup();
				Message m=new Message();
				
				ObjectOutputStream oos=new ObjectOutputStream(
						socket.getOutputStream());
				
				if(theUserGroup.compare(user)){
					if(TheOnlineGroup.isInOnlineGroup(user.getName())){
						TheThreadGroup.find(user.getName()).s.close();
						TheThreadGroup.delete(user.getName());
					}
					
                    //����һ���ɹ���½����Ϣ��
					m.setMessage("1");
					oos.writeObject(m);
					
					//����һ�����߳�
					ServerThread serverThread = new ServerThread(socket,user.getName());
					TheThreadGroup.add(user.getName(), serverThread);
					
					Thread sT = new Thread(serverThread);
			        //�����߳�
					sT.start();
					

					TheOnlineGroup.addOnlineGroup(user.getName(),user.getAdr());
					serverThread.notifyOther();
					
					Set<String> keySet = TheOnlineGroup.getOnlineGroup().keySet();
					if(TheOnlineGroup.getOnlineGroup().size()!=0){
					StringBuffer t = new StringBuffer();
					   for(String stuKey:keySet){
						   if(stuKey!=null){
						   t.append("�û���"+stuKey+'\n');
						   }
					   }
					   
					   String s =new String(t);
					 
					   centerL.setText(s);
					  
					}
				
				}	
				else{
					m.setMessage("2");
					oos.writeObject(m);
					//�ر�Socket
					socket.close();
					}
				}
		}catch (IOException e) {
			
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		}
	}
	
	public static final JTextArea centerL = new JTextArea("��������δ����",20,25);	
	public static void main(String[] args){
		final Action act = new Action();
		final Thread action = new Thread(act);
		final JFrame Frame = new JFrame("������");
		Container CP = Frame.getContentPane();
		JPanel JP  = new JPanel();
		JPanel JP2 = new JPanel();
		JPanel JP3 = new JPanel();
		JPanel JP4 = new JPanel();
		JPanel JP5 = new JPanel();
		JLabel northM = new JLabel();
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
			northM.setText("��������IP��ַΪ��"+address.getHostAddress());
			
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		final JTextArea centerR = new JTextArea(20,25);		
		
		JLabel northL = new JLabel("���߳�Ա"+"     IP��ַΪ��"+address.getHostAddress()+"     ���г�Ա",JLabel.CENTER);
		
		northL.setFont(new   java.awt.Font("Dialog",1,15));
		northL.setForeground(Color.blue);
		
		JButton openB = new JButton("����");
		JButton closeB = new JButton("�ر�");
		JButton addB = new JButton("���ӳ�Ա");
		openB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e1) {
				
			centerL.setText("�������Ѿ�����");
			
		      try{
		         int RMIPortNum = 8800;
		         Registry registry = LocateRegistry.createRegistry(RMIPortNum);
		         RMIClass exportedObj = new RMIClass();
		         String registryURL = "rmi://localhost:8800/tencent";
		         Naming.rebind(registryURL, exportedObj);
		      }catch (Exception e) {
		         System.out.println("Exception in RMIServer.main: " + e);
		      } 
		      
			action.start();
				
			}
		});
		closeB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    
				act.keeprunning =false;
				centerL.setText("�������Ѿ��ر�");
				
			}
		});
		addB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TheUserGroup theUserGroup = TheUserGroup.theusergroup();
				theUserGroup.addUser("chen","12345");
				theUserGroup.addUser("cheng","12345");
				theUserGroup.addUser("ou","12345");
				theUserGroup.addUser("wang","12345");
				theUserGroup.addUser("wu","12345");
				StringBuffer t = new StringBuffer();
				Set<String> keySet =theUserGroup.getUsers().keySet();
				for(String tuserKey:keySet){
						   t.append(tuserKey+'\t'+"�����ǣ�12345"+'\n');
					   }	
				String s =new String(t);
				centerR.setText(s);
				
				
			}
		});
		//����ʱ�����ޣ�����Ϊ����ܻ��޸ĵ��ܶ�ط�����������û�������ʱȡ��
		/*addB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFrame Frame = new JFrame("����û�");
		    	 Container CP = Frame.getContentPane(); //ȡ��Frame������
		    	 final JTextField TF1 = new JTextField(8);
		    	 JLabel JL1 = new JLabel("�û���");
		    	 final JPasswordField TF2 = new JPasswordField(8);
		    	 JLabel JL2 = new JLabel("����");
		    	 JButton B1 = new JButton("���");
		    	B1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						TheUserGroup theUserGroup = TheUserGroup.theusergroup();
						String name =TF1.getText();
						char[] c =TF2.getPassword();
						String password = new String(c);
						theUserGroup.addUser(name,password);
						StringBuffer t = new StringBuffer();
						Set<String> keySet =theUserGroup.getUsers().keySet();
						for(String tuserKey:keySet){
								   t.append(tuserKey+'\n');
							   }	
						String s =new String(t);
						centerR.setText(s);
						Frame.setVisible(false);
						
					}
				});

		    	 CP.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));//ֻ��CEBTER,LEFT,RIGHT��������
		    	 
		    	 CP.add(JL1);
		    	 CP.add(TF1);
		    	 CP.add(JL2);
		    	 CP.add(TF2);
		    	
		    	 CP.add(B1);
		    	
		    	 Frame.setResizable(false);
		    	 Frame.setSize(325, 120);
		    	 Frame.setVisible(true);
		    	 Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});*/
		
		//CP.setLayout(new BorderLayout(5,5));
		
		JP.setLayout(new FlowLayout(FlowLayout.CENTER,80,5));
		JP.add(openB);
		JP.add(closeB);
				
		JP2.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		
		centerL.setEditable(false);//Ĭ��Ϊ���޸ĵı༭��
		centerL.setLineWrap(true);//�Զ�����
		JScrollPane jsp=new JScrollPane(centerL);//���ֹ���	
		centerR.setEditable(false);//Ĭ��Ϊ���޸ĵı༭��
		centerR.setLineWrap(true);//�Զ�����
		JScrollPane jsp2=new JScrollPane(centerR);//���ֹ���
		JP2.add(jsp);
		JP2.add(jsp2);
		
		JP3.setLayout(new FlowLayout(FlowLayout.CENTER,250,5));
		JP3.add(northL,FlowLayout.LEFT);
		
		
		JP4.setLayout(new FlowLayout(FlowLayout.CENTER,90,5));
		JP4.add(addB);
		
		JP5.setLayout(new FlowLayout(FlowLayout.CENTER,0,5));
		JP5.add(JP);
		JP5.add(JP4);
		
	    CP.add(northM,BorderLayout.NORTH);
		CP.add(JP5,BorderLayout.SOUTH);
		CP.add(JP3,BorderLayout.NORTH);
		CP.add(JP2,BorderLayout.CENTER);
		
		
		
		Frame.setResizable(false);
		Frame.setSize(645,490);
		Frame.setVisible(true);
		Frame.setLocation(427, 132);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}