package ToBigFactory.DP;

/**
 * @author Etherstrings
 * @create 2023-07-30 14:41 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L718 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/30 - the current system date.  14:41 - the current system time.  2023 - the current year.  07 - the current month.  30 - the current day of the month.  14 - the current hour.  41 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L718 {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        int result = 0;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result;
    }
}
