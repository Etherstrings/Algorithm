/**
 *
 *
 * @author Etherstrings
 * @create 2022-01-05 12:19 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L1576 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/5 - the current system date.  12:19 - the current system time.  2022 - the current year.  01 - the current month.  05 - the current day of the month.  12 - the current hour.  19 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */

    //1576. 替换所有的问号



/**
 *  给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 *
 * 注意：你 不能 修改非 '?' 字符。
 *
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 *
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class L1576 {
    public static void main(String[] args) {
        L1576 l1576=new L1576();
        System.out.println(l1576.modifyString("j?qg??b"));
    }
    public String modifyString(String s) {
        char[] temp = {'a', 'b', 'c', 'd', 'e'};

        if(s.equals("?")){
            return "a";
        }
        if(s.equals("??")){
            return "ab";
        }
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                if (i == 0) {
                    int n = 0;
                    do {
                        chars[i] = temp[n];
                        n += 1;
                    } while (chars[i] == chars[i + 1]);
                } else if (i == chars.length - 1) {
                    int n = 0;
                    do {
                        chars[i] = temp[n];
                        n += 1;
                    } while (chars[i] == chars[i - 1]);
                } else {
                    int n = 0;
                    do {
                        chars[i] = temp[n];
                        n += 1;
                    } while (chars[i] == chars[i - 1] || chars[i] == chars[i + 1]);
                }
            }
        }
        String answer =String.valueOf(chars);


        return answer;
    }
}
