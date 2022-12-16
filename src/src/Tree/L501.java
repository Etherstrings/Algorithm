package src.Tree;

import Tree.TreeNode;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-04-15 10:26 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L501 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/15 - the current system date.  10:26 - the current system time.  2022 - the current year.  04 - the current month.  15 - the current day of the month.  10 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L501 {
    //501. 二叉搜索树中的众数
    //给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
    //
    //如果树中有不止一个众数，可以按 任意顺序 返回。
    //
    //假定 BST 满足如下定义：
    //
    //结点左子树中所含节点的值 小于等于 当前节点的值
    //结点右子树中所含节点的值 大于等于 当前节点的值
    //左子树和右子树都是二叉搜索树
    //
    //
    //示例 1：
    //
    //
    //输入：root = [1,null,2,2]
    //输出：[2]
    //示例 2：
    //
    //输入：root = [0]
    //输出：[0]



    //层序遍历+HashMap
    public int[] findMode(TreeNode root) {

        Queue<TreeNode> judege=new LinkedList<>();

        ArrayList<Integer> All = new ArrayList<>();

        judege.offer(root);

        while(!judege.isEmpty()){
            int size= judege.size();

            for(int i=0;i<size;i++){
                TreeNode now=judege.poll();
                All.add(now.val);

                if(now.left!=null){
                    judege.offer(now.left);
                }

                if(now.right!=null){
                    judege.offer(now.right);
                }

            }
        }
        HashMap<Integer, Integer> sorted = new HashMap<>();

        // key value
        // num nums
        for(Integer num:All){
            if(sorted.get(num)==0){
                sorted.put(num,1);
            }else{
                sorted.put(num,sorted.get(num)+1);
            }
        }

        int max=0;
        for(Integer num:All){
            max=Math.max(max,sorted.get(num));
        }

        ArrayList<Integer> Relanswer = new ArrayList<>();

        for(Integer num:sorted.keySet()){
            if(sorted.get(num)==max){
                Relanswer.add(num);
            }
        }




        return Arrays.stream(Relanswer).mapToInt(Integer::valueOf);

    }
}
