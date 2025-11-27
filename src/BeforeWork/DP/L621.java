package DP;

/**
 * @author Etherstrings
 * @create 2022-09-02 11:42 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L621 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/2 - the current system date.  11:42 - the current system time.  2022 - the current year.  09 - the current month.  02 - the current day of the month.  11 - the current hour.  42 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L621 {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if (n == 0 || len == 1) {
            return len;
        }
        //每个任务出现了几次？
        int[] cnt = new int[26];
        for (char task : tasks) {
            cnt[task - 'A']++;
        }

        //出现的最多的任务出现了几次
        //有几个这样的任务
        int count = 0;
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                count = 1;
            } else if (cnt[i] == max) {
                count++;
            }
        }

        return Math.max(len, (max - 1) * (n + 1) + count);

    }

}
