package StringExer;

/**
 * @author Etherstrings
 * @create 2022-02-14 18:00 StringExer - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L344Reverse - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/14 - the current system date.  18:00 - the current system time.  2022 - the current year.  02 - the current month.  14 - the current day of the month.  18 - the current hour.  00 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L344Reverse {
    //344. 反转字符串

    public void reverseString(char[] s) {
        //思路
        //双指针
        //left 0-----length/2
        //right length-1----length/2
        int length=s.length;


        int right=length-1;
        char temp;
        for(int i=0;i<length/2;i++){
                temp=s[i];
                s[i]=s[right];
                s[right]=temp;
                right-=1;
        }

    }
}
