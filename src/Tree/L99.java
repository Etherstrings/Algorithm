package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-03-17 11:05 Tree - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L99 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/17 - the current system date.  11:05 - the current system time.  2022 - the current year.  03 - the current month.  17 - the current day of the month.  11 - the current hour.  05 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L99 {
    //199. 二叉树的右视图
    //给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
    //
    //
    //
    //示例 1:
    //
    //
    //
    //输入: [1,2,3,null,5,null,4]
    //输出: [1,3,4]
    //示例 2:
    //
    //输入: [1,null,3]
    //输出: [1,3]
    //示例 3:
    //
    //输入: []
    //输出: []
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }

        List<Integer> answer=new ArrayList<>();
        Deque<TreeNode> judge=new LinkedList<>();

        judge.offer(root);


        while(!judge.isEmpty()){
            int levelSize=judge.size();

            for(int i=0;i<levelSize;i++){

                TreeNode now=judge.pollFirst();

                if(now.left!=null){
                    judge.offer(now.left);
                }
                if(now.right!=null){
                    judge.offer(now.right);
                }


                if(i==levelSize-1){
                    answer.add(now.val);
                }
            }
        }

        return answer;
    }
}
