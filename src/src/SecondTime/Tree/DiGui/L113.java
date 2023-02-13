package src.SecondTime.Tree.DiGui;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-16 21:29 SecondTime.Tree.DiGui - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L113 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/16 - the current system date.  21:29 - the current system time.  2022 - the current year.  08 - the current month.  16 - the current day of the month.  21 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L113 {
    List<List<Integer>> ans=new ArrayList<>();
    LinkedList<Integer> Path=new LinkedList<>();
    int sum=0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return ans;
        }
        sum+=root.val;
        DFS(root,targetSum);
        return ans;
    }

    void DFS(TreeNode root, int targetSum){
        Path.add(root.val);
        if(root.left==null&&root.right==null){
            if(sum==targetSum){
                ans.add(new ArrayList<>(Path));
            }
            return;
        }

        if(root.left!=null){
            sum+=root.left.val;

            DFS(root.left,targetSum);
            Path.removeLast();
            sum-=root.left.val;
        }
        if(root.right!=null){
            sum+=root.right.val;

            DFS(root.right,targetSum);
            Path.removeLast();
            sum-=root.right.val;
        }
    }
}
