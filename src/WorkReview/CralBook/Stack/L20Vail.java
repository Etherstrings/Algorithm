package WorkReview.CralBook.Stack;

import java.util.Objects;
import java.util.Stack;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-14
 */
public class L20Vail {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || Objects.equals(s,"")) {
            return false;
        }
        for (Character now : s.toCharArray()) {
            if (now == '(') {
                stack.push(')');
            } else if (now == '[') {
                stack.push(']');
            } else if (now == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek()!= now) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
