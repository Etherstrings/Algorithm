package leetcode.week352;

import java.util.ArrayList;
import java.util.List;

public class num2 {
    //2761. 和等于目标值的质数对 显示英文描述
    //通过的用户数1949
    //尝试过的用户数2465
    //用户总通过次数2045
    //用户总提交次数7707
    //题目难度Medium
    //给你一个整数 n 。如果两个整数 x 和 y 满足下述条件，则认为二者形成一个质数对：
    //
    //1 <= x <= y <= n
    //x + y == n
    //x 和 y 都是质数
    //请你以二维有序列表的形式返回符合题目要求的所有 [xi, yi] ，列表需要按 xi 的 非递减顺序 排序。如果不存在符合要求的质数对，则返回一个空数组。
    //
    //注意：质数是大于 1 的自然数，并且只有两个因子，即它本身和 1 。
    //
    //
    //
    //示例 1：
    //
    //输入：n = 10
    //输出：[[3,7],[5,5]]
    //解释：在这个例子中，存在满足条件的两个质数对。
    //这两个质数对分别是 [3,7] 和 [5,5]，按照题面描述中的方式排序后返回。
    //示例 2：
    //
    //输入：n = 2
    //输出：[]
    //解释：可以证明不存在和为 2 的质数对，所以返回一个空数组。
    public static void main(String[] args) {
        System.out.println(findPrimePairs(10).size());
    }
    public static int len=100010;
    public static List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] used=new boolean[len];
        for(int i=2;i<n;i++){
            if(used[i]){
                continue;
            }
            int j=n-i;
            if(i>j){
                break;
            }
            if(TryDiv(i)){
                for(int k=2;i*k<=n;k++){
                    used[i*k]=true;
                }
                if(TryDiv(j)){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(i);temp.add(j);
                    ans.add(temp);
                }
            }else {
                for(int k=2;i*k<=n;k++){
                    used[i*k]=true;
                }
            }
        }
        return ans;
    }

    public static boolean TryDiv(int x){
        //试除法
        if(x<2){
            return false;
        }
        for(int i=2;i<=x/i;i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
}
