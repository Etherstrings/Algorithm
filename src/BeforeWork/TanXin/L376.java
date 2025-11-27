package TanXin;

/**
 * @author Etherstrings
 * @create 2022-07-12 20:32 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L376 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/12 - the current system date.  20:32 - the current system time.  2022 - the current year.  07 - the current month.  12 - the current day of the month.  20 - the current hour.  32 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L376 {
    //376. 摆动序列
    //如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
    //
    //例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
    //
    //相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
    //子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
    //
    //给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。

    //动态规划的思路
    //目的 删除或者不删除 返回一个摆动序列的最长子序列
    //局部最优是什么？
    //一次单调中保持最短---这样的可以保持能够有更多的波峰
    //全局最优是什么？
    //每次都最短  在固定长度中有最多的波峰

    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }


        //当前差值
        int curDiff=0;
        //上一个差值
        int preDiff=0;

        //默认有一个波峰
        int cont=1;

        for(int i=1;i<nums.length;i++){
            //得到当前差值----因为要从1-0开始
            curDiff=nums[i]-nums[i-1];
            if(curDiff>0&&preDiff<=0||preDiff>=0&&curDiff<0){
                //找到
                //1.当前的差值>0 那波峰需要之前的差值<=0
                //2.当前的差值>0 那波峰需要之前的差值<=0
                cont++;
                preDiff=curDiff;
            }
        }
        return cont;
    }

}
