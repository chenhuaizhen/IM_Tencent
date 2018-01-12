package Tecent_View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

import Tools.*;


public class Tree {
	
	public static Map<String,IconNode> name_Icon = new HashMap<String,IconNode>();
	static String space2 = new String("                          ");
	public static IconNode Root = new IconNode(null, null);// ������ڵ�
	public static IconNode chen = new IconNode(new ImageIcon("Image2/0_2_1.png"),"chen"+space2);
	public static IconNode wang = new IconNode(new ImageIcon("Image2/0_2_1.png"),"wang"+space2);
	public static IconNode ou = new IconNode(new ImageIcon("Image2/0_2_1.png"),"ou"+space2);
	public static IconNode cheng = new IconNode(new ImageIcon("Image2/0_2_1.png"),"cheng"+space2);
	public static IconNode wu = new IconNode(new ImageIcon("Image2/0_2_1.png"),"wu"+space2);
	public static void change_photo(String name,String adr){
		 name_Icon.get(name).setIcon(new ImageIcon(adr));
	}
	public static void clear(){
		chen.setIcon(new ImageIcon("Image2/0_2_1.png"));
		wang.setIcon(new ImageIcon("Image2/0_2_1.png"));
		ou.setIcon(new ImageIcon("Image2/0_2_1.png"));
		cheng.setIcon(new ImageIcon("Image2/0_2_1.png"));
		wu.setIcon(new ImageIcon("Image2/0_2_1.png"));
	}
    public static JTree jTree(final String owner){
    	    Root.removeAllChildren();
    	    String space = new String("                             ");
    	    
    		final ImageIcon a = new ImageIcon("image2/2_4.png");
    		final ImageIcon b = new ImageIcon("image2/2_3.png");
    		final IconNode root1 = new IconNode(a,"�ҵ��豸"+space);
    		final IconNode root2 = new IconNode(a,"�ҵĺ���"+space);
    		final IconNode root3 = new IconNode(a,"����"+space+"    ");
    		final IconNode root4 = new IconNode(a,"����"+space+"    ");
    		final IconNode root5 = new IconNode(a,"ͬѧ"+space+"    ");
    		final IconNode root6 = new IconNode(a,"�������"+space);
    		final IconNode root7 = new IconNode(a,"������"+space+"  ");

    		
    		
    		for (String string:name_Icon.keySet()) {
				if(!string.equals(owner)){
					root2.add(name_Icon.get(string));
				}
			}
    	
    		
    		
    		
    		Root.add(root1);// ��������ڵ�
    		Root.add(root2);// ��������ڵ�
    		Root.add(root3);
    		Root.add(root4);
    		Root.add(root5);
    		Root.add(root6);
    		Root.add(root7);

    		final JTree tree  = new JTree(Root);// ������
    		tree.setUI(new MyTreeUI());
    		tree.setCellRenderer(new IconNodeRenderer()); // ���õ�Ԫ������


    		tree.setEditable(false); // �������Ƿ�ɱ༭
    		tree.setRootVisible(false);// �������ĸ��ڵ��Ƿ����
    		tree.setToggleClickCount(1);// ���õ�������չ�����ڵ�
    		//tree.expandRow();//����չ���ڼ���
    		//tree.expandRow(4);
    		// �����¼�

    		tree.addMouseListener(new MouseAdapter() {
    			public void mouseExited(MouseEvent arg0) {
    				//TreePath path = tree.getSelectionPath();// ��ȡѡ�нڵ�·��
    				//IconNode node = (IconNode) path.getLastPathComponent();
    				
    				
    			}
    			
    			public void mouseEntered(MouseEvent arg0) {
    				// TODO Auto-generated method stub
    				
    			}
    		public void mouseClicked(MouseEvent e) {
    			if(e.getClickCount() == 1){
    				TreePath path = tree.getSelectionPath();// ��ȡѡ�нڵ�·��
    				IconNode node = (IconNode) path.getLastPathComponent();
    				if (node == root1){
    					if(root1.getIcon().equals(a)){
    					root1.setIcon(b);
    					tree.expandRow(0);
    					}
    					else {
    						root1.setIcon(a);
    						tree.collapseRow(0);
    					}
    					tree.revalidate();
    					tree.repaint();
    				}else if (node == root2){
    					if(root2.getIcon().equals(a)){
    						root2.setIcon(b);
    						tree.expandRow(1);	
    					}
    						else {
    							root2.setIcon(a);
    							tree.collapseRow(1);
    						}
    					tree.revalidate();
    					tree.repaint();
    				}else if (node == root3){
    					if(root3.getIcon().equals(a)){
    						root3.setIcon(b);
    					}
    						else {
    							root3.setIcon(a);
    						}
    					tree.revalidate();
    					tree.repaint();
    				}else if (node == root4){
    					if(root4.getIcon().equals(a)){
    						root4.setIcon(b);
    					}
    						else {
    							root4.setIcon(a);
    						}
    					tree.revalidate();
    					tree.repaint();
    				}else if (node == root5){
    					if(root5.getIcon().equals(a)){
    						root5.setIcon(b);
    					}
    						else {
    							root5.setIcon(a);
    						}
    					tree.revalidate();
    					tree.repaint();
    				}else if (node == root6){
    					if(root6.getIcon().equals(a)){
    						root6.setIcon(b);
    					}
    						else {
    							root6.setIcon(a);
    						}
    					tree.revalidate();
    					tree.repaint();
    				}else if (node == root7){
    					if(root7.getIcon().equals(a)){
    						root7.setIcon(b);
    					}
    						else {
    							root7.setIcon(a);
    						}
    					tree.revalidate();
    					tree.repaint();
    				}
    				
    			}
    		if (e.getClickCount() == 2)// ˫���ڵ�
    		{
    		TreePath path = tree.getSelectionPath();// ��ȡѡ�нڵ�·��
    		IconNode node = (IconNode) path.getLastPathComponent();// ͨ��·����ָ��ָ��ýڵ�

    		if (node.isLeaf()&&node.getIcon()!=a&&node.getIcon()!=b)// ����ýڵ���Ҷ�ӽڵ�
    		{
    	    String[] name=node.getText().split(" ");
    	    if(Friend_Photo.find_Photo(name[0])==null){
    	    	new Wrong_offline();
    	    }else{
    	    if(ManageCommunicate_Win.Judge(owner,name[0])){
    	    	ManageCommunicate_Win.addCommunicate(
    				owner,name[0],new Communicate_Win(Friend_Photo.find_Photo(name[0]),name[0],owner));  	    	
    	    }else {
    	    	Communicate_Win c_w =
    	    			(Communicate_Win)ManageCommunicate_Win.getCommunicate_Win(owner,name[0]);
    	    	c_w.onTop();
    	    }
    		}
    	    } else// ����Ҷ�ӽڵ�
    		{
    		}

    		}
    		}
    		});
            tree.setOpaque(false);
    		return tree;
    }
}
