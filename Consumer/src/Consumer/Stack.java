package Consumer;

public class Stack {
	private int pointer=0;
	private char[] data=new char[5];
	public synchronized void push(char c) {
		// TODO 自动生成的方法存根
		while(pointer==data.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		this.notify();
		data[pointer]=c;
		pointer++;
	}

	public synchronized char pop() {
		// TODO 自动生成的方法存根
		while(pointer==0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		this.notify();
		pointer --;
		return data[pointer];
	}

}
