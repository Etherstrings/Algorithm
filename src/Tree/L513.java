package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-04-01 10:28 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L513 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/1 - the current system date.  10:28 - the current system time.  2022 - the current year.  04 - the current month.  01 - the current day of the month.  10 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L513 {
    //513. 找树左下角的值
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
    //
    //
    //提示:
    //
    //二叉树的节点个数的范围是 [1,104]
    //-231 <= Node.val <= 231 - 1


    //我的思路？
    //层序遍历
    //最后一个 就是
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> judge=new LinkedList<>();
        judge.offer(root);

        int answer=0;
        while (!judge.isEmpty()){
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

    //递归
    class Solution {
        private int Deep = -1;
        private int value = 0;
        public int findBottomLeftValue(TreeNode root) {
            value = root.val;
            findLeftValue(root,0);
            return value;
        }

        private void findLeftValue (TreeNode root,int deep) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                if (deep > Deep) {
                    value = root.val;
                    Deep = deep;
                }
            }
            if (root.left != null) findLeftValue(root.left,deep + 1);
            if (root.right != null) findLeftValue(root.right,deep + 1);
        }
    }
}
