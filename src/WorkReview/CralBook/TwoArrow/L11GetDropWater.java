package WorkReview.CralBook.TwoArrow;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-22
 */
public class L11GetDropWater {
    //输入：[1,8,6,2,5,4,8,3,7]
    //输出：49
    //解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
    public int maxArea(int[] height) {
        //底 = right - left;
        //hight = Math.min(height[left], height[right]);
        int ans = 0;
        int left = 0 ;
        int right = height.length - 1;
        while (left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans,area);
            if (height[left] <= height[right]){
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }
}
