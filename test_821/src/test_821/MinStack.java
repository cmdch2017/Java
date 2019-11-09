package test_821;
import java.util.Stack;

 class MinStack {
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public MinStack() {}
    //根据图片你可能会写出这样一个白话文
    //显然直接这么写有一个问题就是Min的值每次都会被销毁
    public void pushError(int x) {
    	int Min=0;
    	//如果有负数，赋予初值时赋予一个极小值就可以了
    	if(normal.empty()) {
    		normal.push(x);
    		min.push(x);
    		Min=x;
    	}
    	else {
    		if(x<=Min) {
    			normal.push(x);
    			min.push(x);
    			Min=x;
    		}
    		else {
    			normal.push(x);
    			min.push(Min);
    		}
    	}
    }
 //下面对代码进行改进，处理Min的问题
    //总结：如何解决，需要调用前一次遍历Min的值，与x进行比较，却由于每次方法运行完毕都会销毁，无法保存Min的值
    //解决方法：采用每一次先记录第二个栈min.peek()的值，再用之前的方法进行比较
    public void push(int x) {
    	//因为每一次normal都需要push，就调整到最前面
        normal.push(x);
        if (min.empty()) {
        //min.empty的情况就是上面图画的第一种遍历情况，min的栈中push();
        	min.push(x);
        } else {
        //分为两种情况讨论，如果给定值小，就push给定值，如果给定值大，就push(Min)
        	//首先记录Min的值，为了区别上一个错误示范，这里用m来表示最小值的记录
            int m = min.peek();
            if (x <= m) {
                min.push(x);
            } else {
                min.push(m);
            }
        }
    }

    public void pop() {
        normal.pop();
        min.pop();
    }
    public int top() {
        return normal.peek();
    }
    public int getMin() {
        return min.peek();
    }
}
