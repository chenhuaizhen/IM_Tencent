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
		 final JFrame Frame = new JFrame("��ʼ��������IP");
    	 Container CP = Frame.getContentPane(); //ȡ��Frame������
    	 JLabel JL1 = new JLabel("Ĭ�Ϸ�����IP");
    	 final JTextField TF1 = new JTextField("192.168.179.1",15);
    	 JLabel JL2 = new JLabel("����ݷ���������ʾ��IP����д");
    	 JButton B1 = new JButton("ȷ��");
    	 B1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Login(TF1.getText());
				Frame.setVisible(false);
			}
		});
    	 CP.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));//ֻ��CEBTER,LEFT,RIGHT��������
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
