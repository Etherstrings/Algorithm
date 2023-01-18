import static java.lang.Math.max;

/**
 * @author Justice_wby
 * @create 2023-01-15 17:17
 */
public class L2293 {
    public int minMaxGame(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        while(nums.length!=1){
            int[] nnums=new int[nums.length/2];
            for(int i=0;i<nnums.length;i++){
                if(i%2==0){
                    nnums[i]=Math.min(nums[2 * i], nums[2 * i + 1]);
                }else {
                    nnums[i]=Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums=nnums;
        }
        return nums[0];
    }

    static void Digui(int[] nums){
        if(nums.length==1){
            return;
        }
        int[] nnums=new int[nums.length/2];
        for(int i=0;i<nnums.length;i++){
            if(i%2==0){
                nnums[i]=Math.min(nums[2 * i], nums[2 * i + 1]);
            }else {
                nnums[i]=max(nums[2 * i], nums[2 * i + 1]);
            }
        }
        nums=nnums;
        Digui(nums);
    }
}
