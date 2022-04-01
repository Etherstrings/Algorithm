package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-04-01 9:55 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L404 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/1 - the current system date.  9:55 - the current system time.  2022 - the current year.  04 - the current month.  01 - the current day of the month.  09 - the current hour.  55 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L404 {
    //404. 左叶子之和
    //给定二叉树的根节点 root ，返回所有左叶子之和。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入: root = [3,9,20,null,null,15,7]
    //输出: 24
    //解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
    //示例 2:
    //
    //输入: root = [1]
    //输出: 0


    //前序迭代
    public int sumOfLeftLeaves(TreeNode root) {
        //迭代法
        //关键在于什么？
        //关键在于如何判断左叶子
        //root.left!=null root.left.left=null root.left.right=null
        if(root==null){
            return 0;
        }
        Stack<TreeNode> judge=new Stack<>();
        int answer=0;

        judge.add(root);
        while(!judge.isEmpty()){
            TreeNode now=judge.pop();

            if(now.left!=null&&now.left.left==null&&now.left.right==null){
                answer+=now.left.val;
            }

            if(now.left!=null){
                judge.add(now.left);
            }
            if(now.right!=null){
                judge.add(now.right);
            }


        }
        return answer;

    }

    //层序迭代
    public int sumOfLeftLeaves1(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) { // 左节点不为空
                    queue.offer(node.left);
                    if (node.left.left == null && node.left.right == null){ // 左叶子节点
                        sum += node.left.val;
                    }
                }
                if (node.right != null) queue.offer(node.right);
            }
        }
        return sum;
    }

    //递归
    public int sumOfLeftLeaves2(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=sumOfLeftLeaves2(root.left);
        int right=sumOfLeftLeaves2(root.right);

        int midvalue=0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            midvalue+=root.left.val;
        }

        int sum=midvalue+left+right;
        return sum;
    }


}
