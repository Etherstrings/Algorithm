package WorkReview.CralBook.backTarcking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-13
 */
public class L22Gen {
    public static void main(String[] args) {
        new L22Gen().generateParenthesis(3);
    }
    public List<String> generateParenthesis(int n) {
        //全排列
        List<String> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backTracking(ans,temp,n);
        ans.forEach(now-> System.out.println(now));
        ans = ans.stream().filter(
                s -> isVaild(s)
        ).collect(Collectors.toList());
        return ans;
    }

    private void backTracking(List<String> ans, List<String> temp, int n) {
        if (temp.size() == 2*n) {
            ans.add(String.join("",temp));
            return;
        }
        for (int j=0;j<2;j++) {
            temp.add(j==0 ? "(" : ")");
            backTracking(ans,temp,n);
            temp.remove(temp.size()-1);
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
