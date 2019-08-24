import java.util.ArrayList;

public class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> stack = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(': case '[': case '{':
                    stack.add(ch);break;
                case ')': case ']': case '}': {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char left = stack.remove(stack.size() - 1);
//移除数组中最后一个元素，即栈中第一个元素
                    if (!match(left, ch)) { return false; }break;
                }
            }
        }
//结束for循环，遍历结束，栈不为空说明错误
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    private boolean match(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }

        if (left == '[' && right == ']') {
            return true;
        }

        if (left == '{' && right == '}') {
            return true;
        }

        return false;
    }
}