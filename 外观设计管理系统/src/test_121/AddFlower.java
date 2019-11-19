package test_121;


import javax.swing.*;

import javax.swing.event.AncestorListener;

 

import java.awt.Font;

import java.awt.event.*;

 

public class AddFlower extends JFrame implements ActionListener

{

	JLabel tableLabel;

	

	JLabel NumLabel;//编号

	JLabel NameLabel;//名称

	JLabel PriceLabel;//单价

	JLabel UnitLabel;//计价单位

 

	JTextField NumText;//编号文本框

	JTextField NameText;//名称文本框

	JTextField PriceText;//单价文本框

	JTextField UnitText;//计价单位文本框

	

	JButton[] rbts;//按钮数组对象

	ButtonGroup btGroup;//按钮组，从逻辑上来涵盖所有的单选按钮

	JButton Addbt;//增加按钮

	

	public AddFlower()

	{

		this.setSize(500, 500);

		this.setTitle("外观设计");

		this.setLocation(700,200);

		this.setVisible(true);

		this.setLayout(null);

		this.init();

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

			rbts[i].setLocation(100*i+60, 30);

			btGroup.add(rbts[i]);//从逻辑上将单选按钮添加到一个按钮数组中

			this.add(rbts[i]);//从物理位置上将单选按钮添加到窗体中

			rbts[i].addActionListener(this);

		}

		

		//编号

		NumLabel=new JLabel("编号");

		NumLabel.setFont(NumLabel.getFont().deriveFont(Font.BOLD, 18));

		NumLabel.setSize(90,30);

		NumLabel.setLocation(70, 110);

		this.add(NumLabel);

		NumText=new JTextField();

		NumText.setSize(180,30);

		NumText.setLocation(170, 110);

		this.add(NumText);

		

		//名称

		NameLabel=new JLabel("名称");

		NameLabel.setFont(NameLabel.getFont().deriveFont(Font.BOLD, 18));

		NameLabel.setSize(90,30);

		NameLabel.setLocation(70, 170);

		this.add(NameLabel);

		NameText=new JTextField();

		NameText.setSize(180,30);

		NameText.setLocation(170, 170);

		this.add(NameText);

		

		//单价

		PriceLabel=new JLabel("单价");

		PriceLabel.setFont(PriceLabel.getFont().deriveFont(Font.BOLD, 18));

		PriceLabel.setSize(90,30);

		PriceLabel.setLocation(70, 230);

		this.add(PriceLabel);

		PriceText=new JTextField();

		PriceText.setSize(180,30);

		PriceText.setLocation(170, 230);

		this.add(PriceText);

 

		//备注

		UnitLabel=new JLabel("备注");

		UnitLabel.setFont(UnitLabel.getFont().deriveFont(Font.BOLD, 18));

		UnitLabel.setSize(90,30);

		UnitLabel.setLocation(70, 290);

		this.add(UnitLabel);

		UnitText=new JTextField();

		UnitText.setSize(180,30);

		UnitText.setLocation(170, 290);

		this.add(UnitText);

		

		//添加按钮

		Addbt=new JButton("添加");	

		Addbt.setSize(90,50);

		Addbt.setLocation(200, 360);

		Addbt.addActionListener(

				new ActionListener()

				{

					public void actionPerformed(ActionEvent e)

					{

						

						 if(!checkIsNull())

					      {

							  final ImageIcon icon3 = new ImageIcon("question.png");

							 JOptionPane.showMessageDialog(null,"有未填信息？", "提示", JOptionPane.INFORMATION_MESSAGE, icon3);

					      }else

					      {

					    	  if(!checkInput().equals(""))

					    	  {

					    		  final ImageIcon icon2 = new ImageIcon("NotOk.png");

									 JOptionPane.showMessageDialog(null,checkInput(), "提示", JOptionPane.INFORMATION_MESSAGE, icon2);

					    	  }else

					    	  {

					    		  FlowerDAO dao = new FlowerDAO();

					    		  //引用添加花朵信息的方法

					    		  StringBuffer FloInfo=new StringBuffer();

					    		  FloInfo.append(NumText.getText().trim()+",");

					    		  FloInfo.append(NameText.getText().trim()+",");

					    		  FloInfo.append(PriceText.getText().trim()+",");

					    		  FloInfo.append(UnitText.getText().trim());

					    		// dao.AddFlower(FloInfo);
					    		  if(dao.AddFlower(FloInfo.toString()))

									{

					    			  final ImageIcon icon = new ImageIcon("Ok2.png");

										JOptionPane.showMessageDialog(null,"添加成功", "提示", JOptionPane.INFORMATION_MESSAGE, icon);

										NumText.setText("");

										NameText.setText("");

										PriceText.setText("");

										UnitText.setText("");

									}

									else

									{

										final ImageIcon icon1 = new ImageIcon("NotOk2.png");

										JOptionPane.showMessageDialog(null,"信息重复", "提示", JOptionPane.INFORMATION_MESSAGE, icon1);

									}

					    	  }

					      }

					}

				}

		);

		this.add(Addbt);

	}

	@Override

	public void actionPerformed(ActionEvent e) {

		 String buttonName = e.getActionCommand();

      if(buttonName.equals("增加")){

    	  System.out.println("已处在增加界面上");

      }else if(buttonName.equals("删除")){

    	  DeleteFlower deleteflower = new DeleteFlower();

      }else if(buttonName.equals("搜索")){

    	  SearchFlower searchflower = new SearchFlower();

      }else{

    	  ModifyFlower modifyflower = new ModifyFlower();

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
