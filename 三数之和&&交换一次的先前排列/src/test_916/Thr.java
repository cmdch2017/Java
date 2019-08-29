package test_916;
import java.util.*;
//下一节题目思路
//逆着找第一个降序的位置i
//2.从i的右边找比a[i]小的中，最大的一个，如果出现多个，交换最左边的一个
public class Thr {
	public static int[] prevPermOpt1(int[] A) {
		int[] array = A;
		// 3 1 1 3
		int temp=0;
		for(int i=array.length-1;i>0;i--) {
			//先不考虑重复元素怎么办
			if(A[i-1]>A[i]) {
				temp=i-1;//记录位置
				break;
			}
			if(i==1) return array;//升序排序
		}
		int max=Integer.MIN_VALUE;
		int index=0;
		for(int j=temp+1;j<array.length;j++) {
			if(array[temp]>array[j]&&max<array[j]) {
			max=array[j];
            index=j;//index记录max实时位置
			}
		}
		swap(array,index,temp);
		return array;
	}
	private static void swap(int[] array,int index, int temp) {
		// TODO 自动生成的方法存根
		int a=array[index];
		array[index]=array[temp];
		array[temp]=a;
	}
	public static List<List<Integer>> threeSum3(int[] nums){
		Arrays.sort(nums);
		HashSet<List<Integer>> set=new HashSet<>();
		for(int i=0;i<nums.length-2;i++) {
			int j=i+1;
			int k=nums.length-1;
			while(j<k) {
			int sum=nums[i]+nums[j]+nums[k];
			if(sum<0) j++;
			if(sum>0) k--;
			if(sum==0) {
				List<Integer> e=new ArrayList<>();
				e.add(nums[i]);
				e.add(nums[j]);
				e.add(nums[k]);
				set.add(e);
				j++;k--;
			}
			}
		}
		return  new ArrayList<>(set);
	}
	public static List<List<Integer>> threeSum(int[] nums){
	Arrays.sort(nums);
	List<List<Integer>> result= new ArrayList<>();
	int i=0;
	while(i<nums.length-2) {
		int j=i+1;
		int k=nums.length-1;
		while(j<k) {
		while(j<k&&nums[i]+nums[j]+nums[k]<0) {
			j++;
		}
		if(j>=k) {
			break;
		}
		if(nums[i]+nums[j]+nums[k]==0) {
			List<Integer> e=new ArrayList<>();
			e.add(nums[i]);
			e.add(nums[j]);
			e.add(nums[k]);
			result.add(e);
			while(j<k&&nums[k]==nums[k-1]) {
				k--;
			}
			k--;
		}
		}
		i++;
	}
	return result;
	/*
	e.add(-1);
	e.add(0);
	e.add(1);
	result.add(e);
	List<Integer> f=new ArrayList<>();
	e.add(-1);
	e.add(0);
	e.add(1);
	result.add(f);
	*/
}
	public static void main(String[] args) {
		int[] array= {-1,0,1,2,-1,4};
		List<List<Integer>> r=threeSum3(array);
		System.out.println(r);
		int[] array1= {3,2,1};
		int[] array2= {1,9,4,6,7};
		int[] array3= {1,1,5};
		System.out.println(Arrays.toString(prevPermOpt1(array1)));
		System.out.println(Arrays.toString(prevPermOpt1(array2)));
		System.out.println(Arrays.toString(prevPermOpt1(array3)));
	}
}
