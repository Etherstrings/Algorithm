package src.TwoTo2;

/**
 * @author Etherstrings
 * @create 2021-12-31 23:41 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  TwoTo2.Leetcode352break - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2021/12/31 - the current system date.  23:41 - the current system time.  2021 - the current year.  12 - the current month.  31 - the current day of the month.  23 - the current hour.  41 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  十二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十二月 - full name of a month. Example: January, February, etc
 */
public class Leetcode352break {
    /**
     *
     * @param nums
     * @param target
     * @return
     *
     * 定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     */
    public static void main(String[] args) {
        Leetcode352break leetcode352break=new Leetcode352break();
        int[] nums=new int[]{1,3,5,6};

        System.out.println(leetcode352break.break2search(nums,2));
    }

    public int break2search(int[] nums, int target){
            //肯定是用二分法
        int left=0;
        int right=nums.length;
        int end=0;
        //采用的方式为左闭右开区间
        //[ )
        //从头到尾要采用这个方式

        while(left<right){
            int mid=(left+right)/2;
            if(target==nums[mid]){
                return mid;
            }
            if(target<nums[mid]){
                right=mid;
                end=right;
            }else{
                left=mid+1;
                end=left;
            }
        }
        return end;
    }
}
