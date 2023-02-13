package src;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-09 14:03
 */
public class L31 {
    //31. 下一个排列
    //整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
    //
    //例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
    //整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
    //
    //例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
    //类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
    //而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
    //给你一个整数数组 nums ，找出 nums 的下一个排列。
    //
    //必须 原地 修改，只允许使用额外常数空间。
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }
        int firstindex=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                firstindex=i;
                break;
            }
        }

        if(firstindex==-1){
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int secondIndex=-1;
        //从尾挨个遍历
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[firstindex]){
                secondIndex=i;
                break;
            }
        }
        swap(nums, firstindex, secondIndex);
        reverse(nums,firstindex+1, nums.length-1);
        return;
    }

    void reverse(int[] nums,int start,int end){
        while (start <  end) {
            swap(nums, start++, end--);
        }
    }

    void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }
}
