package src;

/**
 * @author Etherstrings
 * @create 2022-01-13 22:06 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L747 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/13 - the current system date.  22:06 - the current system time.  2022 - the current year.  01 - the current month.  13 - the current day of the month.  22 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */
public class L747 {
    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.dominantIndex(new int[]{0,0,0,1}));
    }

    /**
     * 747. 至少是其他数字两倍的最大数
     *
     * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
     *
     * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。
     *
     * 如果是，则返回 最大元素的下标 ，否则返回 -1 。
     *
     *
     *
     */

    static class Solution {
        public int dominantIndex(int[] nums) {
            if(nums.length==1){
                return 0;
            }
            int max=-1;
            int numid=-1;
            for(int i=0;i<nums.length;i++){
                if(nums[i]>max){
                    max=nums[i];
                    numid=i;
                }

            }
            boolean flag=true;

            for(int i=0;i<nums.length;i++){
                if(i==numid){
                    continue;
                }
                if(nums[i]*2<=max){
                }else{
                    flag=false;
                }
            }



            if(flag==false){
                return -1;
            }

            return numid;

        }
    }
}
