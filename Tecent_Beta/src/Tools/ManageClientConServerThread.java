package Tools;

import java.util.*;
public class ManageClientConServerThread {

	private static HashMap hm=new HashMap<String, ClientConServerThread>();
	
	//把创建好的ClientConServerThread放入到hm
	public static void addClientConServerThread(String name,ClientConServerThread ccst)
	{
		hm.put(name, ccst);
	}
	
	//可以通过qqId取得该线程 
	public static ClientConServerThread getClientConServerThread(String name)
	{
		return (ClientConServerThread)hm.get(name);
	}
}
