package src.TwoPoint;

/**
 * @author Etherstrings
 * @create 2022-04-01 13:34 TwoPoint - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  S2006 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/1 - the current system date.  13:34 - the current system time.  2022 - the current year.  04 - the current month.  01 - the current day of the month.  13 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class S2006 {
    //给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
    //
    //函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
    //
    //假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
    //
    // 
    //
    //示例 1：
    //
    //输入：numbers = [1,2,4,6,10], target = 8
    //输出：[1,3]
    //解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
    //示例 2：
    //
    //输入：numbers = [2,3,4], target = 6
    //输出：[0,2]
    //示例 3：
    //
    //输入：numbers = [-1,0], target = -1
    //输出：[0,1]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/kLl5u1
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int[] twoSum(int[] numbers, int target) {
        //双指针
        int left=0;
        int right=numbers.length-1;
        int answer=0;
        int[] relanswer=new int[2];
        while(left<right){
            answer=numbers[left]+numbers[right];
            if(answer<target){
                left++;
            }else if(answer>target){
                right--;
            }else if(answer==target){
                relanswer[0]=left;
                relanswer[1]=right;
                break;
            }
        }
        return relanswer;

    }
}
