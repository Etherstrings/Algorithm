package src.Tree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-04-03 23:04 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L113_L112II - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/3 - the current system date.  23:04 - the current system time.  2022 - the current year.  04 - the current month.  03 - the current day of the month.  23 - the current hour.  04 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L113_L112II {
    //113. 路径总和 II
    //给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
    //
    //叶子节点 是指没有子节点的节点。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
    //输出：[[5,4,11,2],[5,8,4,5]]
    //示例 2：
    //
    //
    //输入：root = [1,2,3], targetSum = 5
    //输出：[]
    //示例 3：
    //
    //输入：root = [1,2], targetSum = 0
    //输出：[]
    public List<List<Integer>> pathsum(TreeNode root, int targetsum) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res; // 非空判断

        List<Integer> path = new LinkedList<>();
        preorderdfs(root, targetsum, res, path);
        return res;
    }

    public void preorderdfs(TreeNode root, int targetsum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        // 遇到了叶子节点
        if (root.left == null && root.right == null) {
            // 找到了和为 targetsum 的路径
            if (targetsum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return; // 如果和不为 targetsum，返回
        }

        if (root.left != null) {
            preorderdfs(root.left, targetsum - root.val, res, path);
            path.remove(path.size() - 1); // 回溯
        }
        if (root.right != null) {
            preorderdfs(root.right, targetsum - root.val, res, path);
            path.remove(path.size() - 1); // 回溯
        }
    }
}
