package SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-17 17:54
 */
public class L1302 {
    public int deepestLeavesSum(TreeNode root){
        return DFS(root);
    }

    int DFS(TreeNode root){
        if(root.left==null&&root.right==null){
            return root.val;
        }
        int left=0;
        if(root.left!=null){
            left=DFS(root.left);
        }
        int right=0;
        if(root.right!=null){
            right=DFS(root.right);
        }
        return left+right;
    }
}
