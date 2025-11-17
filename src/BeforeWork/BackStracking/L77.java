package BackStracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-09 10:17 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L77 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/9 - the current system date.  10:17 - the current system time.  2022 - the current year.  05 - the current month.  09 - the current day of the month.  10 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L77 {
    //77. 组合
    //给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
    //
    //你可以按 任何顺序 返回答案。
    //
    //
    //
    //示例 1：
    //
    //输入：n = 4, k = 2
    //输出：
    //[
    //  [2,4],
    //  [3,4],
    //  [2,3],
    //  [1,2],
    //  [1,3],
    //  [1,4],
    //]
    //示例 2：
    //
    //输入：n = 1, k = 1
    //输出：[[1]]
    //
    //
    //提示：
    //
    //1 <= n <= 20
    //1 <= k <= n

    //回溯的第一题

    //回溯 抽象为树结构
    //树 多层 每一层都有不同的分支

    //For循环来进行本层的遍历
    //递归 进入下一层
    List<List<Integer>> result=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        //startindex=1;
        backStacking(n,k,1);
        return result;

    }

    private void backStacking(int n,int k,int startindex){

        //首先肯定写的是终止条件
        if(path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }

        //每一层怎么处理
        //首先要遍历该层 然后再进入下一层

        //不减枝的写法
        for(int i=startindex;i<=n;i++){
            //路径添加当前的节点
            path.add(i);
            //处理当前的节点 //递归处理这一条分支
            backStacking(n,k,i+1);
            path.removeLast();
        }


    }
}
