package list;

public interface List {
	 // β��
    boolean add(int element);
    // �����ݲ��뵽 index �±괦
    boolean add(int index, int element);

    int get(int index);

    int set(int index, int val);

    // ɾ��ָ��λ�õ�����
    int remove(int index);

    int size();

    boolean isEmpty();

    Iterator iterator();
}
