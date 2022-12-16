package src.TwoPoint;

/**
 * @author Etherstrings
 * @create 2022-02-19 12:18 TwoPoint - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L11WhichMostWater - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/19 - the current system date.  12:18 - the current system time.  2022 - the current year.  02 - the current month.  19 - the current day of the month.  12 - the current hour.  18 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L11WhichMostWater {
    //11. 盛最多水的容器
    //给定一个长度为 n 的整数数组 height 。
    // 有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
    //
    //找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    //
    //返回容器可以储存的最大水量。
    //
    //说明：你不能倾斜容器。

    public int maxArea(int[] height) {
        //双指针
        //left  -  right
        //如何移动？
        //移动较小的
        int left=0;
        int right=height.length-1;
        int answer=0;
        while (left<right){
            int temp=(right-left)*Math.min(height[left],height[right]);
            answer=Math.max(answer,temp);
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return answer;

    }

}
