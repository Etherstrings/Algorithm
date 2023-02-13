package SecondTime.BackTarcking.ZuheAndPaixu.Zuhe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-19 15:17
 */
public class L40 {
    //candidates可能有重复的数字
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length==0||candidates==null){
            return ans;
        }
        Arrays.sort(candidates);
        //boolean[] used=new boolean[candidates.length];
        BackTarcking(candidates,0,target);
        return ans;
    }
    int sum=0;
    LinkedList<Integer> Path=new LinkedList<>();
    List<List<Integer>> ans=new ArrayList<>();
    void BackTarcking(int[] candidates,int startindex,int target){
        //写过滤条件
        if(sum>=target){
            if(sum==target){
                ans.add(new ArrayList<>(Path));
            }
            return;
        }

        for(int i=startindex;i<candidates.length;i++){
            //去重
            //去的是第一个入的地方不可以重复
            if(i>startindex&&candidates[i]==candidates[i-1]){
                continue;
            }

            sum+=candidates[i];
            Path.add(candidates[i]);
            //used[i] = true;
            BackTarcking(candidates,i+1,target);
            //used[i] = false;
            sum-=candidates[i];
            Path.removeLast();
        }
    }
}
