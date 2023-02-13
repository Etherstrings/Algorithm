package SecondTime.BackTarcking.ZuheAndPaixu.Zuhe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-19 11:52
 */
public class L216 {
    //k个数相加等于n
    public List<List<Integer>> combinationSum3(int k, int n) {
        BackTarcking(k,n,1);
        return ans;

    }
    int sum=0;
    LinkedList<Integer> Path=new LinkedList<>();
    List<List<Integer>> ans=new ArrayList<>();
    void BackTarcking(int k,int n,int startindex){
        if(Path.size()==k){
            if(sum==n){
                ans.add(new ArrayList<>(Path));
            }
            return;
        }
        //是要这样取 这样取没问题
        //从哪个开始 0 1 2 3 4 5
        for(int i=startindex;i<=9;i++){
            Path.add(i);
            sum+=i;
            BackTarcking(k,n,i+1);
            sum-=i;
            Path.removeLast();
        }
    }
}
