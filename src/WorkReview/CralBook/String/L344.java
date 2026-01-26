package WorkReview.CralBook.String;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-07
 */
public class L344 {
    public static void main(String[] args) {
        //示例 1：
        //
        //输入：s = ["h","e","l","l","o"]
        //输出：["o","l","l","e","h"]
        char[] test = new char[]{'h','e','l','l','o'};
        new L344().reverseString(test);
        System.out.println(test);
    }
    public void reverseString(char[] s) {
        int len = s.length/2;
        for (int i=0;i<len;i++) {
            char temp = s[i];
            s[i]=s[s.length-i-1];
            s[len-i-1]=temp;
        }
    }
}
