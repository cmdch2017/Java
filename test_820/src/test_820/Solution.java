package test_820;
import java.util.*;
class Pokecard{
	int val;
	String color;
	public Pokecard(int val, String color) {
		// TODO 自动生成的构造函数存根
		this.val=val;
		this.color=color;
	}
	@Override
	public String toString() {
		return "Pokecard [val=" + val + ", color=" + color + "]";
	}
	public boolean equals(Object obj) {
		if(obj==null) return false;
		//instanceof
		//返回obj对象能否被Pokecard类型的引用指向
		//obj对象的类型是不是Pokecard类型的小类型
		if(!(obj instanceof Pokecard)) {//是否是它的实例
			return false;
		}
	Pokecard other= (Pokecard) obj;
	return this.val==other.val&&this.color.equals(other.color);
	}
}
public class Solution {
static int initialCapacity=52;
private static void swap(ArrayList<Pokecard> list,int i,int j){
Pokecard temp=list.get(i);
list.set(i,list.get(j));
list.set(j,temp);
}
 public static void main(String[] args) {
	 ArrayList<Pokecard> cards=new ArrayList<Pokecard>(initialCapacity);
	 String[] colors= {"♥","♠","♦","♣"};
	 for(int i=0;i<4;i++) {
		 for(int j=1;j<=13;j++) {
			 Pokecard card=new Pokecard(j,colors[i]);
			 cards.add(card);
		 }
	 }
	// System.out.println(cards.toString());
int seed=11;
 Random random=new Random(seed);
 for(int i=51;i>0;i--){
 int j=random.nextInt(i);
 swap(cards,i,j);
 }
   ArrayList<Pokecard> A=new ArrayList<>();
   ArrayList<Pokecard> B=new ArrayList<>();
   ArrayList<Pokecard> C=new ArrayList<>();
   for(int i=0;i<15;i++) {
	   Pokecard card=cards.remove(cards.size()-1);
	   switch(i%3) {
	   case 0:A.add(card);break;
	   case 1:B.add(card);break;
	   case 2:C.add(card);break;
   }
   }
Pokecard heartA=new Pokecard(1,"♥");
/*for(int i=0;i<cards.size();i++) {
	if(true==A.get(i).equals(heartA)) {
		System.out.println("包含");
		A.remove(heartA);
	}
}*/
if(A.contains(heartA)) {
	System.out.println("包含");
	A.remove(heartA);
}
else {
	System.out.println("不包含");
}
System.out.println(cards.toString());
Iterator<Pokecard> it=A.iterator();
while(it.hasNext()) {
	System.out.println(it.next());
}
 }
 }


