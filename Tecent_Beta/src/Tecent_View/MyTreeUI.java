package Tecent_View;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.plaf.TreeUI;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.TreePath;

class MyTreeUI extends BasicTreeUI{

	//ʵ��ȥ��JTree�Ĵ�ֱ�ߺ�ˮƽ��
	@Override
	protected void paintVerticalLine(Graphics g, JComponent c, int x, int top,
	int bottom) {
	}

	@Override
	protected void paintHorizontalLine(Graphics g, JComponent c, int y,
	int left, int right) {
	}

	//ʵ�ָ��ڵ����ӽڵ����
	@Override
	public void setLeftChildIndent(int newAmount) {

	}

	@Override
	public void setRightChildIndent(int newAmount) {

	}	
	}