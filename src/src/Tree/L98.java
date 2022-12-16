package src.Tree;

import Tree.TreeNode;

import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-04-12 10:17 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L98 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/12 - the current system date.  10:17 - the current system time.  2022 - the current year.  04 - the current month.  12 - the current day of the month.  10 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L98 {
    //98. 验证二叉搜索树
    //给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
    //
    //有效 二叉搜索树定义如下：
    //
    //节点的左子树只包含 小于 当前节点的数。
    //节点的右子树只包含 大于 当前节点的数。
    //所有左子树和右子树自身必须也是二叉搜索树。


    //中序遍历为升序即可
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }

        Stack<TreeNode> stack=new Stack<>();

        TreeNode pre=null;

        while(root!=null||!stack.isEmpty()){

            while(root!=null){
                stack.push(root);
                root=root.left;
            }

            //中的处理
            TreeNode pop=stack.pop();
            if(pre!=null&&pop.val<=pre.val){
                return false;
            }

            pre=pop;

            root=pop.right;
        }
        return true;


    }

}
