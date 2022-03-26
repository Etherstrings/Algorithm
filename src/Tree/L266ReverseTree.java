package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-03-23 20:14 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L266ReverseTree - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/23 - the current system date.  20:14 - the current system time.  2022 - the current year.  03 - the current month.  23 - the current day of the month.  20 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L266ReverseTree {
    //给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        swap(root);

        return root;
    }

    public TreeNode invertTree1(TreeNode root){
        if(root==null){
            return null;
        }

        Queue<TreeNode> judge=new LinkedList<>();
        judge.offer(root);

        while(!judge.isEmpty()){
            int size=judge.size();

            while(size>0){
                TreeNode node=judge.poll();
                swap(node);

                if(node.left!=null){
                    judge.offer(node.left);
                }
                if(node.right!=null){
                    judge.offer(node.right);
                }
            }
        }

        return root;

    }
    public void swap(TreeNode root){
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
    }
}
