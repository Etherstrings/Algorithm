package Stack;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-03 15:08
 */
public class L42 {
    //42. 接雨水
    //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
    //输出：6
    //解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
    //示例 2：
    //
    //输入：height = [4,2,0,3,2,5]
    //输出：9

    //方法1：双指针--接雨水
    //遍历每一列
    //每一列寻找左侧最大值 右侧最大值
    //两者更小的与当前的差值---就是当前列的雨水
    public int trap(int[] height) {
        int sum=0;
        for(int i=0;i<height.length;i++){
            //第一个柱子或者最后一个不接雨水
            if(i==0||i==height.length-1){
                continue;
            }
            int leftMax=-1;
            int righMax=-1;
            for(int r=i+1;r<height.length;r++){
                righMax=Math.max(righMax,height[r]);
            }
            for(int l=i-1;l>=0;l--){
                leftMax=Math.max(leftMax,height[l]);
            }
            int h = Math.min(leftMax, righMax) - height[i];
            if(h>0){
                sum+=h;
            }
        }
        return sum;
    }

    //方法2：动态规划
    //两个DP数组
    //左边最大值DP
    //右边最大值DP
}
