package test_930;

import java.util.Timer;

public class TimerTest{
    public static void main(String[] args){
        Timer timer=new Timer();
        MyTimerTask myTask=new MyTimerTask("TimeTask 1");
        timer.schedule(myTask,1000L,1000L);
        MyTimerTask myTask2=new MyTimerTask("TimeTask 2");
        timer.schedule(myTask2,1000L,3000L);
    }
/*当前执行项目TimeTask 1
当前执行项目TimeTask 2
当前执行项目TimeTask 1
当前执行项目TimeTask 1
当前执行项目TimeTask 1
当前执行项目TimeTask 2
当前执行项目TimeTask 1
当前执行项目TimeTask 1
……
*/
/*
 * 当前执行项目TimeTask 1
当前执行项目TimeTask 2
当前执行项目TimeTask 1
当前执行项目TimeTask 1
当前执行项目TimeTask 2
当前执行项目TimeTask 1
当前执行项目TimeTask 1
……
*/

}