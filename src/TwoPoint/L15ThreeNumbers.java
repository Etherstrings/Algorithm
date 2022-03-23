package TwoPoint;

/**
 * @author Etherstrings
 * @create 2022-01-10 10:17 TwoPoint - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L15ThreeNumbers - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/10 - the current system date.  10:17 - the current system time.  2022 - the current year.  01 - the current month.  10 - the current day of the month.  10 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */


/**
 *
 * 15. 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *


 */
public class L15ThreeNumbers {
    public static void main(String[] args) {
        L15ThreeNumbers l15ThreeNumbers=new L15ThreeNumbers();
        int[] nums={-1,0,1,2,-1,-4};

        int[] answer=l15ThreeNumbers.threeSum(nums);
        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }


    }



    //三重循环肯定不对劲
    public int[] threeSum(int[] nums) {

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){

                        int[] answer={nums[i],nums[j],nums[k]};

                        return answer;
                    }
                }
            }
        }
        return null;
    }
}
