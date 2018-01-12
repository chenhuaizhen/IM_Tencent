package Common;
import java.rmi.*;
import Common.Items;

public interface RMIInterface extends Remote {	
	public Items getItem(String name) 
	      throws java.rmi.RemoteException;
} 