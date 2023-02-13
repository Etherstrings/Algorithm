package src.Tree;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-07-22 13:20 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L814 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/22 - the current system date.  13:20 - the current system time.  2022 - the current year.  07 - the current month.  22 - the current day of the month.  13 - the current hour.  20 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L814 {
    public TreeNode pruneTree(TreeNode root) {
        if(root==null){
            return null;
        }
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);

        if(root.val==0&&root.left==null&&root.right==null){
            return null;
        }
        return root;
    }


}
