package test_121;

import javax.swing.*;

import javax.swing.event.AncestorListener;

import java.awt.*;

import java.awt.event.*;

public class Enter extends JFrame implements ActionListener{
	JLabel userLa,passLa;
	JTextField userTxt;
	JPasswordField passTxt;
	JLabel PhotoLabel = new JLabel(new ImageIcon("Flower.jpg"));

	JButton loginbt;//��¼���밴ť

	JLabel InformationJLabel;//��ӭ��

	public Enter(){

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
		
		//�ָ���
		userLa=new JLabel("�û���");//������ǩ
		userLa.setSize(60, 30);
		userLa.setLocation(90, 200);
		this.add(userLa);//����ǩ�ŵ�������
		
		userTxt=new JTextField();//�����ı���
		userTxt.setSize(150, 30);
		userTxt.setLocation(160, 200);
		this.add(userTxt);//���ı���ŵ�������
		
		passLa=new JLabel("��   ��");//������ǩ
		passLa.setSize(60, 30);
		passLa.setLocation(90, 260);
		this.add(passLa);//����ǩ�ŵ�������
		passTxt=new JPasswordField();//���������
		passTxt.setSize(150, 30);
		passTxt.setLocation(160, 260);
		this.add(passTxt);//�������ŵ�������

	}

	private void init(){
		loginbt=new JButton("��¼");

		loginbt.setSize(100,50);

		loginbt.setLocation(180, 330);

		loginbt.addActionListener(this);

		this.add(loginbt);

		InformationJLabel = new JLabel("��ӭʹ��!");
		
		InformationJLabel.setFont(new Font("����", Font.BOLD | Font.ITALIC, 50));

		InformationJLabel.setSize(300, 50);

		InformationJLabel.setLocation(120,100);

		this.add(InformationJLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bt=(JButton)e.getSource();
		if(bt.getText().equals("��¼"))
		{
		String name=userTxt.getText().trim();
		//��ȡ�û���
		@SuppressWarnings("deprecation")
		String num=passTxt.getText().trim();
		//��ȡѧ��
		String a=AppDAO.findFlowerBySno(num);
		String[] array=a.split(",");
		String searchName=array[1];
		//����ѧ���ļ��������
			if(num!=null&&searchName!=null&&name.equals(searchName)){
				AddApp addflower = new AddApp(); 
			}
			else {
			System.out.println("���������������˻�������");
			}
		}
	
	}

}
