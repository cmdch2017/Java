package Consumer;
public class Solution {
	public static void main(String[] args) {
		Stack stack=new Stack();
		Thread producer=new Thread(()->{
			char c;
			for(int i=0;i<10;i++) {
				//“*26”是为了控制随机生成范围为26个字母
				c=(char)(Math.random()*26+'A');
				stack.push(c);
				System.out.println("生产："+c);
				try {
					//每生产一个字符线程休眠一次，休眠时间（ 0.0 to1.0）*1000
					Thread.sleep((int)(Math.random()*1000));
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
		Thread consumer=new Thread(()->{
			char c;
			for(int i=0;i<10;i++) {
				c=stack.pop();
				System.out.println("消费："+c);
				try {
					Thread.sleep((int)(Math.random()*1000));
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
		producer.start();
		consumer.start();
	}
}
