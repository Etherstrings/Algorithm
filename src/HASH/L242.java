package HASH;

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
}
