package test_821;
import java.util.Stack;

 class MinStack {
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public MinStack() {}
    //����ͼƬ����ܻ�д������һ���׻���
    //��Ȼֱ����ôд��һ���������Min��ֵÿ�ζ��ᱻ����
    public void pushError(int x) {
    	int Min=0;
    	//����и����������ֵʱ����һ����Сֵ�Ϳ�����
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
 //����Դ�����иĽ�������Min������
    //�ܽ᣺��ν������Ҫ����ǰһ�α���Min��ֵ����x���бȽϣ�ȴ����ÿ�η���������϶������٣��޷�����Min��ֵ
    //�������������ÿһ���ȼ�¼�ڶ���ջmin.peek()��ֵ������֮ǰ�ķ������бȽ�
    public void push(int x) {
    	//��Ϊÿһ��normal����Ҫpush���͵�������ǰ��
        normal.push(x);
        if (min.empty()) {
        //min.empty�������������ͼ���ĵ�һ�ֱ��������min��ջ��push();
        	min.push(x);
        } else {
        //��Ϊ����������ۣ��������ֵС����push����ֵ���������ֵ�󣬾�push(Min)
        	//���ȼ�¼Min��ֵ��Ϊ��������һ������ʾ����������m����ʾ��Сֵ�ļ�¼
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
