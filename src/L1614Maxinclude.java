/**
 * @author Etherstrings
 * @create 2022-01-07 15:04 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L1614Maxinclude - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/7 - the current system date.  15:04 - the current system time.  2022 - the current year.  01 - the current month.  07 - the current day of the month.  15 - the current hour.  04 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */

public class L1614Maxinclude {

    /** 1614. 括号的最大嵌套深度
     *  给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
     *
     *
     *
     */
    public int maxDepth(String s) {

        int size=0;
        int ans=0;
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;++i){

            if(chars[i]=='('){
                size+=1;
                ans=Math.max(ans,size);
            }
            if(chars[i]==')'){
                size+=1;
            }


        }
        return ans;
    }

    class Solution {
        public int maxDepth(String s) {
            int ans = 0, size = 0;
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    ++size;
                    ans = Math.max(ans, size);
                } else if (ch == ')') {
                    --size;
                }
            }
            return ans;
        }
    }

}
