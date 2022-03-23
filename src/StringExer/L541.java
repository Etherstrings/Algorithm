package StringExer;

/**
 * @author Etherstrings
 * @create 2022-02-16 0:28 StringExer - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L541 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/16 - the current system date.  0:28 - the current system time.  2022 - the current year.  02 - the current month.  16 - the current day of the month.  00 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L541 {
    //541. 反转字符串 II
    //给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
    //
    //如果剩余字符少于 k 个，则将剩余字符全部反转。
    //如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

    public String reverseStr(String s, int k) {
        char[] ch=s.toCharArray();

        //每2k字符 翻转前k个字符
        for(int i=0;i<ch.length;i+=2*k){
            //判断是否够
            if(i+k<=ch.length){
                reverse(ch,i,i+k-1);
                continue;
            }
            //不够的话如何
            reverse(ch,i,ch.length-1);
        }

        return new String(ch);

    }

    public void reverse(char[] ch,int i,int j){
        for(;i<j;i++,j--){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
        }
    }

}
