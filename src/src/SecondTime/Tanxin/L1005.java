package src.SecondTime.Tanxin;

import java.util.stream.IntStream;

/**
 * @author Etherstrings
 * @create 2022-08-24 18:50 SecondTime.Tanxin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1005 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/24 - the current system date.  18:50 - the current system time.  2022 - the current year.  08 - the current month.  24 - the current day of the month.  18 - the current hour.  50 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //怎么变换？
        //每次变换小的负数

        //两次贪心
        //第一次 每次都变最大的负数
        //第二次 每次都找最小的正数
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();


        for(int i=0;i<nums.length;i++){
            if(nums[i]<0&&k>0){
                nums[i]=-nums[i];
                k--;
            }
        }
        if(k%2==1){
            nums[nums.length-1]=-nums[nums.length-1];
        }
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        return sum;
    }
}
