package HASH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-10-20
 */
public class L1726 {
    //给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
    //
    //示例 1：
    //
    //输入：nums = [2,3,4,6]
    //输出：8
    //解释：存在 8 个满足题意的元组：
    //(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
    //(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)

    //> 2023/10/20 11:06:10
    //解答成功:
    //	执行耗时:284 ms,击败了7.27% 的Java用户
    //	内存消耗:103.7 MB,击败了5.10% 的Java用户

    // 通过Hash表存储积为一样的两个数，判断这些数是不是一样
    public int tupleSameProduct(int[] nums) {
        int ans=0;
        Arrays.sort(nums);
        HashMap<Integer, List<int[]>> map=new HashMap<>();
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int a=nums[i];
                int b=nums[j];
                int temp=a*b;
                if(map.containsKey(temp)){
                    for(int[] t:map.get(temp)){
                        int c=t[0];
                        int d=t[1];
                        if(a != c && a != d && b != c && b != d){
                            ans+=8;
                        }
                    }
                    map.get(temp).add(new int[]{a,b});
                }else {
                    List<int[]> te=new ArrayList<>();
                    te.add(new int[]{a,b});
                    map.put(temp,te);
                }
            }
        }
        return ans;
    }
}
