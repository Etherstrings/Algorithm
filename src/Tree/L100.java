package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-06-13 11:04 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L100 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/13 - the current system date.  11:04 - the current system time.  2022 - the current year.  06 - the current month.  13 - the current day of the month.  11 - the current hour.  04 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L100 {
    //100. 相同的树
    //给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
    //
    //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：p = [1,2,3], q = [1,2,3]
    //输出：true
    //示例 2：
    //
    //
    //输入：p = [1,2], q = [1,null,2]
    //输出：false
    //示例 3：
    //
    //
    //输入：p = [1,2,1], q = [1,1,2]
    //输出：false
    //
    //
    //提示：
    //
    //两棵树上的节点数目都在范围 [0, 100] 内
    //-104 <= Node.val <= 104


    //递归的参数
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null&&q!=null){
            return false;
        }
        if(p!=null&&q==null){
            return false;
        }
        if(p!=null&&q!=null){
            if(p.val!=q.val){
                return false;
            }
            boolean left= isSameTree(p.left,q.left);
            boolean right= isSameTree(p.right,q.right);
            return left&&right;
        }
        return false;
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        Queue<TreeNode> judgep=new LinkedList<>();
        Queue<TreeNode> judgeq=new LinkedList<>();

        judgep.offer(p);
        judgeq.offer(q);

        while(!judgep.isEmpty()&&!judgeq.isEmpty()){
            int levelp=judgep.size();
            int levelq=judgeq.size();
            if(levelp!=levelq){
                return false;
            }

            while((levelp>0)&&(levelq>0)){
                TreeNode nowp=judgep.poll();
                TreeNode nowq=judgeq.poll();

                if(nowq==null&&nowp==null){
                    continue;
                }

                if(nowq==null){
                    return false;
                }
                if(nowp==null){
                    return false;
                }

                if(nowp.val!=nowp.val){
                    return false;
                }else {
                    judgep.add(nowp.left);
                    judgeq.add(nowq.left);
                    judgep.add(nowp.right);
                    judgeq.add(nowq.right);
                }

                levelp--;
                levelq--;
            }

        }

        return true;
    }

}
