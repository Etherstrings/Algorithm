package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-01-30 22:02
 */
public class L884 {
    /**
     *  884. 两句话中的不常见单词
     *
     * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
     *
     * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
     *
     * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
     *
     */

    public String[] uncommonFromSentences(String s1, String s2) {
        //1.合并AB
        String[] AB=(s1+" "+s2).split(" ");

        //
        HashMap<String, Integer> choose = new HashMap<>();
        for(int i=0;i<AB.length;i++)
            if (choose.containsKey(AB[i])) {
                Integer value = choose.get(AB[i]) + 1;
                choose.put(AB[i],value);
            } else {
                choose.put(AB[i], 1);
            }

        List<String> list=new ArrayList<>();
        for(String key:choose.keySet()){
            if(choose.get(key)==1){
                list.add(key);
            }
        }

        String[] ans=new String[list.size()];

        return list.toArray(ans);
    }
}
