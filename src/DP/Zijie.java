package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-02-21 17:12 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Zijie - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/21 - the current system date.  17:12 - the current system time.  2023 - the current year.  02 - the current month.  21 - the current day of the month.  17 - the current hour.  12 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class Zijie {
    public static void main(String[] args) {
        System.out.println(getKTree(new int[]{1,3,2,4,7,5,9}));
    }

    public static int[] getKTree(int[] nums){
        //当前位置的最大值 包括当前位置
        int[] dp1=new int[nums.length];
        int[] dp2=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            if(i==0){
                dp1[i]=nums[0];
                continue;
            }
            dp1[i]=Math.max(dp1[i-1],nums[i]);
        }

        for(int i=nums.length-1;i>=0;i--){
            if(i== nums.length-1){
                dp2[i]=nums[nums.length-1];
                continue;
            }
            dp2[i]=Math.min(dp2[i+1],nums[i]);
        }
        //若有一个数，它前面的所有数都比它小，它后面的所有数都比它大。
        List<Integer> tans=new ArrayList<>();
        for(int i=0;i< nums.length;i++){
            if(i==0){
                //后边最小值都比现在的大
                if(nums[i]<dp2[i+1]){
                    tans.add(nums[i]);
                    continue;
                }
            }
            if(i== nums.length-1){
                if(nums[i]>dp1[i-1]){
                    tans.add(nums[i]);
                    continue;
                }
            }
            //比前边的最大值大
            if(nums[i]>dp1[i-1]&&nums[i]<dp2[i+1]){
                tans.add(nums[i]);
            }
        }
        int[] ans=new int[tans.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=tans.get(i);
        }
        return ans;
    }
}
