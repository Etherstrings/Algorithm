package PreSum;

import java.util.Arrays;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2024-01-22
 */
public class LMagicBean {

    public long minimumRemoval(int[] beans) {
        int n = beans.length;// 元素个数
        Arrays.sort(beans); // 对种子进行排序
        long[] suffixSums = new long[n + 1]; // 后缀和数组，suffixSums[i]表示[i, n)的元素和，suffixSums[n] = 0表示[n, n)的元素和不存在
         long sufSum = 0; // 后缀和
         for(int i = n - 1; i >= 0; i--){
             sufSum += beans[i]; // 先累加当前位置元素
              suffixSums[i] = sufSum; // 再更新后缀和
         }
         long ans = suffixSums[0]; // 最少数目，初始为极大值——所有元素和，表示拿走所有魔法豆
        long preSum = 0; // 前缀和，表示[0,i)的元素和
        for(int i = 0; i < n; i++){
            // 每次要将数组中的元素都变成beans[i]，比beans[i]小的魔法豆全都拿走，即为前缀和；
            // 比beans[i]大的魔法豆要变成beans，即为后缀和 - beans[i] * (n - i - 1)
             ans = Math.min(ans, preSum + suffixSums[i + 1] - (long)beans[i] * (n - i - 1));
             preSum += beans[i];
             }
             return ans;
    }
}
