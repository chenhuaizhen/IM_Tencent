package Tecent_View;

import Common.RMIInterface;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class showMes implements MouseListener{

	private String name = "";
	public showMes(String name){
		this.name = name;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
        String registryURL = 
           "rmi://localhost:8800/tencent";  
		try {
			RMIInterface h = (RMIInterface)Naming.lookup(registryURL);
			MesWin mw = new MesWin();
			mw.show(h.getItem(name));
		} catch (MalformedURLException | RemoteException | NotBoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
