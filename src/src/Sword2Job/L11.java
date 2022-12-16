package src.Sword2Job;

/**
 * @author Etherstrings
 * @create 2022-03-08 23:22 Sword2Job - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L11 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/8 - the current system date.  23:22 - the current system time.  2022 - the current year.  03 - the current month.  08 - the current day of the month.  23 - the current hour.  22 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L11 {
    //剑指 Offer 11. 旋转数组的最小数字
    //把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    //
    //给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
    //
    //示例 1：
    //
    //输入：[3,4,5,1,2]
    //输出：1
    //示例 2：
    //
    //输入：[2,2,2,0,1]
    //输出：0
    public int minArray(int[] numbers) {

        //判断从哪个数开始
        //比后面的大
        if(numbers.length==1){
            return numbers[0];
        }
        int answer=-1;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>numbers[i+1]){
                answer=numbers[i+1];
                break;
            }else {
                continue;
            }
        }
        return answer;

    }

    public int minArray1(int[] numbers) {
        int left=0;
        int right=numbers.length-1;

        while(left<right){
            int mid=left+(right-left)/2;

            if(numbers[mid]<numbers[right]){
                right=mid;
            }else if(numbers[mid]>numbers[right]){
                left=mid+1;
            }else {
                right-=1;
            }
        }

        return numbers[left];
    }

}
