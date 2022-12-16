package src;

/**
 * @author Etherstrings
 * @create 2022-02-23 23:39 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L917 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/23 - the current system date.  23:39 - the current system time.  2022 - the current year.  02 - the current month.  23 - the current day of the month.  23 - the current hour.  39 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L917 {
    //917. 仅仅反转字母
    //给你一个字符串 s ，根据下述规则反转字符串：
    //
    //所有非英文字母保留在原有位置。
    //所有英文字母（小写或大写）位置反转。
    //返回反转后的 s 。
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();

        //双指针
        //头指针0
        //尾指针index-1
        //头>尾 停止
        //头不是字母 头++
        //尾不是字母 尾--
        //头尾都是字母 头++ 尾--
        int start=0;
        int end=chars.length-1;

        while(start<end){
            if(!Character.isLetter(chars[start])){
                start++;
            }
            if(!Character.isLetter(chars[end])){
                end--;
            }

            if(Character.isLetter(chars[start])&&Character.isLetter(chars[end])){
                char temp=chars[start];
                chars[start]=chars[end];
                chars[end]=temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}
