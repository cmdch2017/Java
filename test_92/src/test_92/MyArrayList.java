package test_92;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E>{
	private E[] array;
	private int size;
	//����ѹ��
	//���Ͱ�ȫ��δ�����Ĵ� Object[] �� E[] ��ǿ������ת��
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		//����ֱ��дnew E[100],ԭ���Ƿ����޷�����������
	array=(E[]) new Object[100];
	size=0;
	}
	public boolean add(E element) {
		return (boolean) (array[size++]=element);
	}
	public void remove() {
		//��������˳����Ϳգ������ڴ�й©��û��GC���ձ�Ӧɾȥ�Ķ���
		array[--size]=null;
	}
	@Override
	public int size() {
		// TODO �Զ����ɵķ������
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO �Զ����ɵķ������
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO �Զ����ɵķ������
		return false;
	}
	@Override
	public Iterator<E> iterator() {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public boolean remove(Object o) {
		// TODO �Զ����ɵķ������
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO �Զ����ɵķ������
		return false;
	}
	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO �Զ����ɵķ������
		return false;
	}
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO �Զ����ɵķ������
		return false;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO �Զ����ɵķ������
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO �Զ����ɵķ������
		return false;
	}
	@Override
	public void clear() {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public E get(int index) {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public E set(int index, E element) {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public void add(int index, E element) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public E remove(int index) {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public int indexOf(Object o) {
		// TODO �Զ����ɵķ������
		return 0;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO �Զ����ɵķ������
		return 0;
	}
	@Override
	public ListIterator<E> listIterator() {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO �Զ����ɵķ������
		return null;
	}
}
