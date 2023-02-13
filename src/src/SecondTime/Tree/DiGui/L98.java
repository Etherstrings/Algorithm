package src.SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-18 15:01
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
    long maxval=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }

        boolean left=isValidBST(root.left);
        //必须要当前的节点值大于剩下所有的节点值
        if(root.val>maxval){
            maxval=root.val;
        }else {
            return false;
        }
        boolean right=isValidBST(root.right);

        return left&&right;
    }
}
