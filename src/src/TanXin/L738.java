package src.TanXin;

/**
 * @author Etherstrings
 * @create 2022-07-22 0:23 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L738 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/22 - the current system date.  0:23 - the current system time.  2022 - the current year.  07 - the current month.  22 - the current day of the month.  00 - the current hour.  23 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L738 {
    //738. 单调递增的数字
    //当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
    //
    //给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
    //
    //
    //
    //示例 1:
    //
    //输入: n = 10
    //输出: 9
    //示例 2:
    //
    //输入: n = 1234
    //输出: 1234
    //示例 3:
    //
    //输入: n = 332
    //输出: 299
    //
    //
    //提示:
    //
    //0 <= n <= 109
    public int monotoneIncreasingDigits(int n) {
        //找到一个单调递增的数 这个数＜n

        //从后往前遍历

        //如果 i-1 的数 > i
        //那么 [i-1]= [i-1]-1  [i]=9
        String s = Integer.toString(n);
        char[] chars = s.toCharArray();
        int start=s.length();
        for(int i=s.length()-1;i>0;i--){
            if(s.charAt(i-1)>s.charAt(i)){
                chars[i-1]=(char)((Integer.valueOf(s.charAt(i-1))-1)+'0');
                start=i;
            }
        }
        for(int i=start;i<s.length();i++){
            chars[i]='9';
        }
        String sans="";
        for(char a:chars){
            sans+=a;
        }
        return Integer.valueOf(sans);
    }
}
