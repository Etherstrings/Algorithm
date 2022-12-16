package src;

/**
 * @author Etherstrings
 * @create 2022-06-25 21:45 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L912 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/25 - the current system date.  21:45 - the current system time.  2022 - the current year.  06 - the current month.  25 - the current day of the month.  21 - the current hour.  45 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L912 {
    //912. 排序数组
    //给你一个整数数组 nums，请你将该数组升序排列。
    public int[] sortArray(int[] nums) {
        //快排
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public static void quickSort(int[] nums,int start,int end) {
        //什么时候递归结束
        if (start > end) {
            return;
        }

        //当前第一个值作为基准
        int first = nums[start];

        //双指针
        int left = start;
        int right = end;

        while (left != right) {
            //找到第一个比基准值小的值，右指针指向
            while (right > left && nums[right] >= first) {
                right--;
            }
            // 找出第一个比基准值大的值，并将左指针指向它
            while (left < right && nums[left] <= first) {
                left++;
            }

            // 条件允许，将左指针所指的值与右指针所指的值交换
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        // 此时左右指针指向同一位置，将基准值与该位置的值交换
        nums[start] = nums[left];
        nums[left] = first;

        // 将左边数组进行一次递归
        quickSort(nums, start, left - 1);
        // 右边数组进行递归
        quickSort(nums, left + 1, end);
    }

}
