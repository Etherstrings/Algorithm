/**
 * @author Etherstrings
 * @create 2022-07-27 19:18 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L592 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/27 - the current system date.  19:18 - the current system time.  2022 - the current year.  07 - the current month.  27 - the current day of the month.  19 - the current hour.  18 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L592 {
    //592. 分数加减运算
    //给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。
    //
    //这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
    //
    //
    //
    //示例 1:
    //
    //输入: expression = "-1/2+1/2"
    //输出: "0/1"
    // 示例 2:
    //
    //输入: expression = "-1/2+1/2+1/3"
    //输出: "1/3"
    //示例 3:
    //
    //输入: expression = "1/3-1/2"
    //输出: "-1/6"
    //
    //
    //提示:
    //
    //输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。
    //输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
    //输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
    //输入的分数个数范围是 [1,10]。
    //最终结果的分子与分母保证是 32 位整数范围内的有效整数。
    public String fractionAddition(String expression) {
        char[] chars = expression.toCharArray();
        if(chars[0]=='-'){
            int temp=0;
            for(int i=1;i<chars.length;i++){
                while(chars[i]=='-'||chars[i]=='+'){

                }
            }
        }
        return "";
    }

}
