package test_121;


import javax.swing.*;

import javax.swing.event.AncestorListener;

import java.awt.*;

import java.awt.event.*;

 

 

public class Enter extends JFrame implements ActionListener

{

	JLabel PhotoLabel = new JLabel(new ImageIcon("Flower.jpg"));

	JButton loginbt;//��¼���밴ť

	JLabel InformationJLabel;//��ӭ��

	

	public Enter()

	{

		this.setSize(500, 500);

		this.setTitle("������ר������ϵͳ");

		this.setLocation(700,200);

		this.setVisible(true);

		this.setLayout(null);

		//������ƬΪ����

		String Background = "Flower.jpg";

		ImageIcon background = new ImageIcon(Background);

		JLabel label = new JLabel(background);

		label.setBounds(0, 0,this.getWidth() , this.getHeight());

		JPanel imagePanel = (JPanel) this.getContentPane();

		imagePanel.setOpaque(false);

		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.init();

	}

	

	private void init()

	{

		loginbt=new JButton("��¼");

		loginbt.setSize(100,50);

		loginbt.setLocation(180, 330);

		loginbt.addActionListener(this);

		this.add(loginbt);

		InformationJLabel = new JLabel("��ӭʹ��!");

		InformationJLabel.setFont(new Font("����", Font.BOLD | Font.ITALIC, 50));

		InformationJLabel.setSize(300, 50);

		InformationJLabel.setLocation(120,150);

		this.add(InformationJLabel);

		

	}

	

	@Override

	public void actionPerformed(ActionEvent e) {

      AddFlower addflower = new AddFlower(); 

		

	}

	

}
