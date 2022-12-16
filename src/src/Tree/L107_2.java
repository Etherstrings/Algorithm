package src.Tree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-03-17 10:24 Tree - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L107_2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/17 - the current system date.  10:24 - the current system time.  2022 - the current year.  03 - the current month.  17 - the current day of the month.  10 - the current hour.  24 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L107_2 {
    public List<List<Integer>> levelOrderBottom(Tree.TreeNode root) {
        List<List<Integer>> Relanswer = new ArrayList<List<Integer>>();

        //利用队列来实现层序遍历

        if(root == null)
            return new ArrayList<>();

        Queue<Tree.TreeNode> judge=new LinkedList<>();

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
        List<List<Integer>> result = new ArrayList<>();
        for(int i=Relanswer.size()-1;i>=0;i--){
            result.add(Relanswer.get(i));
        }
        return result;
    }
}
