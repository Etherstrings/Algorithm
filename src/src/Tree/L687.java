package src.Tree;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-09-02 0:19 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L687 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/2 - the current system date.  0:19 - the current system time.  2022 - the current year.  09 - the current month.  02 - the current day of the month.  00 - the current hour.  19 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L687 {
    int res;
    public int longestUnivaluePath(Tree.TreeNode root) {
        res=0;
        DFS(root);
        return res;
    }

    int DFS(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=DFS(root.left);
        int right=DFS(root.right);
        int left1=0;int right1=0;
        if(root.left!=null&&root.left.val==root.val){
            left1=left+1;
        }
        if(root.right!=null&&root.right.val==root.val){
            right1=right+1;
        }
        res=Math.max(res,left1+right1);
        return Math.max(left1,right1);
    }
}
