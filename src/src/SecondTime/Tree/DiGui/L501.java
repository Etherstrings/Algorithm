package src.SecondTime.Tree.DiGui;

import Tree.TreeNode;

import java.util.*;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-18 15:29
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
    List<Integer> ans=new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        HashMap<Integer,Integer> Judge=new HashMap<>();
        Set<Integer> P=new HashSet<>();
        for(int a:ans){
            if(Judge.containsKey(a)){
                Judge.put(a,Judge.get(a)+1);
            }else {
                Judge.put(a,1);
            }
            P.add(a);
        }
        int num=Integer.MIN_VALUE;
        for(int a:P){
            num=Math.max(Judge.get(a),num);
        }
        ArrayList<Integer> temp=new ArrayList<>();
        for(int a:P){
            if(num==Judge.get(a)){
                temp.add(a);
            }
        }
        int[] answer=new int[temp.size()];
        for(int i=0;i<temp.size();i++){
            answer[i]=temp.get(i);
        }
        return answer;
    }

    void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
}
