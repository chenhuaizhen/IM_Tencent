package Tecent_View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;


public class IconNodeRenderer extends DefaultTreeCellRenderer//继承该类 
{ 
 
	
//重写该方法
public Component getTreeCellRendererComponent(JTree tree, Object value,boolean sel, 
boolean expanded, boolean leaf, int row,boolean hasFocus)
{ 
super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,row, hasFocus); //调用父类的该方法 
Icon icon = ((IconNode) value).getIcon();//从节点读取图片
String txt=((IconNode) value).getText(); //从节点读取文本
setIcon(icon);//设置图片
setText(txt);//设置文本
this.setFont(new Font("黑体", 0, 14));

setBackgroundNonSelectionColor(new Color(0, 0, 0, 0));


return this; 
}



}
//定义节点类
class IconNode extends DefaultMutableTreeNode 
{ 
protected Icon icon; 
protected String txt; 

//只包含文本的节点构造
public IconNode(String txt)
{
super();
this.txt=txt;
} 

//包含文本和图片的节点构造
public IconNode(Icon icon,String txt)
{
super();
this.icon = icon; 
this.txt = txt;
}
public void setIcon(Icon icon) 
{ 
this.icon = icon; 
} 


public Icon getIcon() 
{ 
return icon; 
} 

public void setText(String txt)
{
this.txt=txt;
}

public String getText()
{
return txt;
} 


}


