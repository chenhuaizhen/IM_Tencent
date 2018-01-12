package Tools;

import java.util.HashMap;
import java.util.Map;

public class Friend_Photo {

	public static Map<String,String> friend_Photo = new HashMap<String,String>();
	
	public static String find_Photo(String name){
		return friend_Photo.get(name);
	}
	
	public static void add_photo(String adr,String name){
		friend_Photo.put(name, adr);
	}
	
	public static void clear(){
		friend_Photo.clear();
	}
}
