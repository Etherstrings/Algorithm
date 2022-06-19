package Tree;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-06-19 12:10 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L508 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/19 - the current system date.  12:10 - the current system time.  2022 - the current year.  06 - the current month.  19 - the current day of the month.  12 - the current hour.  10 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L508 {
    //508. 出现次数最多的子树元素和
    //给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
    //
    //一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入: root = [5,2,-3]
    //输出: [2,-3,4]
    //示例 2：
    //
    //
    //
    //输入: root = [5,2,-5]
    //输出: [2]
    //
    //
    //提示:
    //
    //节点数在 [1, 104] 范围内
    //-105 <= Node.val <= 105
    //这里存入的是所有节点的值
    HashMap<Integer,Integer> Judge=new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        GetSum(root);
        int times=0;
        for(Integer a:Judge.keySet()){
            times=Math.max(times,Judge.get(a));
        }
        //遍历Judge 寻找Value一样的;
        ArrayList<Integer> Ans=new ArrayList<>();
        for(Integer b:Judge.keySet()){
            if(Judge.get(b)==times){
                Ans.add(b);
            }
        }
        int[] trueans=new int[Ans.size()];
        for(int i=0;i<Ans.size();i++){
            trueans[i]=Ans.get(i);
        }
        return trueans;
    }

    int GetSum(TreeNode root){
        if(root==null){
            return 0;
        }

        int sum=root.val+GetSum(root.left)+GetSum(root.right);
        if(Judge.containsKey(sum)){
            Judge.put(sum,Judge.get(sum)+1);
        }else {
            Judge.put(sum,1);
        }
        return sum;
    }
}
