package src.SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-19 10:08
 */
public class L669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null){
            return null;
        }

        if(root.val<low){
            TreeNode right=trimBST(root.right,low,high);
            return right;
        }

        if(root.val>high){
            TreeNode left=trimBST(root.left,low,high);
            return left;
        }

        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);

        return root;
    }
}
