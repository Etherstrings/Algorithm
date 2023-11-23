package PreSum;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-13
 */
public class L307 {
    public static int[] PreSum;
    public void NumArray(int[] nums) {
        PreSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            PreSum[i + 1] = PreSum[i] + nums[i];
        }
    }

    public void update(int index, int val) {
        int diff = val - PreSum[index + 1] + PreSum[index];
        for (int i = index + 1; i < PreSum.length; i++) {
            PreSum[i] += diff;
        }
    }

    public int sumRange(int left, int right) {
        return PreSum[right + 1] - PreSum[left];
    }
}
