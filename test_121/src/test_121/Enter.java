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

	JButton loginbt;//登录进入按钮

	JLabel InformationJLabel;//欢迎语

	public Enter(){

		this.setSize(500, 500);

		this.setTitle("外观设计专利管理系统");

		this.setLocation(700,200);

		this.setVisible(true);

		this.setLayout(null);

		//设置照片为背景

		String Background = "Flower.jpg";

		ImageIcon background = new ImageIcon(Background);

		JLabel label = new JLabel(background);

		label.setBounds(0, 0,this.getWidth() , this.getHeight());

		JPanel imagePanel = (JPanel) this.getContentPane();

		imagePanel.setOpaque(false);

		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.init();
		
		//分割线
		userLa=new JLabel("用户名");//创建标签
		userLa.setSize(60, 30);
		userLa.setLocation(90, 200);
		this.add(userLa);//将标签放到窗体上
		
		userTxt=new JTextField();//创建文本框
		userTxt.setSize(150, 30);
		userTxt.setLocation(160, 200);
		this.add(userTxt);//将文本框放到窗体上
		
		passLa=new JLabel("密   码");//创建标签
		passLa.setSize(60, 30);
		passLa.setLocation(90, 260);
		this.add(passLa);//将标签放到窗体上
		passTxt=new JPasswordField();//创建密码框
		passTxt.setSize(150, 30);
		passTxt.setLocation(160, 260);
		this.add(passTxt);//将密码框放到窗体上

	}

	private void init(){
		loginbt=new JButton("登录");

		loginbt.setSize(100,50);

		loginbt.setLocation(180, 330);

		loginbt.addActionListener(this);

		this.add(loginbt);

		InformationJLabel = new JLabel("欢迎使用!");
		
		InformationJLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 50));

		InformationJLabel.setSize(300, 50);

		InformationJLabel.setLocation(120,100);

		this.add(InformationJLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bt=(JButton)e.getSource();
		if(bt.getText().equals("登录"))
		{
		String name=userTxt.getText().trim();
		//获取用户名
		@SuppressWarnings("deprecation")
		String num=passTxt.getText().trim();
		//获取学号
		String a=AppDAO.findFlowerBySno(num);
		String[] array=a.split(",");
		String searchName=array[1];
		//创建学生文件处理对象
			if(num!=null&&searchName!=null&&name.equals(searchName)){
				AddApp addflower = new AddApp(); 
			}
			else {
			System.out.println("错误请重新输入账户或密码");
			}
		}
	
	}

}
