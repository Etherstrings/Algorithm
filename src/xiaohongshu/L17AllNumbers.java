package xiaohongshu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-23
 */
public class L17AllNumbers {

    //输入：digits = "23"
    //输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    //示例 2：
    //
    //输入：digits = "2"
    //输出：["a","b","c"]
    public static void main(String[] args) {
        System.out.println(new L17AllNumbers().letterCombinations("23"));
    }


    public List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backTracking(ans, temp, digits, 0, phoneMap);
        return ans;
    }

    private void backTracking(List<String> ans, List<String> temp, String digits, int i, Map<Character, String> phoneMap) {
        if (i == digits.length()) {
            //当前这个位置拼到末尾了
            ans.add(String.join("", temp));
            return;
        }
        String canJoinLetters = phoneMap.get(digits.charAt(i));
        for (int j=0;j<canJoinLetters.length();j++) {
            temp.add(String.valueOf(canJoinLetters.charAt(j)));
            backTracking(ans, temp, digits, i+1, phoneMap);
            temp.remove(temp.size()-1);
        }
    }
}
