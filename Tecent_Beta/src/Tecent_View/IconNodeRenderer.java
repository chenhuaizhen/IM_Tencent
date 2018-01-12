package Tecent_View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;


public class IconNodeRenderer extends DefaultTreeCellRenderer//�̳и��� 
{ 
 
	
//��д�÷���
public Component getTreeCellRendererComponent(JTree tree, Object value,boolean sel, 
boolean expanded, boolean leaf, int row,boolean hasFocus)
{ 
super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,row, hasFocus); //���ø���ĸ÷��� 
Icon icon = ((IconNode) value).getIcon();//�ӽڵ��ȡͼƬ
String txt=((IconNode) value).getText(); //�ӽڵ��ȡ�ı�
setIcon(icon);//����ͼƬ
setText(txt);//�����ı�
this.setFont(new Font("����", 0, 14));

setBackgroundNonSelectionColor(new Color(0, 0, 0, 0));


return this; 
}



}
//����ڵ���
class IconNode extends DefaultMutableTreeNode 
{ 
protected Icon icon; 
protected String txt; 

//ֻ�����ı��Ľڵ㹹��
public IconNode(String txt)
{
super();
this.txt=txt;
} 

//�����ı���ͼƬ�Ľڵ㹹��
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


