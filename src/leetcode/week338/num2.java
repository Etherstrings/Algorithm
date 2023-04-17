package leetcode.week338;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-03-26 10:38 leetcode.week338 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/26 - the current system date.  10:38 - the current system time.  2023 - the current year.  03 - the current month.  26 - the current day of the month.  10 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public List<Long> minOperations(int[] nums, int[] queries) {
        //每一次都减去queries[i]
        //累加就是答案
        List<Long> ans=new ArrayList<>();
        for(int target:queries){
            long temp=0;
            for(int n:nums){
                temp+=Math.abs(n-target);
            }
            ans.add(temp);
        }
        return ans;

    }
    static int N = 100010;
    static int[] A=new int[N];
    static int[] B=new int[N];
    static int[] C=new int[N];
    public static List<Long> getans(int[] nums,int[] queries){
        //构造A数组
        for(int i=0;i<nums.length;i++){
            A[i+1]=nums[i];
        }
        //构造B数组
        for(int i=1;i<=nums.length;i++){
            insert(i,i,A[i]);
        }
        List<Long> ans=new ArrayList<>();

        for(int target:queries){
            insert(1,nums.length,-target);
            //构造执行后的前缀和--执行后数组
            long sum=0;
            for(int i=1;i<=nums.length;i++){
                C[i]=C[i-1]+B[i];
                sum+=C[i];
            }
            //计算总和
            ans.add(sum);
            insert(1,nums.length,target);
        }
        return ans;

    }
    public static void insert(int l,int r,int c){
        B[l]+=c;
        B[r+1]-=c;
    }
}
