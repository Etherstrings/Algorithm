package Tree;

/**
 * @author Etherstrings
 * @create 2022-03-23 20:38 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L101 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/23 - the current system date.  20:38 - the current system time.  2022 - the current year.  03 - the current month.  23 - the current day of the month.  20 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L101 {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left,root.right);
    }

    boolean compare(TreeNode left,TreeNode right){
        if(left==null&&right!=null){
            return false;
        }

        if(left!=null&&right==null){
            return false;
        }

        if(left==null&&right==null){
            return true;
        }

        if(left.val!=right.val){
            return false;
        }

        boolean ComOutside=compare(left.left,right.right);
        boolean ComInside=compare(left.right,right.left);

        return ComInside&&ComOutside;
    }
}
