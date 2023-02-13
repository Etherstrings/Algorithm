package SecondTime.Tree.DiGui;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-16 21:49 SecondTime.Tree.DiGui - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L129 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/16 - the current system date.  21:49 - the current system time.  2022 - the current year.  08 - the current month.  16 - the current day of the month.  21 - the current hour.  49 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L129 {
    List<String> ans=new ArrayList<>();
    List<String> Path=new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        int Tans=0;
        DFS(root);
        for(String temp:ans){
            temp=temp.replace("^0*","");
            Tans+=Integer.parseInt(temp);
        }
        return Tans;
    }
    void DFS(TreeNode root){
        Path.add(String.valueOf(root.val));
        if(root.left==null&&root.right==null){
            String temp="";
            for(String a:Path){
                temp+=a;
            }
            ans.add(temp);
        }

        if(root.left!=null){
            DFS(root.left);
            Path.remove(Path.size()-1);
        }

        if(root.right!=null){
            DFS(root.right);
            Path.remove(Path.size()-1);
        }
    }

}
