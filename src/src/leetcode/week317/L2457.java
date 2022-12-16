package src.leetcode.week317;

/**
 * @author Etherstrings
 * @create 2022-11-01 15:23 leetcode.week317 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2457 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/1 - the current system date.  15:23 - the current system time.  2022 - the current year.  11 - the current month.  01 - the current day of the month.  15 - the current hour.  23 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L2457 {
    public long makeIntegerBeautiful(long n, int target) {
        long ans=0;
        long now=getsum(n);
        if(now<=target){
            return ans;
        }
        while(now>target){
            ans++;
            long test=n+ans;
            now=getsum(test);
            if(now<=target){
                break;
            }
        }
        return ans;
    }

    public static long getsum(long n){
        String now=n+"";
        long sum=0;
        for(char a:now.toCharArray()){
            sum+=Integer.parseInt(a+"");
        }
        return sum;
    }

    public static long getsum1(long n){
        long sum=0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}
