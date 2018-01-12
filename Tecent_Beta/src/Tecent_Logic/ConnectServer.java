package Tecent_Logic;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import Tecent_View.Offline_2;
import Tecent_View.Wrong_Win;
import Tools.*;
import Common.*;

public class ConnectServer {

public  Socket s;
	
	//发送第一次请求
	public boolean sendLoginInfoToServer(Object o,String IP)
	{
		boolean b=false;
		try {
			s=new Socket(IP,8888);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			
			Message ms=(Message)ois.readObject();
			//这里就是验证用户登录的地方
			if(ms.getMessage().equals("1"))
			{
				//就创建一个该qq号和服务器端保持通讯连接得线程
				ClientConServerThread ccst=new ClientConServerThread(((TheUser)o).getName(),s);
				//启动该通讯线程
				ccst.start();
				ManageClientConServerThread.addClientConServerThread
				(((TheUser)o).getName(), ccst);
				b=true;
			}else{
				//关闭Scoket
				s.close();
				new Wrong_Win().wrong();
			}
			
		}catch (SocketException e1) {
			new Offline_2();
		} 
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
		}
		return b;
	}
	
}
