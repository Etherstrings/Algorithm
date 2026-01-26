package WorkReview.CralBook.Stack;

import java.util.Objects;
import java.util.Stack;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-14
 */
public class L394DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
    //394. 字符串解码

    //示例 1：
    //
    //输入：s = "3[a]2[bc]"
    //输出："aaabcbc"
    public static String decodeString(String s) {
        if (s==null || Objects.equals(s,"")) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (Character now : s.toCharArray()) {
            if (now==']') {
                //找到对应的字符 找到一个'[' 中间的就是字符
                sb = new StringBuilder();
                while (!(stack.peek() == '[')) {
                    sb.append(stack.pop());
                }
                stack.pop();
                String temp = sb.reverse().toString();
                //找到数字 第一个不是数字的值
                sb = new StringBuilder();
                boolean flag = true;
                while (flag) {
                    if (stack.isEmpty()) {
                        flag = false;
                        continue;
                    }
                    if (!Character.isDigit(stack.peek())) {
                        flag = false;
                        continue;
                    } else {
                        sb.append(stack.pop());
                    }
                }
                Integer num = Integer.parseInt(sb.reverse().toString());
                for (int i=0;i<num;i++) {
                    for (Character n : temp.toCharArray()) {
                        stack.push(n);
                    }
                }
            } else {
                stack.push(now);
            }
        }
        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
