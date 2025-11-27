package StringExer;

import java.util.*;

/**
 * @author Justice_wby
 * @create 2023-01-27 1:54
 */
public class L2309 {
    //2309. 兼具大小写的最好英文字母
    //给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
    //
    //最好 英文字母的大写和小写形式必须 都 在 s 中出现。
    //
    //英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "lEeTcOdE"
    //输出："E"
    //解释：
    //字母 'E' 是唯一一个大写和小写形式都出现的字母。
    public String greatestLetter(String s) {
        Map<Character,int[]> map=new HashMap<>();
        for(char n:s.toCharArray()){
            //如果当前的是大写字母
            if(Character.isUpperCase(n)){
                char lower=Character.toLowerCase(n);
                if(map.containsKey(lower)){
                    int[] t=map.get(lower);
                    t[1]=1;
                    map.put(lower,t);
                    continue;
                }else {
                    map.put(lower,new int[]{0,1});
                    continue;
                }
            }else {
                //当前为小写字母
                if(map.containsKey(n)){
                    //已经有了
                    int[] t=map.get(n);
                    t[0]=1;
                    map.put(n,t);
                    continue;
                }else {
                    map.put(n,new int[]{1,0});
                    continue;
                }
            }
        }
        List<Character> ans=new ArrayList<>();
        for(char c:map.keySet()){
            int[] now=map.get(c);
            if(now[0]==now[1]&&now[0]==1){
                ans.add(Character.toUpperCase(c));
            }
        }
        if(ans.size()==0){
            return "";
        }
        Collections.sort(ans);
        return ans.get(ans.size()-1)+"";
    }
}
