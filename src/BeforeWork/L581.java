import java.util.Arrays;

public class L581 {

    //给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
    //
    //请你找出符合题意的 最短 子数组，并输出它的长度。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [2,6,4,8,10,9,15]
    //输出：5
    //解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
    //示例 2：
    //
    //输入：nums = [1,2,3,4]
    //输出：0
    //示例 3：
    //
    //输入：nums = [1]
    //输出：0
    public int findUnsortedSubarray(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(nums);
        int left=0;
        int right=0;
        for(int i=0;i<nums.length;i++){
            if(clone[i]!=nums[i]){
                left=i;
                break;
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(clone[i]!=nums[i]){
                right=i;
                break;
            }
        }
        if(left==0&&right==0){
            //左右都没有赋值
            return 0;
        }
        return right-left+1;
    }
}
