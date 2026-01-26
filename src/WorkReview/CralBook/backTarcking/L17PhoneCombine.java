package WorkReview.CralBook.backTarcking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-13
 */
public class L17PhoneCombine {

    //233
    public static List<String> ans;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits == null || Objects.equals(digits,"")) {
            return new ArrayList<>();
        }
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        back(0,digits,numString,new StringBuilder());
        return ans;
    }

    public void back(int numIndex,String digits,String[] numString,StringBuilder sb) {
        if (numIndex >= digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String str = numString[digits.charAt(numIndex)-'0'];
        for (int i=0;i<str.length();i++) {
            sb.append(str.charAt(i));
            back(numIndex+1,digits,numString,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
