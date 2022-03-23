package StringExer;

/**
 * @author Etherstrings
 * @create 2022-02-16 19:40 StringExer - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  LSword05 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/16 - the current system date.  19:40 - the current system time.  2022 - the current year.  02 - the current month.  16 - the current day of the month.  19 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class LSword05 {
    //剑指 Offer 05. 替换空格
    //请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    public String replaceSpace(String s) {
        StringBuffer answer=new StringBuffer(s);
        while(answer.indexOf(" ")!=-1){
            int start=answer.indexOf(" ");
            answer.replace(start,start+1,"%20");
        }

        return answer.toString();
    }
}
