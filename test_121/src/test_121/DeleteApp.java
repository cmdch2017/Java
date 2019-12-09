package test_121;


import javax.swing.*;

 

import java.awt.Font;

import java.awt.event.*;

import java.util.ArrayList;

 

public class DeleteApp extends JFrame implements ActionListener

{

	JLabel tableLabel;//����

	JScrollPane tablePane;//�����ӿ�

	JTable table;//�����б�

	JLabel Labelnum;//ɾ����ʾ

	

	JTextField DeleteText;//ɾ���ı���

	JButton Deletebt;//ɾ����ť

	JButton[] rbts;//��ť�������

	ButtonGroup btGroup;//��ť�飬���߼������������еĵ�ѡ��ť

	

	

	public DeleteApp()

	{

		this.setLayout(null);

		this.setSize(700, 580);

		this.setTitle("������");

		this.setLocation(600,250);

		this.init();

		this.refreshTable();

		this.setVisible(true);

		new Thread().start();

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

		

		Labelnum = new JLabel("���");

		Labelnum.setFont(Labelnum.getFont().deriveFont(Font.BOLD, 16));

		Labelnum.setSize(100,30); 

		Labelnum.setLocation(100,70);

		this.add(Labelnum);

		

		DeleteText = new JTextField();

		DeleteText.setSize(180,30);

		DeleteText.setLocation(170, 70);

		this.add(DeleteText);

		

		Deletebt = new JButton("ɾ��");

		Deletebt.setSize(70, 30);

		Deletebt.setLocation(380, 70);

		Deletebt.addActionListener(new ActionListener()

		{

			@Override

			public void actionPerformed(ActionEvent e) {

				int str=JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ����", "����", JOptionPane.YES_NO_OPTION); 

				if(str==JOptionPane.YES_OPTION)

				{

					//System.out.println("����");

					if(checkIsNull()){

						if(AppDAO.DeleteFlower(DeleteText.getText().trim()))

						{

							final ImageIcon icon = new ImageIcon("Ok.png");

							JOptionPane.showMessageDialog(null,"ɾ���ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE, icon);

							DeleteText.setText("");

							refreshTable();

						}

						else

						{

							JOptionPane.showMessageDialog(null, "ɾ��ʧ��", "��ʾ", JOptionPane.ERROR_MESSAGE);

						}

					}else{

						 final ImageIcon icon1 = new ImageIcon("�����ʺ�3.png");

						 JOptionPane.showMessageDialog(null,"δ����ɾ����Ϣ", "��ʾ", JOptionPane.INFORMATION_MESSAGE, icon1);

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

		

		tableLabel = new JLabel("�����ƾ��ѹ���");	

		tableLabel.setBounds(300,105, 100, 50);

		tableLabel.setFont(new Font("����", Font.BOLD , 20));

		this.add(tableLabel);

		String[] columnNames = {"���","����","����","�Ƽ۵�λ"};

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
		
		System.out.println("����ɾ������");
		

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

	    	  System.out.println("�Ѵ���ɾ��������");

	      }else if(buttonName.equals("����")){

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

					result="����а����������ַ�";

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
