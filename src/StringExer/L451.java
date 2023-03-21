package StringExer;

import java.util.*;

public class L451 {
    //给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
    //
    //返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
    //
    //
    //
    //示例 1:
    //
    //输入: s = "tree"
    //输出: "eert"
    //解释: 'e'出现两次，'r'和't'都只出现一次。
    //因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
    //示例 2:
    //
    //输入: s = "cccaaa"
    //输出: "cccaaa"
    //解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
    //注意"cacaca"是不正确的，因为相同的字母必须放在一起。
    //示例 3:
    //
    //输入: s = "Aabb"
    //输出: "bbAa"
    //解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
    //注意'A'和'a'被认为是两种不同的字符。
    public String frequencySort(String s) {
        //根据出现次数排序
        Comparator<Map.Entry<Character,Integer>> com=new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        };
        Map<Character,Integer> Judge=new HashMap<>();
        for(Character a:s.toCharArray()){
            if(Judge.containsKey(a)){
                Judge.put(a,Judge.get(a)+1);
            }else {
                Judge.put(a,1);
            }
        }
        List<Map.Entry> AsnwerList=new ArrayList<>();
        for(Map.Entry a:Judge.entrySet()){
            AsnwerList.add(a);
        }
        Collections.sort(AsnwerList,com);
        String ans="";
        for(Map.Entry a:AsnwerList){
            ans+=a.getKey();
        }
        return ans;
    }

    public String frequencySort1(String s){
        //上方思路应该是对的
        Map<Character,Integer> Judge=new HashMap<>();
        for(Character a:s.toCharArray()){
            if(Judge.containsKey(a)){
                Judge.put(a,Judge.get(a)+1);
            }else {
                Judge.put(a,1);
            }
        }

        List<Integer> Value=new ArrayList<>();
        for(Integer a:Judge.values()){
            Value.add(a);
        }
        Collections.sort(Value, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1;
            }
        });

        String ans="";
        for(int i=0;i<Value.size();i++){
            int many=Value.get(i);
            for(Map.Entry a:Judge.entrySet()){
                if((int)a.getValue()==many){
                    for(int k=0;k<many;k++){
                        ans+=a.getKey();
                    }
                    Judge.remove(a.getKey());
                }
                break;
            }
        }
        return ans;

    }

}
