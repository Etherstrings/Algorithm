package Moni;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-08-16 15:54 Moni - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2682 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/8/16 - the current system date.  15:54 - the current system time.  2023 - the current year.  08 - the current month.  16 - the current day of the month.  15 - the current hour.  54 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L2682 {
    public static void main(String[] args) {
    }
    public static int[] circularGameLosers(int n, int k) {
        //1-n
        int[] used=new int[n+1];
        used[1]=1;
        int round=1;
        boolean flag=true;
        int index=1;
        while(flag){
            int len=round*k;
            while(len!=0){
                index++;
                len--;
                if(index==n+1){
                    index=1;
                }
            }
            round++;
            used[index]++;
            if(used[index]==2){
                flag=false;
            }
        }
        List<Integer> tans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(used[i]==0){
                tans.add(i);
            }
        }
        int[] ans=new int[tans.size()];
        for(int i=0;i< tans.size();i++){
            ans[i]=tans.get(i);
        }
        return ans;
    }
}
