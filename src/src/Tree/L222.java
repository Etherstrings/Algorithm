package src.Tree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-03-29 18:52 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L222 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/29 - the current system date.  18:52 - the current system time.  2022 - the current year.  03 - the current month.  29 - the current day of the month.  18 - the current hour.  52 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L222 {
    //222. 完全二叉树的节点个数
    //给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
    //完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：root = [1,2,3,4,5,6]
    //输出：6
    //示例 2：
    //
    //输入：root = []
    //输出：0
    //示例 3：
    //
    //输入：root = [1]
    //输出：1
    public int countNodes(TreeNode root) {
        //迭代法
        if(root==null){
            return 0;
        }

        Queue<TreeNode> judge=new LinkedList<>();
        int nums=0;
        judge.offer(root);
        while(!judge.isEmpty()){
            int size=judge.size();

            for(int i=0;i<size;i++){
                TreeNode now = judge.poll();
                if(now.left!=null){
                    judge.offer(now.left);
                }
                if(now.right!=null){
                    judge.offer(now.right);
                }
                nums++;
            }
        }
        return nums;
    }

    public int countNodes1(TreeNode root){
        return getNodesNum(root);
    }
    public int getNodesNum(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftnum=getNodesNum(root.left);
        int rightnum=getNodesNum(root.right);

        int Treenum=leftnum+rightnum+1;
        return Treenum;
    }
}
