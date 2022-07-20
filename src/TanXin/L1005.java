package TanXin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @author Etherstrings
 * @create 2022-07-14 20:25 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1005 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/14 - the current system date.  20:25 - the current system time.  2022 - the current year.  07 - the current month.  14 - the current day of the month.  20 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L1005 {
    //1005. K 次取反后最大化的数组和
    //给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
    //
    //选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
    //重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
    //
    //以这种方式修改数组后，返回数组 可能的最大和 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [4,2,3], k = 1
    //输出：5
    //解释：选择下标 1 ，nums 变为 [4,-2,3] 。
    //示例 2：
    //
    //输入：nums = [3,-1,0,2], k = 3
    //输出：6
    //解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
    //示例 3：
    //
    //输入：nums = [2,-3,-1,5,-4], k = 2
    //输出：13
    //解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
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

    public int largestSumAfterKNegations_worng(int[] nums, int k) {
        //自己的思路
            //我只想到了第一层的贪心

        //怎么变换？
        //每次变换小的负数
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(i<k){
                nums[i]=-nums[i];
            }
            sum+=nums[i];
        }
        return sum;
    }
}
