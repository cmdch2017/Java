package test_121;

import javax.swing.*;

 

import java.awt.Font;

import java.awt.event.*;

import java.util.ArrayList;

 

public class ModifyApp extends JFrame implements ActionListener

{

	JButton[] rbts;//��ť�������

	ButtonGroup btGroup;//��ť�飬���߼������������еĵ�ѡ��ť

	

	JLabel tableLabel;//����

	JScrollPane tablePane;//�����ӿ�

	JTable table;//�����б�

 

	JLabel NumLabel;//���

	JLabel NameLabel;//����

	JLabel PriceLabel;//����

	JLabel UnitLabel;//�Ƽ۵�λ

	

	JTextField NumText;//����ı���

	JTextField NameText;//�����ı���

	JTextField PriceText;//�����ı���

	JTextField UnitText;//�Ƽ۵�λ�ı���

	

	JButton Modifybt;//�޸İ�ť

	public ModifyApp()

	{

		this.setLayout(null);

		this.setSize(700, 580);

		this.setTitle("������ר����Ϣ����ϵͳ");

		this.setLocation(600,250);

		this.init();

		this.refreshTable();

		this.setVisible(true);

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

			rbts[i].setLocation(150*i+80, 10);

			btGroup.add(rbts[i]);//���߼��Ͻ���ѡ��ť��ӵ�һ����ť������

			this.add(rbts[i]);//������λ���Ͻ���ѡ��ť��ӵ�������

			rbts[i].addActionListener(this);

		}

		

		//���

		NumLabel=new JLabel("���");

		NumLabel.setFont(NumLabel.getFont().deriveFont(Font.BOLD, 16));

		NumLabel.setSize(80,30);

		NumLabel.setLocation(80, 60);

		this.add(NumLabel);

		NumText=new JTextField();

		NumText.setSize(100,30);

		NumText.setLocation(140, 60);

		this.add(NumText);

		

		//����

		NameLabel=new JLabel("����");

		NameLabel.setFont(NameLabel.getFont().deriveFont(Font.BOLD, 16));

		NameLabel.setSize(80,30);

		NameLabel.setLocation(300,60);

		this.add(NameLabel);

		NameText=new JTextField();

		NameText.setSize(100,30);

		NameText.setLocation(380, 60);

		this.add(NameText);

		

		//����

		PriceLabel=new JLabel("����");

		PriceLabel.setFont(PriceLabel.getFont().deriveFont(Font.BOLD, 16));

		PriceLabel.setSize(80,30);

		PriceLabel.setLocation(80, 100);

		this.add(PriceLabel);

		PriceText=new JTextField();

		PriceText.setSize(100,30);

		PriceText.setLocation(140, 100);

		this.add(PriceText);

 

		//�Ƽ۵�λ

		UnitLabel=new JLabel("��ע");

		UnitLabel.setFont(UnitLabel.getFont().deriveFont(Font.BOLD, 16));

		UnitLabel.setSize(80,30);

		UnitLabel.setLocation(300, 100);

		this.add(UnitLabel);

		UnitText=new JTextField();

		UnitText.setSize(100,30);

		UnitText.setLocation(380, 100);

		this.add(UnitText);

		

		Modifybt = new JButton("�޸�");

		Modifybt.setSize(70, 30);

		Modifybt.setLocation(530, 100);

		Modifybt.addActionListener(new ActionListener()

		{

			@Override

			public void actionPerformed(ActionEvent e) {

				if(!checkIsNull())//����û�����Ϊ�յĻ�

				{

					 final ImageIcon icon = new ImageIcon("2.jpg");

					 JOptionPane.showMessageDialog(null,"������ϢΪ�գ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE, icon);			}

				else

				{

					if(!checkInput().equals(""))

					{

						JOptionPane.showMessageDialog(null,checkInput());

					}

					else

					{

						AppDAO dao=new AppDAO();

						//����һ������ѧ����Ϣ�ı��ļ��Ķ���

						StringBuffer floInfo=new StringBuffer();

						floInfo.append(NumText.getText().trim()+",");

						floInfo.append(NameText.getText().trim()+",");

						floInfo.append(PriceText.getText().trim()+",");

						floInfo.append(UnitText.getText().trim());

						if(dao.ModifyFlower(floInfo.toString()))

						{

							final ImageIcon icon2 = new ImageIcon("OK.jpg");

							JOptionPane.showMessageDialog(null,"�޸ĳɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE, icon2);

							NumText.setText("");

							NameText.setText("");

							PriceText.setText("");

							UnitText.setText("");

							refreshTable();

							//��ӳɹ���ˢ�±��

						}

						else

						{

							JOptionPane.showMessageDialog(null,"�޸ļ�¼ʧ��");

						}

					}

				}

		}

		}		

		);

		this.add(Modifybt);

		

	}

	

	//���

	private void refreshTable()

	{

		tableLabel = new JLabel("������ר�������嵥");	

		tableLabel.setBounds(300,140, 100, 50);

		tableLabel.setFont(new Font("����", Font.BOLD , 20));

		

		String[] columnNames = {"���","����","����","��ע"};

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

	

	//ˢ�±��

	public void run() {

		while (true) {

			//ÿ��1���Ӹ���JTable

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

	      if(buttonName.equals("����")){

	    	  AddApp addflower = new AddApp(); 

	      }else if(buttonName.equals("ɾ��")){

	    	  DeleteApp deleteflower = new DeleteApp();

	      }else if(buttonName.equals("����")){

	    	  SearchApp searchflower = new SearchApp();

	      }else{

	    	  System.out.println("�Ѵ����޸Ľ�����");

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
