package DP;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2023-05-04 11:00 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L124_TreeDP - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/4 - the current system date.  11:00 - the current system time.  2023 - the current year.  05 - the current month.  04 - the current day of the month.  11 - the current hour.  00 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L124_TreeDP {
    //124. 二叉树中的最大路径和
    //二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
    //
    //路径和 是路径中各节点值的总和。
    //
    //给你一个二叉树的根节点 root ，返回其 最大路径和 。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：root = [1,2,3]
    //输出：6
    //解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
    //示例 2：
    //
    //
    //输入：root = [-10,9,20,null,null,15,7]
    //输出：42
    //解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0; // 没有节点，和为 0
        int lVal = dfs(node.left); // 左子树最大链和
        int rVal = dfs(node.right); // 右子树最大链和
        ans = Math.max(ans, lVal + rVal + node.val); // 两条链拼成路径
        return Math.max(Math.max(lVal, rVal) + node.val, 0); // 当前子树最大链和
    }

}
