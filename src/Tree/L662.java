package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-08-27 12:34 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L662 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/27 - the current system date.  12:34 - the current system time.  2022 - the current year.  08 - the current month.  27 - the current day of the month.  12 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L662 {
    public int widthOfBinaryTree(TreeNode root) {
        //先用层序遍历试一试
        if(root==null){
            return 0;
        }
        Queue<TreeNode> Judge=new LinkedList<>();
        Judge.add(root);
        int level=1;
        while(!Judge.isEmpty()){
            int size=Judge.size();
            level++;
            for(int i=0;i<size;i++){
                TreeNode temp=Judge.poll();
                if(temp.left!=null){
                    Judge.offer(temp.left);
                }
                if(temp.right!=null){
                    Judge.offer(temp.right);
                }
            }
        }
        //现在已经有了层数
        Judge=new LinkedList<>();
        Judge.add(root);
        int nlevel=1;
        int max=Integer.MIN_VALUE;
        while(!Judge.isEmpty()){

        }
        return nlevel;
    }
}
