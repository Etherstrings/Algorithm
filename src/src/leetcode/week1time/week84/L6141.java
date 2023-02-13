package src.leetcode.week1time.week84;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-08-07 11:32 leetcode.week1time.week84 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6141 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/7 - the current system date.  11:32 - the current system time.  2022 - the current year.  08 - the current month.  07 - the current day of the month.  11 - the current hour.  32 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L6141 {
    //6141. 合并相似的物品

    //题目难度Easy
    //给你两个二维整数数组 items1 和 items2 ，表示两个物品集合。每个数组 items 有以下特质：
    //
    //items[i] = [valuei, weighti] 其中 valuei 表示第 i 件物品的 价值 ，weighti 表示第 i 件物品的 重量 。
    //items 中每件物品的价值都是 唯一的 。
    //请你返回一个二维数组 ret，其中 ret[i] = [valuei, weighti]， weighti 是所有价值为 valuei 物品的 重量之和 。
    //
    //注意：ret 应该按价值 升序 排序后返回
    //
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        //物品价值+物品的重量
        HashMap<Integer,Integer> Judge=new HashMap<>();
        //用于对价值表排序的List
        for(int[] a:items1){
            //第一次遍历 里面不会出现哈希表不相同的情况
            Judge.put(a[0],a[1]);
        }
        for(int[] a:items2){
            //如果出现价值相同的情况
            if(Judge.containsKey(a[0])){
                Judge.put(a[0],Judge.get(a[0])+a[1]);
            }else {
                Judge.put(a[0],a[1]);
            }
        }
        List<Integer> temp=new ArrayList<>();
        Set<Integer> keys=Judge.keySet();
        for(Integer a:keys){
            temp.add(a);
        }
        Collections.sort(temp);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<temp.size();i++){
            List<Integer> everytemp=new ArrayList<>();
            everytemp.add(temp.get(i));
            everytemp.add(Judge.get(temp.get(i)));
            ans.add(everytemp);
        }
        return ans;


    }
}
