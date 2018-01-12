package Server_Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Set;

import Server_View.Server_Win;
import Common.*;

public class ServerThread implements Runnable {
    
public Socket s;
String name;
File f = null;
FileOutputStream fout = null;
	public ServerThread(Socket s,String name)
	{
		//�ѷ������͸ÿͻ��˵����Ӹ���s
		this.s=s;
		this.name = name;
	}
	
	//�ø��߳�ȥ֪ͨ�����û�
	public void notifyOther()
	{
		//�õ��������ߵ��˵��߳�
		Set<String> keySet = TheOnlineGroup.getOnlineGroup().keySet();
		if(TheOnlineGroup.getOnlineGroup().size()!=0){
		   for(String stuKey:keySet){
			   if(stuKey!=null){
	        Message m=new Message();
			m.setContain(TheOnlineGroup.theOnlineUsers());
			m.setMessage(MessageType.message_ret_onLineFriend);
			try {
				ObjectOutputStream oos=new ObjectOutputStream(
						TheThreadGroup.find(stuKey).s.getOutputStream());
				m.setGetter(stuKey);
				oos.writeObject(m);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		   }
		  }
		}
	}
	
	public void run()
	{
		boolean keeprunning = true;
		while(keeprunning)
		{
			
			//������߳̾Ϳ��Խ��տͻ��˵���Ϣ.
			try {
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
	
				//�Դӿͻ���ȡ�õ���Ϣ���������жϣ�Ȼ������Ӧ�Ĵ���
				if(m.getMessage().equals(MessageType.message_comm_mes))
				{
					if(!TheOnlineGroup.isInOnlineGroup(m.getGetter())){
						ObjectOutputStream oos=new ObjectOutputStream(this.s.getOutputStream());
						String sender = m.getSender();
						m.setSender(m.getGetter());
						m.setGetter(sender);
						m.setContain("���û��Ѿ����ߣ�Ŀǰ���������֧��������Ϣ\n");
						oos.writeObject(m);
					}else{
					//ȡ�ý����˵�ͨ���߳�
					ServerThread st=TheThreadGroup.find(m.getGetter());
					ObjectOutputStream oos=new ObjectOutputStream(st.s.getOutputStream());
					oos.writeObject(m);}
				}else if(m.getMessage().equals(MessageType.message_get_onLineFriend))
				{
					//���ڷ������ĺ��Ѹ��ÿͻ��˷���.
					String res=TheOnlineGroup.theOnlineUsers();
					Message m2=new Message();
					m2.setMessage(MessageType.message_ret_onLineFriend);
					m2.setContain(res);
					m2.setGetter(m.getSender());
					ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(m2);
				}else if(m.getMessage().equals(MessageType.message_group_mes))
				{
					Set<String> keySet = TheOnlineGroup.getOnlineGroup().keySet();
					if(TheOnlineGroup.getOnlineGroup().size()!=0){
					   for(String stuKey:keySet){
						   if(!m.getSender().equals(stuKey)){
					//ȡ�ý����˵�ͨ���߳�
					ServerThread st=TheThreadGroup.find(stuKey);
					ObjectOutputStream oos=new ObjectOutputStream(st.s.getOutputStream());
					oos.writeObject(m);
						   }
					   }
					}
				}else if(m.getMessage().equals(MessageType.message_document)){
					if(!TheOnlineGroup.isInOnlineGroup(m.getGetter())){
						ObjectOutputStream oos=new ObjectOutputStream(this.s.getOutputStream());
						String sender = m.getSender();
						m.setSender(m.getGetter());
						m.setGetter(sender);
						m.setContain("���û��Ѿ����ߣ�Ŀǰ���������֧��������Ϣ\n");
						oos.writeObject(m);
					}else{
						//ȡ�ý����˵�ͨ���߳�
						ServerThread st=TheThreadGroup.find(m.getGetter());
						ObjectOutputStream oos=new ObjectOutputStream(st.s.getOutputStream());
						oos.writeObject(m);
						String filename[] = m.getContain().split(",");
						try{
							if(f==null||!f.getName().equals(filename[0])){
								f =new File("F:\\server\\"+filename[0]);
								if(f.exists()){
									f.delete();
									f=new File("F:\\server\\"+filename[0]);
								}
								fout =new FileOutputStream(f);
							}
							fout.write(m.getBuf());
							if(Long.parseLong(filename[1])<=4096){
								fout.close();
								f = null;
							}
						}catch(IOException e){
							e.printStackTrace();
						}
					}
				}
			} catch (SocketException e1) {
				TheOnlineGroup.deleteOnlineGroup(name);
				notifyOther();
				Set<String> keySet = TheOnlineGroup.getOnlineGroup().keySet();
				if(TheOnlineGroup.getOnlineGroup().size()!=0){
				StringBuffer t = new StringBuffer();
				   for(String stuKey:keySet){
					   if(stuKey!=null){
					   t.append("�û���"+stuKey+'\n');
					   }
				   }
				   
				   String ss =new String(t);   
				   Server_Win.centerL.setText(ss);
				  
				}else  Server_Win.centerL.setText("");
				try {
					s.close();
					keeprunning = false;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			
		}
		
		
	}


}
