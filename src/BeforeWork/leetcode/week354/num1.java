package leetcode.week354;

/**
 * @author Etherstrings
 * @create 2023-07-16 10:29 leetcode.week354 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/16 - the current system date.  10:29 - the current system time.  2023 - the current year.  07 - the current month.  16 - the current day of the month.  10 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        System.out.println(sumOfSquares(new int[]{1,2,3,4}));
    }

    public static int sumOfSquares(int[] nums) {
        int ans=0;
        int len=nums.length;
        for(int i=0;i<nums.length;i++){
            int index=i+1;
            if(len%index==0){
                ans+=nums[i]*nums[i];
            }
        }
        return ans;

    }
}
