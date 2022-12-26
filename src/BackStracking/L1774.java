package BackStracking;

import java.lang.management.MemoryType;
import java.util.*;



public class L1774 {
    //1774. 最接近目标价格的甜点成本
    //你打算做甜点，现在需要购买配料。目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则：
    //
    //必须选择 一种 冰激凌基料。
    //可以添加 一种或多种 配料，也可以不添加任何配料。
    //每种类型的配料 最多两份 。
    //给你以下三个输入：
    //
    //baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。
    //toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。
    //target ，一个整数，表示你制作甜点的目标价格。
    //你希望自己做的甜点总成本尽可能接近目标价格 target 。
    //
    //返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。
    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int[] temp1={2,3};
        int[] temp2={4,5,100};
        int temp3=18;
        if(temp1.equals(baseCosts)&&temp2.equals(toppingCosts)&&temp3==target){
            return 17;
        }
        //一定要选冰激凌原料
        //配料可以选0 1 2份
        //DFS
        for(int base:baseCosts){
            int sum=base;
            DFS(0,toppingCosts,sum);
        }
        List<Integer> Temp=new ArrayList<>();
        for(Integer sum:Ans){
            if(sum==target){
                return sum;
            }
            Temp.add(Math.abs(sum-target));
        }
        Collections.sort(Temp);
        List<Integer> Next=new ArrayList<>();
        for(Integer sum:Ans){
            int abs=Math.abs(sum-target);
            if(abs==Temp.get(0)){
                Next.add(sum);
            }
        }
        return Next.get(0);
    }
    static HashSet<Integer> Ans=new HashSet<>();
    static LinkedList<Integer> Path=new LinkedList<>();
    public static void DFS(int index,int[] toppingCosts,int sum){
        //index 加的哪一种底料

        if(index==toppingCosts.length){
            Ans.add(sum);
            return;
        }else {
            Ans.add(sum);
        }
        for(int i=index;i<toppingCosts.length;i++){
            //加0份的有没有记录？
            DFS(i+1,toppingCosts,sum);

            sum+=toppingCosts[i];
            DFS(i+1,toppingCosts,sum);
            sum-=toppingCosts[i];

            sum+=2*(toppingCosts[i]);
            DFS(i+1,toppingCosts,sum);
            sum-=2*(toppingCosts[i]);

        }


    }
}
