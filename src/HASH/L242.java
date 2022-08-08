package HASH;

import java.util.HashMap;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-02-06 13:14
 */
public class L242 {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     *
     */
    public boolean isAnagram(String s, String t) {
        int[] answer=new int[26];
        for(char c:s.toCharArray()){
            answer[c-'a']+=1;
        }
        for(char c:t.toCharArray()){
            answer[c-'a']-=1;
        }

        for(int i:answer){
            if(i!=0){
                return false;
            }
        }

        return true;
    }


    /**
     *
     * @param ransomNote
     * @param magazine
     * @return
     *
     * L383
     *
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] answer=new int[26];
        for(char c:magazine.toCharArray()){
            answer[c-'a']+=1;
        }

        for(char c:ransomNote.toCharArray()){
            answer[c-'a']-=1;
            if(answer[c-'a']<0){
                return false;
            }
        }
        return true;
    }


    public boolean isAnagram1(String s, String t){
        //判断s和t是不是相同字母组成的 只是位置不同
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> sh=new HashMap<>();
        HashMap<Character,Integer> th=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(sh.containsKey(s.charAt(i))){
                sh.put(s.charAt(i),sh.get(s.charAt(i))+1);
            }else {
                sh.put(s.charAt(i),1);
            }

            if(th.containsKey(t.charAt(i))){
                th.put(t.charAt(i),th.get(t.charAt(i))+1);
            }else {
                th.put(t.charAt(i),1);
            }
        }
        Set<Character> schars = sh.keySet();
        Set<Character> tchars = th.keySet();
        boolean Flag=true;
        for(Character a:schars){
            if(!tchars.contains(a)){
                Flag=false;
                break;
            }
            if(sh.get(a)!=th.get(a)){
                Flag=false;
                break;
            }
        }
        return Flag;

    }
}
