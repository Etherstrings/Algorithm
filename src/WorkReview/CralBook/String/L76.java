package WorkReview.CralBook.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-07
 */
public class L76 {
    public static void main(String[] args) {
        //输入：s = "ADOBECODEBANC", t = "ABC"
        //输出："BANC"
        //解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
        System.out.println(new L76().minWindow("ADOBECODEBANC","ABC"));
    }

    public String minWindow(String s, String t) {
        int slow=0;
        int fast=0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        Map<Character,Integer> map = new HashMap<>();
        for (Character c:t.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        while (fast<s.length()) {
            sb.append(s.charAt(fast));
            while(isCon(sb,map)) {
                if (fast-slow+1<minLen) {
                    ans = s.substring(slow,fast+1);
                    minLen = fast-slow+1;
                }
                sb.deleteCharAt(0);
                slow++;
            }
            fast++;
        }
        return ans;
    }

    public static boolean isCon(StringBuilder sb, Map<Character,Integer> jug) {
        Map<Character,Integer> temp = new HashMap<>();
        for (Character c : sb.toString().toCharArray()) {
            temp.put(c, temp.getOrDefault(c,0)+1);
        }
        boolean falg = true;
        for (Map.Entry<Character,Integer> entry:jug.entrySet()) {
            if (temp.getOrDefault(entry.getKey(),0)<entry.getValue()) falg=false;
        }
        return falg;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String s:strs) {
            String key = coverKey(s);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(key, temp);
            }
        }
        for (Map.Entry<String,List<String>> entry: map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static String coverKey(String str){
        // 将字符串转换为字符数组
        char[] chars = str.toCharArray();
        // 对字符数组进行排序
        Arrays.sort(chars);
        // 将排序后的字符数组转换回字符串
        return new String(chars);
    }
}
