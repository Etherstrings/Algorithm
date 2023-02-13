package src;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2022-02-13 21:42 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L1189 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/13 - the current system date.  21:42 - the current system time.  2022 - the current year.  02 - the current month.  13 - the current day of the month.  21 - the current hour.  42 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L1189 {
    //1189. “气球” 的最大数量
    //给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
    //
    //字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
    //

    public int maxNumberOfBalloons(String text) {

        char[] chars = text.toCharArray();
        int[] balloon=new int[5];
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='b'){
                balloon[0]++;
            }
            if(chars[i]=='a'){
                balloon[1]++;
            }
            if(chars[i]=='l'){
                balloon[2]++;
            }
            if(chars[i]=='o'){
                balloon[3]++;
            }
            if(chars[i]=='n'){
                balloon[4]++;
            }
        }

        balloon[2]/=2;
        balloon[3]/=2;

        Arrays.sort(balloon);
        return balloon[0];


    }
}
