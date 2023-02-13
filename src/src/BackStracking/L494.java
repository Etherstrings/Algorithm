package src.BackStracking;

/**
 * @author Etherstrings
 * @create 2022-09-02 12:25 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L494 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/2 - the current system date.  12:25 - the current system time.  2022 - the current year.  09 - the current month.  02 - the current day of the month.  12 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L494 {
    //回溯
    int sum=0;
    int ans=0;
    public int findTargetSumWays(int[] nums, int target) {
        DFS(0,nums,target);
        return ans;
    }

    void DFS(int startindex,int[] nums,int target){
        if(startindex==nums.length){
            if(sum==target){
                ans++;
            }
            return;
        }
            sum+=nums[startindex];
            DFS(startindex+1,nums,target);
            sum-=nums[startindex];
            sum-=nums[startindex];
            DFS(startindex+1,nums,target);
            sum+=nums[startindex];

    }
}
