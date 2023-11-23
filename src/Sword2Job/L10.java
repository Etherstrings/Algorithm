package Sword2Job;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-03-08 14:25 Sword2Job - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L11 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/8 - the current system date.  14:25 - the current system time.  2022 - the current year.  03 - the current month.  08 - the current day of the month.  14 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L10 {
    public int fib(int n) {
        n=fix(n);
        return n;
    }

    public int fix(int n){
        if(n<2){
            return n;
        }
        return (fix(n-1)+fix(n-2))%1000000007;
    }
}


class Solution {

    Map<Integer,Integer> hashMap = new HashMap<>();

    public int fib(int n) {
        if (n <2) return n;

        if (hashMap.get(n) != null) {
            return hashMap.get(n);
        }
        int sum = (fib(n-1)+fib(n-2)) % 1000000007;
        hashMap.put(n,sum);
        return sum;
    }
}

