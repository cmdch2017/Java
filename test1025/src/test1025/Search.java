package test1025;

import java.util.ArrayList;

import java.util.List;

public class Search{
public List<Integer> commonBinarySearch(double[] array,double testNumber){
		List<Integer> list=new ArrayList<>();
		int low = 0;
		int high = array.length - 1;
		int middle = 0;			//����middle
		while(low <= high){
			middle = (low + high) / 2;
			if(array[middle] > testNumber){
				//�ȹؼ��ִ���ؼ�����������
				high = middle - 1;
			}else if(array[middle] < testNumber){
				//�ȹؼ���С��ؼ�����������
				low = middle + 1;
			}else if(array[middle]==testNumber){
				while(array[middle]==testNumber) {
					middle++;
				}
				middle--;
				while(array[middle]==testNumber) {
					list.add(middle);
					middle--;
					}
				return list;
			}
		}
		return list;	
	}
}