package TwoTo2;

import java.util.Arrays;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-07
 */
public class L2594 {
    public static void main(String[] args) {
        int[] ranks=new int[]{5,1,8};
        System.out.println(repairCars(ranks,6));
    }
    public static long repairCars(int[] ranks, int cars) {
        //r*n*n的分钟修好n辆车
        //那就是一辆车就是r 两辆车就是4r 三辆车就是9r
        //越小的r，能力越强，修更多的车消耗的时间更少
        //所有的车都让能力最强的人修，比如这个值为x，如果转一个车出去，这个增量是没有这个大的，所以效率最高
        //有个重点：所有的机械工可以同时修理汽车
        //那么假如现在的时间为t，实际上能修的汽车数是固定的，每个人能修的是(t/r)开根号
        long left=0;
        Arrays.sort(ranks);
        long right=cars*cars*ranks[0];
        //二分查找
        //左闭右边
        while(left<right){
            long mid=left+(right-left)/2;
            if(check(mid,ranks,cars)==0) {
                return mid;
            }else if(check(mid,ranks,cars)>0){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }

    public static long check(long mid,int[] ranks,int cars){
        long sum=0;
        for(int i=0;i<ranks.length;i++){
            sum+=Math.sqrt(mid/ranks[i]);
        }
        return sum-cars;
    }

    public static long repairCars_t(int[] ranks, int cars){
        long left=0;
        Arrays.sort(ranks);
        long right=cars*cars*ranks[0];
        for(;left<=right;left++){
            long sum=0;
            for(int i=0;i<ranks.length;i++){
                sum+=Math.sqrt(left/ranks[i]);
            }
            if(sum>=cars){
                return left;
            }
        }
        return left;
    }

}
