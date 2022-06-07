package Tree;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-05-25 20:43 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1305 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/25 - the current system date.  20:43 - the current system time.  2022 - the current year.  05 - the current month.  25 - the current day of the month.  20 - the current hour.  43 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> R1=new ArrayList<>();
        List<Integer> R2=new ArrayList<>();
        Mid(root1,R1);
        Mid(root2,R2);
        return Two2oneAndSort(R1,R2);
    }

    private void Mid(TreeNode root,List<Integer> Result){
        if(root==null){
            return ;
        }
        Mid(root.left,Result);
        Result.add(root.val);
        Mid(root.right,Result);

    }

    private List<Integer> Two2oneAndSort(List<Integer> a,List<Integer> b){
        for(Integer c:b){
            a.add(c);
        }
        Collections.sort(a);
        return a;
    }
}
