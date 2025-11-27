package leetcode.week336;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2023-03-12 10:50 leetcode.week336 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  10:50 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  10 - the current hour.  50 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num3 {

    public long beautifulSubarrays(int[] nums) {
        long ans=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(vild(nums,i,j)){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static boolean vild(int[] nums,int i,int j){
        Queue<Integer> big = new PriorityQueue<>((x, y) -> (x - y));
        for(int index=i;index<=j;index++){
            big.offer(nums[index]);
        }
        boolean flag=true;
        while(!big.isEmpty()){
            int biggset=big.poll();
            if(big.isEmpty()){
                flag=false;
                break;
            }
            if(big.peek()==biggset){
                big.poll();
                if(big.isEmpty()){
                    flag=false;
                    break;
                }
            }else if(big.peek()<biggset){
                int left=biggset-big.poll();
                big.offer(left);
            }
        }
        return flag;
    }

}
