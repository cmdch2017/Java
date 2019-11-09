package 实验课一;
public class InsertSort implements Sorts {
    @Override
    public String name() {
        return "ֱ�Ӳ�������";
    }

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int key = array[i + 1];
            int j;
            for (j = i; j >= 0 && array[j] > key; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }
}
