package leetcode.week302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-07-17 11:56 leetcode.week302 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6122 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/17 - the current system date.  11:56 - the current system time.  2022 - the current year.  07 - the current month.  17 - the current day of the month.  11 - the current hour.  56 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L6122 {

    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        List<Integer> Judge=new ArrayList<>();
        for(int a:nums){
            if(Judge.contains(a)){
                continue;
            }else {
                Judge.add(a);
            }
        }
        int whichone=Integer.MIN_VALUE;
        for(Integer a:Judge){
            boolean flag=true;
            for(Integer b:numsDivide){
                if(b%a!=0){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                whichone=a;
                break;
            }
        }
        int ans=-1;
        for(int i=0;i<Judge.size();i++){
            if(Judge.get(i)==whichone){
                ans=i+1;
            }
        }
        return ans;
    }
}
