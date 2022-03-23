package HASH;

import sun.security.krb5.Asn1Exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-02-13 22:18 HASH - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L15ThreeNumber - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/13 - the current system date.  22:18 - the current system time.  2022 - the current year.  02 - the current month.  13 - the current day of the month.  22 - the current hour.  18 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L15ThreeNumber {
    //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    //
    //注意：答案中不可以包含重复的三元组。
    //

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer=new ArrayList<>();
        //先对nums进行排序
        //这样双指针的话就可以有序
        Arrays.sort(nums);


        //定义a的位置
        for(int i=0;i<nums.length;i++){


            if(nums[i]>0){
                return answer;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }

            int left=i+1;
            int right=nums.length-1;

            while(right>left){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum>0){
                    right-=1;

                }
                if(sum<0){
                    left+=1;

                }
                if(sum==0){
                    answer.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }

        return answer;
    }
}
