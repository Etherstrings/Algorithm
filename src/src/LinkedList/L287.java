package src.LinkedList;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-12 13:42
 */
public class L287 {
    //287. 寻找重复数
    //给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
    //
    //假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
    //
    //你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,3,4,2,2]
    //输出：2
    //示例 2：
    //
    //输入：nums = [3,1,3,4,2]
    //输出：3
    //
    //
    //提示：
    //
    //1 <= n <= 105
    //nums.length == n + 1
    //1 <= nums[i] <= n
    //nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
    public int findDuplicate(int[] nums) {
        //实际上是图论
        //0指向nums[0]
        //nums[0]指向nums[nums[0]]

        //[1,3,4,2,2]
        //n f(n)
        //f(0)=1;
        //f(1)=3;
        //f(2)=4;
        //f(3)=2;
        //f(4)=2;
        int slow=0;
        int fast=0;
        slow=nums[slow];
        fast=nums[fast];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }

        int pre1=0;
        int pre2=slow;
        while(pre1!=pre2){
            pre1=nums[pre1];
            pre2=nums[pre2];
        }
        return pre1;
    }
}
