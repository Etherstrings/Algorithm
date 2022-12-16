package src.Tree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-03-23 0:38 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L111_MinLevel - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/23 - the current system date.  0:38 - the current system time.  2022 - the current year.  03 - the current month.  23 - the current day of the month.  00 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L111_MinLevel {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        int deep=0;
        if(!queue.isEmpty()){
            int size=queue.size();

            deep++;


            while(size>0){
                TreeNode now=queue.poll();
                if(now.left==null&&now.right==null){
                    return deep;
                }

                if(now.left!=null){
                    queue.offer(now.left);
                }
                if(now.right!=null){
                    queue.offer(now.right);
                }
            }

            return deep;
        }
    }
}
