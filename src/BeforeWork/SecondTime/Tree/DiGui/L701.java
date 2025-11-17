package SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-18 16:29
 */
public class L701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //当前地方为空--那就是在这个地方构建root
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val<val){
            root.right=insertIntoBST(root.right,val);
        }
        if(root.val>val){
            root.left=insertIntoBST(root.left,val);
        }
        return root;

    }
}
