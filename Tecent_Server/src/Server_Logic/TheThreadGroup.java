package Server_Logic;

import java.util.HashMap;
import java.util.Map;

public class TheThreadGroup {
      
	private static Map<String,ServerThread> threadGroup = new HashMap<String,ServerThread>();
	

	public static void add(String name,ServerThread thread){
		threadGroup.put(name, thread);
	}
	
	public static void delete(String name){
		threadGroup.remove(name);
	}
	
	public static ServerThread find(String name){
		return threadGroup.get(name);
	}
}
