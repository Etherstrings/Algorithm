package TwoPoint;

/**
 * @author Etherstrings
 * @create 2022-01-09 16:02 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  TwoPoint.L26TwoPoint - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/9 - the current system date.  16:02 - the current system time.  2022 - the current year.  01 - the current month.  09 - the current day of the month.  16 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */
public class L26TwoPoint {
    /**
     *
     * @param nums
     * @return
     *  26. 删除有序数组中的重复项
     *
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int removeDuplicates(int[] nums) {
        int num=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){

                    nums[j]=nums[j+1];
                }
            }
            num+=1;
        }
        return num;

    }

    public int removeDuplicates1(int[] nums){
        //分析
        //重复 有序
        //说明重复的只会连续出现
        //不会出现类似 2 2  3  2 2 2的情况
        //只需要判断 当前新指向的位置与前一个位置是否相同
        //慢 无问题的数组
        //快 顺序遍历
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int slow=1;

        for(int fast=1;fast<nums.length;fast++){
            if(nums[fast]!=nums[fast-1]){
                nums[slow]=nums[fast];
                slow+=1;
            }
            //如果相等 那slow就停下来不动
            //fast继续往下走！
        }
        return slow;
    }
}
