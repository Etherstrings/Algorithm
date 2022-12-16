package src.SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-19 10:33
 */
public class L538 {
    //定义一个全局变量pre
    int pre;
    public TreeNode convertBST(TreeNode root) {
        pre=0;
        return build(root);
    }

    TreeNode build(TreeNode cur){
        if(cur==null){
            return null;
        }
        //右中左
        build(cur.right);
        cur.val+=pre;
        pre=cur.val;
        build(cur.left);
        return cur;
    }
}
