package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class L538II {
    int pre;
    public TreeNode convertBST(TreeNode root){
        pre=0;
        traversal(root);
        return root;
    }

    private void traversal(TreeNode root){
        //中序遍历的模板
        //中序遍历用什么？
        //用栈
        Stack<TreeNode> st=new Stack<>();
        TreeNode now=root;



        while(!st.isEmpty()||now!=null){

            if(now!=null){
                st.push(now);

                //当前为右
                now=now.right;
            }else {
                //当前遍历为null
                now=st.peek();
                st.pop();
                now.val+=pre;
                pre=now.val;
                now=now.left;
            }
        }
    }
}
