/**
 * @author Etherstrings
 * @create 2022-06-10 9:39 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L43 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/10 - the current system date.  9:39 - the current system time.  2022 - the current year.  06 - the current month.  10 - the current day of the month.  09 - the current hour.  39 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L43 {
    //43. 字符串相乘
    //给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
    //
    //注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
    //
    //
    //
    //示例 1:
    //
    //输入: num1 = "2", num2 = "3"
    //输出: "6"
    //示例 2:
    //
    //输入: num1 = "123", num2 = "456"
    //输出: "56088"
    public String multiply(String num1, String num2) {
        int Asnwer=String2Int(num1)*String2Int(num2);

        return Integer.toString(Asnwer);

    }

    private int CharToInt(Character c){
        return c-'0';
    }

    private int String2Int(String num){
        int level=0;
        int Inum=0;
        for(int i=num.length()-1;i>=0;i--){
            if(level==0){
                Inum+=CharToInt(num.charAt(i));
                level++;
            }else {
                Inum+=CharToInt(num.charAt(i))^level;
                level++;
            }

        }
        return Inum;
    }

}
