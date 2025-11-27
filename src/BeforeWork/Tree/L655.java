package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-23
 */
public class L655 {
    //给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
    //
    //树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
    //矩阵的列数 n 应该等于 2(height+1)次方 - 1 。
    //根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
    //对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
    //继续这一过程，直到树中的所有节点都妥善放置。
    //任意空单元格都应该包含空字符串 "" 。
    //返回构造得到的矩阵 res 。

    //打印二叉树
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(3,null,null),null),null);
        System.out.println(printTree(root));
    }
    public static List<List<String>> printTree(TreeNode root) {
        //先计算树的高度
        int height = getHeight(root);
        //计算矩阵的行数
        int m = height;
        //计算矩阵的列数
        int n = (int) Math.pow(2, height) - 1;
        //初始化矩阵
        String[][] res = new String[m][n];
        //填充矩阵
        fill(res, root, 0, 0, n - 1);
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(Arrays.asList(res[i]));
        }
        return list;
    }

    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }

    private static void fill(String[][] res, TreeNode root, int row, int l, int r) {
        if (root == null) {
            return;
        }
        //计算当前节点的列下标
        int mid = (l + r) / 2;
        res[row][mid] = String.valueOf(root.val);
        //填充左子树
        fill(res, root.left, row + 1, l, mid - 1);
        //填充右子树
        fill(res, root.right, row + 1, mid + 1, r);
    }
}
