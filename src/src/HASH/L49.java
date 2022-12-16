package src.HASH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-02-07 21:38
 */
public class L49 {
    /**
     *
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param strs
     * @return
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        //key 为a4 b7 c7....
        //value为{[eae],[aee],[eea]}
        Map<String, List<String>> answer = new HashMap<String, List<String>>();

        //对于每一个从strs中取出来的str
        for (String str : strs) {
            //a-z 数组
            int[] counts = new int[26];

            //取出来的str的长度
            int length = str.length();

            //每个str的字母
            for (int i = 0; i < length; i++) {
                //根据字母所在的位置 将每个字母所出现的次数表示
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            //sb-----a2b4c6
            String key = sb.toString();

            //取出key的value-----List
            //list添加str

            List<String> list = answer.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            //answer添加key---list
            answer.put(key, list);
        }
        return new ArrayList<List<String>>(answer.values());
    }

}
