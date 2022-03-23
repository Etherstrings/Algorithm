package Tree;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-03-17 19:19 Tree - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  null.java - the name of the PHP file that will be created.  L515 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/17 - the current system date.  19:19 - the current system time.  2022 - the current year.  03 - the current month.  17 - the current day of the month.  19 - the current hour.  19 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L515 {
    //515. 在每个树行中找最大值
    //给定一棵二叉树的根节点 root,请找出该二叉树中每一层的最大值。
    //示例1：
    //输入: root = [1,3,2,5,3,null,9]
    //输出: [1,3,9]
    //示例2：
    //输入: root = [1,2,3]
    //输出: [1,3]
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> answer=new ArrayList<>();
        Queue<TreeNode> judge=new LinkedList<>();

        if(root!=null){
            judge.offer(root);
        }


        while(!judge.isEmpty()){
            List<Integer> EveryLevel=new ArrayList<>();
            int level=judge.size();
            for(int i=0;i<level;i++){
                TreeNode now=judge.poll();
                EveryLevel.add(now.val);
                if(now.left!=null){
                    judge.offer(now.left);
                }
                if(now.right!=null){
                    judge.offer(now.right);
                }

            }

            answer.add(Collections.max(EveryLevel));
        }

        return answer;
    }


}
