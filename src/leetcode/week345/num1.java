package leetcode.week345;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-05-14 10:20 leetcode.week345 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/14 - the current system date.  10:20 - the current system time.  2023 - the current year.  05 - the current month.  14 - the current day of the month.  10 - the current hour.  20 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        int[] show=circularGameLosers(12,5);
        for(int n:show){
            System.out.print(n+" ");
        }
    }
    public static int[] circularGameLosers(int n, int k) {
        int[] people=new int[n+1];
        int index=1;
        int i=1;
        people[index]++;
        while(people[index]!=2) {
            int len = i * k;
            i++;
            if (len < n) {
                if (n - index >= len) {
                    people[index+len]++;
                    index = index + len;
                } else {
                    int left = len - (n - index);
                    people[left]++;
                    index = left;
                }
            } else if (len > n) {
                len = len % n;
                if (n - index >= len) {
                    people[index+len]++;
                    index = index + len;
                } else {
                    int left = len - (n - index);
                    people[left]++;
                    index = left;
                }
            } else {
                //len=n
                people[index]++;
                index = index;
            }
        }
        List<Integer> Temp=new ArrayList<>();
        for(int j=1;j<=n;j++){
            if(people[j]==0){
                Temp.add(j);
            }
        }
        int[] ans=new int[Temp.size()];
        for(int j=0;j<Temp.size();j++){
            ans[j]=Temp.get(j);
        }
        return ans;
    }
}
