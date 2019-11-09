package 实验课一;

import java.util.Arrays;
import java.util.Random;

public class Runner {
    private static final Sorts[] sorts = {
            new InsertSort(),
    };

  
    // Arguments
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("error");
            return;
        }

        String order = args[0];
        int size = Integer.parseInt(args[1]);
        int[] array;
        if (order.equals("˳��")) {
            array = buildOrderedArray(size);
        } else if (order.equals("����")) {
            array = buildReversedArray(size);
        } else if (order.equals("���")) {
            array = buildRandomArray(size);
        } else {
            System.out.println("��֧�ֵ�����˳��");
            return;
        }

        testSort(array);
    }

    private static int[] buildRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random(20190830);
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }

        return array;
    }

    private static int[] buildReversedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }

        return array;
    }

    private static int[] buildOrderedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        return array;
    }

    private static void testSort(int[] origin) {

        for (Sorts sort : sorts) {
            int[] array = Arrays.copyOf(origin, origin.length);
            long begin = System.nanoTime();
            sort.sort(array);
            long end = System.nanoTime();

            int[] second = Arrays.copyOf(origin, origin.length);
            Arrays.sort(second);

            if (!Arrays.equals(array, second)) {
                System.out.println("�������");
            }

            System.out.printf("%s: �������ĵ�ʱ����: %.4f ����%n", sort.name(), (end - begin) * 1.0 / 1000 / 1000);
        }
    }
}
