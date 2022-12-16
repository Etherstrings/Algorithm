package src.SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-16 14:17
 */
public class L110 {
    public boolean isBalanced(TreeNode root) {
        if(Compare(root)==-1){
            return false;
        }
        return true;
    }

    int Compare(TreeNode root){
        //左 右 中
        if(root==null){
            return 0;
        }
        int left=Compare(root.left);
        int right=Compare(root.right);
        if(left==-1){
            return -1;
        }
        if(right==-1){
            return -1;
        }
        if(Math.abs(left-right)>1){
            return -1;
        }

        return Math.max(left,right)+1;

    }
}
