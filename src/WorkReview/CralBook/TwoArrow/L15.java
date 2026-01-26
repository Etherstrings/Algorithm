package WorkReview.CralBook.TwoArrow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-08
 */
public class L15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0) {
                return result;
            }
            //去重
            if (i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int now = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left<right) {
                int sum = now+nums[left]+nums[right];
                if (sum<0) {
                    left++;
                } else if (sum>0) {
                    right--;
                } else {
                    List<Integer> temp = new ArrayList(){};
                    temp.add(now);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    while (left<right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left<right && nums[right] == nums[right-1]) {
                        right++;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
