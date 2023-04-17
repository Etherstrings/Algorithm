package DP;

import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-03-03 16:14 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L120 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/3 - the current system date.  16:14 - the current system time.  2023 - the current year.  03 - the current month.  03 - the current day of the month.  16 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L120 {

    //每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/triangle
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int minimumTotal(List<List<Integer>> triangle) {
        int ans=Integer.MAX_VALUE;
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int[][] dp=new int[triangle.size()][];
        int[] first=new int[]{triangle.get(0).get(0)};
        dp[0]=first;
        for(int i=1;i<triangle.size();i++){
            int[] temp=new int[triangle.get(i).size()];
            for(int j=0;j<triangle.get(i).size();j++){
                //只能从的节点过来
                int now=triangle.get(i).get(j);
                if(j==0){
                    temp[j]=dp[i-1][j]+now;
                    continue;
                }
                if(j==triangle.get(i).size()-1){
                    temp[j]=dp[i-1][dp[i-1].length-1]+now;
                    continue;
                }
                temp[j]=Math.min(dp[i-1][j]+now,dp[i-1][j-1]+now);
            }
            dp[i]=temp;
        }
        for(int i=0;i<dp[dp.length-1].length;i++){
            ans=Math.min(dp[dp.length-1][i],ans);
        }
        return ans;
    }
}
