package test_121;

import javax.swing.*;

 

import java.awt.Font;

import java.awt.event.*;

import java.util.ArrayList;

 

public class ModifyApp extends JFrame implements ActionListener

{

	JButton[] rbts;//按钮数组对象

	ButtonGroup btGroup;//按钮组，从逻辑上来涵盖所有的单选按钮

	

	JLabel tableLabel;//标题

	JScrollPane tablePane;//滚动视口

	JTable table;//花卉列表

 

	JLabel NumLabel;//编号

	JLabel NameLabel;//名称

	JLabel PriceLabel;//单价

	JLabel UnitLabel;//计价单位

	

	JTextField NumText;//编号文本框

	JTextField NameText;//名称文本框

	JTextField PriceText;//单价文本框

	JTextField UnitText;//计价单位文本框

	

	JButton Modifybt;//修改按钮

	public ModifyApp()

	{

		this.setLayout(null);

		this.setSize(700, 580);

		this.setTitle("外观设计专利信息管理系统");

		this.setLocation(600,250);

		this.init();

		this.refreshTable();

		this.setVisible(true);

	}

	private void init()

	{

		//增删查改功能入口按钮

		btGroup=new ButtonGroup();

		rbts=new JButton[4];

		String[] strs = {"增加","删除","搜索","修改"};

		for(int i = 0;i<strs.length;i++)

		{

			rbts[i]=new JButton(strs[i]);

			rbts[i].setSize(70, 30);

			rbts[i].setLocation(150*i+80, 10);

			btGroup.add(rbts[i]);//从逻辑上将单选按钮添加到一个按钮数组中

			this.add(rbts[i]);//从物理位置上将单选按钮添加到窗体中

			rbts[i].addActionListener(this);

		}

		

		//编号

		NumLabel=new JLabel("编号");

		NumLabel.setFont(NumLabel.getFont().deriveFont(Font.BOLD, 16));

		NumLabel.setSize(80,30);

		NumLabel.setLocation(80, 60);

		this.add(NumLabel);

		NumText=new JTextField();

		NumText.setSize(100,30);

		NumText.setLocation(140, 60);

		this.add(NumText);

		

		//名称

		NameLabel=new JLabel("名称");

		NameLabel.setFont(NameLabel.getFont().deriveFont(Font.BOLD, 16));

		NameLabel.setSize(80,30);

		NameLabel.setLocation(300,60);

		this.add(NameLabel);

		NameText=new JTextField();

		NameText.setSize(100,30);

		NameText.setLocation(380, 60);

		this.add(NameText);

		

		//单价

		PriceLabel=new JLabel("单价");

		PriceLabel.setFont(PriceLabel.getFont().deriveFont(Font.BOLD, 16));

		PriceLabel.setSize(80,30);

		PriceLabel.setLocation(80, 100);

		this.add(PriceLabel);

		PriceText=new JTextField();

		PriceText.setSize(100,30);

		PriceText.setLocation(140, 100);

		this.add(PriceText);

 

		//计价单位

		UnitLabel=new JLabel("备注");

		UnitLabel.setFont(UnitLabel.getFont().deriveFont(Font.BOLD, 16));

		UnitLabel.setSize(80,30);

		UnitLabel.setLocation(300, 100);

		this.add(UnitLabel);

		UnitText=new JTextField();

		UnitText.setSize(100,30);

		UnitText.setLocation(380, 100);

		this.add(UnitText);

		

		Modifybt = new JButton("修改");

		Modifybt.setSize(70, 30);

		Modifybt.setLocation(530, 100);

		Modifybt.addActionListener(new ActionListener()

		{

			@Override

			public void actionPerformed(ActionEvent e) {

				if(!checkIsNull())//如果用户输入为空的话

				{

					 final ImageIcon icon = new ImageIcon("2.jpg");

					 JOptionPane.showMessageDialog(null,"输入信息为空！", "提示", JOptionPane.INFORMATION_MESSAGE, icon);			}

				else

				{

					if(!checkInput().equals(""))

					{

						JOptionPane.showMessageDialog(null,checkInput());

					}

					else

					{

						AppDAO dao=new AppDAO();

						//创建一个操作学生信息文本文件的对象

						StringBuffer floInfo=new StringBuffer();

						floInfo.append(NumText.getText().trim()+",");

						floInfo.append(NameText.getText().trim()+",");

						floInfo.append(PriceText.getText().trim()+",");

						floInfo.append(UnitText.getText().trim());

						if(dao.ModifyFlower(floInfo.toString()))

						{

							final ImageIcon icon2 = new ImageIcon("OK.jpg");

							JOptionPane.showMessageDialog(null,"修改成功", "提示", JOptionPane.INFORMATION_MESSAGE, icon2);

							NumText.setText("");

							NameText.setText("");

							PriceText.setText("");

							UnitText.setText("");

							refreshTable();

							//添加成功后刷新表格

						}

						else

						{

							JOptionPane.showMessageDialog(null,"修改记录失败");

						}

					}

				}

		}

		}		

		);

		this.add(Modifybt);

		

	}

	

	//表格

	private void refreshTable()

	{

		tableLabel = new JLabel("外观设计专利经费清单");	

		tableLabel.setBounds(300,140, 100, 50);

		tableLabel.setFont(new Font("宋体", Font.BOLD , 20));

		

		String[] columnNames = {"编号","名称","单价","备注"};

		AppDAO dao=new AppDAO();

		ArrayList<String> flos=dao.findAllFlowers();

		Object[][] objs=new Object[flos.size()][4];

		for(int i=0;i<flos.size();i++)

		{

			String[] strs1=flos.get(i).split(",");

			objs[i][0]=strs1[0];

			objs[i][1]=strs1[1];

			objs[i][2]=strs1[2];

			objs[i][3]=strs1[3];

			

		}
		System.out.println("Modify");
		

		table=new JTable(objs,columnNames);

		table.setSize(380,150);

		tablePane = new JScrollPane(table);

		tablePane.setSize(660, 320);

		tablePane.setLocation(10, 190);

		table.getTableHeader().setReorderingAllowed(false);

		table.getTableHeader().setResizingAllowed(false);

		table.enable(false);

		

		this.add(tableLabel);

		this.add(tablePane);

	}

	

	//刷新表格

	public void run() {

		while (true) {

			//每隔1秒钟更新JTable

			table.validate();

			table.updateUI();

			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

	}

	

	@Override

	public void actionPerformed(ActionEvent e) {

		 String buttonName = e.getActionCommand();

	      if(buttonName.equals("增加")){

	    	  AddApp addflower = new AddApp(); 

	      }else if(buttonName.equals("删除")){

	    	  DeleteApp deleteflower = new DeleteApp();

	      }else if(buttonName.equals("搜索")){

	    	  SearchApp searchflower = new SearchApp();

	      }else{

	    	  System.out.println("已处在修改界面上");

	      }

		

	}

 

	private boolean checkIsNull() 

	{

		boolean flag=true;

		if(NumText.getText().trim().equals(""))

		{

			flag = false;

		}else if(NameText.getText().trim().equals(""))

		{

			flag=false;

		}else if(PriceText.getText().trim().equals(""))

		{

			flag=false;

		}else if(UnitText.getText().trim().equals(""))

		{

			flag=false;

		}

		return flag;

	}

	

	private Object checkInput() 

	{	

		String result="";

		String result1="";

			for(int i=0;i<NumText.getText().trim().length();i++)

			{

				char ch=NumText.getText().trim().charAt(i);

				if((ch<'0')||(ch>'9'))

				{

					result="编号中包含非数字字符";

					break;

				}

			}

			for(int i=0;i<PriceText.getText().trim().length();i++)

			{

				char ch=PriceText.getText().trim().charAt(i);

				if((ch<'0')||(ch>'9'))

				{

					result1="单价中包含非数字字符";

					break;

				}

			}

		if(result=="编号中包含非数字字符" && result1=="")

		{

			return result;

		}else if(result1=="单价中包含非数字字符" && result=="")

		{

			return result1;

		}else if(result=="编号中包含非数字字符" && result1=="单价中包含非数字字符")

		{

			return "编号和单价中均包含非数字字符";

		}else

		{

			return "";

		}

		

	}

 

}
