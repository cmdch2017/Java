package linkedList;

public abstract class AbstractList implements List{
private int size;
protected abstract void insertInternal(int index,int val);
public void pushFront(int val) {
	insertInternal(0,val);
	size++;
}
public void pushBack(int val) {
	insertInternal(size,val);
	size++;
}
public void insert(int index, int val) {
    if (index < 0 || index > size) {
        System.out.println("ÏÂ±ê´íÎó");
        return;
    }
    insertInternal(index, val);
    size++;
}
public int size() {
    return size;
}
}
