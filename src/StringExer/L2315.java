package StringExer;

import java.util.Stack;

/**
 * @author Justice_wby
 * @create 2023-01-29 0:09
 */
public class L2315 {
    //2315. 统计星号
    //给你一个字符串 s ，每 两个 连续竖线 '|' 为 一对 。换言之，第一个和第二个 '|' 为一对，第三个和第四个 '|' 为一对，以此类推。
    //
    //请你返回 不在 竖线对之间，s 中 '*' 的数目。
    //
    //注意，每个竖线 '|' 都会 恰好 属于一个对。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "l|*e*et|c**o|*de|"
    //输出：2
    //解释：不在竖线对之间的字符加粗加斜体后，得到字符串："l|*e*et|c**o|*de|" 。
    //第一和第二条竖线 '|' 之间的字符不计入答案。
    //同时，第三条和第四条竖线 '|' 之间的字符也不计入答案。
    //不在竖线对之间总共有 2 个星号，所以我们返回 2 。
    public int countAsterisks(String s) {
        int ans=0;
        Stack<Character> stack=new Stack<>();
        for(char now:s.toCharArray()){
            if(now=='|'){
                if(stack.isEmpty()){
                    stack.push(now);
                    continue;
                }else {
                    stack.empty();
                    continue;
                }
            }
            if(now=='*'){
                if(stack.isEmpty()){
                    ans++;
                }
            }
        }
        return ans;
    }
}
