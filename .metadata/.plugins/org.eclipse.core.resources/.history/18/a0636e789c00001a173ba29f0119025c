package test_116;
public class MyRunnable implements Runnable{
    private String name;
    private int ticket=10;
    public void run() {
 
        for(int i=0;i<10;i++){
            if(ticket>0)
                System.out.println(Thread.currentThread().getName()+" "+ticket--);
        }
    }
 
    public MyRunnable(String name) {
        super();
        this.setName(name);
    }
 
    public static void main(String[] args) {
        MyRunnable mr=new MyRunnable("MyRunnable");
        new Thread(mr,"Thread1").start();
        new Thread(mr,"Thread2").start();
        new Thread(mr,"Thread3").start();
 
 
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}