package test_92;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E>{
	private E[] array;
	private int size;
	//警告压制
	//类型安全：未经检查的从 Object[] 到 E[] 的强制类型转换
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		//不能直接写new E[100],原因是泛型无法定义其数组
	array=(E[]) new Object[100];
	size=0;
	}
	public boolean add(E element) {
		return (boolean) (array[size++]=element);
	}
	public void remove() {
		//引用类型顺序表滞空，否则内存泄漏（没被GC回收本应删去的对象）
		array[--size]=null;
	}
	@Override
	public int size() {
		// TODO 自动生成的方法存根
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public Iterator<E> iterator() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public boolean remove(Object o) {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public void clear() {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public E get(int index) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public E set(int index, E element) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public void add(int index, E element) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public E remove(int index) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public int indexOf(Object o) {
		// TODO 自动生成的方法存根
		return 0;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO 自动生成的方法存根
		return 0;
	}
	@Override
	public ListIterator<E> listIterator() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO 自动生成的方法存根
		return null;
	}
}
