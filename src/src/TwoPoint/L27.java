package src.TwoPoint;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-09 15:00
 */
public class L27 {
    public int removeElement(int[] nums, int val) {
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
