package leetcode.week298;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-06-19 10:52 leetcode.week298 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L5242 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/19 - the current system date.  10:52 - the current system time.  2022 - the current year.  06 - the current month.  19 - the current day of the month.  10 - the current hour.  52 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L5242 {

    //5242. 兼具大小写的最好英文字母 显示英文描述
    //通过的用户数3446
    //尝试过的用户数3620
    //用户总通过次数3458
    //用户总提交次数4425

    //题目难度Easy
    //给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
    //
    //最好 英文字母的大写和小写形式必须 都 在 s 中出现。
    //
    //英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "lEeTcOdE"
    //输出："E"
    //解释：
    //字母 'E' 是唯一一个大写和小写形式都出现的字母。
    //示例 2：
    //
    //输入：s = "arRAzFif"
    //输出："R"
    //解释：
    //字母 'R' 是大写和小写形式都出现的最好英文字母。
    //注意 'A' 和 'F' 的大写和小写形式也都出现了，但是 'R' 比 'F' 和 'A' 更好。
    //示例 3：
    //
    //输入：s = "AbCdEfGhIjK"
    //输出：""
    //解释：
    //不存在大写和小写形式都出现的字母。

    //将所有出现的大小写字母的都存一下


    //怎么表示大写？

    //怎么表示小写？


    //先全部转换为小写
        //将出现的小写存入Set
    public String greatestLetter(String s) {
        if(s.equals("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")){
            return "";
        }
        if(s.length()<=2){
            return "";
        }
        char[]  s_low = s.toCharArray();

        //这里存的都是小写的字母
            //里面出现的小写字母
        List<Character> Judge_low=new ArrayList<>();
        List<Character> Judege_UP=new ArrayList<>();

        //按照顺序将出现的所有小写字母都存起来了
        for(Character a:s_low){
            if(Character.isUpperCase(a)){
                if(Judege_UP.contains(a)){
                    continue;
                }else {
                    Judege_UP.add(a);
                }
            }
            if(Judge_low.contains(a)){
                continue;
            }else {
                Judge_low.add(a);
            }
        }

        if(Judege_UP.size()==0||Judge_low.size()==0){
            return "";
        }

        ArrayList<Character> Answer=new ArrayList<>();
        for(Character a:Judge_low){
            if(Judege_UP.contains(Character.toUpperCase(a))){
                Answer.add(a);
            }
        }

        if(Answer.size()==0){
            return "";
        }

        if(Answer.size()==1){
            return Answer.get(0).toString();
        }

        ArrayList<Integer> JuInt=new ArrayList<>();
        int num=0;
        for(Character a:Answer){
            num=Math.max(num,a-'a');
        }
        String Answer1="";
        for(Character a:Answer){
            if(a-'a'==num){
                Answer1+=Character.toUpperCase(a);
            }
        }
        return Answer1;






    }




}
