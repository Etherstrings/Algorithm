package TwoTo2;

import java.util.Arrays;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-26
 */
public class L2517 {
    //给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
    //
    //商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
    //
    //返回礼盒的 最大 甜蜜度。
    //
    //示例 1：
    //
    //输入：price = [13,5,1,8,21,2], k = 3
    //输出：8
    //解释：选出价格分别为 [13,5,21] 的三类糖果。
    //礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
    //可以证明能够取得的最大甜蜜度就是 8 。
    //示例 2：
    //
    //输入：price = [1,3,1], k = 2
    //输出：2
    //解释：选出价格分别为 [1,3] 的两类糖果。
    //礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
    //可以证明能够取得的最大甜蜜度就是 2 。
    //示例 3：
    //
    //输入：price = [7,7,7,7], k = 2
    //输出：0
    //解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。

    //仔细思考一下，这题很有意思
    //记住一句话：最大中找最小/最小中找最大
    //就是二分

    //1.想明白 相当于指定一个值 测算是否在数组中可以包含这个值的间距
    //比如 1  5  9  间距=2
    //2.再想明白，实际上就是在二分查找，找到能够满足可以包含这个值的间距的最大值
    //那就是二分去找
    //3.再想明白，这个间距的值 取值范围有什么
    //0
    //最大值-最小值
    public int maximumTastiness(int[] price, int k) {
        //先排序
        Arrays.sort(price);
        //最小的值是什么？ 0
        //最大的值是什么？ 最大的减去最小的
        //只要能够满足在当前这个值x下，如果能够找到k个，找到就把当前的值x加大
        //如果找不到k个，就把当前的值x减小
        int n = price.length;

        int left = 0;
        int r = price[n - 1] - price[0];
        while (left < r) {
            int mid = left + (r - left + 1) / 2;
            if (check(mid, price, k)) {
                left = mid;
            } else {
                r = mid - 1;
            }
        }
        return left;
    }
    public boolean check(int mid, int[] price, int k){
        //这个方法的意义是什么？
        //mid指的是我需要增加的值
        //开始的值为price[0]
        //逐步增加，看看能不能找到这样相隔的k个数
        int n = price.length;
        int showup = 1;
        int temp = price[0];
        for(int i=1;i<n;i++){
            int now = price[i];
            if(temp+mid<=now){
                showup++;
                temp=now;
            }
        }
        return showup>=k;
    }
}
