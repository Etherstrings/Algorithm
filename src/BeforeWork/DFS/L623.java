package DFS;


import Tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2023-03-05 13:30 DFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L623 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/5 - the current system date.  13:30 - the current system time.  2023 - the current year.  03 - the current month.  05 - the current day of the month.  13 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L623 {
     Set<Integer> set=new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return findTarget(root.left,k)||findTarget(root.right,k);
    }



}
