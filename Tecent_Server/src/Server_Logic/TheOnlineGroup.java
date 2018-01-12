package Server_Logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class TheOnlineGroup {

	    public static Map<String, String> getOnlineGroup() {
			return onlineGroup;
		}

		private static Map<String,String> onlineGroup = new HashMap<String, String>();
	    
	    public static void addOnlineGroup(String name,String adr){
	        onlineGroup.put(name, adr);
	    }
	    
	    public static void deleteOnlineGroup(String name){
	        onlineGroup.remove(name);
	    }
	    
	    public static String findOnlineGroup(String name){
	    	return onlineGroup.get(name);
	    }
	    
	    public static boolean isInOnlineGroup(String name){
	    	if(onlineGroup.get(name)==null)
	    		return false;
	    	else return true;
	    }
	    
	    public static String theOnlineUsers(){
	    	Set<String> keySet = onlineGroup.keySet();
			if(onlineGroup.size()!=0){
			StringBuffer t = new StringBuffer();
			   for(String stuKey:keySet){
				   if(stuKey!=null){
				   t.append(stuKey+" "+onlineGroup.get(stuKey)+"\n");
				   }
			   }
			   
			   String s =new String(t);
			   return s;
	    }else return "\n";
			
    }
}
