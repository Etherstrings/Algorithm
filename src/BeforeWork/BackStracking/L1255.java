package BackStracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-02-26 12:17 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1255 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/26 - the current system date.  12:17 - the current system time.  2023 - the current year.  02 - the current month.  26 - the current day of the month.  12 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L1255 {
    //[]
    //[]
    //[]
    public static void main(String[] args) {
        String[] words={"dog","cat","dad","good"};
        char[] letters=new char[]{'a','a','c','d','d','d','g','o','o'};
        int[] score={1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(maxScoreWords(words,letters,score));
    }
    //单词拼写游戏的规则概述如下：
    //
    //玩家需要用字母表 letters 里的字母来拼写单词表 words 中的单词。
    //可以只使用字母表 letters 中的部分字母，但是每个字母最多被使用一次。
    //单词表 words 中每个单词只能计分（使用）一次。
    //根据字母得分情况表score，字母 'a', 'b', 'c', ... , 'z' 对应的得分分别为 score[0], score[1], ..., score[25]。
    //本场游戏的「得分」是指：玩家所拼写出的单词集合里包含的所有字母的得分之和。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/maximum-score-words-formed-by-letters
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] chars=new int[26];
        for(char n:letters){
            //统计当前有多少字符
            chars[n-'a']++;
        }
        int ans=0;
        temp=new ArrayList<>();
        Backtarcking(words,chars,0);
        for(String t:temp){
            int sum=0;
            for(char n:t.toCharArray()){
                sum+=score[n-'a'];
            }
            ans=Math.max(sum,ans);
        }
        return ans;
    }
    static List<String> temp;
    static LinkedList<String> Path=new LinkedList<>();
    static void Backtarcking(String[] words,int[] chars,int index){
        if(index==words.length){
            if(Path.size()!=0){
                String t="";
                ArrayList<String> strings = new ArrayList<>(Path);
                for(String s:strings){
                    t+=s;
                }
                if(t.equals("")){

                }else {
                    temp.add(t);
                }

            }
            return;
        }
        for(int i=index;i<words.length;i++){
            //选
            //选的上
            //选不上
            String chose=choose(chars,words[i]);
            if(chose.equals("")){

            }else {
                Path.add(chose);
                Backtarcking(words,chars,i+1);
                getback(chars,words[i]);
                Path.removeLast();
            }
            //不选
            Backtarcking(words,chars,i+1);
        }
    }

    static String choose(int[] chars,String word){
        String ans="";
        int[] t=new int[26];
        for(char n:word.toCharArray()){
            t[n-'a']++;
        }
        boolean flag=true;
        for(int i=0;i<chars.length;i++){
            if(chars[i]<t[i]){
                flag=false;
                break;
            }
        }
        if(flag){
            for(int i=0;i<chars.length;i++){
                chars[i]=chars[i]-t[i];
            }
            ans=word;
        }
        return ans;
    }

    static void getback(int[] chars,String word){
        for(char n:word.toCharArray()){
            chars[n-'a']++;
        }
    }
}
