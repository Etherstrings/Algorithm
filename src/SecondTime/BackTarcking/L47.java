package SecondTime.BackTarcking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-22 15:34
 */
public class L47 {
    //47. 全排列 II
    //给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,1,2]
    //输出：
    //[[1,1,2],
    // [1,2,1],
    // [2,1,1]]
    //示例 2：
    //
    //输入：nums = [1,2,3]
    //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        Arrays.fill(used,false);

        BackTarcking(nums,used);
        return ans;
    }
    LinkedList<Integer> Path=new LinkedList<>();
    List<List<Integer>> ans=new ArrayList<>();
    //每次进去 还是从0开始进
    //直接从进不进去这里进行判断
    void BackTarcking(int[] nums,boolean[] used){
        if(Path.size()==nums.length){
            ans.add(new ArrayList<>(Path));
            return;
        }


        for(int i=0;i<nums.length;i++){

            if(i>0&&nums[i]==nums[i-1]&& used[i - 1] == false){
                continue;
            }

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
