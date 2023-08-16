package ToBigFactory.DP;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2023-07-29 21:19 ToBigFactory.DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L337_Thief_Tree - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/29 - the current system date.  21:19 - the current system time.  2023 - the current year.  07 - the current month.  29 - the current day of the month.  21 - the current hour.  19 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L337_Thief_Tree {
    public int rob(TreeNode root) {
        int[] ans=treedp(root);
        return Math.max(ans[0],ans[1]);
    }

    public static int[] treedp(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] left=treedp(root.left);
        int[] right=treedp(root.right);
        //0偷
        //1不偷

        //偷
        int Tou=left[1]+right[1]+root.val;
        //不偷 左边偷/左边不偷 右边偷/右边不偷
        int Butou=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{Tou,Butou};
    }
}
