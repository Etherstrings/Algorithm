package src.Tree;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-05-30 20:15 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1022 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/30 - the current system date.  20:15 - the current system time.  2022 - the current year.  05 - the current month.  30 - the current day of the month.  20 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L1022 {
    //1022. 从根到叶的二进制数之和
    //给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
    //
    //例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
    //对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
    //
    //返回这些数字之和。题目数据保证答案是一个 32 位 整数。

    public int sumRootToLeaf(TreeNode root) {

        return BackTarcking(root,0);
    }

    //回溯
   int BackTarcking(TreeNode root,int val){
        if(root==null){

            return 0;
        }
        val=(val<<1)|root.val;
        if(root.left==null&&root.right==null){
            return val;
        }
        return BackTarcking(root.left,val)+BackTarcking(root.right,val);
    }
}
