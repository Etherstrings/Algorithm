package Sword2Job;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-04-15 10:10 Sword2Job - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  SII045 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/15 - the current system date.  10:10 - the current system time.  2022 - the current year.  04 - the current month.  15 - the current day of the month.  10 - the current hour.  10 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class SII045 {
    //剑指 Offer II 045. 二叉树最底层最左边的值
    //给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
    //
    //假设二叉树中至少有一个节点。
    //
    //
    //
    //示例 1:
    //
    //
    //
    //输入: root = [2,1,3]
    //输出: 1
    //示例 2:
    //
    //
    //
    //输入: [1,2,3,4,null,5,6,null,null,7]
    //输出: 7


    //层序遍历

    //迭代 最后添加左边的值
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> judge=new LinkedList<>();
        judge.offer(root);
        int answer=0;
        while(!judge.isEmpty()){
            int size=judge.size();

            for(int i=0;i<size;i++){
                TreeNode now=judge.poll();
                if(i==0){
                    answer=now.val;
                }
                if(now.left!=null){
                    judge.offer(now.left);
                }
                if(now.right!=null){
                    judge.offer(now.right);
                }
            }
        }
        return answer;
    }
}
