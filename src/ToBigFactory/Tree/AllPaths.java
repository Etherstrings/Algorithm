package ToBigFactory.Tree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-07-04 20:40 ToBigFactory.Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  AllPaths - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/4 - the current system date.  20:40 - the current system time.  2023 - the current year.  07 - the current month.  04 - the current day of the month.  20 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class AllPaths {

    public List<String> binaryTreePaths(TreeNode root) {
        Path=new LinkedList<>();
        ans=new ArrayList<>();
        Back(root);
        return ans;
    }
    public static List<TreeNode> Path;
    public static List<String> ans;
    public static void Back(TreeNode root){
        Path.add(root);
        if(root.left==null&&root.right==null){
            String temp="";
            for(int i=0;i<Path.size()-1;i++){
                temp+=Path.get(i).val+"->";
            }
            temp+=Path.get(Path.size()-1).val;
            ans.add(temp);
            return;
        }

        //单层回溯的方式
        //每一层都有拼左 拼右的两种方式
        if(root.left!=null){
            Back(root.left);
            Path.remove(Path.size()-1);
        }
        if(root.right!=null){
            Back(root.right);
            Path.remove(Path.size()-1);
        }
    }
}
