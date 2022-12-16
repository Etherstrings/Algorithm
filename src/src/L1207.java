package src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-04 14:09
 */
public class L1207 {
    //1207. 独一无二的出现次数
    //给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
    //
    //如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
    //
    //
    //
    //示例 1：
    //
    //输入：arr = [1,2,2,1,1,3]
    //输出：true
    //解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
    //示例 2：
    //
    //输入：arr = [1,2]
    //输出：false
    //示例 3：
    //
    //输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
    //输出：true
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> Judeg1=new HashMap<>();
        Set<Integer> Judge2=new HashSet<>();
        for(int a:arr){
            Judge2.add(a);
            if(Judeg1.containsKey(a)){
                Judeg1.put(a,Judeg1.get(a)+1);
            }else {
                Judeg1.put(a,1);
            }
        }

        Set<Integer> Ans=new HashSet<>();
        boolean flag=true;
        for(Integer b:Judge2){
            if(Ans.contains(Judeg1.get(b))){
                flag=false;
                break;
            }else {
                Ans.add(Judeg1.get(b));
            }
        }
        return flag;
    }
}
