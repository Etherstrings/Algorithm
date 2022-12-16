package src;

import java.util.*;

public class L692 {
    //给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
    //
    //返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
    //
    //
    //
    //示例 1：
    //
    //输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    //输出: ["i", "love"]
    //解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    //    注意，按字母顺序 "i" 在 "love" 之前。
    //示例 2：
    //
    //输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
    //输出: ["the", "is", "sunny", "day"]
    //解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    //    出现次数依次为 4, 3, 2 和 1 次。
    public List<String> topKFrequent(String[] words, int k) {
        //出现了哪些单词
        Set<String> Judege=new HashSet<>();
        //这个单词对应出现了几次？
        Map<String,Integer> Judge1=new HashMap<>();

        for(String a:words){
            Judege.add(a);
            if(Judge1.containsKey(a)){
                Judge1.put(a,Judge1.get(a)+1);
            }else {
                Judge1.put(a,1);
            }
        }

        //此时Set里存了有哪些单词---Judege1里存了这些单词有几次
        ArrayList<Integer> values =(ArrayList<Integer>)Judge1.values();
        Collections.sort(values);
        Collections.reverse(values);
        ArrayList<String> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            //每次都取最大的value匹配----匹配后删去
            int temp=values.get(i);
            ArrayList<String> Match=new ArrayList<>();
            for(String a:Judege){
                if(Judge1.get(a)==temp){
                    Match.add(a);
                    Judege.remove(a);
                    Judge1.remove(a);
                }
            }
            Collections.sort(Match);
            ans.addAll(Match);
        }
        return ans;

    }

}
