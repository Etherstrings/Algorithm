package src.SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-16 14:00
 */
public class L111 {
    public int minDepth(TreeNode root) {
       return dfs(root);
    }

    int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);

        if(root.left==null&&root.right!=null){
            return right+1;
        }
        if(root.left!=null&&root.right==null){
            return left+1;
        }
        return 1+Math.min(left,right);

    }
}
