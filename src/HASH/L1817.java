package HASH;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Justice_wby
 * @create 2023-01-20 10:46
 */
public class L1817 {
    //1817. 查找用户活跃分钟数
    //给你用户在 LeetCode 的操作日志，和一个整数 k 。日志用一个二维整数数组 logs 表示，其中每个 logs[i] = [IDi, timei] 表示 ID 为 IDi 的用户在 timei 分钟时执行了某个操作。
    //
    //多个用户 可以同时执行操作，单个用户可以在同一分钟内执行 多个操作 。
    //
    //指定用户的 用户活跃分钟数（user active minutes，UAM） 定义为用户对 LeetCode 执行操作的 唯一分钟数 。 即使一分钟内执行多个操作，也只能按一分钟计数。
    //
    //请你统计用户活跃分钟数的分布情况，统计结果是一个长度为 k 且 下标从 1 开始计数 的数组 answer ，对于每个 j（1 <= j <= k），answer[j] 表示 用户活跃分钟数 等于 j 的用户数。
    //
    //返回上面描述的答案数组 answer 。
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        //用户 - 活跃的分钟
        Map<Integer, HashSet<Integer>> map=new HashMap<>();
        for(int[] log:logs){
            int user=log[0];
            int time=log[1];
            if(map.containsKey(user)){
                HashSet<Integer> temp=map.get(user);
                temp.add(time);
                map.put(user,temp);
            }else {
                HashSet<Integer> temp=new HashSet<>();
                temp.add(time);
                map.put(user,temp);
            }
        }
        int[] ans=new int[k];
        Arrays.fill(ans,0);
        for(Integer key:map.keySet()){
            int size=map.get(key).size();
            ans[--size]++;
        }
        return ans;
    }

}
