package ≈≈–Ú;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Person{
	String name;
	public int age;
}
public class A {
public static void bubbleSort(Person[] array,Comparator <Person> comparator) {
	for(int i=0;i<array.length-1;i++) {
		for(int j=0;j<array.length-i-1;j++) {
			int r=comparator.compare(array[j],array[j+1]);
			if(r>0)
				swap(array,j,j+1);
		}
	}
}
public static void swap(Person[] array,int p,int q) {
Person temp=array[p];
array[p]=array[q];
array[q]=temp;
}
public static void main(String[] args) {
	Person[] people=new Person[10];
	Arrays.sort(people);
	Arrays.sort(people,new PersonRankComparator());
	List<Person> people1=new ArrayList<>();
	people1.sort(new PersonRankComparator());
}
}
