package ToBigFactory.Tree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2023-07-04 20:20 ToBigFactory.Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  MinDeep - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/4 - the current system date.  20:20 - the current system time.  2023 - the current year.  07 - the current month.  04 - the current day of the month.  20 - the current hour.  20 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class MinDeep {
    public int minDepth(TreeNode root) {
        return getMin(root);
    }

    public static int getMin(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftdeep=getMin(root.left);
        int rightdeep=getMin(root.right);
        if(root.left==null&&root.right!=null){
            return rightdeep+1;
        }
        if(root.left!=null&&root.right==null){
            return leftdeep+1;
        }
        return Math.min(leftdeep,rightdeep)+1;
    }

    public static int getMinBFS(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int dep=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            dep++;
            for(int i=0;i<size;i++){
                TreeNode now=queue.poll();
                if(now.left==null&&now.right==null){
                    return dep;
                }
                if(now.left!=null){
                    queue.offer(now.left);
                }
                if(now.right!=null){
                    queue.offer(now.right);
                }
            }
        }
        return dep;
    }
}
