package SecondTime.Tree.DiGui;

import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-16 16:18
 */
public class L513 {
    //找最后一层左下角的值
    int dep=Integer.MIN_VALUE;
    int left=0;
    public int findBottomLeftValue(TreeNode root){
        left=root.val;
        Backtarcking(root,0);
        return left;
    }

    void Backtarcking(TreeNode root,int level){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            if(level>dep){
                dep=level;
                left=root.val;
            }
        }

        if(root.left!=null){
            level++;
            Backtarcking(root.left,level);
            level--;
        }
        if(root.right!=null){
            level++;
            Backtarcking(root.right,level);
            level--;
        }
    }

}
