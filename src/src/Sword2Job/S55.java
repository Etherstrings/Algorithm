package src.Sword2Job;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-04-16 9:35 Sword2Job - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  S55 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/16 - the current system date.  9:35 - the current system time.  2022 - the current year.  04 - the current month.  16 - the current day of the month.  09 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class S55 {
    //剑指 Offer 55 - I. 二叉树的深度
    //输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
    //
    //例如：
    //
    //给定二叉树 [3,9,20,null,null,15,7]，
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回它的最大深度 3 。


    public int maxDepth(TreeNode root) {
        int deep=0;
        if(root==null){
            return deep;
        }

        Queue<TreeNode> judge=new LinkedList<>();
        judge.offer(root);


        while(!judge.isEmpty()){
            int size=judge.size();

            for(int i=0;i<size;i++){
                TreeNode now=judge.poll();
                if(now.left!=null){
                    judge.offer(now.left);
                }

                if(now.right!=null){
                    judge.offer(now.right);
                }




            }

            deep++;


        }

        return deep;

    }
}
