package src.Sword2Job;




import Tree.TreeNode;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-04-12 15:23 Sword2Job - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  SII044 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/12 - the current system date.  15:23 - the current system time.  2022 - the current year.  04 - the current month.  12 - the current day of the month.  15 - the current hour.  23 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class SII044 {
    //剑指 Offer II 044. 二叉树每层的最大值
    //给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
    //
    //
    //
    //示例1：
    //
    //输入: root = [1,3,2,5,3,null,9]
    //输出: [1,3,9]
    //解释:
    //          1
    //         / \
    //        3   2
    //       / \   \
    //      5   3   9
    //示例2：
    //
    //输入: root = [1,2,3]
    //输出: [1,3]
    //解释:
    //          1
    //         / \
    //        2   3
    //示例3：
    //
    //输入: root = [1]
    //输出: [1]
    //示例4：
    //
    //输入: root = [1,null,2]
    //输出: [1,2]
    //解释:
    //           1
    //            \
    //             2
    //示例5：
    //
    //输入: root = []
    //输出: []
    public List<Integer> largestValues(TreeNode root) {
        //思路
        //迭代层序遍历
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> answer=new ArrayList<>();

        Queue<TreeNode> judge=new LinkedList<>();

        judge.offer(root);

        while(!judge.isEmpty()){
            int size= judge.size();
            List<Integer> EveryLevel=new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode now=judge.poll();
                if(now.left!=null){
                    judge.offer(now.left);
                }
                if(now.right!=null){
                    judge.offer(now.right);
                }
                EveryLevel.add(now.val);
            }
            answer.add(Collections.max(EveryLevel));
        }
        return answer;
    }
}
