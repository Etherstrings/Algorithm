package WorkReview.CralBook.BigSmallStack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-04
 */
public class L347ShowUpKNum {
    public static void main(String[] args) {

    }



    public static int[] getShowUpKNumber(int[] nums, int k) {
        //定义一个大顶堆，大顶堆用出现次数排序
        PriorityQueue<int[]> big = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        //维护所有出现的Key/V
        Map<Integer,Integer> showUp = new HashMap<>();
        for (int n:nums) {
            showUp.put(n,showUp.getOrDefault(n,0)+1);
        }
        showUp.forEach((key,value) -> {int[] tem = {key,value};big.offer(tem);});
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = big.poll()[0];
        }
        return res;
    }
}
