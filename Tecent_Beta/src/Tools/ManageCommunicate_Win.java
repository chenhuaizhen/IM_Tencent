package Tools;

import java.util.HashMap;
import java.util.Map;

import Tecent_View.*;

public class ManageCommunicate_Win {

	private static Map<String,Map> HM = new HashMap<String, Map>();
	
	//加入
	public static void addCommunicate(String owner,String friend,Communicate_Win communicate)
	{
		if(HM.get(owner)==null){
			Map<String, Communicate_Win> hm=new HashMap<String, Communicate_Win>();
			hm.put(friend, communicate);
			HM.put(owner, hm);
		}
		else{
			HM.get(owner).put(friend, communicate);
		}
		
	}
	//取出
	public static Object getCommunicate_Win(String owner,String friend )
	{
		return HM.get(owner).get(friend);
	}
	//删除
	public static void deleteCommunicates(String owner , String name){
		HM.get(owner).remove(name);
	}
	//判断
	public static boolean Judge(String owner , String friend){
		if(HM.get(owner)==null)return true;
		if(HM.get(owner).get(friend)==null)
			return true;
		else return false;
	}
	
	//加入
	public static void addGroupCommunicate(String owner,String friend,Group_Communicate_Win communicate)
	{
		if(HM.get(owner)==null){
			Map<String, Group_Communicate_Win> hm=new HashMap<String, Group_Communicate_Win>();
			hm.put(friend, communicate);
			HM.put(owner, hm);
		}
		else{
			HM.get(owner).put(friend, communicate);
		}
	}
	

	
	
}
