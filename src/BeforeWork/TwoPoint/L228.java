package TwoPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-12-11
 */
public class L228 {

    //给定一个 无重复元素 的 有序 整数数组 nums 。
    //
    // 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于
    //nums 的数字 x 。
    //
    // 列表中的每个区间范围 [a,b] 应该按如下格式输出：
    //
    //
    // "a->b" ，如果 a != b
    // "a" ，如果 a == b
    //
    //
    //
    //
    // 示例 1：
    //
    //
    //输入：nums = [0,1,2,4,5,7]
    //输出：["0->2","4->5","7"]
    //解释：区间范围是：
    //[0,2] --> "0->2"
    //[4,5] --> "4->5"
    //[7,7] --> "7"
    //
    //
    // 示例 2：
    //
    //
    //输入：nums = [0,2,3,4,6,8,9]
    //输出：["0","2->4","6","8->9"]
    //解释：区间范围是：
    //[0,0] --> "0"
    //[2,4] --> "2->4"
    //[6,6] --> "6"
    //[8,9] --> "8->9"
    //
    //
    //
    //
    // 提示：
    //
    //
    // 0 <= nums.length <= 20
    // -2³¹ <= nums[i] <= 2³¹ - 1
    // nums 中的所有值都 互不相同
    // nums 按升序排列
    //
    //
    // Related Topics 数组 👍 368 👎 0

    //> 2023/12/11 14:34:18
    //解答成功:
    //	执行耗时:6 ms,击败了43.29% 的Java用户
    //	内存消耗:40.2 MB,击败了5.04% 的Java用户

    public List<String> summaryRanges(int[] nums) {
        int startIdx = 0;
        int endIdx = 0;
        List<String> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i==nums.length-1){
                if(startIdx==endIdx){
                    ans.add(String.valueOf(nums[startIdx]));
                }else{
                    ans.add(nums[startIdx]+"->"+nums[endIdx]);
                }
                break;
            }
            if(nums[i]+1==nums[i+1]){
                endIdx++;
            }else{
                if(startIdx==endIdx){
                    ans.add(String.valueOf(nums[startIdx]));
                }else{
                    ans.add(nums[startIdx]+"->"+nums[endIdx]);
                }
                startIdx = i+1;
                endIdx = i+1;
            }
        }
        return ans;
    }
}
