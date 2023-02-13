package StringExer;

import java.util.*;

public class L1796 {
    //1796. 字符串中第二大的数字
    //给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
    //
    //混合字符串 由小写英文字母和数字组成。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "dfa12321afd"
    //输出：2
    //解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
    //示例 2：
    //
    //输入：s = "abc1111"
    //输出：-1
    //解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
    public int secondHighest(String s) {
        Set<Integer> temp=new HashSet<>();
        for(char now:s.toCharArray()){
            if(Character.isDigit(now)){
                temp.add(Integer.parseInt(now+""));
            }
        }
        if(temp.size()==1||temp.size()==0){
            return -1;
        }
        List<Integer> list=new ArrayList<>();
        for(Integer now:temp){
            list.add(now);
        }
        Collections.sort(list);
        return list.get(list.size()-2);
    }
}
