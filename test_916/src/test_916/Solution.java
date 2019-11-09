package test_916;

import java.util.HashMap;
import java.util.HashSet;

class Card{
	int value;
	String color;
	public Card(int value,String color) {
		this.value=value;
		this.color=color;
	}
	/*public int hashCode() {
		return value^color.hashCode();
	}*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
}

public class Solution {
	public static void main(String[] args) {
	Card p=new Card(1,"♠A");
	Card q=new Card(1,"♠A");
	HashSet <Card> set=new HashSet<>();
	set.add(p);
	System.out.println(set.contains(q));
	HashMap<Card,String> map=new HashMap<>();
	map.put(p,"黑桃A");
	System.out.println(map.get(q));
	}

}
