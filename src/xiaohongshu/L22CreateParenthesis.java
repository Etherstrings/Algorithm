package xiaohongshu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-23
 */
public class L22CreateParenthesis {
    public static void main(String[] args) {
        System.out.println(new L22CreateParenthesis().generateParenthesis(3));
    }
    //输入：n = 3 输出：["((()))","(()())","(())()","()(())","()()()"]
    public List<String> generateParenthesis(int n) {
        //全排列
        List<String> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backTracking(ans,temp,0,n);
        ans = ans.stream().filter(
                s -> isVaild(s)
        ).collect(Collectors.toList());
        return ans;
    }

    private void backTracking(List<String> ans, List<String> temp, int i, int n) {
        if (temp.size() == 2*n) {
            ans.add(String.join("",temp));
            return;
        }
        for (int j=0;j<2;j++) {
            temp.add(j==0 ? "(" : ")");
            backTracking(ans,temp,i+1,n);
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
