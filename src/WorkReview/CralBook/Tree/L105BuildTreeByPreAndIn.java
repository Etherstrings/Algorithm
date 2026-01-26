package WorkReview.CralBook.Tree;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-11
 */
public class L105BuildTreeByPreAndIn {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(inorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder,int preLeft,int preRight, int[] inorder, int inLeft,int inRight) {
        // 递归终止条件
        if (inLeft > inRight || preLeft > preRight) return null;

        // val 为前序遍历第一个的值，也即是根节点的值
        // idx 为根据根节点的值来找中序遍历的下标
        int idx = inLeft, val = preorder[preLeft];
        TreeNode root = new TreeNode(val);
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                idx = i;
                break;
            }
        }

        // 根据 idx 来递归找左右子树
        root.left = build(preorder, preLeft + 1, preLeft + (idx - inLeft),
                inorder, inLeft, idx - 1);
        root.right = build(preorder, preLeft + (idx - inLeft) + 1, preRight,
                inorder, idx + 1, inRight);
        return root;
    }
}
