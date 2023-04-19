/**
 * @author Etherstrings
 * @create 2022-02-19 21:26 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L12 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/19 - the current system date.  21:26 - the current system time.  2022 - the current year.  02 - the current month.  19 - the current day of the month.  21 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L12 {
    //12. 整数转罗马数字
    //罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
    //
    //字符          数值
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    //例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
    //
    //通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
    //
    //I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
    //X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
    //C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
    //给你一个整数，将其转为罗马数字。


    static String[] sym={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    static int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    public static String intToRoma(int num){
        StringBuffer ans=new StringBuffer();
        //从左侧有限匹配最大的值给num
        for(int i=0;i<sym.length;i++){
            int value=values[i];
            String str=sym[i];
            while(num>=value){
                num=num-value;
                ans.append(str);
            }
            if(num==0){
                break;
            }
        }
        return ans.toString();
    }
}
