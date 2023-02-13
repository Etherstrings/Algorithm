package src.SecondTime.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-07-27 21:40 SecondTime.ArrayList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L977 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/27 - the current system date.  21:40 - the current system time.  2022 - the current year.  07 - the current month.  27 - the current day of the month.  21 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L977 {
    //977. 有序数组的平方
    //给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [-4,-1,0,3,10]
    //输出：[0,1,9,16,100]
    //解释：平方后，数组变为 [16,1,0,9,100]
    //排序后，数组变为 [0,1,9,16,100]
    //示例 2：
    //
    //输入：nums = [-7,-3,2,3,11]
    //输出：[4,9,9,49,121]
    //
    //
    //提示：
    //
    //1 <= nums.length <= 104
    //-104 <= nums[i] <= 104
    //nums 已按 非递减顺序 排序
    //
    //
    //进阶：
    //
    //请你设计时间复杂度为 O(n) 的算法解决本问题
    public int[] sortedSquares(int[] nums) {
        int left=0;
        int right=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                left=i-1;
                break;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                right=i;
                break;
            }
        }
        //全是正的
        if(right==0){
            for(int i=0;i<nums.length;i++){
                nums[i]=nums[i]*nums[i];
            }
            return nums;
        }

        //开始就是0
        if(left==-1){
            for(int i=0;i<nums.length;i++){
                nums[i]=nums[i]*nums[i];
            }
            return nums;
        }

        //有正有负
        //left为正数最大
        //right为正数最小
        int lsize=left-0+1;
        int rsize=nums.length-right;
        int zerosize=nums.length-lsize-rsize;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<zerosize;i++){
            ans.add(0);
        }
        while(left>=0&&right<nums.length){
            if(-nums[left]>nums[right]){
                ans.add(nums[left]*nums[left]);
                left--;
            }else if(-nums[left]<nums[right]){
                ans.add(nums[right]*nums[right]);
                right++;
            }else {
                ans.add(nums[right]*nums[right]);
                left--;
                right++;
            }
        }
        //左边到头 右边没到头
        if(left==-1&&right<nums.length){
            for(int i=right;i<nums.length;i++){
                ans.add(nums[right]*nums[right]);
            }
        }
        //右边到头 左边没到头
        if(right==nums.length&&left>0){
            for(int i=left;i>=0;i--){
                ans.add(nums[left]*nums[left]);
            }
        }
        //左右都到头
        Collections.reverse(ans);
        for(int i=0;i<nums.length;i++){
            nums[i]=ans.get(i);
        }
        return nums;
    }

}
