package Tecent_View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

import Tools.*;


public class Group_Tree {
	
    public static JTree jGroupTree(final String owner){
    	    String space = new String("                            ");
    		String space2 = new String("                ");
    		IconNode Root = new IconNode(null, null);// ������ڵ�
    		final ImageIcon a = new ImageIcon("image2/2_4.png");
    		final ImageIcon b = new ImageIcon("image2/2_3.png");
    		final IconNode root1 = new IconNode(a,"������"+space);
    		IconNode group = new IconNode(new ImageIcon("Image2/16_2.png"),"Communicate_Group"+space2);
    		root1.add(group);
    		Root.add(root1);// ��������ڵ�

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
    				}
    				
    			}
    		if (e.getClickCount() == 2)// ˫���ڵ�
    		{
    		TreePath path = tree.getSelectionPath();// ��ȡѡ�нڵ�·��
    		IconNode node = (IconNode) path.getLastPathComponent();// ͨ��·����ָ��ָ��ýڵ�

    		if (node.isLeaf()&&node.getIcon()!=a&&node.getIcon()!=b)// ����ýڵ���Ҷ�ӽڵ�
    		{
	    	    if(ManageCommunicate_Win.Judge(owner,"Communicate_Group")){
	    	    	ManageCommunicate_Win.addGroupCommunicate(
	    	    			owner,"Communicate_Group",new Group_Communicate_Win(owner)); 
	    	    	Group_Communicate_Win.fresh_line();
	    	    }else {
	    	    	Group_Communicate_Win g_c_w = 
	    	    			(Group_Communicate_Win)ManageCommunicate_Win.getCommunicate_Win(owner,"Communicate_Group");
	    	    			g_c_w.onTop();
	    	    }
	    		}
	    	    } else// ����Ҷ�ӽڵ�
	    		{
	    		}
	
	    		}
    		
    		});
            tree.setOpaque(false);
    		return tree;
    }
}
