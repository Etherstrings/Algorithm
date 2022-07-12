import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-07-11 21:47 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1160 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/11 - the current system date.  21:47 - the current system time.  2022 - the current year.  07 - the current month.  11 - the current day of the month.  21 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L1160 {
    //1160. 拼写单词
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
        //先存chars
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
            HashMap<Character,Integer> clone =(HashMap<Character, Integer>)Judge.clone();
            for(Character a:word.toCharArray()){
                if(clone.containsKey(a)){
                    //如果当前有a
                    if(clone.get(a)==1){
                        //如果当前有a且只剩1
                        clone.remove(a);
                    }else {
                        clone.put(a,clone.get(a)-1);
                    }
                }else {
                    //当前没有a---那就是拼不起来
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
