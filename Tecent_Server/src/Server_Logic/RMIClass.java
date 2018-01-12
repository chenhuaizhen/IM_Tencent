package Server_Logic;
import java.rmi.*;
import java.rmi.server.*;
import Common.Items;
import Common.RMIInterface;

public class RMIClass  extends UnicastRemoteObject implements RMIInterface {
	  
			public RMIClass() throws RemoteException {
					super( );
			}

			public Items getItem(String name) throws RemoteException {
				ItemsDAO it = new ItemsDAO();
				return it.getItems(name);
			}
} 
