package src.TwoPoint;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2022-03-09 9:54 TwoPoint - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L16 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/9 - the current system date.  9:54 - the current system time.  2022 - the current year.  03 - the current month.  09 - the current day of the month.  09 - the current hour.  54 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */

//16. 最接近的三数之和
//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//
//返回这三个数的和。
//
//假定每组输入只存在恰好一个解。
//
//
//
//示例 1：
//
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//示例 2：
//
//输入：nums = [0,0,0], target = 1
//输出：0
public class L16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best=10000000;
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }

            //ijk
            //每次判断i+j+k
            //移动j和k
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[k]+nums[j];
                if(sum==target){
                    return target;
                }
                if(Math.abs(sum-target)<Math.abs(best-target)){
                    best=sum;
                }

                if(sum>target){
                    int knew=k-1;
                    while(j<knew&&nums[knew]==nums[k]){
                        knew--;
                    }
                    k=knew;
                }else{
                    int jnew=j+1;

                    while(jnew<k&&nums[jnew]==nums[j]){
                        jnew++;
                    }
                    j=jnew;
                }
            }

        }
        return best;
    }
}
