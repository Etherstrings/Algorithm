package ToBigFactory.Tree;

import Tree.TreeNode;

public class MirrorTree {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left,root.right);
    }

    public static boolean compare(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left!=null&&right==null){
            return false;
        }
        if(left==null&&right!=null){
            return false;
        }
        boolean flag=true;
        if(left!=null&&right!=null){
            if(left.val!=right.val){
                return false;
            }else {
                boolean outside=compare(left.left,right.right);
                boolean inside=compare(left.right,right.left);
                flag=outside&&inside;
            }
        }
        return flag;
    }
}
