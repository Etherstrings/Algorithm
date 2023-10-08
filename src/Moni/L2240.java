package Moni;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-01
 */
public class L2240 {
public static void main(String[] args) {

        System.out.println(waysToBuyPensPencils(1000000, 1, 1));
    }

    //买笔的模拟数
    //可以简单抽离为数学问题
    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        for(int i=0;i<=total/cost1;i++){
            res+=(total-cost1*i)/cost2;
            res++;
        }
        return res;
    }

    //换背包问题
    //先容量 后物品
    public static long waysToBuyPensPencils_dp(int total, int cost1, int cost2){
        //价值就是容量
        return 0;
    }
}
