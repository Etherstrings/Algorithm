package DP;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-07-28 22:12 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L337_StealIII - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/28 - the current system date.  22:12 - the current system time.  2022 - the current year.  07 - the current month.  28 - the current day of the month.  22 - the current hour.  12 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L337_StealIII {
    //337. 打家劫舍 III
    //小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
    //
    //除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
    //
    //给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
    //
    //
    //
    //示例 1:
    //
    //
    //
    //输入: root = [3,2,3,null,3,null,1]
    //输出: 7
    //解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
    //示例 2:
    //
    //
    //
    //输入: root = [3,4,5,1,3,null,1]
    //输出: 9
    //解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
    public int rob(TreeNode root) {
        //树型 DP
        int[] ans=robtree(root);
        return Math.max(ans[0],ans[1]);
    }

    int[] robtree(TreeNode root){
        int res[]=new int[2];
        //终止递归条件
        if(root==null){
            return res;
        }

        int[] left=robtree(root.left);
        int[] right=robtree(root.right);

        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        res[1]=root.val+left[0]+right[0];
        return res;
    }
}
