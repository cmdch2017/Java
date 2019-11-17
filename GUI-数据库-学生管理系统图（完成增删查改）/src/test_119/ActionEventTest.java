package test_119;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ActionEventTest extends JFrame implements ActionListener,MouseListener,WindowListener
{
	public JButton[] bts;
	
	public ActionEventTest()
	{
		this.setSize(300, 150);
		this.setTitle("�����¼�ʵ��");
		bts=new JButton[3];
		String[] colors={"��ɫ","��ɫ","��ɫ"};
		this.setLayout(null);
		for(int i=0;i<bts.length;i++)
		{
			bts[i]=new JButton(colors[i]);
			bts[i].setSize(60, 30);
			bts[i].setLocation(30+i*70, 40);
			bts[i].addMouseListener(this);
			this.add(bts[i]);
		}
		this.addWindowListener(new WindowTest());
		this.setVisible(true);
	}
	
	//���崦�����¼��Ĵ���
	public void actionPerformed(ActionEvent e)
	{
		JButton sourceBt=(JButton)e.getSource();
		//��ȡ�¼�Դ����ǿ��ת��Ϊ��ť����
		String colorTxt=sourceBt.getText();
		//��ȡ��ť�ϵ��ı�
		if(colorTxt.equals("��ɫ"))
		{
			this.getContentPane().setBackground(Color.RED);
		}
		else
		{
			if(colorTxt.equals("��ɫ"))
			{
				this.getContentPane().setBackground(Color.blue);
			}
			else
			{
				this.getContentPane().setBackground(Color.green);
			}
		}
	}
	
	 public void mouseClicked(MouseEvent e)
	 {
		 JButton sourceBt=(JButton)e.getSource();
			//��ȡ�¼�Դ����ǿ��ת��Ϊ��ť����
			String colorTxt=sourceBt.getText();
			//��ȡ��ť�ϵ��ı�
			if(colorTxt.equals("��ɫ"))
			{
				this.getContentPane().setBackground(Color.RED);
			}
			else
			{
				if(colorTxt.equals("��ɫ"))
				{
					this.getContentPane().setBackground(Color.blue);
				}
				else
				{
					this.getContentPane().setBackground(Color.green);
				}
			}
	 }
	 public void mousePressed(MouseEvent e){}
	 public void mouseReleased(MouseEvent e){}
	 public void mouseEntered(MouseEvent e)
	 {
		 JButton sourceBt=(JButton)e.getSource();
		 //��ȡ�¼�Դ����ǿ��ת��Ϊ��ť����
		 sourceBt.setBackground(Color.yellow);
	 }
	 public void mouseExited(MouseEvent e)
	 {
		 JButton sourceBt=(JButton)e.getSource();
		 //��ȡ�¼�Դ����ǿ��ת��Ϊ��ť����
		 sourceBt.setBackground(Color.white);
	 }
	 
	    public void windowOpened(WindowEvent e)
	    {
	    	System.out.println("�����Ѿ���");
	    }
	    public void windowClosing(WindowEvent e){
	    	System.out.println("�������ڹر�");
	    }
	    public void windowClosed(WindowEvent e){
	    	System.out.println("�����Ѿ��ر�");
	    }
	    public void windowIconified(WindowEvent e){
	    	System.out.println("������С��");
	    }
	    public void windowDeiconified(WindowEvent e){
	    	System.out.println("�������");
	    }
	    public void windowActivated(WindowEvent e){
	    	System.out.println("�����ý���");
	    }
	    public void windowDeactivated(WindowEvent e){
	    	System.out.println("����ʧȥ����");
	    }
	
}

