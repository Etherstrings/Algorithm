package TanXin;

/**
 * @author Etherstrings
 * @create 2023-03-15 23:10 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2383 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/15 - the current system date.  23:10 - the current system time.  2023 - the current year.  03 - the current month.  15 - the current day of the month.  23 - the current hour.  10 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans=0;
        int esum=0;
        for(int n:energy){
            esum+=n;
        }
        if(initialEnergy<esum){
            ans+=esum-initialEnergy+1;
        }
        for(int n:experience){
            if(initialExperience<n){
                ans+=n-initialExperience+1;
            }
            initialExperience=initialExperience+n;
        }
        return ans;
    }
}
