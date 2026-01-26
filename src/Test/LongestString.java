package Test;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-19
 */
public class LongestString {
    //给你一个字符串 s，找到 s 中最长的 回文 子串。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "babad"
    //输出："bab"
    //解释："aba" 同样是符合题意的答案。
    //示例 2：
    //
    //输入：s = "cbbd"
    //输出："bb"
    //
    //
    //提示：
    //
    //1 <= s.length <= 1000
    //s 仅由数字和英文字母组成
    public static void main(String[] args) {
        String s = "bb";
        System.out.println(getLongest(s));
    }
    public static String getLongest(String input) {
        String ans = "";
        int size = 0;
        int n = input.length();
        for (int i=1;i<n-1;i++) {
            int left = i-1;
            int right = i+1;
            StringBuilder sb = new StringBuilder();
            sb.append(input.charAt(i));
            size = Math.max(sb.length(),size);
            if (!(size > 1)) {
                ans = sb.toString();
            }
            while (left>=0 && right<=n-1) {
                StringBuilder temp = new StringBuilder();
                temp.append(input.charAt(left));
                temp.append(sb);
                temp.append(input.charAt(right));
                if (isVaild(temp)) {
                    size = Math.max(temp.length(),size);
                    if (size == temp.length()) {
                        ans = temp.toString();
                        sb = temp;
                    }
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            left = i-1;
            sb = new StringBuilder();
            sb.append(input.charAt(i));
            while (left>=0) {
                StringBuilder temp = new StringBuilder();
                temp.append(input.charAt(left));
                temp.append(sb);
                if (isVaild(temp)) {
                    size = Math.max(temp.length(),size);
                    if (size == temp.length()) {
                        ans = temp.toString();
                        sb = temp;
                    }
                }
                left--;
            }
            right = i+1;
            sb = new StringBuilder();
            sb.append(input.charAt(i));
            while (right<=n-1) {
                StringBuilder temp = new StringBuilder();
                temp.append(sb);
                temp.append(input.charAt(right));
                if (isVaild(temp)) {
                    size = Math.max(temp.length(),size);
                    if (size == temp.length()) {
                        ans = temp.toString();
                        sb = temp;
                    }
                }
                right++;
            }
        }
        return ans;
    }

    public static boolean isVaild (StringBuilder sb) {
        if (sb.length() == 1) {
            return true;
        }
        for (int i=0;i<sb.length()/2;i++) {
            if (sb.charAt(i) != sb.charAt(sb.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
