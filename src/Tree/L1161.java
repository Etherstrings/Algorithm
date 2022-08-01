package Tree;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-07-31 0:45 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1161 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/31 - the current system date.  0:45 - the current system time.  2022 - the current year.  07 - the current month.  31 - the current day of the month.  00 - the current hour.  45 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L1161 {
    //1161. 最大层内元素和
    //给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
    //
    //请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：root = [1,7,0,7,-8,null,null]
    //输出：2
    //解释：
    //第 1 层各元素之和为 1，
    //第 2 层各元素之和为 7 + 0 = 7，
    //第 3 层各元素之和为 7 + -8 = -1，
    //所以我们返回第 2 层的层号，它的层内元素之和最大。
    //示例 2：
    //
    //输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
    //输出：2
    public int maxLevelSum(TreeNode root) {
        //层序遍历
        if(root==null){
            return 1;
        }
        Deque<TreeNode> judge=new LinkedList<>();
        HashMap<Integer,Integer> Ans=new HashMap<>();
        judge.offer(root);
        int level=1;
        while(!judge.isEmpty()){
            int levelSize=judge.size();
            int sum=0;
            for(int i=0;i<levelSize;i++){
                TreeNode now=judge.pollFirst();
                if(now.left!=null){
                    judge.offer(now.left);
                }
                if(now.right!=null){
                    judge.offer(now.right);
                }
                sum+=now.val;
            }
            if(!Ans.containsKey(sum)){
                //已经有了
                //当前层级就是最小的
                Ans.put(sum,level);
            }

            level++;
        }
        ArrayList<Integer> ans=new ArrayList<>();

        for(Integer a:Ans.keySet()){
            ans.add(a);
        }
        Collections.sort(ans);

        return Ans.get(ans.get(ans.size()-1));

    }
}
