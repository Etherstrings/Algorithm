package leetcode.week373;

import java.util.HashSet;
import java.util.Set;

public class num2 {
    //给你一个字符串 s 和一个正整数 k 。
    //
    //用 vowels 和 consonants 分别表示字符串中元音字母和辅音字母的数量。
    //
    //如果某个字符串满足以下条件，则称其为 美丽字符串 ：
    //
    //vowels == consonants，即元音字母和辅音字母的数量相等。
    //(vowels * consonants) % k == 0，即元音字母和辅音字母的数量的乘积能被 k 整除。
    //返回字符串 s 中 非空美丽子字符串 的数量。
    //
    //子字符串是字符串中的一个连续字符序列。
    //
    //英语中的 元音字母 为 'a'、'e'、'i'、'o' 和 'u' 。
    //
    //英语中的 辅音字母 为除了元音字母之外的所有字母。
    public static void main(String[] args) {
        //"eeebjoxxujuaeoqibd"
        //8
        String s = "eeebjoxxujuaeoqibd";
        int k = 8;
        System.out.println(beautifulSubstrings(s,k));
    }
    public static int beautifulSubstrings(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('o');
        set.add('i');
        set.add('u');
        //维护两个前缀和数组
        int[] a = new int[s.length()+1];
        int[] b = new int[s.length()+1];
        for(int i=1;i<=s.length();i++){
            if(set.contains(s.charAt(i-1))){
                a[i]=a[i-1]+1;
                b[i]=b[i-1];
            }else{
                a[i]=a[i-1];
                b[i]=b[i-1]+1;
            }
        }
        int res = 0;
        for(int i=1;i<=s.length();i++){
            for(int j=i;j<=s.length();j++){
                if((a[j]-a[i-1])==(b[j]-b[i-1])&&(a[j]-a[i-1])*(b[j]-b[i-1])%k==0){
                    res++;
                }
            }
        }
        return res;
    }
}
