package Tools;


import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

import Tecent_View.Communicate_Win;
import Common.*;
import Tecent_View.*;

public class ClientConServerThread extends Thread {

	private Socket s;
	private String owner;
	File file = null;
	FileOutputStream fout = null;
	
	//构造函数
	public ClientConServerThread(String owner,Socket s)
	{
		this.s=s;
		this.owner=owner;
	}
	
	public void run()
	{
		boolean keeprunning = true;
		while(keeprunning)
		{
			//不停的读取从服务器端发来的消息
			try {
				
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();

				
				if(m.getMessage().equals(MessageType.message_comm_mes))
				{
				    if(ManageCommunicate_Win.Judge(m.getGetter(),m.getSender())){
				    	Communicate_Win com = new Communicate_Win(
				    			m.getPhoto_adr(),m.getSender(),m.getGetter());
				    	com.JT1.append(m.getSendTime()+"\n"+m.getSender()+" : "+m.getContain()+"\n");
				    	ManageCommunicate_Win.addCommunicate(m.getGetter(),m.getSender(), com);
				    }else{
				    	Communicate_Win c_w = 
				    			(Communicate_Win)ManageCommunicate_Win.getCommunicate_Win(m.getGetter(),m.getSender());
				    	c_w.onTop();
				    	c_w.JT1.append(
				    			m.getSendTime()+"\n"+m.getSender()+" : "+m.getContain()+"\n");
				    }

				}else if(m.getMessage().equals(MessageType.message_ret_onLineFriend))
				{
					Friend_Photo.clear();
					Tree.clear();
					String []name_photo = m.getContain().split("\n");
					for (String string : name_photo) {
						if(string!=null){
							String []name = string.split(" ");
							Tree.change_photo(name[0],name[1]);
							Friend_Photo.add_photo(name[1], name[0]);
						}
					}	
						if(!ManageCommunicate_Win.Judge(owner,"Communicate_Group")){
							Group_Communicate_Win.fresh_line();
						}
				}else if(m.getMessage().equals(MessageType.message_group_mes))
				{
				    if(ManageCommunicate_Win.Judge(owner,"Communicate_Group")){
				    	Group_Communicate_Win com = new Group_Communicate_Win(owner);
				    	Group_Communicate_Win.fresh_line();
				    	com.JT1.append(m.getSendTime()+"\n"+m.getSender()+" : "+m.getContain()+"\n");
				    	ManageCommunicate_Win.addGroupCommunicate(owner,"Communicate_Group", com);
				    }else{
				    	Group_Communicate_Win g_c_w =
				    			(Group_Communicate_Win)ManageCommunicate_Win.getCommunicate_Win(owner,"Communicate_Group");
				    			g_c_w.onTop();
				    			g_c_w.JT1.append(
				    			m.getSendTime()+"\n"+m.getSender()+" : "+m.getContain()+"\n");
				    }

				}else if(m.getMessage().equals(MessageType.message_document))
				{
			    	String filename[] = m.getContain().split(",");
					try{
						if(file==null||!file.getName().equals(filename[0])){
							file = new File("F:\\"+filename[0]);
							if(file.exists()){
								file.delete();
								file = new File("F:\\"+filename[0]);
							}
							fout =new FileOutputStream(file);
						}
						fout.write(m.getBuf());
						if(Long.parseLong(filename[1])<=4096){
							fout.close();
							file = null;
							if(ManageCommunicate_Win.Judge(m.getGetter(),m.getSender())){
						    	Communicate_Win com = new Communicate_Win(
						    			m.getPhoto_adr(),m.getSender(),m.getGetter());
						    	com.JT1.append(m.getSendTime()+"\n"+m.getSender()+" : 收到了文件，其名为"+filename[0]+"\n");
						    	ManageCommunicate_Win.addCommunicate(m.getGetter(),m.getSender(), com);
						    }else{
						    	Communicate_Win c_w = 
						    			(Communicate_Win)ManageCommunicate_Win.getCommunicate_Win(m.getGetter(),m.getSender());
						    	c_w.onTop();
						    	c_w.JT1.append(
						    			m.getSendTime()+"\n"+m.getSender()+" :收到了文件，其名为 "+filename[0]+"\n");
						    }
						}
					}catch(IOException e){
						e.printStackTrace();
					}
				}
			}catch(EOFException e){
				try {
					s.close();
					keeprunning = false;
					new Offline();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} 
			catch (SocketException e1) {
				try {
					s.close();
					keeprunning = false;
					new Offline_2();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}

	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}
	
}
