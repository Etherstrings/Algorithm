package TwoTo2; /**
 * @author Etherstrings
 * @create 2022-01-03 21:47 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  TwoTo2.L34HaveSame2Find - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/3 - the current system date.  21:47 - the current system time.  2022 - the current year.  01 - the current month.  03 - the current day of the month.  21 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */


import java.util.Arrays;
import java.util.List;

/**
 *  给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 *
 *
 */
public class L34HaveSame2Find {
    public static void main(String[] args) {
        int[] n={5,7,7,8,8,10};
        List<int[]> num=Arrays.asList(n);
        System.out.println(Arrays.asList(num).contains(8));
    }

    //target 小于最小值 大于最大值
        //target在数组范围中 但是不存在
            //target在数组范围中 存在
    public int[] searchRange(int[] nums, int target) {


        if(target<nums[0]&&target>nums[nums.length-1]){
            return new int[]{-1,-1};
        }
        Boolean Flag=true;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                Flag=false;
            }
        }
        if(Flag==true){
            return new int[]{-1,-1};
        }
        int left=0;
        int right=nums.length-1;
        int RightBo=-2;
        int LeftBo=-2;
        //先查找右区间  不包括
        while(right>=left){
            int mid=(left+right)/2;
            if(target>=nums[mid]){// target=num[mid]
                left=mid+1;
                RightBo=left;
            }else{
                right=mid-1;
            }
        }
        //再查询左区间 也是不包括
        int left1=0;
        int right1=nums.length-1;
        while(right1>=left1){
            int mid=(left1+right1)/2;
            if(target<=nums[mid]){
                right1=mid-1;
                LeftBo=right1;
            }else{
                left1=mid+1;
            }
        }
        int[] answer=new int[RightBo-LeftBo-1];
        for(int i=0;i<answer.length;i++){
            answer[i]=LeftBo+i+1;
        }
        return answer;
    }
}
