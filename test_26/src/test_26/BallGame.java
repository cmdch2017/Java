package test_26;

import java.awt.*;

public class BallGame extends Frame{
	public static void main(String[] args) {
		BallGame l=new BallGame();
		l.lauchFrame();
	}
	private void lauchFrame() {
		// TODO �Զ����ɵķ������
		setSize(856,480);
		setLocation(50,50);
		setTitle("test");
		setVisible(true);
		while(true) {
			repaint();
			try {
				Thread.sleep(40);
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	Image ball=Toolkit.getDefaultToolkit().getImage("ball.png");
	Image desk=Toolkit.getDefaultToolkit().getImage("desk.jpg");
	double x=100;double y=100;double degree=3.14/3;
	public void paint(Graphics g) {
		//System.out.println("���ڱ�����һ��");
		g.drawImage(desk, 0, 0,null);
		g.drawImage(ball, (int)x,(int)y,null);
		
		x=x+10*Math.cos(degree);
		y+=10*Math.sin(degree);
		
		//�Ldegree=-degree;
		//�Jdegree=3.14-degree;
		if(y>480-30-40) {
			degree=-degree;
		}
		if(x>856-30-40) {
			degree=3.14-degree;
		}
		if(x<20+20) {
			degree=3.14-degree;
		}
		if(y<20+20) {
			degree=-degree;
		}
	}
}
