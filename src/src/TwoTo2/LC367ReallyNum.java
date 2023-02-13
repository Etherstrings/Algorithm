package src.TwoTo2;

/**
 * @author Etherstrings
 * @create 2022-01-06 15:26 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  TwoTo2.LC367ReallyNum - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/6 - the current system date.  15:26 - the current system time.  2022 - the current year.  01 - the current month.  06 - the current day of the month.  15 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */
public class LC367ReallyNum {

    public static void main(String[] args) {
        LC367ReallyNum lc367ReallyNum=new LC367ReallyNum();
        System.out.println(lc367ReallyNum.isPerfectSquare(361201));

    }

    /**
     * 367. 有效的完全平方数
     *
     * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
     *
     * 进阶：不要 使用任何内置的库函数，如  sqrt 。
     *
     * 示例 1：
     *
     * 输入：num = 16
     * 输出：true
     *
     * 示例 2：
     *
     * 输入：num = 14
     * 输出：false

     */

    public boolean isPerfectSquare(int num) {
        if(num==0){
            return true;
        }
        if(num==1){
            return true;
        }


        int left=1;
        int right=num;

        //左闭右闭
        while(right>=left){
            int mid=left+(right-left)/2;
            long rmid=(long) mid*mid;

            if(rmid<num){
                left=mid+1;
            }else if(rmid>num){
                right=mid-1;
            }else{
                return true;
            }
        }
        return false;


    }
}
