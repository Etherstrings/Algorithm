package src.SecondTime.Tree.CengXu;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-08-15 22:46 SecondTime.Tree.CengXu - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L543 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/15 - the current system date.  22:46 - the current system time.  2022 - the current year.  08 - the current month.  15 - the current day of the month.  22 - the current hour.  46 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L543 {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        //左子树与右子树的路径最大和
        if(root==null){
            return 0;
        }
        dfs(root);
        return max;
    }

    //当前传入节点的最大值
    int dfs(TreeNode root){
        if(root.left==null&&root.right==null){
            return 0;
        }
        int leftsize;
        int rightsize;
        if(root.left==null){
            leftsize=0;
        }else {
            leftsize=dfs(root.left)+1;
        }

        if(root.right==null){
            rightsize=0;
        }else {
            rightsize=dfs(root.right)+1;
        }

        max=Math.max(max,rightsize+leftsize);
        return Math.max(leftsize,rightsize);
    }
}
