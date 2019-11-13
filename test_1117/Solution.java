package test_1117;

public class Solution {
	static int completeValue=9;
	public static void main(String[] args) {
	int[][] array= {{0,1,1,0},{0,1,4,0},{0,2,2,0}};
	printArrays(array);
	//找到优先级高的前提是什么？
	//所需要的时间不能为0
    //找到优先级高的
	int needTimeAll = 0;
	for(int i=0;i<array.length;i++) {
		needTimeAll+=array[i][1];
	}
	while(needTimeAll!=0) {
	//去个极小值
	int maxValue=-10000;
	int maxIndex=-10;
	for(int i=0;i<array.length;i++) {	
		if(array[i][1]!=0) {
			//maxIndex更新,优先级最高的下标
			if(maxValue<array[i][2]) {
				maxValue=array[i][2];
				maxIndex=i;
			}
		}
	}
	//System.out.println((maxIndex+1)+"优先级最高");
	//优先级最高且所需要的时间不为0，就让此进程运行
	//优先级-1;需要时间-1;
	if(maxIndex==-10) break;
	array[maxIndex][1]--;
	array[maxIndex][2]--;
	array[maxIndex][0]++;
	//如果进程开始运行，即CPUTIME不等于0时，CPUTIME+1
	//遍历整个数组
	for(int i=0;i<array.length;i++) {	
			if(array[i][0]!=0) {
				//如果未完成，就加1
				if(array[i][3]!=completeValue) {
					array[i][0]++;
				}
			}
	}
	//运行加了两次CPUTIME，回调时间
	array[maxIndex][0]--;
	//执行后如果需要时间为0，优先级变为finish

	if(array[maxIndex][1]==0) {
		System.out.println("finish"+(maxIndex+1)+"号进程");
		array[maxIndex][3]=completeValue;
	}
	needTimeAll--;
	printArrays(array);
	}
	}
	private static void printArrays(int[][] array) {
		// TODO 自动生成的方法存根
		System.out.println("CPUTIME"+" NeedTime"+" Priority"+" complete(等于9就是完成数值)");
		for(int[] i:array) {
			for(int j:i) {
			System.out.print(" "+j+"       ");
			}
			System.out.println();
		}
		System.out.println("__________________________________________");
	}
}
