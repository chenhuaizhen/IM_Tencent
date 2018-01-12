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
		//把服务器和该客户端的连接赋给s
		this.s=s;
		this.name = name;
	}
	
	//让该线程去通知其它用户
	public void notifyOther()
	{
		//得到所有在线的人的线程
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
			
			//这里该线程就可以接收客户端的信息.
			try {
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
	
				//对从客户端取得的消息进行类型判断，然后做相应的处理
				if(m.getMessage().equals(MessageType.message_comm_mes))
				{
					if(!TheOnlineGroup.isInOnlineGroup(m.getGetter())){
						ObjectOutputStream oos=new ObjectOutputStream(this.s.getOutputStream());
						String sender = m.getSender();
						m.setSender(m.getGetter());
						m.setGetter(sender);
						m.setContain("该用户已经下线，目前该软件还不支持离线信息\n");
						oos.writeObject(m);
					}else{
					//取得接收人的通信线程
					ServerThread st=TheThreadGroup.find(m.getGetter());
					ObjectOutputStream oos=new ObjectOutputStream(st.s.getOutputStream());
					oos.writeObject(m);}
				}else if(m.getMessage().equals(MessageType.message_get_onLineFriend))
				{
					//把在服务器的好友给该客户端返回.
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
					//取得接收人的通信线程
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
						m.setContain("该用户已经下线，目前该软件还不支持离线信息\n");
						oos.writeObject(m);
					}else{
						//取得接收人的通信线程
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
					   t.append("用户："+stuKey+'\n');
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
