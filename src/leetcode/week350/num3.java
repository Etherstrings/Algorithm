package leetcode.week350;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-06-18 10:56 leetcode.week350 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/6/18 - the current system date.  10:56 - the current system time.  2023 - the current year.  06 - the current month.  18 - the current day of the month.  10 - the current hour.  56 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        System.out.println(specialPerm(new int[]{2,3,6}));
    }

    public static int specialPerm(int[] nums) {
        Path=new LinkedList<>();
        ans=0l;
        Used=new boolean[nums.length];
        backtarcking(nums);
        return (int) (ans%MOD);
    }
    static final int MOD = 1000000007;
    static LinkedList<Integer> Path;
    static Long ans;
    static boolean[] Used;
    //获取所有的排列
    public static void backtarcking(int[] nums){
        if(Path.size()==nums.length){
                List<Integer> temp=new ArrayList<>(Path);
                if(isVaild(temp)){
                    ans++;
                }
            return;
        }


        for(int i=0;i<nums.length;i++){
            //是不是用过了？
            if(Used[i]){
                continue;
            }
            Used[i]=true;
            Path.add(nums[i]);
            backtarcking(nums);
            Used[i]=false;
            Path.removeLast();
        }
    }

    //验证排列是不是对的
    public static boolean isVaild(List<Integer> nums){
        boolean flag=true;
        for(int i=0;i<nums.size()-1;i++){
            if((nums.get(i) % nums.get(i+1) != 0)&&(nums.get(i+1) % nums.get(i) != 0)){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
