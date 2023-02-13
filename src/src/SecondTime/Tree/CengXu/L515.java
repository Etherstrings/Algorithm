package src.SecondTime.Tree.CengXu;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-08-15 22:07 SecondTime.Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L515 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/15 - the current system date.  22:07 - the current system time.  2022 - the current year.  08 - the current month.  15 - the current day of the month.  22 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L515 {
    public List<Integer> largestValues(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> Judge=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        Judge.offer(root);
        while(!Judge.isEmpty()){
            int size=Judge.size();
            int minnum=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode Temp=Judge.poll();
                minnum=Math.max(Temp.val,minnum);
                if(Temp.left!=null){
                    Judge.offer(Temp.left);
                }
                if(Temp.right!=null){
                    Judge.offer(Temp.right);
                }
            }
            ans.add(minnum);
        }
        return ans;
    }
}
