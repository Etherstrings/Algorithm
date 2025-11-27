package HASH;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-08 10:24
 */
public class L383 {
    //383. 赎金信
    //给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
    //
    //如果可以，返回 true ；否则返回 false 。
    //
    //magazine 中的每个字符只能在 ransomNote 中使用一次。
    //
    //
    //
    //示例 1：
    //
    //输入：ransomNote = "a", magazine = "b"
    //输出：false
    //示例 2：
    //
    //输入：ransomNote = "aa", magazine = "ab"
    //输出：false
    //示例 3：
    //
    //输入：ransomNote = "aa", magazine = "aab"
    //输出：true
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] Judge=new int[26];
        Arrays.fill(Judge,0);
        for(char a:magazine.toCharArray()){
            Judge[a-'a']+=1;
        }
        for(char a:ransomNote.toCharArray()){
            Judge[a-'a']-=1;
        }
        for(int a:Judge){
            if(a<0){
                return false;
            }
        }
        return true;
    }
}
