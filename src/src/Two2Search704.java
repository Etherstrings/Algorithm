package src;

/**
 * @author Etherstrings
 * @create 2021-12-30 1:18 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  Two2Search704 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2021/12/30 - the current system date.  1:18 - the current system time.  2021 - the current year.  12 - the current month.  30 - the current day of the month.  01 - the current hour.  18 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  十二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十二月 - full name of a month. Example: January, February, etc
 */
public class Two2Search704 {
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    /**
     *  给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  
     *  写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     *
     *
     *
     *
     */
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length;
        //明确区间 [  )
        while(right>left){
            int middle=(right+left)/2;
            if(nums[middle]>target){
                right=middle;
            }else if(nums[middle]<target){
                left=middle+1;
            }else{
                return middle;
            }
        }
        return -1;

    }
}
