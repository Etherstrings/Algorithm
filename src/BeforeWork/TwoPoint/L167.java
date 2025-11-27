package TwoPoint;

/**
 * @author Etherstrings
 * @create 2023-02-22 22:25 TwoPoint - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L167 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/22 - the current system date.  22:25 - the current system time.  2023 - the current year.  02 - the current month.  22 - the current day of the month.  22 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L167 {

    public static int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        int[] ans={0,0};
        while(left<right){
            int l=numbers[left];
            int r=numbers[right];
            if(l+r==target){
                ans[0]=left+1;
                ans[1]=right+1;
                break;
            }
            if(l+r>target){
                right--;
                continue;
            }
            if(l+r<target){
                left++;
                continue;
            }
        }
        return ans;
    }
}
