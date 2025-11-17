package TanXin;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2023-03-17 10:58 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2389 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/17 - the current system date.  10:58 - the current system time.  2023 - the current year.  03 - the current month.  17 - the current day of the month.  10 - the current hour.  58 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i=0;i<queries.length;i++){
            int target=queries[i];
            int len=0;
            int sum=0;
            for(int j=0;j<nums.length;j++){
                sum+=nums[j];
                if(sum>target){
                    queries[i]=len;
                    break;
                }
                len++;
                if(len==nums.length){
                    queries[i]=len;
                    break;
                }
            }
        }
        return queries;
    }
}
