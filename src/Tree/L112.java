package Tree;

import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-04-03 22:56 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L112 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/3 - the current system date.  22:56 - the current system time.  2022 - the current year.  04 - the current month.  03 - the current day of the month.  22 - the current hour.  56 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L112 {
    //112. 路径总和
    //给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
    //
    //叶子节点 是指没有子节点的节点。
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> judge=new Stack<>();
        Stack<Integer> sum=new Stack<>();

        if(root==null){
            return false;
        }

        judge.push(root);
        sum.push(root.val);

        while(!judge.isEmpty()){
            int size=judge.size();

            for(int i=0;i<size;i++){
                TreeNode now=judge.pop();
                int nowsum=sum.pop();

                if(now.left==null&&now.right==null&&nowsum==targetSum){
                    return true;
                }
                if(now.left!=null){
                    judge.push(now.left);
                    sum.push(nowsum+now.left.val);
                }

                if(now.right!=null){
                    judge.push(now.right);
                    sum.push(nowsum+now.right.val);
                }
            }
        }
        return false;
    }

}
