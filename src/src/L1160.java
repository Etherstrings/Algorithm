package src;

import java.util.HashMap;
import java.util.Map;

public class L1160 {
    //拼写单词
    //Category	Difficulty	Likes	Dislikes
    //algorithms	Easy (68.47%)	162	-
    //Tags
    //Companies
    //给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
    //
    //假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
    //
    //注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
    //
    //返回词汇表 words 中你掌握的所有单词的 长度之和。
    //
    //
    //
    //示例 1：
    //
    //输入：words = ["cat","bt","hat","tree"], chars = "atach"
    //输出：6
    //解释：
    //可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
    //示例 2：
    //
    //输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
    //输出：10
    //解释：
    //可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
    public int countCharacters(String[] words, String chars) {
        //先取chars的HashMap---key-value
        //遍历words的word---判断是不是每个都能匹配
        HashMap<Character,Integer> Judge=new HashMap<>();
        for(Character a:chars.toCharArray()){
            if(Judge.containsKey(a)){
                Judge.put(a,Judge.get(a)+1);
            }else {
                Judge.put(a,1);
            }
        }
        int ans=0;
        for(String word:words){
            boolean flag=true;

            Map<Character,Integer> temp =(HashMap<Character,Integer>) Judge.clone();
            for(Character a:word.toCharArray()){
                if(temp.containsKey(a)){
                    //有a
                    if(temp.get(a)==1){
                        temp.remove(a);
                    }else {
                        temp.put(a,temp.get(a)-1);
                    }
                }else {
                    //没有a 拼不成
                    flag=false;
                    break;
                }
            }
            if(flag){
                ans+=word.length();
            }
        }
        return ans;
    }
}
