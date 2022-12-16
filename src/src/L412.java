package src;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-27 22:29 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L412 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/27 - the current system date.  22:29 - the current system time.  2022 - the current year.  08 - the current month.  27 - the current day of the month.  22 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L412 {
    //412. Fizz Buzz
    //给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
    //
    //answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
    //answer[i] == "Fizz" 如果 i 是 3 的倍数。
    //answer[i] == "Buzz" 如果 i 是 5 的倍数。
    //answer[i] == i （以字符串形式）如果上述条件全不满足。
    //
    //
    //示例 1：
    //
    //输入：n = 3
    //输出：["1","2","Fizz"]
    //示例 2：
    //
    //输入：n = 5
    //输出：["1","2","Fizz","4","Buzz"]
    public List<String> fizzBuzz(int n) {
        List<String> ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%15==0){
                ans.add("FizzBuzz");
                continue;
            }
            if(i%3==0){
                ans.add("Fizz");
                continue;
            }
            if(i%5==0){
                ans.add("Buzz");
                continue;
            }
            ans.add(String.valueOf(i));
        }
        return ans;
    }
}
