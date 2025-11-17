package DFS;


import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2023-03-04 0:18 DFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L700 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/4 - the current system date.  0:18 - the current system time.  2023 - the current year.  03 - the current month.  04 - the current day of the month.  00 - the current hour.  18 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        if(root.val<val){
            return searchBST(root.right,val);
        }
        if(root.val>val){
            return searchBST(root.left,val);
        }
        return null;
    }
}
