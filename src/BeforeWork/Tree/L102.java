package Tree;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-03-17 9:59 Tree - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L102 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/17 - the current system date.  9:59 - the current system time.  2022 - the current year.  03 - the current month.  17 - the current day of the month.  09 - the current hour.  59 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L102 {
    //102. 二叉树的层序遍历
    //给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：root = [3,9,20,null,null,15,7]
    //输出：[[3],[9,20],[15,7]]
    //示例 2：
    //
    //输入：root = [1]
    //输出：[[1]]

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> Relanswer = new ArrayList<List<Integer>>();

        //利用队列来实现层序遍历

        if(root == null)
            return new ArrayList<>();

        Queue<TreeNode> judge=new LinkedList<>();

        judge.offer(root);

        while(!judge.isEmpty()){
            int len=judge.size();
            List<Integer> answer=new ArrayList<>();

            while(len>0){
                TreeNode now=judge.poll();
                answer.add(now.val);
                len--;
                if(now.left!=null){
                    judge.offer(now.left);
                }
                if(now.right!=null){
                    judge.offer(now.right);
                }

            }
            Relanswer.add(answer);
        }

        return Relanswer;
    }
}
