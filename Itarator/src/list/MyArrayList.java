package list;

import java.util.Arrays;

public class MyArrayList implements List {
    // �����ص�ģ��
    // 1. �ô�����ʡ�ռ䣬�õ�ʱ��������
    // 2. ��������һ�õ�ʱ����ʱ��ƽʱ����
    int[] array = null;
    int size = 0;
    class iterator implements Iterator{
        int current;
        iterator(int current){
        	this.current=current;
        }
		@Override
		public boolean hasNext() {
			// TODO �Զ����ɵķ������
			return current<size;
		}

		@Override
		public int next() {
			// TODO �Զ����ɵķ������
			return array[current++];
		}

		@Override
		public int remove() {
			// TODO �Զ����ɵķ������
			if(size==0)
				return -1;
			if(current+1<size)
			System.arraycopy(array, current+1, array, current, size-current-1);
			else {
				current=0;//ɾ��������
			}
			return 0;
		}
    	
    }
    private void ensureCapacity() {
        // 1. ����������ã�ֱ�ӷ���
        if (array != null && size < array.length) {
            return;
        }

        // 2. �����µ�������С
        int capacity;
        if (array == null) {
            capacity = 10;
        } else {
            capacity = 2 * array.length;
        }

        // 3. �����¿ռ� - ��� - ������Ȧ
        if (array != null) {
            array = Arrays.copyOf(array, capacity);
        } else {
            array = new int[capacity];
        }
    }


    @Override
    public boolean add(int element) {
        return add(size, element);
    }

    @Override
    public boolean add(int index, int element) {
        // 1. �±���
        if (index < 0 || index > size) {
            System.out.println("�±����");
            return false;
        }

        // 2. ȷ���ռ乻��
        ensureCapacity();

        // 3. Ϊ index �±꣬�ڳ�λ����
        System.arraycopy(array, index, array, index + 1, size - index);

        // 4. ����
        array[index] = element;

        // 5. �������
        size++;

        return true;
    }

    @Override
    public int get(int index) {
        // 1. �ж��±�Ϸ���
        if (index < 0 || index >= size) {
            System.out.println("�±����");
            return -1;
        }

        return array[index];
    }

    @Override
    public int set(int index, int val) {
        // 1. �ж��±�Ϸ���
        if (index < 0 || index >= size) {
            System.out.println("�±����");
            return -1;
        }

        int oldVal = array[index];
        array[index] = val;

        return oldVal;
    }

    @Override
    public int remove(int index) {
        // 1. �ж��±�Ϸ���
        if (index < 0 || index >= size) {
            System.out.println("�±����");
            return -1;
        }

        int oldValue = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}