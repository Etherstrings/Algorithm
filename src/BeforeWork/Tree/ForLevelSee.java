package Tree;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-03-16 14:59 Tree - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  ForLevelSee - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/16 - the current system date.  14:59 - the current system time.  2022 - the current year.  03 - the current month.  16 - the current day of the month.  14 - the current hour.  59 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class ForLevelSee {
    //按照层来遍历
    public List<List<Integer>> checkFun01(TreeNode node){
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if(node==null){
            return null;
        }

        Queue<TreeNode> que=new LinkedList<>();

        que.offer(node);

        while(!que.isEmpty()){

            int len=que.size();
            List<Integer> answer=new ArrayList<>();

            while(len>0){
                TreeNode test=que.poll();
                answer.add(test.val);

                if(test.left!=null){
                    que.offer(test.left);
                }
                if(test.right!=null){
                    que.offer(test.right);
                }


                len--;
            }
            resList.add(answer);
        }
        return resList;
    }
}
