package WorkReview.CralBook.StackAndList;

import java.util.Objects;
import java.util.Stack;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-03
 */
public class L20 {
    public static void main(String[] args) {
        System.out.println(isValidStr("([}}])"));
    }
    public static boolean isValidStr(String s) {
        //核心思路是等右入的时候再去启动判断
        if (s == null) {
            return false;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Objects.equals('(', c)) {
                stack.push(')');
                continue;
            }
            if (Objects.equals('[', c)) {
                stack.push(']');
                continue;
            }
            if (Objects.equals('{', c)) {
                stack.push('}');
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (stack.peek() != c) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
