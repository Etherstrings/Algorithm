package ToBigFactory.Tree;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2023-07-04 20:31 ToBigFactory.Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  JudgeBalanceTree - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/4 - the current system date.  20:31 - the current system time.  2023 - the current year.  07 - the current month.  04 - the current day of the month.  20 - the current hour.  31 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class JudgeBalanceTree {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(getdep(root)==-1){
            return false;
        }
        return true;
    }

    public static int getdep(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=getdep(root.left);
        if(left==-1){
            return -1;
        }
        int right=getdep(root.right);
        if(right==-1){
            return -1;
        }
        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left,right)+1;
    }

}
