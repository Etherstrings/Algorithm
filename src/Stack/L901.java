package Stack;

import java.util.Stack;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-10-07
 */
public class L901 {
    class StockSpanner{
        //输入： ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"] [[], [100], [80], [60], [70], [60], [75], [85]]
        //输出： [null, 1, 1, 1, 2, 1, 4, 6]
        Stack<int[]> stack;
        int index;
        public StockSpanner() {
            stack=new Stack<>();
            index=0;
            stack.push(new int[]{Integer.MAX_VALUE,0});
        }

        public int next(int price) {
            index++;
            while (stack.peek()[0]<=price){
                stack.pop();
            }
            int ans=index-stack.peek()[1];
            stack.push(new int[]{price,index});
            return ans;
        }
    }

}
