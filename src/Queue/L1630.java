package Queue;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-23 23:16 Queue - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1630 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/23 - the current system date.  23:16 - the current system time.  2023 - the current year.  03 - the current month.  23 - the current day of the month.  23 - the current hour.  16 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int left=l[i];
            int right=r[i];
            boolean flag=true;
            List<Integer> temp=new ArrayList<>();
            for(int j=left;j<=right;j++){
                temp.add(nums[j]);
            }
            Collections.sort(temp);
            if(temp.size()==2){
                ans.add(true);
                continue;
            }
            int t=temp.get(1)-temp.get(0);
            for(int k=1;k<temp.size();k++){
                if(temp.get(k)!=temp.get(0)+k*t){
                    flag=false;
                    break;
                }
            }
            ans.add(flag);
        }
        return ans;
    }
}
