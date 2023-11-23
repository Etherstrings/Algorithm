package HASH;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-10-17
 */

    //给你两个整数数组 nums1 和 nums2 ，请你实现一个支持下述两类查询的数据结构：
//
//累加 ，将一个正整数加到 nums2 中指定下标对应元素上。
//计数 ，统计满足 nums1[i] + nums2[j] 等于指定值的下标对 (i, j) 数目（0 <= i < nums1.length 且 0 <= j < nums2.length）。
//实现 FindSumPairs 类：
//
//FindSumPairs(int[] nums1, int[] nums2) 使用整数数组 nums1 和 nums2 初始化 FindSumPairs 对象。
//void add(int index, int val) 将 val 加到 nums2[index] 上，即，执行 nums2[index] += val 。
//int count(int tot) 返回满足 nums1[i] + nums2[j] == tot 的下标对 (i, j) 数目。
//示例：
//
//输入：
//["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
//[[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
//输出：
//[null, 8, null, 2, 1, null, null, 11]


    //L1865

    class FindSumPairs {
    //> 2023/10/17 16:04:47
    //解答成功:
    //	执行耗时:209 ms,击败了7.25% 的Java用户
    //	内存消耗:83.1 MB,击败了5.80% 的Java用户
        static Map<Integer,Integer> map;
        static int[] snums1;
        static int[] snums2;
        public FindSumPairs(int[] nums1, int[] nums2) {
            map=new HashMap<>();
            for(int i=0;i<nums2.length;i++){
                map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
            }
            snums1=nums1;
            snums2=nums2;
        }

        public void add(int index, int val) {
            map.put(snums2[index],map.get(snums2[index])-1);
            snums2[index]+=val;
            map.put(snums2[index],map.getOrDefault(snums2[index],0)+1);
        }

        public int count(int tot) {
            int ans=0;
            for(int n:snums1){
                int key=tot-n;
                if(map.containsKey(key)){
                    if(map.get(key)>=1){
                        ans+=map.get(key);
                    }
                }
            }
            return ans;
        }
    }

