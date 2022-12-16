package src.TanXin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-07-21 16:17
 */
public class L763 {
    //763. 划分字母区间
    //字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
    //
    //
    //
    //示例：
    //
    //输入：S = "ababcbacadefegdehijhklij"
    //输出：[9,7,8]
    //解释：
    //划分结果为 "ababcbaca", "defegde", "hijhklij"。
    //每个字母最多出现在一个片段中。
    //像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
    //
    //
    //提示：
    //
    //S的长度在[1, 500]之间。
    //S只包含小写字母 'a' 到 'z' 。
    public List<Integer> partitionLabels(String s) {
        //思路 遍历 记录某个字母的最后出现位置
        //如果出现了某个字母 判断当前的遍历位置是不是可以满足这个最大位置
        //如果出现的所有字母 都在当前的最大范围内  那就可以划分
        HashMap<Character,Integer> Judge=new HashMap<>();
        for(int i=0;i<s.length();i++){
            Judge.put(s.charAt(i),i);
        }
        List<Integer> answer=new ArrayList<>();

        int right=0;
        int lastpoint=-1;
        for(int i=0;i<s.length();i++){
            //last是当前出现字母的最远位置
            right=Math.max(right,Judge.get(s.charAt(i)));

            //当前遍历的位置 已经满足了最高
            if(i==right){

                answer.add(right-lastpoint);

                lastpoint=i;
            }
        }
        return answer;
    }
}
