package src.Tree;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2022-09-02 14:20 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L437 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/2 - the current system date.  14:20 - the current system time.  2022 - the current year.  09 - the current month.  02 - the current day of the month.  14 - the current hour.  20 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L437 {

    public int pathSum(Tree.TreeNode root, int targetSum) {
        //每一个节点开始判断
        if(root==null){
            return 0;
        }
        Long sum=(long)targetSum;
        int ans=DFS(root,sum);
        ans+=DFS(root.left,sum);
        ans+=DFS(root.right,sum);
        return ans;
    }

    int DFS(TreeNode root, Long sum){
        if(root==null) {
            return 0;
        }
        int res=0;
        if(root.val==sum){
            res++;
        }
        int left=DFS(root.left,sum-root.val);
        int right=DFS(root.right,sum-root.val);
        res+=left;
        res+=right;

        return res;

    }
}
