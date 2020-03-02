package test_121;


import javax.swing.*;

 

import java.awt.Font;

import java.awt.event.*;

import java.util.ArrayList;

 

public class DeleteApp extends JFrame implements ActionListener

{

	JLabel tableLabel;//标题

	JScrollPane tablePane;//滚动视口

	JTable table;//花卉列表

	JLabel Labelnum;//删除提示

	

	JTextField DeleteText;//删除文本框

	JButton Deletebt;//删除按钮

	JButton[] rbts;//按钮数组对象

	ButtonGroup btGroup;//按钮组，从逻辑上来涵盖所有的单选按钮

	

	

	public DeleteApp()

	{

		this.setLayout(null);

		this.setSize(700, 580);

		this.setTitle("外观设计");

		this.setLocation(600,250);

		this.init();

		this.refreshTable();

		this.setVisible(true);

		new Thread().start();

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

		

		Labelnum = new JLabel("编号");

		Labelnum.setFont(Labelnum.getFont().deriveFont(Font.BOLD, 16));

		Labelnum.setSize(100,30); 

		Labelnum.setLocation(100,70);

		this.add(Labelnum);

		

		DeleteText = new JTextField();

		DeleteText.setSize(180,30);

		DeleteText.setLocation(170, 70);

		this.add(DeleteText);

		

		Deletebt = new JButton("删除");

		Deletebt.setSize(70, 30);

		Deletebt.setLocation(380, 70);

		Deletebt.addActionListener(new ActionListener()

		{

			@Override

			public void actionPerformed(ActionEvent e) {

				int str=JOptionPane.showConfirmDialog(null, "是否删除？", "警告", JOptionPane.YES_NO_OPTION); 

				if(str==JOptionPane.YES_OPTION)

				{

					//System.out.println("进入");

					if(checkIsNull()){

						if(AppDAO.DeleteFlower(DeleteText.getText().trim()))

						{

							final ImageIcon icon = new ImageIcon("Ok.png");

							JOptionPane.showMessageDialog(null,"删除成功", "提示", JOptionPane.INFORMATION_MESSAGE, icon);

							DeleteText.setText("");

							refreshTable();

						}

						else

						{

							JOptionPane.showMessageDialog(null, "删除失败", "提示", JOptionPane.ERROR_MESSAGE);

						}

					}else{

						 final ImageIcon icon1 = new ImageIcon("黑人问号3.png");

						 JOptionPane.showMessageDialog(null,"未输入删除信息", "提示", JOptionPane.INFORMATION_MESSAGE, icon1);

					}

				}else{

					;

				}

					

			}

		}

					

		);

		this.add(Deletebt);	

		

		

	}

	

	private void refreshTable()

	{

		

		tableLabel = new JLabel("外观设计经费管理");	

		tableLabel.setBounds(300,105, 100, 50);

		tableLabel.setFont(new Font("宋体", Font.BOLD , 20));

		this.add(tableLabel);

		String[] columnNames = {"编号","名称","单价","计价单位"};

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
		
		System.out.println("正在删除界面");
		

		table=new JTable(objs,columnNames);

		table.setSize(380,150);

		tablePane = new JScrollPane(table);

		tablePane.setSize(660, 350);

		tablePane.setLocation(10, 150);

		table.getTableHeader().setReorderingAllowed(false);

		table.getTableHeader().setResizingAllowed(false);

		table.enable(false);

		

		this.add(tablePane);

	}

	

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

	    	  System.out.println("已处在删除界面上");

	      }else if(buttonName.equals("搜索")){

	    	  SearchApp searchflower = new SearchApp();

	      }else{

	    	  ModifyApp modifyflower = new ModifyApp();

	      }

		

	}

	

	private boolean checkIsNull() 

	{

		boolean flag=true;

		if(DeleteText.getText().trim().equals(""))

		{

			flag = false;

		}

		return flag;

	}

	

	private Object checkInput() 

	{	

		String result="";

		String result1="";

			for(int i=0;i<DeleteText.getText().trim().length();i++)

			{

				char ch=DeleteText.getText().trim().charAt(i);

				if((ch<'0')||(ch>'9'))

				{

					result="编号中包含非数字字符";

					break;

				}else

				{

					result="";

					break;

				}

			}

			return result;

		

	}

 

	

}
