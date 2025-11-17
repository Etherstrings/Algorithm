package TanXin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-10-07
 */
public class L2499 {
    //1.Mac密码：djy000721
    //2.公司谷歌账户：EtherstringsJustice@gmail.com
    //Djy000721
    //3.appleid:EtherstringsJustice@gmail.com
    //Djy00721

    //给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两者长度都为 n 。
    //
    //每次操作中，你可以选择交换 nums1 中任意两个下标处的值。操作的 开销 为两个下标的 和 。
    //
    //你的目标是对于所有的 0 <= i <= n - 1 ，都满足 nums1[i] != nums2[i] ，你可以进行 任意次 操作，请你返回达到这个目标的 最小 总代价。
    //
    //请你返回让 nums1 和 nums2 满足上述条件的 最小总代价 ，如果无法达成目标，返回 -1 。
    //
    //示例 1：
    //
    //输入：nums1 = [1,2,3,4,5], nums2 = [1,2,3,4,5]
    //输出：10
    //解释：
    //实现目标的其中一种方法为：
    //- 交换下标为 0 和 3 的两个值，代价为 0 + 3 = 3 。现在 nums1 = [4,2,3,1,5] 。
    //- 交换下标为 1 和 2 的两个值，代价为 1 + 2 = 3 。现在 nums1 = [4,3,2,1,5] 。
    //- 交换下标为 0 和 4 的两个值，代价为 0 + 4 = 4 。现在 nums1 = [5,3,2,1,4] 。
    //最后，对于每个下标 i ，都有 nums1[i] != nums2[i] 。总代价为 10 。
    //还有别的交换值的方法，但是无法得到代价和小于 10 的方案。

    //首先将满足nums1[i] == nums2[i]的第i列叫做重复对。
    //
    //如果有某个数在nums1和nums2出现的次数大于nums1.size(),
    //则显然不管怎么换都总有一对重复的
    //例如:
    //2 2 2
    //1 2 1
    //此时返回-1。
    //
    //统计出重复对总个数为sameCount,重复对中出现最多次的元素为maxGropuNum，其出现的对数为maxGroupCount。
    //
    //当sameCount为偶数，且maxGroupCount<=sameCount/2时，总能有一种方法可以只在重复对之中进行两两交换来调整到无重复对
    //例如：
    //...2 ... 2 ... 1 ... 3...(...代表任意数量不重复的对)
    //...2 ... 2 ... 1 ... 3...
    //可以将第1组和第3组交换，第2组和第4组交换，达成无重复对。此时最小代价为所有重复对所在的下标之和
    //
    //当sameCount为偶数，且maxGroupCount>sameCount/2时，这个时候只在重复对中两两交换就不够了。
    //在重复对中两两交换可以处理掉一部分，但maxGroupCount超出sameCount/2的这个数量，需要去找不重复的对来和他交换。
    //我们用overflow = maxGroupCount*2 - sameCount计算出需要找不重复对进行交换的数量。
    //显然需要找不重复对来交换的对只可能是maxGropuNum构成的。所有不是maxGroupNum的重复对都被用去和是maxGroupNum的重复对交换了，但是还换不完，所以才出来找不重复对交换。
    //下标从低到高找overflow个不包含maxGropuNum且不重复的对，将其下标求和，再将所有重复对下标求和，二者相加就是此时的最小代价。
    //
    //演示一次算法流程：
    //例如：
    //1 1 1 1 2 3 4 5
    //2 1 1 1 2 6 5 6
    //先进行检查, 发现没有一个数的出现次数大于nums1.size(), 执行后续
    //遍历一次数据，统计得出sameCount = 4, maxGroupCount = 3, maxGropuNum = 1
    //计算overflow = maxGroupCount*2 - sameCount, 得overflow = 2, 也就是需要请2次外援（找2个不重复的对进行交换）
    //令cost = 0，cost是总代价
    //再次遍历数据：
    //    对每个下标i，如果是重复对，cost+=i
    //    如果不是重复对 并且 overflow>0 并且 这一对的上下都不是maxGroupNum，cost+=i且overflow--;
    //最后得出cost = 1 + 2 + 3 + 4 + 5 + 6 = 21
    public static long minimumTotalCost(int[] nums1, int[] nums2) {
        Map<Integer,Integer> num_showtime=new HashMap<>();
        Map<Integer,Integer> samekey_showup=new HashMap<>();
        int sameCount=0;
        int maxGroupCount=0;
        int maxGroupNum=0;
        for(int i=0;i<nums1.length;i++){
            num_showtime.put(nums1[i],num_showtime.getOrDefault(nums1[i],0)+1);
            num_showtime.put(nums2[i],num_showtime.getOrDefault(nums2[i],0)+1);
            if(nums1[i]==nums2[i]){
                samekey_showup.put(nums1[i],samekey_showup.getOrDefault(nums1[i],0)+1);
                if(samekey_showup.get(nums1[i])>maxGroupCount){
                    maxGroupCount=samekey_showup.get(nums1[i]);
                    maxGroupNum=nums1[i];
                }
            }
        }
        sameCount=samekey_showup.size();
        for(int key:num_showtime.keySet()){
            if(num_showtime.get(key)>nums1.length){
                return -1;
            }
        }
        long cost=0;
        int overflow=maxGroupCount*2-sameCount;
        if(overflow<0){
            for(int i=0;i<nums1.length;i++){
                cost+=i;
            }
        }else {

            for(int i=0;i<nums1.length;i++){
                if(nums1[i]==nums2[i]){
                    cost+=i;
                    continue;
                }
                if(overflow>0 && nums1[i]!=maxGroupNum && nums2[i]!=maxGroupNum){
                    cost+=i;
                    overflow--;
                }
            }
        }
        return cost;
    }

    public long minimumTotalCost1(int[] nums1, int[] nums2) {
        int n =  nums1.length;
        Map<Integer,Integer> sames = new HashMap<>();
        int cnt = 0;
        long ans = 0L;
        for(int i = 0; i < n; i++){
            if(nums1[i]==nums2[i]){
                ans += i;
                ++cnt;
                sames.merge(nums1[i],1,Integer::sum);
            }
        }

        int last = 0;
        int j = -1;
        for(int key:sames.keySet()) {
            int value = sames.get(key);
            if(value*2>cnt) {
                last = value*2-cnt;
                j = key;
            }
        }

        for(int i = 0; i < n&&last>0; i++){
            if(nums1[i]!=nums2[i] && nums1[i]!=j && j!=nums2[i]){
                ans += i;
                --last;
            }
        }

        return last == 0?ans:-1;
    }

    public static void main(String[] args) {
        System.out.println(minimumTotalCost(new int[]{1,5,3,5,5},new int[]{1,2,3,4,5}));
    }



}
