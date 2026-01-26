package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-13
 */
public class Test1 {
    //给你提供一个无序的正整数数组
    //请你判断是否存在这样的元素，他出现的次数超过了数组长度的一半
    //如果存在，打印这个元素，如果不存在，打印0
    //要求空间复杂度是o(1) 时间复杂度是o(n)

    // 1-n
    // v 1-n

    //int key int value

    //1 2 3 3 3

    public static void main(String[] args) {

    }

    public static int getShowMoreN(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int n = nums.length;
        for (Entry<Integer, Integer> entry:map.entrySet()) {
            if (entry.getValue()>=n/2) {
                return entry.getKey();
            }
        }
        return 0;
    }

}
