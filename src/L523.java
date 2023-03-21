import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L523 {
    //给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
    //
    //子数组大小 至少为 2 ，且
    //子数组元素总和为 k 的倍数。
    //如果存在，返回 true ；否则，返回 false 。
    //
    //如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [23,2,4,6,7], k = 6
    //输出：true
    //解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
    //示例 2：
    //
    //输入：nums = [23,2,6,4,7], k = 6
    //输出：true
    //解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
    //42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
    //示例 3：
    //
    //输入：nums = [23,2,6,4,7], k = 13
    //输出：false
    List<List<Integer>> Result=new ArrayList<>();
    LinkedList<Integer> Path=new LinkedList<>();
    public boolean checkSubarraySum1(int[] nums, int k) {
        //回溯
        //    //给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
        //    //
        //    //子数组大小 至少为 2 ，且
        //    //子数组元素总和为 k 的倍数。
        Backtarcking(nums,k,0,0);
        return true;
    }

    void Backtarcking(int[] nums,int k,int startindex,int sum){
        if(isTure(sum)||startindex== nums.length-1){
            Result.add(new ArrayList<>(Path));
            return;
        }
        for(int i=startindex;i<nums.length;i++){
            sum+=nums[i];
            Path.add(nums[i]);
            Backtarcking(nums,k,i+1,sum);
            int temp=Path.getLast();
            sum-=temp;
            Path.removeLast();
        }
    }

     boolean isTure(int sum){
        return true;
     }

    public boolean checkSubarraySum(int[] nums, int k){
        boolean Flag=false;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                //当前判断的字串为哪些？
                //比如第一次进 0 1
                if(isTure(nums,i,j,k)){
                    Flag=true;
                    break;
                }
            }
        }
        return Flag;
    }

    boolean isTure(int[] nums,int left,int right,int k){
        if(right+1-left<2){
            return false;
        }
        int sum=0;
        for(int i=left;i<right+1;i++){
            sum=sum+nums[i];
        }
        boolean Flag=false;
        if(sum%k==0||sum==0){
            Flag=true;
        }
        return Flag;

    }



}
