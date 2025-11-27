package SecondTime.BackTarcking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-22 14:32
 */
public class L46 {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used=new boolean[nums.length];
        Arrays.fill(used,false);
        BackTarcking(nums,used);
        return ans;
    }
    LinkedList<Integer> Path=new LinkedList<>();
    List<List<Integer>> ans=new ArrayList<>();
    void BackTarcking(int[] nums,boolean[] used){
        if(Path.size()==nums.length){
            ans.add(new ArrayList<>(Path));
            return;
        }
        //这里找对了
        //每次排列都是从头开始搜索
        //每次都要跳过自己 也就是选过的元素
        for(int i=0;i<nums.length;i++){
            if(used[i]==true){
                continue;
            }
            used[i]=true;
            Path.add(nums[i]);
            BackTarcking(nums,used);
            Path.removeLast();
            used[i]=false;
        }
    }
}
