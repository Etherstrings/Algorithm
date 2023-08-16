package leetcode.week356;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2023-07-30 10:52 leetcode.week356 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/30 - the current system date.  10:52 - the current system time.  2023 - the current year.  07 - the current month.  30 - the current day of the month.  10 - the current hour.  52 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public int countCompleteSubarrays(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        if(map.size()==1){
            int ans=1;
            for(int v: map.values()){
                ans=v;
            }
            return (ans+1)*ans/2;
        }
        int ans=1;
        int now=nums[0];
        int len=1;
        for(int i=1;i<nums.length;i++){
            if(i==nums.length-1){
                if(nums[i]==now){
                    len++;
                    ans*=len;
                    continue;
                }else {
                    ans*=len;
                    now=nums[i];
                    len=1;
                    continue;
                }
            }
            if(nums[i]==now){
                len++;
                continue;
            }else {
                ans*=len;
                len=1;
                now=nums[i];
            }
        }
        return ans;
    }
}
