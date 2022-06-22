package StringExer;

import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-06-22 23:58 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L500 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/22 - the current system date.  23:58 - the current system time.  2022 - the current year.  06 - the current month.  22 - the current day of the month.  23 - the current hour.  58 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L500 {
    //500. 键盘行
    //给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
    //
    //美式键盘 中：
    //
    //第一行由字符 "qwertyuiop" 组成。
    //第二行由字符 "asdfghjkl" 组成。
    //第三行由字符 "zxcvbnm" 组成。
    //American keyboard
    //
    //
    //
    //示例 1：
    //
    //输入：words = ["Hello","Alaska","Dad","Peace"]
    //输出：["Alaska","Dad"]
    //示例 2：
    //
    //输入：words = ["omk"]
    //输出：[]
    //示例 3：
    //
    //输入：words = ["adsdf","sfd"]
    //输出：["adsdf","sfd"]
    public String[] findWords(String[] words) {
        //思路
        //1.遍历words-判断
        //2.三个Set存三行
        //3.挨个判断---一旦有一个字母不在这个Set中--寄
                        //Set中全存小写字母----遍历时候大写转小写
                        //---全都在---加入
        ArrayList<String> Judge=new ArrayList<>();
        for(String word: words){
            if(isture(word)){
                Judge.add(word);
            }
        }

        String[] answer=new String[Judge.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=Judge.get(i);
        }
        return answer;

    }
    Set<Character> set1=new HashSet<>();
    Set<Character> set2=new HashSet<>();
    Set<Character> set3=new HashSet<>();

    boolean isture(String word){
        String line1="qwertyuiop";
        String line2="asdfghjkl";
        String line3="zxcvbnm";
        for(Character a:line1.toCharArray()){
            set1.add(a);
        }
        for(Character a:line2.toCharArray()){
            set2.add(a);
        }
        for(Character a:line3.toCharArray()){
            set3.add(a);
        }

        boolean Flag=true;
        int index1=0;
        int index2=0;
        int index3=0;
        int index=0;
        for(Character a:word.toCharArray()){

            if(Character.isUpperCase(a)){
                a = Character.toLowerCase(a);
            }

            if(index==0){
                //第一次进来
                if(set1.contains(a)){
                    index1++;
                }
                if(set2.contains(a)){
                    index2++;
                }
                if(set3.contains(a)){
                    index3++;
                }
                index++;
            }else {
                if(index1!=0){
                    if(set1.contains(a)){
                        index1++;
                        continue;
                    }else {
                        Flag=false;
                        break;
                    }
                }
                if(index2!=0){
                    if(set1.contains(a)){
                        index2++;
                        continue;
                    }else {
                        Flag=false;
                        break;
                    }
                }
                if(index3!=0){
                    if(set3.contains(a)){
                        index3++;
                        continue;
                    }else {
                        Flag=false;
                        break;
                    }
                }
            }
        }
        return Flag;
    }
}
