package DP;

import java.util.Stack;

public class L1124 {
    //1124. 表现良好的最长时间段
    //给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
    //
    //我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
    //
    //所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
    //
    //请你返回「表现良好时间段」的最大长度。
    //
    //
    public int longestWPI(int[] hours) {
        for(int i=0;i<hours.length;i++){
            if (hours[i] > 8) {
                hours[i] = 1;
            } else {
                hours[i] = -1;
            }
        }
        //计算前缀和
        int[] Pre=new int[hours.length+1];
        Pre[0]=0;
        //Pre数组表示什么？
        //0
        //1-第0项的加和 包括第0
        //2-0+1 前两项 包括1
        for(int i=1;i<Pre.length;i++){
            Pre[i]=Pre[i-1]+hours[i-1];
        }
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < hours.length; i++) {
            if (stk.isEmpty() || Pre[stk.peek()] > Pre[i]) {
                stk.push(i);
            }
        }

        int res = 0;
        for (int i = hours.length; i >= 0; i--) {
            while(!stk.isEmpty() && Pre[i] > Pre[stk.peek()]) {
                res = Math.max(i - stk.pop(), res);
            }
        }
        return res;


    }
}
