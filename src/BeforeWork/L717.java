/**
 * @author Etherstrings
 * @create 2022-02-20 21:14 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L717 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/20 - the current system date.  21:14 - the current system time.  2022 - the current year.  02 - the current month.  20 - the current day of the month.  21 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L717 {
    //717. 1比特与2比特字符
    //有两种特殊字符：
    //
    //第一种字符可以用一个比特 0 来表示
    //第二种字符可以用两个比特(10 或 11)来表示、
    //给定一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一位字符，则返回 true 。
    //
    // 
    //
    //示例 1:
    //
    //输入: bits = [1, 0, 0]
    //输出: true
    //解释: 唯一的编码方式是一个两比特字符和一个一比特字符。
    //所以最后一个字符是一比特字符。
    //示例 2:
    //
    //输入: bits = [1, 1, 1, 0]
    //输出: false
    //解释: 唯一的编码方式是两比特字符和两比特字符。
    //所以最后一个字符不是一比特字符。

    public boolean isOneBitCharacter(int[] bits){
        int n=bits.length;
        int i=n-2;
        while(i>=0&&bits[i]==1){
            --i;
        }

        return (n-i)%2==0;
    }
}
