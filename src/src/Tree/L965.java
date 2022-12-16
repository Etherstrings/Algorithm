package src.Tree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-30 20:05 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L965 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/30 - the current system date.  20:05 - the current system time.  2022 - the current year.  05 - the current month.  30 - the current day of the month.  20 - the current hour.  05 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L965 {
    //965. 单值二叉树
    //如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
    //
    //只有给定的树是单值二叉树时，才返回 true；否则返回 false。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：[1,1,1,1,1,null,1]
    //输出：true
    //示例 2：
    //
    //
    //
    //输入：[2,2,2,5,2]
    //输出：false
    public boolean isUnivalTree(Tree.TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Order(root,result);
        boolean Flag=true;
        int temp=result.get(0);
        for(Integer a:result){
            if(a!=temp){
                Flag=false;
                break;
            }
        }
        return Flag;
    }

    public void Order(TreeNode root, List<Integer> result){
        if(root==null){
            return ;
        }
        result.add(root.val);
        Order(root.left,result);
        Order(root.right,result);
    }
}
