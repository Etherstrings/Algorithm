package src.Tree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-03-23 0:34 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L104_howdeep - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/23 - the current system date.  0:34 - the current system time.  2022 - the current year.  03 - the current month.  23 - the current day of the month.  00 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L104_howdeep {
    //104. 二叉树的最大深度
    //给定一个二叉树，找出其最大深度。
    //
    //二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    //
    //说明: 叶子节点是指没有子节点的节点。
    //
    //示例：
    //给定二叉树 [3,9,20,null,null,15,7]，
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回它的最大深度 3 。
    public int maxDepth(Tree.TreeNode root) {
           if(root==null){
               return 0;
           }
        Queue<Tree.TreeNode> judge=new LinkedList<>();

           judge.offer(root);

           int deep=0;

           while(!judge.isEmpty()){
               int level=judge.size();

               while(level>0){
                   TreeNode now=judge.poll();
                   if(now.left!=null){
                       judge.offer(now.left);
                   }
                   if(now.right!=null){
                       judge.offer(now.right);
                   }

                   level--;
               }
               deep++;
           }

           return deep;
    }

}
