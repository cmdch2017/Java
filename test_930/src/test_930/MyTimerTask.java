package test_930;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask{
    private String taskName;
    public MyTimerTask(String taskName){
        this.taskName=taskName;
    }
    public String getTaskname(){
        return taskName;
    }
    public void setTaskName(String taskName){
        this.taskName=taskName;
    }
	@Override
	public void run() {
		System.out.println("当前执行项目"+taskName);
	}
   
}


