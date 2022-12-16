package src.SecondTime.Tree;

import Tree.TreeNode;

import java.util.*;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-22 11:50
 */
public class L655 {
    //655. 输出二叉树
    //给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
    //
    //树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
    //矩阵的列数 n 应该等于 2height+1 - 1 。
    //根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
    //对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
    //继续这一过程，直到树中的所有节点都妥善放置。
    //任意空单元格都应该包含空字符串 "" 。
    //返回构造得到的矩阵 res 。

    public List<List<String>> printTree(TreeNode root) {
        //层序遍历
        //模拟

        //先第一次层序遍历 找到层数

        Queue<TreeNode> Judeg=new LinkedList<>();
        int hight=1;
        Judeg.offer(root);
        while(!Judeg.isEmpty()){
            int size=Judeg.size();
            for(int i=0;i<size;i++){
                TreeNode temp=Judeg.poll();
                if(temp.left!=null){
                    Judeg.offer(temp.left);
                }
                if(temp.right!=null){
                    Judeg.offer(temp.right);
                }
            }
            hight++;
        }
        int n=(int)Math.pow(2,hight+1)-1;
        String[][] ans=new String[hight+1][n];
        for(int i=0;i<ans.length;i++){
            Arrays.fill(ans[i],"");
        }
        //矩阵构建完毕
        //填充
        //根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
        DFS(0,(n-1)/2,ans,root,hight);
        List<List<String>> tans=new ArrayList<>();
        for(int i=0;i<ans.length;i++){
            List<String> temp=Arrays.asList(ans[i]);
            tans.add(temp);
        }
        return tans;
    }

    void DFS(int level,int col,String[][] ans,TreeNode root,int hight){
        if(root==null){
            return;
        }
        ans[level][col]=String.valueOf(root.val);
        //res[r][c]
        // 左子节点放置在 res[r+1][c-2height-r-1]
        // 右子节点放置在 res[r+1][c+2height-r-1]
        if(root.left!=null){
            DFS(level+1,col-2*hight-level-1,ans,root.left,hight);
        }
        if(root.right!=null){
            DFS(level+1,col+2*hight-level-1,ans,root.right,hight);
        }
    }
}
