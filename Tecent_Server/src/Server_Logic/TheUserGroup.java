package Server_Logic;

import java.util.HashMap;
import java.util.Map;

import Common.*;

public class TheUserGroup {
    private TheUserGroup(){ 
    }
    
    private static TheUserGroup theUserGroup = new TheUserGroup();
    
    public static TheUserGroup theusergroup(){
    	return theUserGroup;
    }
    
    private static Map<String,TheUser> users = new HashMap<String,TheUser>();
    
    public Map<String, TheUser> getUsers() {
		return users;
	}

	public void addUser(String name,String password){
    	users.put(name,new TheUser(name,password));
    	}
    
    public boolean compare(TheUser user){
    	String username = user.getName();
    	String password  = user.getPassword();
    	TheUser oldUser = users.get(username);
    	if(oldUser==null){
    		return false;
    	}else {
    		if(password.equals(oldUser.getPassword()))
    			return true;
    		else {
    			return false;
    		}
    	}
    }

    
}
