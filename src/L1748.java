import java.util.HashSet;

/**
 * @author Etherstrings
 * @create 2022-02-06 10:50
 */
public class L1748 {
    /**
     *
     * @param nums
     * @return
     *
     * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
     *
     * 请你返回 nums 中唯一元素的 和 。
     */
    public int sumOfUnique(int[] nums) {
        HashSet<Integer> Answer=new HashSet<>();
        HashSet<Integer> ShowUp=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(Answer.contains(nums[i])){
                Answer.remove(nums[i]);
                ShowUp.add(nums[i]);
            }else{
                if(!ShowUp.contains(nums[i])){
                Answer.add(nums[i]);}
            }
        }
        int sum=0;
        for(int i:Answer){
            sum+=i;
        }
        return sum;
    }
}
