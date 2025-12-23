package WorkReview.CralBook.StackAndList;

import java.util.Stack;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-04
 */
public class L2211CarAccicent {
    //碰撞
    public static int countCollisions(String directions) {
        Stack<String> stack = new Stack<>();
        int ans = 0;
        for (Character dir:directions.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(dir+"");
                continue;
            }
            if (dir == 'S') {
                //现在进来的这个车是停止的
                //那就只会和向右的碰,并且一堆R都会碰
                if (stack.peek().equals("R")) {
                    while (!stack.isEmpty() && stack.peek().equals("R")) {
                        ans += 1;
                        stack.pop();
                    }
                    stack.push("S");
                } else {
                    stack.push("S");
                }
                continue;
            }
            if (dir == 'R') {
                //向右的
                stack.push("R");
                continue;
            }
            if (dir == 'L') {
                //向左
                if (stack.peek().equals("R")) {
                    ans += 1;
                    while (!stack.isEmpty() && stack.peek().equals("R")) {
                        ans += 1;
                        stack.pop();
                    }
                    stack.push("S");
                } else if (stack.peek().equals("S")) {
                    ans += 1;
                    stack.push("S");
                } else {
                    stack.push("L");
                }
                continue;
            }
        }
        return ans;
    }
}
