package MovingWindow;

/**
 * @author Etherstrings
 * @create 2023-03-09 19:27 MovingWindow - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2379 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/9 - the current system date.  19:27 - the current system time.  2023 - the current year.  03 - the current month.  09 - the current day of the month.  19 - the current hour.  27 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L2379 {
    public int minimumRecolors(String blocks, int k) {
        //寻找连续黑块的最大值
        int n=blocks.length();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<=n-k;i++){
            int wcout=0;
            for(int j=i;j<i+k;j++){
                if(blocks.charAt(j)=='W'){
                    wcout++;
                }
            }
            ans=Math.min(wcout,ans);
        }
        return ans;
    }
}
