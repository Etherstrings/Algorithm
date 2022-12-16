package src.Sword2Job;

/**
 * @author Etherstrings
 * @create 2022-04-20 11:50 Sword2Job - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  SII005 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/20 - the current system date.  11:50 - the current system time.  2022 - the current year.  04 - the current month.  20 - the current day of the month.  11 - the current hour.  50 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class SII005 {
    //剑指 Offer II 005. 单词长度的最大乘积
    //给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
    //
    //
    //
    //示例 1:
    //
    //输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
    //输出: 16
    //解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
    //示例 2:
    //
    //输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
    //输出: 4
    //解释: 这两个单词为 "ab", "cd"。
    //示例 3:
    //
    //输入: words = ["a","aa","aaa","aaaa"]
    //输出: 0
    //解释: 不存在这样的两个单词。
    public int maxProduct(String[] words) {
        //思路是什么？



        //维护当前遍历到的字符的长度

        //维护当前遍历到的字符的key
        //怎么判断是否含有相同的字符呢?
        //int [26] 每一个26都放进去
        int max=0;
        for(int i=0;i< words.length-1;i++){
            for(int j=i+1;j< words.length;j++){
                max=Integer.max(max,Twocompare(words[i],words[j]));
            }
        }
        return max;
    }

    public int Twocompare(String a,String b){
        int[] a1=new int[26];
        int[] b1=new int[26];
        for(int i=0;i<a.length();i++){
            a1[a.charAt(i)-'a']+=1;
        }
        for(int i=0;i<b.length();i++){
            b1[b.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++){
            if(a1[i]!=0&&b1[i]!=0){
                return 0;
            }
        }
        return (a1.length)* (b1.length);
    }


}
