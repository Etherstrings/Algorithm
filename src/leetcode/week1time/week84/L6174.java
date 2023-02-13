package leetcode.week1time.week84;

import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-08-07 12:06 leetcode.week1time.week84 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6174 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/7 - the current system date.  12:06 - the current system time.  2022 - the current year.  08 - the current month.  07 - the current day of the month.  12 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L6174 {
    //6174. 任务调度器 II 显示英文描述
    //通过的用户数1955
    //尝试过的用户数2467
    //用户总通过次数2014
    //用户总提交次数5120
    //题目难度Medium
    //给你一个下标从 0 开始的正整数数组 tasks ，表示需要 按顺序 完成的任务，其中 tasks[i] 表示第 i 件任务的 类型 。
    //
    //同时给你一个正整数 space ，表示一个任务完成 后 ，另一个 相同 类型任务完成前需要间隔的 最少 天数。
    //
    //在所有任务完成前的每一天，你都必须进行以下两种操作中的一种：
    //
    //完成 tasks 中的下一个任务
    //休息一天
    //请你返回完成所有任务所需的 最少 天数。
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer,Long> Judge=new HashMap<>();
        long ans=0;
        long zero=0;
        for(int i:tasks){
            if(ans>=Judge.getOrDefault(i,zero)){
                ans++;
            }else {
                ans=Judge.get(i)+1;
            }
            Judge.put(i,ans+space);

        }
        return ans;
    }

}
