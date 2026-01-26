package WorkReview.CralBook.Stack;

import java.util.Stack;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-14
 */
public class L739DaliyTemper {
    public int[] dailyTemperatures(int[] temperatures) {
        //单调zhan
        //核心思路 zhan里维护的只能是逐渐变大或者逐渐变小的
        //每次都会维护当前的最大值
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i=0;i<temperatures.length;i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            int value = temperatures[i];
            if (temperatures[stack.peek()] >= value) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && temperatures[stack.peek()] < value) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
}
