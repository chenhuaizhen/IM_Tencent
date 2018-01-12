package Tecent_View;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextArea;

import Common.Message;
import Common.MessageType;
import Tools.Friend_Photo;
import Tools.ManageClientConServerThread;

public class MyTextArea extends JTextArea implements DropTargetListener{
    public String owner,name;
	public MyTextArea(){
        new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
    }
    public void dragEnter(DropTargetDragEvent dtde) {
    }

    public void dragOver(DropTargetDragEvent dtde) {
    }

    public void dropActionChanged(DropTargetDragEvent dtde) {
    }

    public void dragExit(DropTargetEvent dte) {
    }

    public void drop(DropTargetDropEvent dtde) {
        try {
            Transferable tr = dtde.getTransferable();

            if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                List list = (List) (dtde.getTransferable()
                        .getTransferData(DataFlavor.javaFileListFlavor));
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    File f = (File) iterator.next();
                    this.append("发送文件："+f.getName()+"\n");
                    Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					String d = sdf.format(date);
					long length = f.length();
					FileInputStream fin=new FileInputStream(f);
					int count=0;
					byte[] buf=new byte[4096];
					while((count=fin.read(buf))>0){
	                    Message m=new Message();
						m.setMessage(MessageType.message_document);
						m.setSender(owner);
						m.setGetter(name);
						m.setPhoto_adr(Friend_Photo.find_Photo(owner));
						m.setContain(f.getName()+","+length);
						m.setSendTime(d);
						m.setBuf(buf);
						//发送给服务器.
						try {
							ObjectOutputStream oos=new ObjectOutputStream
							(ManageClientConServerThread.getClientConServerThread(
									owner).getS().getOutputStream());
							oos.writeObject(m);
						} catch (Exception e1) {
							e1.printStackTrace();
							// TODO: handle exception
						}
						length -= 4096;
					}
					fin.close();
                }
                dtde.dropComplete(true);
                this.updateUI();
            }else {
                dtde.rejectDrop();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        }
    }
    
}
