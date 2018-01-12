package Common;

import java.io.Serializable;

public class TheUser implements Serializable{

	private String name;

	private String password;

	private String adr="image2/0_2.png";
	
	public TheUser(){}
	
	public TheUser(String name,String password){
		this.name = name;
		this.password = password;
	}
	
	
	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
