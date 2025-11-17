package SecondTime.Tree;

import Tree.TreeNode;

import java.util.*;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-12 14:24
 */
public class TreeSeeAll_DieDai {
    //深搜的话---使用栈进行迭代


    //层搜的话---使用队列进行迭代
    List<Integer> Pre(TreeNode root){
            List<Integer> result = new LinkedList<>();
            Stack<TreeNode> st = new Stack<>();
            if (root != null) st.push(root);
            while (!st.empty()) {
                TreeNode node = st.peek();
                if (node != null) {
                    st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                    if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）
                    if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）
                    st.push(node);                          // 添加中节点
                    st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。

                } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                    st.pop();           // 将空节点弹出
                    node = st.peek();    // 重新取出栈中元素
                    st.pop();
                    result.add(node.val); // 加入到结果集
                }
            }
            return result;
        }


    List<Integer> Mid(TreeNode root){
        //左中右
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> Judge=new Stack<>();
        if (root != null){
            Judge.push(root);
        }
        while (!Judge.empty()) {
            TreeNode Temp=Judge.peek();
            if(Temp!=null){
                Judge.pop();
                if(Temp.right!=null){
                    Judge.push(Temp.right);
                }
                Judge.push(Temp);
                Judge.push(null);
                if(Temp.left!=null){
                    Judge.push(Temp.left);
                }
            }else {
                Judge.pop();
                Temp=Judge.peek();
                Judge.pop();
                result.add(Temp.val);
            }
        }
        return result;
    }


    List<Integer> Back(TreeNode root){
        //左右中
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> Judge=new Stack<>();
        if (root != null){
            Judge.push(root);
        }
        while (!Judge.empty()) {
            TreeNode Temp=Judge.peek();
            if(Temp!=null){
                Judge.pop();
                Judge.push(null);
                Judge.push(Temp);
                if(Temp.right!=null){
                    Judge.push(Temp.right);
                }
                if(Temp.left!=null){
                    Judge.push(Temp.left);
                }
            }else {
                Judge.pop();
                Temp=Judge.peek();
                Judge.pop();
                result.add(Temp.val);
            }
        }
        return result;
    }
}
