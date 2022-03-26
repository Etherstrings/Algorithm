package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-03-26 19:29 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  S27MirrorTree - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/26 - the current system date.  19:29 - the current system time.  2022 - the current year.  03 - the current month.  26 - the current day of the month.  19 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class S27MirrorTree {
    //迭代
    //反转重构二叉树
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return root;
        }
        Queue<TreeNode> judge=new LinkedList<>();
        judge.offer(root);

        while(!judge.isEmpty()){
            int size=judge.size();
            for(int i=0;i<size;i++){
                TreeNode now=judge.poll();
                TreeNode temp=now.left;
                now.left=now.right;
                now.right=temp;
                if(now.left!=null){
                    judge.offer(now.left);
                }
                if(now.right!=null){
                    judge.offer(now.right);
                }

            }

        }
        return root;
    }

    //递归
    public TreeNode mirrorTree1(TreeNode root){
            return swap(root);

    }

    TreeNode swap(TreeNode root){
        if(root==null){
            return root;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        swap(root.left);
        swap(root.right);

        return root;
    }
}
