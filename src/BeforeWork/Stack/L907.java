package Stack;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-27
 */
public class L907 {
    //给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
    //
    //由于答案可能很大，因此 返回答案模 10^9 + 7 。
    //
    //示例 1：
    //
    //输入：arr = [3,1,2,4]
    //输出：17
    //解释：
    //子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
    //最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
    //示例 2：
    //
    //输入：arr = [11,81,94,43,3]
    //输出：444
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        // 0 和 1 分别存储每个元素左右两侧第一个比它小的元素的位置
        int[][] rage = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        //先找左边的范围
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) { // 如果栈顶元素大于当前元素，则栈顶元素的右侧第一个比它小的元素就是当前元素
                stack.pop();
            }
            rage[i][0] = stack.isEmpty() ? -1 : stack.peek(); // 如果栈为空，则当前元素左侧第一个比它小的元素不存在，否则就是栈顶元素
            stack.push(i);
        }
        stack.clear();
        //再找右边的范围
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) { // 如果栈顶元素大于等于当前元素，则栈顶元素的左侧第一个比它小的元素就是当前元素
                stack.pop();
            }
            rage[i][1] = stack.isEmpty() ? arr.length : stack.peek(); // 如果栈为空，则当前元素右侧第一个比它小的元素不存在，否则就是栈顶元素
            stack.push(i);
        }
        int result = 0;
        for (int i = 0; i < arr.length; ++i) {
            result = (result + arr[i] * (i - rage[i][0]) * (rage[i][1] - i)) % mod; // 计算每个元素作为最小值的子数组的贡献，并累加到结果中
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        return result;
    }
}
