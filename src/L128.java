import org.junit.Test;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-06-13 16:06 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L128 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/13 - the current system date.  16:06 - the current system time.  2022 - the current year.  06 - the current month.  13 - the current day of the month.  16 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L128 {
    //128. 最长连续序列
    //给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    //
    //请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [100,4,200,1,3,2]
    //输出：4
    //解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
    //示例 2：
    //
    //输入：nums = [0,3,7,2,5,8,4,6,0,1]
    //输出：9

    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        Arrays.sort(nums);


        //滑动窗口

        int slow=0;
        int length=0;

        //窗口里的是递增的
        for(int fast=1;fast<nums.length;fast++){
            if(nums[fast]-nums[fast-1]==1){
                if(fast==nums.length-1){
                    length=Math.max(length,fast+1-slow);
                    break;
                }
                continue;
            }else if(nums[fast]-nums[fast-1]==0){
                slow++;
                if(fast==nums.length-1){
                    length=Math.max(length,fast+1-slow);
                    break;
                }
                continue;
            } else {
                length=Math.max(length,fast-slow);
                slow=fast;
                fast++;

            }
        }
        return length;
    }

    public int longestConsecutive1(int[] nums) {
        //换个思路
        //这回用set存

        Set<Integer> Judge=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            Judge.add(nums[i]);
        }
        if(Judge.size()==1){
            return 1;
        }
        ArrayList<Integer> rel=new ArrayList<>();

        for(Integer a:Judge){
            rel.add(a);
        }

        Collections.sort(rel);
        int length=0;
        int slow=0;
        for(int i=1;i<rel.size();i++){
            if(rel.get(i)- rel.get(i-1)==1){
                length=Math.max(length,i+1-slow);
                continue;
            }else {
                length=Math.max(length,i-slow);
                slow=i;
                i++;
            }
        }
        return length;
    }

    @Test
    void test(){
        int[] nums={4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        System.out.println(longestConsecutive(nums));
    }

}
