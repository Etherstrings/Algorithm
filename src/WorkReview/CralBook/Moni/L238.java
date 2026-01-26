package WorkReview.CralBook.Moni;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-08
 */
public class L238 {
    public static void main(String[] args) {
        //输入: nums = [1,2,3,4]
        //输出: [24,12,8,6]
        System.out.println(new L238().productExceptSelf(new int[]{1,2,3,4}));
    }
    public int[] productExceptSelf(int[] nums) {
        //维护当前位置左边的乘和右边的乘
        // 1 2 3 4
        // 0-24 1-12 2-4 6-0
        int[][] muti = new int[nums.length][2];
        muti[0][0] = 0;
        muti[nums.length-1][1] = 0;
        for (int i=1;i<nums.length;i++) {
            if (i==1) {
                muti[i][0]=nums[i-1];
                continue;
            }
            muti[i][0]=muti[i-1][0]*nums[i-1];
        }
        for (int i=nums.length-2;i>=0;i--) {
            if (i==nums.length-2) {
                muti[i][1]=nums[i+1];
                continue;
            }
            muti[i][1]=muti[i+1][1]*nums[i+1];
        }
        int[] ans = new int[nums.length];
        ans[0]=muti[0][1];
        ans[nums.length-1]=muti[nums.length-1][0];
        for (int i=1;i<nums.length-1;i++) {
            ans[i]=muti[i][0]*muti[i][1];
        }
        return ans;
    }
}
