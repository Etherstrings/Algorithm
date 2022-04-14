package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-04-14 11:07 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L530 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/14 - the current system date.  11:07 - the current system time.  2022 - the current year.  04 - the current month.  14 - the current day of the month.  11 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L530 {
    //530. 二叉搜索树的最小绝对差
    //给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
    //
    //差值是一个正数，其数值等于两值之差的绝对值。

    //层序遍历
    //迭代

    public int getMinimumDifference(TreeNode root) {
        //遍历
        //返回最小差值



        //最小两个节点
        //肯定root！=null
        Queue<TreeNode> judge=new LinkedList<>();

        judge.offer(root);
        int min=-1;

        while(!judge.isEmpty()){
            int size= judge.size();

            for(int i=0;i<size;i++){
                TreeNode now=judge.poll();

                if(now.left!=null){
                    judge.offer(now.left);
                    min=Math.max(min,Math.abs(now.left.val- now.val));
                }

                if(now.right!=null){
                    judge.offer(now.right);
                    min=Math.max(min,Math.abs(now.right.val-now.val));
                }
            }
        }
        return min;

    }

    //递归
    TreeNode pre;
    int result=Integer.MAX_VALUE;
    public int getMinimumDifference1(TreeNode root) {
        if(root==null)return 0;
        traversal(root);
        return result;
    }
    public void traversal(TreeNode root){
        if(root==null)return;
        //左
        traversal(root.left);
        //中
        if(pre!=null){
            result = Math.min(result,root.val-pre.val);
        }
        pre = root;
        //右
        traversal(root.right);
    }

}
