package Tree;

/**
 * @author Etherstrings
 * @create 2022-03-29 19:12 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L110 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/29 - the current system date.  19:12 - the current system time.  2022 - the current year.  03 - the current month.  29 - the current day of the month.  19 - the current hour.  12 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    private int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftHeight=getHeight(root.left);

        if(leftHeight==-1){
            return -1;
        }

        int rightHeight=getHeight(root.right);
        if(rightHeight==-1){
            return -1;
        }
        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;

    }
}
