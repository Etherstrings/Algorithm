package src.SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-16 11:46
 */
public class L226 {
    public TreeNode invertTree1(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left!=null&&root.right!=null){
            invertTree(root.left);
            invertTree(root.right);
            TreeNode Temp=root.left;
            root.left=root.right;
            root.right=Temp;

        }else if(root.left==null&&root.right!=null){
            invertTree(root.right);
            root.left=root.right;
            root.right=null;
        }else if(root.left!=null&&root.right==null){
            invertTree(root.left);
            root.right=root.left;
            root.left=null;
        }
        return root;
    }


    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        //先递归 再交换
        invertTree(root.left);
        invertTree(root.right);
        TreeNode Temp=root.left;
        root.left=root.right;
        root.right=Temp;
        return root;
    }
}
