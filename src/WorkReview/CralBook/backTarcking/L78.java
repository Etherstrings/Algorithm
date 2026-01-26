package WorkReview.CralBook.backTarcking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-13
 */
public class L78 {
    //子集
    public static List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> temp = new LinkedList<>();
        ans = new ArrayList<>();
        back(nums,temp,0);
        return ans;
    }

    public static void back(int[] nums,LinkedList<Integer> temp,int index){
        ans.add(temp);
        if (index == nums.length-1) {
            return;
        }
        for (int i=index;i<nums.length;i++) {
            temp.add(nums[i]);
            back(nums,temp,index++);
            temp.remove(temp.size()-1);
        }
    }
}
