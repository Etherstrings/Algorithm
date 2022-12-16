package src;

public class L238 {


    public int[] productExceptSelf(int[] nums) {
        long num=1L;
        for(Integer a:nums){
            num=num*a;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=(int)num/nums[i];
        }

        return nums;

    }

}
