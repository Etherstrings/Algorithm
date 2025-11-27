package Tree;

/**
 * @author Etherstrings
 * @create 2022-04-12 10:07 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L700 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/12 - the current system date.  10:07 - the current system time.  2022 - the current year.  04 - the current month.  12 - the current day of the month.  10 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L700 {
    //700. 二叉搜索树中的搜索
    //给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
    //
    //你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。



    //递归
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null||root.val==val){
            return root;
        }

        //当前的值比val小 那就查右边的
        if(root.val<val){
            return searchBST(root.right,val);
        }

        //当前数比val大  那就查左边的
        if(root.val>val){
            return searchBST(root.left,val);
        }

        return null;
    }

    //迭代法
    public TreeNode searchBST1(TreeNode root, int val){
        while(root!=null){
            if(root.val>val){
                root=root.left;
            }else if(root.val<val){
                root=root.right;
            }else{
                return root;
            }
        }
        return null;
    }
}
