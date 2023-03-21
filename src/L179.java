import java.util.Arrays;

public class L179 {
    //给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
    //
    //注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [10,2]
    //输出："210"
    //示例 2：
    //
    //输入：nums = [3,30,34,5,9]
    //输出："9534330"
    public String largestNumber(int[] nums) {
        Arrays.sort(nums);
        StringBuilder sb=new StringBuilder("");
        for(int i= nums.length-1;i>=0;i--){
            sb.append(nums[i]);
        }
        return sb.toString();
    }
}
