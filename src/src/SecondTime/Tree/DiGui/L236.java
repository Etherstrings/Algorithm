package src.SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-18 16:11
 */
public class L236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }


        //后序遍历
        //左右中
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left==null&&right==null){
            return null;
        }else if(left==null&&right!=null){
            return right;
        }else if(left!=null&&right==null){
            return left;
        }else {
            return root;
        }
    }
}
