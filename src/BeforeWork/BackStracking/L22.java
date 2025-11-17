package BackStracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-09 11:45
 */
public class L22 {
    //括号生成全排列

    //22. 括号生成
    //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    //
    //
    //
    //示例 1：
    //
    //输入：n = 3
    //输出：["((()))","(()())","(())()","()(())","()()()"]
    //示例 2：
    //
    //输入：n = 1
    //输出：["()"]

    public List<String> generateParenthesis(int n) {
        //如果全排列 不满足所有的深搜结果都是满足的
        //全排列怎么深搜呢
        List<String> res=new ArrayList<>();
        if(n==0){
            return res;
        }
        dfs("",n,n,res);
        return res;
        //n
    }
    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    void dfs(String curStr, int left, int right, List<String> res){
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 为什么 因为只有剪枝 没有判断可用与否的条件
        if(left==0&&right==0){
            //左右两边都用完了
            //生成了一个可用的括号组合
            res.add(curStr);
            return;
        }

        if(left>right)
            return;

        if(left>0){
            dfs(curStr+"(",left-1,right,res);
        }

        if(right>0){
            dfs(curStr+")",left,right-1,res);
        }
    }
}
