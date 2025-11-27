package TwoPoint;

/**
 * @author Etherstrings
 * @create 2022-01-09 16:37 TwoPoint - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L844 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/9 - the current system date.  16:37 - the current system time.  2022 - the current year.  01 - the current month.  09 - the current day of the month.  16 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */
public class L844 {
    public static void main(String[] args) {
        L844 l844 = new L844();
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(l844.backspaceCompare(s, t));

    }

    /**
     * 844. 比较含退格的字符串
     * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
     * <p>
     * 如果相等，返回 true ；否则，返回 false 。
     * <p>
     * 注意：如果对空文本输入退格字符，文本继续为空。
     * <p>
     * 输入：s = "a##c", t = "#a#c"
     * 输出：true
     * 解释：s 和 t 都会变成 “c”。
     */
    public boolean backspaceCompare(String s, String t) {
        return toRealString(s).equals(toRealString(t));
    }

    public String toRealString(String string) {
        char[] S = string.toCharArray();
        int j = 0;
        for (int i = 0; i < S.length; i++) {
            if (S[i] == '#') {
                j--;
                //少了个对j的判断 其他没问题了
                if (j < 0)
                    j = 0;
            } else {
                S[j] = S[i];
                j+=1;
            }
        }
        return String.valueOf(S, 0, j);
    }
}

