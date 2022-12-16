package src.Tree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-04-11 17:06 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L617 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/11 - the current system date.  17:06 - the current system time.  2022 - the current year.  04 - the current month.  11 - the current day of the month.  17 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L617 {
    //617. 合并二叉树
    //给你两棵二叉树： root1 和 root2 。
    //
    //想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
    //
    //返回合并后的二叉树。
    //
    //注意: 合并过程必须从两个树的根节点开始。


    //递归方法
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }

        if(root2==null){
            return root1;
        }

        TreeNode newroot =new TreeNode(root1.val+root2.val);

        newroot.left=mergeTrees(root1.left,root2.left);
        newroot.right=mergeTrees(root1.right,root2.right);

        return newroot;
    }


    //队列迭代
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }

        //思路其实还是层序遍历
        //但是只不过是一次入两个

        //入了之后如何判断的问题


        //采用队列进行判断
        Queue<TreeNode> judge=new LinkedList<>();

        judge.offer(root1);
        judge.offer(root2);

        while(!judge.isEmpty()){
            TreeNode node1=judge.poll();
            TreeNode node2=judge.poll();

            node1.val=node1.val+node2.val;

            if(node1.left!=null&&node2.left!=null){
                judge.offer(node1.left);
                judge.offer(node2.left);
            }

            if(node1.right!=null&&node2.right!=null){
                judge.offer(node1.right);
                judge.offer(node2.right);
            }

            // 若node1的左节点为空，直接赋值
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            // 若node1的右节点为空，直接赋值
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }


        }

        return root1;


    }

    //栈迭代
    public TreeNode mergeTrees3(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root2);
        stack.push(root1);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            node1.val += node2.val;
            if (node2.right != null && node1.right != null) {
                stack.push(node2.right);
                stack.push(node1.right);
            } else {
                if (node1.right == null) {
                    node1.right = node2.right;
                }
            }
            if (node2.left != null && node1.left != null) {
                stack.push(node2.left);
                stack.push(node1.left);
            } else {
                if (node1.left == null) {
                    node1.left = node2.left;
                }
            }
        }
        return root1;
    }
}
