package SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-16 13:39
 */
public class L101 {
    public boolean isSymmetric1(TreeNode root) {
        return compare(root);
    }

    boolean compare(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.left!=null&&root.right==null){
            return false;
        }
        if(root.left==null&&root.right!=null){
            return false;
        }
        if(root.right.val!=root.left.val){
            return false;
        }
        boolean left=compare(root.left);
        boolean right=compare(root.right);


        return left&&right;

    }

    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        return Compane(root.left,root.right);
    }

    boolean Compane(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left!=null&&right==null){
            return false;
        }
        if(right!=null&&left==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        boolean out=Compane(left.left,right.right);
        boolean in=Compane(left.right,right.left);
        return out&&in;
    }
}
