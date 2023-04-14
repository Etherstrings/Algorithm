package leetcode.week340;

/**
 * @author Etherstrings
 * @create 2023-04-09 12:34 leetcode.week340 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6361 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/9 - the current system date.  12:34 - the current system time.  2023 - the current year.  04 - the current month.  09 - the current day of the month.  12 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L6361 {
    public int diagonalPrime(int[][] nums) {
        int n=nums[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            if(isPrime(nums[i][i])){
                ans=Math.max(ans,nums[i][i]);
            }
            if(isPrime(nums[i][n-1-i])){
                ans=Math.max(ans,nums[i][n-1-i]);
            }
        }
        return ans;
    }

    public boolean isPrime(int x){
        if(x<=1)return false;
        for(int i=2;i*i<=x;i++){
            if(x%i==0)return false;
        }
        return true;
    }
}
