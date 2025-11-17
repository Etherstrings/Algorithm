package SecondTime.BackTarcking.ZuheAndPaixu.Zuhe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-19 11:23
 */
public class L77 {
    //n个数 kk组合
    //4个数 22组合
    LinkedList<Integer> Path=new LinkedList<>();
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        BackTarcking(1,n,k);
        return ans;
    }

    void BackTarcking(int index,int n,int k){
        //每一次到了下一层
        //从什么时候开始组合？
        if(Path.size()==k){
            ans.add(new ArrayList<>(Path));
            return;
        }

        for(int i=index;i<=n;i++){
            Path.add(i);
            BackTarcking(i+1,n,k);
            Path.removeLast();
        }
    }
}
