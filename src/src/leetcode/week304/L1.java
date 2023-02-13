package src.leetcode.week304;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2022-07-31 10:22 leetcode.week304 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/31 - the current system date.  10:22 - the current system time.  2022 - the current year.  07 - the current month.  31 - the current day of the month.  10 - the current hour.  22 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L1 {

    public int minimumOperations(int[] nums) {
        //每一步选择最小值
        Arrays.sort(nums);
        int value=Integer.MAX_VALUE;
        for(int a:nums){
            if(a!=0){
                value=a;
                break;
            }

        }
        if(value==Integer.MAX_VALUE){
            return 0;
        }
        if(value==nums[nums.length-1]){
            return 1;
        }
        int level=0;
        ArrayList<Integer> Judge=new ArrayList<>();
        for(int a:nums){
            Judge.add(a);
        }

        while(Judge.get(Judge.size()-1)!=0){
            int min=-1;
            for(int a:Judge){
                if(a!=0){
                    min=a;
                    break;
                }
            }
            int Max=Judge.get(Judge.size()-1);
            for(int i=0;i<Judge.size();i++){
                if(Judge.get(i)==0){
                    continue;
                }else {
                    Judge.set(i,Judge.get(i)-min);
                }
            }
            level++;
        }
        return level;

    }

}
