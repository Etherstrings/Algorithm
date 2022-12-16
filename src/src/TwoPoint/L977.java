package src.TwoPoint;

/**
 * @author Etherstrings
 * @create 2022-01-09 17:54 TwoPoint - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L977 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/9 - the current system date.  17:54 - the current system time.  2022 - the current year.  01 - the current month.  09 - the current day of the month.  17 - the current hour.  54 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */
public class L977 {
    public int[] sortedSquares(int[] nums) {
    int[] result=new int[nums.length];
    int left=0;
    int right=nums.length-1;
    int write=nums.length-1;
    while(left<=right){
        if(nums[left]*nums[left]>nums[right]*nums[right]){
            //最重要的点在这
            //right指针不变
            //像左侧移动寻找
            //如果左侧第二大的值 依旧比右侧最大值还大
            //那就是次大值
            result[write]=nums[left]*nums[left];
            left+=1;
            write-=1;
        }else {
            //这里思考一下
            //如果右边最大值大于最左边
            //说明最大值已经找到
            //找下一个最大值

            result[write]=nums[right]*nums[right];
            right-=1;

            write-=1;

        }
    }
    return result;
    }
}
