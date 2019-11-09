import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener,MouseListener{
    //定义窗口中存在的控件
	JLabel userLa,passLa;
	JTextField userTxt;
	JPasswordField passTxt;
	JButton loBt,quitBt;
	
	//定义主窗口中的两个面板（操作选择面板和操作面板）
	JPanel selectPa;
	JButton[] selectBts;
	
	
	JPanel controlPa;
	//查找的控件 
	JLabel numLa,nameLa;
	JTextField numTxt,nameTxt;
	JButton findBt;
	
	public LoginFrame()
	{
		//Dimension dime=new Dimension(400,300);
		//this.setSize(dime);
		this.setSize(400, 300);//设置窗体的大小
		this.setTitle("登录窗口");//设置窗体标题
		//以下代码是创建控件并摆放到窗口中
		/*userLa=new JLabel("用户名");//创建标签
		this.add(userLa,BorderLayout.WEST);//将标签放到窗体上
		//userLa=new JLabel();
		//userLa.setText("用户名");
		//userLa.setForeground(Color.RENORTHD);
		userTxt=new JTextField();//创建文本框
		this.add(userTxt,BorderLayout.SOUTH);//将文本框放到窗体上
		passLa=new JLabel("密   码");//创建标签
		this.add(passLa,BorderLayout.EAST);//将标签放到窗体上
		passTxt=new JPasswordField();//创建密码框
		this.add(passTxt,BorderLayout.NORTH);//将密码框放到窗体上
		loBt=new JButton("登录");//创建按钮
		this.add(loBt,BorderLayout.CENTER);//将按钮放到窗体上
		//quitBt=new JButton("退出");//创建按钮
		//this.add(quitBt);//将按钮放到窗体上*/
		//this.setLayout(new FlowLayout());
		//将窗体的布局方式改为流布局对象
		
		/*userLa=new JLabel("用户名");//创建标签
		this.add(userLa);//将标签放到窗体上
		//userLa=new JLabel();
		//userLa.setText("用户名");
		//userLa.setForeground(Color.RENORTHD);
		userTxt=new JTextField();//创建文本框
		this.add(userTxt);//将文本框放到窗体上
		passLa=new JLabel("密   码");//创建标签
		this.add(passLa);//将标签放到窗体上
		passTxt=new JPasswordField();//创建密码框
		this.add(passTxt);//将密码框放到窗体上
		loBt=new JButton("登录");//创建按钮
		this.add(loBt);//将按钮放到窗体上
		quitBt=new JButton("退出");//创建按钮
		this.add(quitBt);//将按钮放到窗体上*/
		/*this.setLayout(new GridLayout(3,2));
		userLa=new JLabel("用户名");//创建标签
		this.add(userLa);//将标签放到窗体上
		//userLa=new JLabel();
		//userLa.setText("用户名");
		//userLa.setForeground(Color.RENORTHD);
		userTxt=new JTextField();//创建文本框
		this.add(userTxt);//将文本框放到窗体上
		passLa=new JLabel("密   码");//创建标签
		this.add(passLa);//将标签放到窗体上
		passTxt=new JPasswordField();//创建密码框
		this.add(passTxt);//将密码框放到窗体上
		loBt=new JButton("登录");//创建按钮
		this.add(loBt);//将按钮放到窗体上
		quitBt=new JButton("退出");//创建按钮
		this.add(quitBt);//将按钮放到窗体上*/
		
		
		this.setLayout(null);
		//设置窗体的布局对象为空
		userLa=new JLabel("用户名");//创建标签
		userLa.setSize(60, 30);
		userLa.setLocation(90, 50);
		this.add(userLa);//将标签放到窗体上
		
		userTxt=new JTextField();//创建文本框
		userTxt.setSize(150, 30);
		userTxt.setLocation(160, 50);
		this.add(userTxt);//将文本框放到窗体上
		
		passLa=new JLabel("密   码");//创建标签
		passLa.setSize(60, 30);
		passLa.setLocation(90, 100);
		this.add(passLa);//将标签放到窗体上
		passTxt=new JPasswordField();//创建密码框
		passTxt.setSize(150, 30);
		passTxt.setLocation(160, 100);
		this.add(passTxt);//将密码框放到窗体上
		loBt=new JButton("登录");//创建按钮
		loBt.setSize(60, 30);
		loBt.setLocation(120, 150);
		loBt.addActionListener(this);
		this.add(loBt);//将按钮放到窗体上
		quitBt=new JButton("退出");//创建按钮
		quitBt.setSize(60, 30);
		quitBt.setLocation(210, 150);
		this.add(quitBt);//将按钮放到窗体上*/
		
		
		this.setVisible(true);//设置窗体可见
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton bt=(JButton)e.getSource();
		if(bt.getText().equals("登录"))
		{
		String name=userTxt.getText().trim();
		//获取用户名
		String num=passTxt.getText().trim();
		//获取学号
		StudentDeal deal=new StudentDeal();
		//创建学生文件处理对象
		if(num.equals(deal.findNumByName(name)))
		{
			/*this.setVisible(false);
			//将当前登录窗口隐藏
			MainFrame main=new MainFrame();
			//创建主窗口，并显示*/
			this.setSize(800, 600);
			//修改窗体的大小
			this.setTitle("主窗口");
			this.getContentPane().removeAll();
			//将窗口上的所有控件移除
			initSelectPanel();//初始化选择面板
			initControlPa();//初始化操作面板
		}
		}
		else
		{
			if(bt.getText().equals("查找"))
			{
				StudentDeal deal=new StudentDeal();
				String name=deal.findNameByNum(numTxt.getText().trim());
				nameTxt.setText(name);
				
			}
		}
		
	}
	
	private void initSelectPanel()
	{
		selectPa=new JPanel();
		selectPa.setLayout(null);
		selectPa.setSize(200, 600);
		selectPa.setBackground(Color.orange);
		String[] strs={"增加学生","删除学生","修改学生","查找学生"};
		selectBts=new JButton[strs.length];
		for(int i=0;i<selectBts.length;i++)
		{
			selectBts[i]=new JButton(strs[i]);
			selectBts[i].setSize(120, 30);
			selectBts[i].setLocation(30,35*i+30);
			selectBts[i].addMouseListener(this);
			selectPa.add(selectBts[i]);
		}
		this.add(selectPa);
		
	}
	
	private void initControlPa()
	{
		controlPa=new JPanel();
		controlPa.setLayout(null);
		controlPa.setLayout(null);
		controlPa.setLocation(200,0);
		controlPa.setSize(600, 600);
		controlPa.setBackground(Color.LIGHT_GRAY);
		this.add(controlPa);
	}
	
	public void mouseClicked(MouseEvent e)
	{
	    JButton sourceBt=(JButton)e.getSource();
	    System.out.println("OK");
		String str=sourceBt.getText();
		if(str.equals("查找学生"))
		{
			controlPa.removeAll();
			//清空操作面板的所有控件
			numLa=new JLabel("请输入学号");
			numLa.setSize(100, 30);
			numLa.setLocation(30, 30);
			controlPa.add(numLa);
			nameLa=new JLabel("学生姓名");
			nameLa.setSize(100, 30);
			nameLa.setLocation(30, 80);
			controlPa.add(nameLa);
			numTxt=new JTextField();
			numTxt.setSize(100, 30);
			numTxt.setLocation(140, 30);
			controlPa.add(numTxt);
			nameTxt=new JTextField();
			nameTxt.setSize(100, 30);
			nameTxt.setLocation(140, 80);
			controlPa.add(nameTxt);
			findBt=new JButton("查找");
			findBt.setSize(60, 30);
			findBt.setLocation(120, 130);
			findBt.addActionListener(this);
			controlPa.add(findBt);
			this.getContentPane().repaint();
		}
	}
	 public void mousePressed(MouseEvent e){}
	 public void mouseReleased(MouseEvent e){}
	 public void mouseEntered(MouseEvent e)
	 {
	 }
	 public void mouseExited(MouseEvent e)
	 {
	 }
}
