package test_121;


import javax.swing.*;

import javax.swing.event.AncestorListener;

 

import java.awt.Font;

import java.awt.event.*;

 

public class AddFlower extends JFrame implements ActionListener

{

	JLabel tableLabel;

	

	JLabel NumLabel;//���

	JLabel NameLabel;//����

	JLabel PriceLabel;//����

	JLabel UnitLabel;//�Ƽ۵�λ

 

	JTextField NumText;//����ı���

	JTextField NameText;//�����ı���

	JTextField PriceText;//�����ı���

	JTextField UnitText;//�Ƽ۵�λ�ı���

	

	JButton[] rbts;//��ť�������

	ButtonGroup btGroup;//��ť�飬���߼������������еĵ�ѡ��ť

	JButton Addbt;//���Ӱ�ť

	

	public AddFlower()

	{

		this.setSize(500, 500);

		this.setTitle("������");

		this.setLocation(700,200);

		this.setVisible(true);

		this.setLayout(null);

		this.init();

	}

	

	private void init()

	{

		//��ɾ��Ĺ�����ڰ�ť

		btGroup=new ButtonGroup();

		rbts=new JButton[4];

		String[] strs = {"����","ɾ��","����","�޸�"};

		for(int i = 0;i<strs.length;i++)

		{

			rbts[i]=new JButton(strs[i]);

			rbts[i].setSize(70, 30);

			rbts[i].setLocation(100*i+60, 30);

			btGroup.add(rbts[i]);//���߼��Ͻ���ѡ��ť��ӵ�һ����ť������

			this.add(rbts[i]);//������λ���Ͻ���ѡ��ť��ӵ�������

			rbts[i].addActionListener(this);

		}

		

		//���

		NumLabel=new JLabel("���");

		NumLabel.setFont(NumLabel.getFont().deriveFont(Font.BOLD, 18));

		NumLabel.setSize(90,30);

		NumLabel.setLocation(70, 110);

		this.add(NumLabel);

		NumText=new JTextField();

		NumText.setSize(180,30);

		NumText.setLocation(170, 110);

		this.add(NumText);

		

		//����

		NameLabel=new JLabel("����");

		NameLabel.setFont(NameLabel.getFont().deriveFont(Font.BOLD, 18));

		NameLabel.setSize(90,30);

		NameLabel.setLocation(70, 170);

		this.add(NameLabel);

		NameText=new JTextField();

		NameText.setSize(180,30);

		NameText.setLocation(170, 170);

		this.add(NameText);

		

		//����

		PriceLabel=new JLabel("����");

		PriceLabel.setFont(PriceLabel.getFont().deriveFont(Font.BOLD, 18));

		PriceLabel.setSize(90,30);

		PriceLabel.setLocation(70, 230);

		this.add(PriceLabel);

		PriceText=new JTextField();

		PriceText.setSize(180,30);

		PriceText.setLocation(170, 230);

		this.add(PriceText);

 

		//��ע

		UnitLabel=new JLabel("��ע");

		UnitLabel.setFont(UnitLabel.getFont().deriveFont(Font.BOLD, 18));

		UnitLabel.setSize(90,30);

		UnitLabel.setLocation(70, 290);

		this.add(UnitLabel);

		UnitText=new JTextField();

		UnitText.setSize(180,30);

		UnitText.setLocation(170, 290);

		this.add(UnitText);

		

		//��Ӱ�ť

		Addbt=new JButton("���");	

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

							 JOptionPane.showMessageDialog(null,"��δ����Ϣ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE, icon3);

					      }else

					      {

					    	  if(!checkInput().equals(""))

					    	  {

					    		  final ImageIcon icon2 = new ImageIcon("NotOk.png");

									 JOptionPane.showMessageDialog(null,checkInput(), "��ʾ", JOptionPane.INFORMATION_MESSAGE, icon2);

					    	  }else

					    	  {

					    		  FlowerDAO dao = new FlowerDAO();

					    		  //������ӻ�����Ϣ�ķ���

					    		  StringBuffer FloInfo=new StringBuffer();

					    		  FloInfo.append(NumText.getText().trim()+",");

					    		  FloInfo.append(NameText.getText().trim()+",");

					    		  FloInfo.append(PriceText.getText().trim()+",");

					    		  FloInfo.append(UnitText.getText().trim());

					    		// dao.AddFlower(FloInfo);
					    		  if(dao.AddFlower(FloInfo.toString()))

									{

					    			  final ImageIcon icon = new ImageIcon("Ok2.png");

										JOptionPane.showMessageDialog(null,"��ӳɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE, icon);

										NumText.setText("");

										NameText.setText("");

										PriceText.setText("");

										UnitText.setText("");

									}

									else

									{

										final ImageIcon icon1 = new ImageIcon("NotOk2.png");

										JOptionPane.showMessageDialog(null,"��Ϣ�ظ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE, icon1);

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

      if(buttonName.equals("����")){

    	  System.out.println("�Ѵ������ӽ�����");

      }else if(buttonName.equals("ɾ��")){

    	  DeleteFlower deleteflower = new DeleteFlower();

      }else if(buttonName.equals("����")){

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

					result="����а����������ַ�";

					break;

				}

			}

			for(int i=0;i<PriceText.getText().trim().length();i++)

			{

				char ch=PriceText.getText().trim().charAt(i);

				if((ch<'0')||(ch>'9'))

				{

					result1="�����а����������ַ�";

					break;

				}

			}

		if(result=="����а����������ַ�" && result1=="")

		{

			return result;

		}else if(result1=="�����а����������ַ�" && result=="")

		{

			return result1;

		}else if(result=="����а����������ַ�" && result1=="�����а����������ַ�")

		{

			return "��ź͵����о������������ַ�";

		}else

		{

			return "";

		}

		

	}

 

	

}
