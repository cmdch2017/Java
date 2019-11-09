package identifyingCode;
import java.awt.*;
import java.util.Random;
public class identifyingCode {
public static void main(String[] args) {
	final Frame frame =new Frame("��֤��");
	final Panel panel =new MyPanel();
	frame.add(panel);
	frame.setSize(200,100);//�����ھ���
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
}
}
class MyPanel extends Panel{
	public void paint(Graphics g) {
		int width=160;
		int height=40;
		g.setColor(Color.LIGHT_GRAY);//������������ɫ
		g.fillRect(0,0, width, height);//��֤�뱳��
		g.setColor(Color.BLACK);
		g.drawRect(0,0, width-1, height-1);//���ñ߿�
		//���Ƹ��ŵ�
		Random r=new Random();
		for(int i=0;i<100;i++) {
			int x=r.nextInt(width)-2;
			int y=r.nextInt(width)-2;
			g.drawOval(x, y, 2, 2);
		}
		g.setFont(new Font("����",Font.BOLD,30));
		g.setColor(Color.BLUE);//��֤����ɫ
		//���������֤��
		char[] chars= ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFG"
		+"HIJKLMNOPQRSTUVWXYZ").toCharArray();
		StringBuilder sb=new StringBuilder();
		for (int i=0;i<4;i++) {
			int pos=r.nextInt(chars.length);
			char c=chars[pos];
			sb.append(c+" ");
		}
		g.drawString(sb.toString(), 20, 30);
	}
}