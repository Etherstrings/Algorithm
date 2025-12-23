package WorkReview.CralBook.TreeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-04
 */
public class L144PreOrder {
    public static void main(String[] args) {

    }

    public List<Integer> perOrderTraversal(Tree.TreeNode root){
        List<Integer> ans  = new ArrayList<>();
        preOrder(ans, root);
        return ans;
    }

    //前序
    //中左右
    public void preOrder(List<Integer> ans, Tree.TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preOrder(ans,root.left);
        preOrder(ans,root.right);
    }


    //前序
    //中左右
    public List<Integer> perOrderTraversalV3(Tree.TreeNode root){
        List<Integer> ans  = new ArrayList<>();
        Stack<Tree.TreeNode> stack = new Stack<>();
        if (root == null) {
            return ans;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Tree.TreeNode now = stack.pop();
            ans.add(now.val);
            if (now.left!=null) {
                stack.add(now.left);
            }
            if (now.right!=null) {
                stack.add(now.right);
            }
        }
        return ans;
    }
}
