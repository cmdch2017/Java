package test_119;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class LoginFrame extends JFrame implements ActionListener,MouseListener{
    //���崰���д��ڵĿؼ�
	JLabel userLa,passLa;
	JTextField userTxt;
	JPasswordField passTxt;
	JButton loBt,quitBt;
	
	//�����������е�������壨����ѡ�����Ͳ�����壩
	JPanel selectPa;
	JButton[] selectBts;
	
	
	JPanel controlPa;
	//���ҵĿؼ� 
	JLabel numLa,nameLa;
	JTextField numTxt,nameTxt;
	JButton insertBt;
	JButton findBt;
	JButton updateBt;
	JButton deleteBt;
	
	public LoginFrame()
	{
		this.setSize(400, 300);//���ô���Ĵ�С
		this.setTitle("��¼����");//���ô������

		this.setLayout(null);
		//���ô���Ĳ��ֶ���Ϊ��
		userLa=new JLabel("�û���");//������ǩ
		userLa.setSize(60, 30);
		userLa.setLocation(90, 50);
		this.add(userLa);//����ǩ�ŵ�������
		
		userTxt=new JTextField();//�����ı���
		userTxt.setSize(150, 30);
		userTxt.setLocation(160, 50);
		this.add(userTxt);//���ı���ŵ�������
		
		passLa=new JLabel("��   ��");//������ǩ
		passLa.setSize(60, 30);
		passLa.setLocation(90, 100);
		this.add(passLa);//����ǩ�ŵ�������
		passTxt=new JPasswordField();//���������
		passTxt.setSize(150, 30);
		passTxt.setLocation(160, 100);
		this.add(passTxt);//�������ŵ�������
		loBt=new JButton("��¼");//������ť
		loBt.setSize(60, 30);
		loBt.setLocation(120, 150);
		loBt.addActionListener(this);
		this.add(loBt);//����ť�ŵ�������
		quitBt=new JButton("�˳�");//������ť
		quitBt.setSize(60, 30);
		quitBt.setLocation(210, 150);
		this.add(quitBt);//����ť�ŵ�������*/
		
		
		this.setVisible(true);//���ô���ɼ�
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton bt=(JButton)e.getSource();
		if(bt.getText().equals("��¼"))
		{
		String name=userTxt.getText().trim();
		//��ȡ�û���
		@SuppressWarnings("deprecation")
		String num=passTxt.getText().trim();
		//��ȡѧ��
		StudentDeal deal=new StudentDeal();
		//����ѧ���ļ��������
			if(num.equals(deal.findNumByName(name)))
			{
			//���������ڣ�����ʾ*/
			this.setSize(800, 600);
			//�޸Ĵ���Ĵ�С
			this.setTitle("������");
			this.getContentPane().removeAll();
			//�������ϵ����пؼ��Ƴ�
			initSelectPanel();//��ʼ��ѡ�����
			initControlPa();//��ʼ���������
			}
			else {
			System.out.println("���������������˻�������");
			}
		}
		else
		{
			
			if(bt.getText().equals("����"))
			{
				StudentDeal deal=new StudentDeal();
					String name=deal.findNameByNum(numTxt.getText().trim());
					nameTxt.setText(name);
				
			} else if (bt.getText().equals("¼��")) {
				String newNum=numTxt.getText().trim();
				String newName=nameTxt.getText().trim();
				//�����ظ�����ѧ��
				boolean flag=checked(newNum);
				if(!flag) {
				Insert l=new Insert();
				l.insertStudent(newName, newNum);
				}
				else {
					System.out.println("�����ظ�¼��");
				}
			}
			else if (bt.getText().equals("����")) {
				String newNum=numTxt.getText().trim();
				String newName=nameTxt.getText().trim();
				//�����ظ�����ѧ��
				boolean flag=checked(newNum);
				if(flag) {
				Update l=new Update();
				l.updateStudent(newName, newNum);
				}
				else {
					System.out.println("����������µ�ѧ�ţ�����������");
				}
			}
			else if (bt.getText().equals("ɾ��")) {
				String newNum=numTxt.getText().trim();
				String confirm=nameTxt.getText().trim();
				if(confirm.equals("yes")) {
				Delete l=new Delete();
				l.deleteStudent(newNum);
				}
				else {
					System.out.println("��ȷ����ɾ����ȷ��ɾ����ʾ��confirm:yes");
				}
			}
		}
		
	}
	//���ط���(true-���ظ�)
	private boolean checked(String newNum) {
		// TODO �Զ����ɵķ������
		SelectReview l=new SelectReview();
		List<StudentInfo> o=new ArrayList<>();
		o=SelectReview.select();
		for(StudentInfo i:o) {
			if(newNum.equals(i.getNum())) {
				return true;
			}
		}
		return false;
	}

	private void initSelectPanel()
	{
		selectPa=new JPanel();
		selectPa.setLayout(null);
		selectPa.setSize(200, 600);
		selectPa.setBackground(Color.orange);
		String[] strs={"����ѧ��","ɾ��ѧ��","�޸�ѧ��","����ѧ��"};
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
	    System.out.println(sourceBt.getText());
		String str=sourceBt.getText();
		
		if(str.equals("����ѧ��"))
		{
			controlPa.removeAll();
			//��ղ����������пؼ�
			numLa=new JLabel("������ѧ��");
			numLa.setSize(100, 30);
			numLa.setLocation(30, 30);
			controlPa.add(numLa);
			nameLa=new JLabel("ѧ������");
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
			findBt=new JButton("¼��");
			findBt.setSize(60, 30);
			findBt.setLocation(120, 130);
			findBt.addActionListener(this);
			controlPa.add(findBt);
			this.getContentPane().repaint();
		}
		else if(str.equals("����ѧ��"))
		{
			controlPa.removeAll();
			//��ղ����������пؼ�
			numLa=new JLabel("������ѧ��");
			numLa.setSize(100, 30);
			numLa.setLocation(30, 30);
			controlPa.add(numLa);
			nameLa=new JLabel("ѧ������");
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
			insertBt=new JButton("����");
			insertBt.setSize(60, 30);
			insertBt.setLocation(120, 130);
			insertBt.addActionListener(this);
			controlPa.add(insertBt);
			this.getContentPane().repaint();
		}
		else if(str.equals("ɾ��ѧ��"))
		{
			controlPa.removeAll();
			numLa=new JLabel("������ѧ��");
			numLa.setSize(100, 30);
			numLa.setLocation(30, 30);
			controlPa.add(numLa);
			nameLa=new JLabel("Confirm");
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
			deleteBt=new JButton("ɾ��");
			deleteBt.setSize(60, 30);
			deleteBt.setLocation(120, 130);
			deleteBt.addActionListener(this);
			controlPa.add(deleteBt);
			this.getContentPane().repaint();
		}
		else if(str.equals("�޸�ѧ��"))
		{
			controlPa.removeAll();
			numLa=new JLabel("������ѧ��");
			numLa.setSize(100, 30);
			numLa.setLocation(30, 30);
			controlPa.add(numLa);
			nameLa=new JLabel("����ѧ������");
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
			updateBt=new JButton("����");
			updateBt.setSize(60, 30);
			updateBt.setLocation(140, 130);
			updateBt.addActionListener(this);
			controlPa.add(updateBt);
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
