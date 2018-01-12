package Tecent_Logic;

import Common.TheUser;

public class ClientUser {

	public boolean checkUser(TheUser u,String IP)
	{
		return new ConnectServer().sendLoginInfoToServer(u,IP);
	}
}
