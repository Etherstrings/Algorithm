import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-03-02 22:48 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L6 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/2 - the current system date.  22:48 - the current system time.  2022 - the current year.  03 - the current month.  02 - the current day of the month.  22 - the current hour.  48 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L6 {

    //将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
    //
    //比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
    //
    //P   A   H   N
    //A P L S I I G
    //Y   I   R
    //之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
    //
    //请你实现这个将字符串进行指定行数变换的函数：
    //
    //string convert(string s, int numRows);
    // 
    //
    //示例 1：
    //
    //输入：s = "PAYPALISHIRING", numRows = 3
    //输出："PAHNAPLSIIGYIR"
    //示例 2：
    //输入：s = "PAYPALISHIRING", numRows = 4
    //输出："PINALSIGYAHRPI"
    //解释：
    //P     I    N
    //A   L S  I G
    //Y A   H R
    //P     I
    //示例 3：
    //
    //输入：s = "A", numRows = 1
    //输出："A"

    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int slength = chars.length;
        if(numRows==1||numRows>slength){
            return s;
        }
        //先判断走了多少个周期
        int round=(numRows-1)*2;




        int columnlength=(slength+round-1)/round*(numRows-1);

        //等到需要填充的数组的行和列
        char[][] ans=new char[numRows][columnlength];

        for(int i=0,x=0,y=0;i<slength;i++){
            ans[x][y]=chars[i];
            if(i%round<numRows-1){
                //向下移动
                x++;
            }else{
                //向右上方移动
                x--;
                y++;
            }
        }
        StringBuffer relAnswer=new StringBuffer();
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[i].length;j++){
                if(ans[i][j]!=0){
                    relAnswer.append(ans[i][j]);
                }

            }
        }

        return relAnswer.toString();
    }
}
