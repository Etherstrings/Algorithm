package WorkReview.CralBook.Trick;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-11
 */
public class L75Sort {
    public static void main(String[] args) {
        //输入：nums = [2,0,2,1,1,0]
        //输出：[0,0,1,1,2,2]
                int[] nums = new int[]{0,1};
        new L75Sort().sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public void sortColors(int[] nums) {
        boolean flag = false;
        int i = doUpdate(nums, 0, 0);
        int i1 = doUpdate(nums, 1, i);
        doUpdate(nums,2,i1);
        Map<Integer,Integer> map = new HashMap<>();
        int k=0;
        int start = 0;
        while (k<3) {
            int end = start+map.get(k);
            for (int j=start;j<end;j++) {
                nums[j] = k;
            }
            start = end;
            k++;
        }
    }

    int doUpdate(int[] nums,int k,int start){
        if (k==0) {
            int slow = 0;
            int fast = 1;
            for (;fast<nums.length;fast++) {
                if (nums[fast]==k) {
                    nums[fast] = nums[slow];
                    nums[slow] = k;
                    slow++;
                }
            }
            return slow;
        }
        int slow = start;
        int fast = slow+1;
        for (;fast<nums.length;fast++) {
            if (nums[fast]==k) {
                nums[fast] = nums[slow];
                nums[slow] = k;
                slow++;
            }
        }
        return slow;
    }
}
