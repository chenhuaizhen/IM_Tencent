package Tools;

import java.util.*;
public class ManageClientConServerThread {

	private static HashMap hm=new HashMap<String, ClientConServerThread>();
	
	//�Ѵ����õ�ClientConServerThread���뵽hm
	public static void addClientConServerThread(String name,ClientConServerThread ccst)
	{
		hm.put(name, ccst);
	}
	
	//����ͨ��qqIdȡ�ø��߳� 
	public static ClientConServerThread getClientConServerThread(String name)
	{
		return (ClientConServerThread)hm.get(name);
	}
}
