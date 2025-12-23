package WorkReview.CralBook.TreeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-04
 */
public class L94MidOrder {
    public static void main(String[] args) {

    }

    public List<Integer> MidOrderTraversal(Tree.TreeNode root){
        List<Integer> ans  = new ArrayList<>();
        midOrder(ans, root);
        return ans;
    }


    //left mid right
    private void midOrder(List<Integer> ans, Tree.TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(ans,root.left);
        ans.add(root.val);
        midOrder(ans,root.right);
    }


    //中序遍历


}
