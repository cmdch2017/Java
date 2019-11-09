
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ActionEventTest extends JFrame implements ActionListener,MouseListener,WindowListener
{
	public JButton[] bts;
	
	public ActionEventTest()
	{
		this.setSize(300, 150);
		this.setTitle("动作事件实例");
		bts=new JButton[3];
		String[] colors={"红色","蓝色","绿色"};
		this.setLayout(null);
		for(int i=0;i<bts.length;i++)
		{
			bts[i]=new JButton(colors[i]);
			bts[i].setSize(60, 30);
			bts[i].setLocation(30+i*70, 40);
			//ActionDeal deal=new ActionDeal();
			//deal.frame=this;
			//bts[i].addActionListener(this);
			bts[i].addMouseListener(this);
			//将事件源和事件处理对象绑定
			this.add(bts[i]);
		}
		//bts[0].addActionListener(this);
		//this.addWindowListener(this);
		this.addWindowListener(new WindowTest());
		this.setVisible(true);
	}
	
	//具体处理动作事件的代码
	public void actionPerformed(ActionEvent e)
	{
		JButton sourceBt=(JButton)e.getSource();
		//获取事件源，并强制转换为按钮对象
		String colorTxt=sourceBt.getText();
		//获取按钮上的文本
		if(colorTxt.equals("红色"))
		{
			this.getContentPane().setBackground(Color.RED);
		}
		else
		{
			if(colorTxt.equals("蓝色"))
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
			//获取事件源，并强制转换为按钮对象
			String colorTxt=sourceBt.getText();
			//获取按钮上的文本
			if(colorTxt.equals("红色"))
			{
				this.getContentPane().setBackground(Color.RED);
			}
			else
			{
				if(colorTxt.equals("蓝色"))
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
		 //获取事件源，并强制转换为按钮对象
		 sourceBt.setBackground(Color.yellow);
	 }
	 public void mouseExited(MouseEvent e)
	 {
		 JButton sourceBt=(JButton)e.getSource();
		 //获取事件源，并强制转换为按钮对象
		 sourceBt.setBackground(Color.white);
	 }
	 
	    public void windowOpened(WindowEvent e)
	    {
	    	System.out.println("窗体已经打开");
	    }
	    public void windowClosing(WindowEvent e){
	    	System.out.println("窗体正在关闭");
	    }
	    public void windowClosed(WindowEvent e){
	    	System.out.println("窗体已经关闭");
	    }
	    public void windowIconified(WindowEvent e){
	    	System.out.println("窗体最小化");
	    }
	    public void windowDeiconified(WindowEvent e){
	    	System.out.println("窗体最大化");
	    }
	    public void windowActivated(WindowEvent e){
	    	System.out.println("窗体获得焦点");
	    }
	    public void windowDeactivated(WindowEvent e){
	    	System.out.println("窗体失去焦点");
	    }
	
}

