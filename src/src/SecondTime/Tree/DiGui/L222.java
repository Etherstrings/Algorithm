package src.SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-16 14:13
 */
public class L222 {
    public int countNodes(TreeNode root) {
        return dfs(root);
    }

    int dfs(TreeNode root){
        //左右中
        if(root==null){
            return 0;
        }
        if(root.left!=null&&root.right==null){
            return 2;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);

        return left+right+1;
    }
}
