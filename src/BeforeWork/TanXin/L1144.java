package TanXin;

/**
 * @author Etherstrings
 * @create 2023-02-27 11:56 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1144 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/27 - the current system date.  11:56 - the current system time.  2023 - the current year.  02 - the current month.  27 - the current day of the month.  11 - the current hour.  56 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L1144 {
    //1144. 递减元素使数组呈锯齿状
    //给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
    //
    //如果符合下列情况之一，则数组 A 就是 锯齿数组：
    //
    //每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
    //或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
    //返回将数组 nums 转换为锯齿数组所需的最小操作次数。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,2,3]
    //输出：2
    //解释：我们可以把 2 递减到 0，或把 3 递减到 1。
    //示例 2：
    //
    //输入：nums = [9,6,1,6,2]
    //输出：4
    public int movesToMakeZigzag(int[] nums) {
        //只有两种情况
        //偶 大于
        //奇 大于
        if(nums.length==1){
            return 0;
        }
        if(nums.length==2){
            if(nums[0]==nums[1]){
                return 1;
            }
            return 0;
        }
        int n=nums.length;

        //先判断偶数
        //判断偶数的时候实际上是遍历奇数
        int ansOu=0;
        int left;
        int right;

        for(int i=1;i<nums.length;i+=2){
                int now=nums[i];
                if(n%2==0){
                    if(i==nums.length-1){
                        left=nums[i-1];
                        if(now>=left){
                            ansOu+=now-left+1;
                        }
                        continue;
                    }
                    continue;
                }
                left=nums[i-1];
                right=nums[i+1];
                if(now<left&&now<right){
                    continue;
                }
                ansOu+=(now-Math.min(left,right)+1);
        }



        //再判断奇数
        //判断奇数的时候实际上是遍历偶数
        int ansOdd=0;
        for(int i=0;i<nums.length;i+=2){
            int now=nums[i];
            if(i==0){
                right=nums[i+1];
                if(now>=right){
                    ansOdd+=(now-right+1);
                }
                continue;
            }
            if(n%2==1){
                if(i==nums.length-1){
                    left=nums[i-1];
                    if(now>=left){
                        ansOdd+=now-left+1;
                    }
                    continue;
                }
                continue;
            }
            left=nums[i-1];
            right=nums[i+1];
            if(now<left&&now<right){
                continue;
            }
            ansOdd+=(now-Math.min(left,right)+1);
        }
        return Math.min(ansOu,ansOdd);
    }
}
