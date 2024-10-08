package ChaFen;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-27
 */
public class L798 {
    //class Solution:
    //    def bestRotation(self, nums: List[int]) -> int:
    //        """
    //        题目要求：给定数组nums，将其按非负整数k进行轮调，使数组变为[nums[k],nums[k + 1],...nums[nums.length - 1],nums[0],nums[1],...,nums[k-1]]的形式
    //        记任何元素值小于等于其下标的都可加一分。在所有可能的轮调中，返回所能得到的最高分数对应的轮调下标k。如果有多个答案，返回满足条件的最小的下标k。
    //        :param nums: 给定的数组nums
    //        :return: 返回得分最大的轮调下标k
    //        """
    //        # 题目要求：题目理解起来并不困难，暴力法也比较容易解决，但显然在该题中会超时(1<=nums.length<=10^5, 暴力法复杂度O(n^2))
    //        # 初步解题思路是找到每个元素可以加分的下标区间，我们的目的就是使得更多的元素在轮调后可以得分，即轮调后更多的元素要落在可得分的下标区间
    //        # 下面就要考虑什么情况下可以得分，即找出每个元素对应的得分区间：(记数组长度为n)
    //        # 记当前元素下标为i，轮调下标为k，那么轮调后元素下标为i-k，当新下标为负数时，相当于nums[i]移动到原数组更“靠后”的位置，此时下标等价于(i-k+n)%n
    //        # 显然新下标的取值范围首先要满足[0,n-1]，即有 0 <= i - k <=n − 1,化简可得k <= i,k >= i - (n-1)
    //        # 可得k的上下界分别为i和i-(n - 1)，而为了满足得分要求，有新下标 i - k >= nums[i], 故 k <= i - nums[i],nums[i]是不小于0的
    //        # 故能使nums[i]得分的k上下界分别为 i - nums[i] 和 i - (n - 1) (注意在真实处理时均进行加n取余转为正数!为书写方便就省略了)
    //        # 下面就要讨论上下界的大小关系确定最终的合法得分区间：
    //        # 情况1：当i − (n−1) <= i − nums[i]时，[i - (n - 1),i - nums[i]]为合法得分区间
    //        # 情况2：当i − (n−1) >  i − nums[i]时，根据负数下标等价于(i - k + n) % n(前面讲述过接在原数组靠后位置)，
    //        # 此时[i - (n - 1),i - nums[i]]等价于[0,i - nums[i]]和[i−(n−1),n−1]两段合法得分区间
    //        # 至此找到了每个元素nums[i]得分区间(用k进行表示的，即k在该区间取值该元素均可得分)
    //        # 记该区间为[l,r]，对[l,r]进行+1标记，代表k在该位置能够加一分，最后找到标记次数最多的位置k即为所求
    //        # 这种处理显然要在大量重复区间上进行加1操作，用差分数组完美解决
    //        # 什么是差分数组，这里简单说明一下：给出原数组为d，差分数组为f，那么有f[i] = d[i] - d[i - 1] (定义就是这么简单，是不是有点类似前缀和)
    //        # 根据这个定义，差分数组可得到一个重要性质：d[i]等于f[i]的前缀和，即差分数组的前缀和就是原数组，自己举个例子很容易理解
    //        # 根据这个性质，得到若对某个区间[L, R]增加一个数x(在原数组上加哦)，只需要使f[L] += x; f[R + 1] -= x ,即可实现对区间的批量修改，而查询时只需要求前缀和查询单个元素即可，是不是很神奇，哈哈哈
    //        # 稍微解释一下：第一个受影响的差分数组中的元素为f[L],即令f[L]+=x，那么后面元素在计算过程中都会加上x；最后一个受影响的差分数组中元素为f[R],所以令f[R+1]-=x，即可保证不会影响到R以后数列元素的计算
    //        # 如果还是不明白的话就只能去补补差分数组的知识了，应该不难理解吧(这个博客或许有用https://blog.csdn.net/qq_31601743/article/details/105352885)
    //        # 下面就是代码咯：
    //        n = len(nums)  # 取数组的长度
    //        diff = [0] * (n + 1)  # 初始化差分数组
    //        for i in range(n):
    //            a = (i - (n - 1) + n) % n  # 得分区间下界
    //            b = (i - nums[i] + n) % n  # 得分区间上界
    //            if a <= b:  # 情况1：对区间进行加一操作咯，有差分数组实现
    //                diff[a] += 1  # 不就是f[L] += x咯(x取1罢了)
    //                diff[b + 1] -= 1  # 不就是f[R + 1] -= x咯
    //            else:  # 情况2：下面操作同理，不罗嗦了
    //                diff[0] += 1
    //                diff[b + 1] -= 1
    //                diff[a] += 1
    //                diff[n] -= 1
    //        for i in range(1, n):  # 然后根据差分数组求前缀和得到标记后的数组咯，标记最多的位置即为所求
    //            diff[i] += diff[i - 1]
    //        res, maxs = 0, diff[0]
    //        for i in range(n):  # 遍历找标记最多的位置
    //            if diff[i] > maxs:
    //                maxs = diff[i]
    //                res = i
    //        return res
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        return 1;
    }
}
