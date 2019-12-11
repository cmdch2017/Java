package test_12171;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class FZXJProblem {

    // ׼�����뱳���е���Ʒ
    private Knapsack[] bags;
    // �������ܳ���
    private int totalWeight;
    // ��������Ʒ��
    private int n;
    // ��Ʒ���뱳�����Ի�õ�����ֵ
    private int bestValue;

    public FZXJProblem(Knapsack[] bags, int totalWeight) {
        super();
        this.bags = bags;
        this.totalWeight = totalWeight;
        this.n = bags.length;
        // ��Ʒ���ݵ�λ������ֵ��������
        Arrays.sort(bags, Collections.reverseOrder());
    }

    // ����ʽ��֧�޽編
    public void solve() {
        LinkedList<Node> nodeList = new LinkedList<Node>();

        // ��ʼ�ڵ㵱ǰ�����͵��ڼ�ֵ��Ϊ0
        nodeList.add(new Node(0, 0, 0));

        while (!nodeList.isEmpty()) {
            // ȡ����������еĵ�һ���ڵ�
            Node node = nodeList.pop();

            if (node.upboundValue >= bestValue && node.index < n) {
                // ��ڵ㣺�ýڵ������Ʒ���뱳���У��ϸ��ڵ�ļ�ֵ+������Ʒ�ļ�ֵΪ��ǰ��ֵ
                int leftWeight = node.currWeight + bags[node.index].getWeight();
                int leftValue = node.currValue + bags[node.index].getValue();
                Node left = new Node(leftWeight, leftValue, node.index + 1);

                // ���뵱ǰ��Ʒ����Ի�õļ�ֵ����
                left.upboundValue = getUpboundValue(left);

                // ����Ʒ���뱳������ڵ���ж�����Ϊ��֤�������������ܳ���
                if (left.currWeight <= totalWeight
                        && left.upboundValue > bestValue) {
                    // ����ڵ���ӵ�������
                    nodeList.add(left);
                    if (left.currValue > bestValue) {
                        // ��Ʒ���뱳�������أ��ҵ�ǰ��ֵ������ǰ��ֵΪ����ֵ
                        bestValue = left.currValue;
                    }
                }

                // �ҽڵ㣺�ýڵ��ʾ��Ʒ�����뱳���У��ϸ��ڵ�ļ�ֵΪ��ǰ��ֵ
                Node right = new Node(node.currWeight, node.currValue,
                        node.index + 1);

                // �����뵱ǰ��Ʒ����Ի�õļ�ֵ����
                right.upboundValue = getUpboundValue(right);

                if (right.upboundValue >= bestValue) {
                    // ���ҽڵ���ӵ�������
                    nodeList.add(right);
                }
            }
        }
    }

    // ��ǰ�����Ľڵ㣬������Ʒ�򲻷�����Ʒ
    class Node {
        // ��ǰ������Ʒ������
        private int currWeight;
        // ��ǰ������Ʒ�ļ�ֵ
        private int currValue;
        // �����뵱ǰ��Ʒ���ܵõ��ļ�ֵ����
        private int upboundValue;
        // ��ǰ����������
        private int index;

        public Node(int currWeight, int currValue, int index) {
            this.currWeight = currWeight;
            this.currValue = currValue;
            this.index = index;
        }
    }

    // ��ֵ����=�ڵ����м�ֵ+����ʣ������*ʣ����Ʒ�����λ������ֵ
    // ����Ʒ�ɵ�λ�����ļ�ֵ�Ӵ�С����ʱ��������ļ�ֵ���޴���������Ʒ��������������С����Ʒ��������
    // �����뱳������ƷԽ��Խ��Խ��ʱ����ֵ����ҲԽ��Խ�ӽ���Ʒ����ʵ�ܼ�ֵ
    private int getUpboundValue(Node n) {

        // ��ȡ����ʣ������
        int surplusWeight = totalWeight - n.currWeight;
        int value = n.currValue;
        int i = n.index;

        while (i < this.n && bags[i].getWeight() <= surplusWeight) {
            surplusWeight -= bags[i].getWeight();
            value += bags[i].getValue();
            i++;
        }

        // ����Ʒ�����޷����뱳����ʱ������ͨ������ʣ������*�¸���Ʒ��λ�����ļ�ֵ�������Ʒ�ļ�ֵ����
        if (i < this.n) {
            value += bags[i].getUnitValue() * surplusWeight;
        }

        return value;
    }

    public int getBestValue() {
        return bestValue;
    }

}
