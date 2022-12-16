package src.Tree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-04-01 9:29 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L257 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/1 - the current system date.  9:29 - the current system time.  2022 - the current year.  04 - the current month.  01 - the current day of the month.  09 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L257 {
    //257. 二叉树的所有路径
    //给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
    //
    //叶子节点 是指没有子节点的节点。
    //
    //
    //示例 1：
    //
    //
    //输入：root = [1,2,3,null,5]
    //输出：["1->2->5","1->3"]
    //示例 2：
    //
    //输入：root = [1]
    //输出：["1"]
    /**
     * 递归法
     */

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);
        // 叶子结点
        if (root.left == null && root.right == null) {
            // 输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
        if (root.right != null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
    }
}
