package Mianshi.Dajiang;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2022-08-14 19:11 Mianshi.Dajiang - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Code1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/14 - the current system date.  19:11 - the current system time.  2022 - the current year.  08 - the current month.  14 - the current day of the month.  19 - the current hour.  11 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class Code1 {
    public boolean containsNearbyDuplic(int[] nums, int k) {
        if(nums.length==2){
            if(nums[0]==nums[1]){
                if(k<=1){
                    return true;
                }else {
                    return false;
                }
            }
        }
        int left=0;
        for(int right=1;right<nums.length;right++){
            if(nums[left]==nums[right]){

            }
        }
        return true;
    }


    public int longestWPI(int[] hours) {
        int[] temp=new int[2];
        int len=0;
       for(int i=0;i<hours.length-1;i++){
           for(int j=i+1;j<hours.length;j++){
               temp=trans(i,j,hours);
               if(temp[0]>temp[1]){
                   len=Math.max(len,j-i);
               }
           }
       }
       return len;


    }
    int[] trans(int i,int j,int[] hours){
        int[] ans=new int[2];
        Arrays.fill(ans,0);
        for(;i<j;i++){
            if(hours[i]>8){
                ans[0]+=1;
            }else {
                ans[1]+=1;
            }
        }
        return ans;
    }
}
