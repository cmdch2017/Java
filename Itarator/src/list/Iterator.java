package list;

public interface Iterator {
	  // �жϵ������Ƿ��ߵ������Ա����
    boolean hasNext();

    // 1. �õ�����������һ����2. ���ص�ǰֵ
    int next();

    // ɾ����ǰ�����������ֵ
    int remove();
}
