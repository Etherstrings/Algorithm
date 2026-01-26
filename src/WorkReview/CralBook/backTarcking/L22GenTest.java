package WorkReview.CralBook.backTarcking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-13
 */
public class L22GenTest {
    public static void main(String[] args) {
        new L22GenTest().generateParenthesis(3);
    }
    public static List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        back(new StringBuilder(),n,0);
        ans = ans.stream().filter(
                s -> isVaild(s)
        ).collect(Collectors.toList());
        return ans;
    }

    public void back(StringBuilder sb,int n,int index){
        if (index >= n*2) {
            if (sb.length() == n*2) {
                ans.add(sb.toString());
            }
            return;
        }
        for (int i=0;i<2;i++) {
            String now = i==0 ? "(":")";
            sb.append(now);
            back(sb,n,index+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public boolean isVaild(String str){
        if (str.isBlank()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        //每一次")"都会触发一次匹配
        for (Character now : str.toCharArray()) {
            if (now == '(') {
                stack.push(')');
            } else {
                //当前未')'
                //如果未空说明不会匹配了
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() != now) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
