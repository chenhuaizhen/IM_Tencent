package Tecent_View;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class IPsetting {

	public static void main(String[] args) {
		 final JFrame Frame = new JFrame("初始化服务器IP");
    	 Container CP = Frame.getContentPane(); //取得Frame的容器
    	 JLabel JL1 = new JLabel("默认服务器IP");
    	 final JTextField TF1 = new JTextField("192.168.179.1",15);
    	 JLabel JL2 = new JLabel("请根据服务器上显示的IP来填写");
    	 JButton B1 = new JButton("确定");
    	 B1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Login(TF1.getText());
				Frame.setVisible(false);
			}
		});
    	 CP.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));//只有CEBTER,LEFT,RIGHT三个属性
    	 CP.add(JL1);
    	 CP.add(TF1);
    	 CP.add(JL2);
    	 CP.add(B1);
    	 Frame.setSize(300, 120);
    	 Frame.setLocation(497, 242);
    	 Frame.setVisible(true);
    	 Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
