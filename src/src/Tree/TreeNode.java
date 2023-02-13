package src.Tree;

/**
 * @author Etherstrings
 * @create 2022-03-13 11:30 Tree - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  TreeNode - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/13 - the current system date.  11:30 - the current system time.  2022 - the current year.  03 - the current month.  13 - the current day of the month.  11 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

}
