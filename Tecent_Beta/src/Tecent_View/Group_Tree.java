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
    		IconNode Root = new IconNode(null, null);// 定义根节点
    		final ImageIcon a = new ImageIcon("image2/2_4.png");
    		final ImageIcon b = new ImageIcon("image2/2_3.png");
    		final IconNode root1 = new IconNode(a,"讨论组"+space);
    		IconNode group = new IconNode(new ImageIcon("Image2/16_2.png"),"Communicate_Group"+space2);
    		root1.add(group);
    		Root.add(root1);// 定义二级节点

    		final JTree tree  = new JTree(Root);// 定义树
    		tree.setUI(new MyTreeUI());
    		tree.setCellRenderer(new IconNodeRenderer()); // 设置单元格描述


    		tree.setEditable(false); // 设置树是否可编辑
    		tree.setRootVisible(false);// 设置树的根节点是否可视
    		tree.setToggleClickCount(1);// 设置单击几次展开数节点
    		//tree.expandRow();//设置展开第几行
    		//tree.expandRow(4);
    		// 测试事件

    		tree.addMouseListener(new MouseAdapter() {
    			public void mouseExited(MouseEvent arg0) {
    				//TreePath path = tree.getSelectionPath();// 获取选中节点路径
    				//IconNode node = (IconNode) path.getLastPathComponent();
    				
    				
    			}
    			
    			public void mouseEntered(MouseEvent arg0) {
    				// TODO Auto-generated method stub
    				
    			}
    		public void mouseClicked(MouseEvent e) {
    			if(e.getClickCount() == 1){
    				TreePath path = tree.getSelectionPath();// 获取选中节点路径
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
    		if (e.getClickCount() == 2)// 双击节点
    		{
    		TreePath path = tree.getSelectionPath();// 获取选中节点路径
    		IconNode node = (IconNode) path.getLastPathComponent();// 通过路径将指针指向该节点

    		if (node.isLeaf()&&node.getIcon()!=a&&node.getIcon()!=b)// 如果该节点是叶子节点
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
	    	    } else// 不是叶子节点
	    		{
	    		}
	
	    		}
    		
    		});
            tree.setOpaque(false);
    		return tree;
    }
}
