package src.SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-18 14:45
 */
public class L617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return build(root1,root2);
    }

    TreeNode build(TreeNode root1, TreeNode root2){
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        if(root1==null&&root2==null){
            return null;
        }
        root1.val=root1.val+root2.val;
        root1.left=build(root1.left,root2.left);
        root1.right=build(root1.right,root2.right);
        return root1;
    }
}
