package StringExer;

/**
 * @author Etherstrings
 * @create 2022-02-19 21:35 StringExer - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L14 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/19 - the current system date.  21:35 - the current system time.  2022 - the current year.  02 - the current month.  19 - the current day of the month.  21 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L14 {
    //14. 最长公共前缀
    //编写一个函数来查找字符串数组中的最长公共前缀。
    //
    //如果不存在公共前缀，返回空字符串 ""。
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        int length=strs[0].length();
        int count=strs.length;
        for(int i=0;i<length;i++){
            char c=strs[0].charAt(i);
            for(int j=1;j<count;j++){
                if(i==strs[j].length()||strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
