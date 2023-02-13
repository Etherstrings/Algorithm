package src.leetcode.week302;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-07-17 10:41 leetcode.week302 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6164 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/17 - the current system date.  10:41 - the current system time.  2022 - the current year.  07 - the current month.  17 - the current day of the month.  10 - the current hour.  41 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L6164 {
    //6164. 数位和相等数对的最大和 显示英文描述
    //通过的用户数821
    //尝试过的用户数926
    //用户总通过次数823
    //用户总提交次数1034
    //题目难度Medium
    //给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。
    //
    //请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [18,43,36,13,7]
    //输出：54
    //解释：满足条件的数对 (i, j) 为：
    //- (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
    //- (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
    //所以可以获得的最大和是 54 。
    //示例 2：
    //
    //输入：nums = [10,12,19,14]
    //输出：-1
    //解释：不存在满足条件的数对，返回 -1 。
    public int maximumSum(int[] nums) {
        if(nums.length<=1){
            return -1;
        }
        int maxsum=0;
        boolean flag=false;
        int pre=0;



        for(int i=0;i<nums.length-1;i++){
            int tempi=sumint(nums[i]);
            for(int j=i+1;j<nums.length;j++){
                int temp=sumint(nums[j]);
                if(temp==tempi){
                    flag=true;
                    maxsum=Math.max(maxsum,nums[i]+nums[j]);
                }else {
                    continue;
                }
            }
        }
        if(flag==false){
            return -1;
        }
        return maxsum;
    }
    int maximumSum1(int[] nums){

        HashMap<Integer, ArrayList<Integer>> Judge=new HashMap<>();
        Set<Integer> SJudge=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(Judge.containsKey(sumint(nums[i]))){
                ArrayList<Integer> integers = Judge.get(sumint(nums[i]));
                integers.add(nums[i]);
                Judge.put(sumint(nums[i]),integers);
            }else {
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(nums[i]);
                Judge.put(sumint(nums[i]),temp);
            }
            SJudge.add(sumint(nums[i]));
        }
        int max=-1;
        for(Integer a:SJudge){
            ArrayList<Integer> temp = Judge.get(a);
            if(temp.size()==1){
                continue;
            }
            Collections.sort(temp);
            max=Math.max(temp.get(temp.size()-1)+temp.get(temp.size()-2),max);
        }
        return max;
    }
    int sumint(int num){
        //求这个数的和
        String temp = Integer.toString(num);
        int sum=0;
        for(Character a:temp.toCharArray()){
            sum+=Character.getNumericValue(a);
        }
        return sum;
    }
}
