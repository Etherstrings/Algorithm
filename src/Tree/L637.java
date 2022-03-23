package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-03-17 12:30 Tree - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L637 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/17 - the current system date.  12:30 - the current system time.  2022 - the current year.  03 - the current month.  17 - the current day of the month.  12 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L637 {
    //637. 二叉树的层平均值
    //给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：root = [3,9,20,null,null,15,7]
    //输出：[3.00000,14.50000,11.00000]
    //解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
    //因此返回 [3, 14.5, 11] 。
    //示例 2:
    //
    //
    //
    //输入：root = [3,9,20,15,7]
    //输出：[3.00000,14.50000,11.00000]
    //
    //
    //提示：
    //
    //树中节点数量在 [1, 104] 范围内
    //-231 <= Node.val <= 231 - 1
    public List<Double> averageOfLevels(TreeNode root) {
        //利用队列
        //按层遍历
        List<Double> answer=new ArrayList<>();
        Queue<TreeNode> judge=new LinkedList<>();

        judge.offer(root);

        while(!judge.isEmpty()){
            //不空的时候 继续进行循环 遍历
            int level=judge.size();
            int levelnum=level;
            double sum=0;
            while(level>0){
                TreeNode now=judge.poll();
                if(now.left!=null){
                    judge.offer(now.left);
                }
                if(now.right!=null){
                    judge.offer(now.right);
                }
                sum+=now.val;


                level--;
            }
            answer.add(sum/levelnum);

        }
        return answer;
    }

}
