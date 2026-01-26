package WorkReview.CralBook.backTarcking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-13
 */
public class L46 {
    public static void main(String[] args) {

    }
    //全排列
    public static List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        back(0,temp,nums);
        return ans;
    }

    public void back(int index,List<Integer> temp,int[] nums){
        if (temp.size()==nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i=index;i<nums.length;i++) {
            temp.add(nums[i]);
            back(index++,temp,nums);
            temp.remove(temp.size()-1);
        }
    }
}
