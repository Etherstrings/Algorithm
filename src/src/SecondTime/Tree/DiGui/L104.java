package src.SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-16 13:55
 */
public class L104 {

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);

        return Math.max(left,right)+1;
    }
}
