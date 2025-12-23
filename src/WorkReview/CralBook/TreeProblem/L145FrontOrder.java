package WorkReview.CralBook.TreeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-04
 */
public class L145FrontOrder {
    public static void main(String[] args) {

    }

    public List<Integer> frontOrderTraversal(Tree.TreeNode root){
        List<Integer> ans  = new ArrayList<>();
        frontOrder(ans, root);
        return ans;
    }

    private void frontOrder(List<Integer> ans, Tree.TreeNode root) {
        if (root == null) {
            return;
        }
        frontOrder(ans,root.left);
        frontOrder(ans,root.right);
        ans.add(root.val);
    }


}
