package Tree;

/**
 * @author Justice_wby
 * @create 2023-02-03 20:02
 */

//这题很有意思
public class L1145 {
    //1145. 二叉树着色游戏
    //有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同。
    //
    //最开始时：
    //
    //「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）；
    //「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。
    //「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。
    //
    //之后两位玩家轮流进行操作，「一号」玩家先手。每一回合，玩家选择一个被他染过色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色（「一号」玩家染红色，「二号」玩家染蓝色）。
    //
    //如果（且仅在此种情况下）当前玩家无法找到这样的节点来染色时，其回合就会被跳过。
    //
    //若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。
    //
    //现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true ；若无法获胜，就请返回 false 。

    //x先放到了一个节点，这个x与root的val是对应的
    //寻找一个y 可以使y所获取的节点最大

    //n2的最大值是什么呢？
    //x所在位置的 左子数 右子树 以及父子树节点
    //即         left  right  father 三个选一个最大的值
    //father的怎么表示？
    //n-(left+right+1)
    //n-n2<n2
    //n1<n2
    //2*(n2)>n
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root,x);
        return Math.max(Math.max(left,right),(n-left-right-1))*2>n;
    }
    private static int left;
    private static int right;

    private static int dfs(TreeNode root,int x){
        if(root==null){
            return 0;
        }
        int nowleft=dfs(root.left,x);
        int nowright=dfs(root.right,x);
        if(root.val==x){
            left=nowleft;
            right=nowright;
        }
        return nowleft+nowright+1;
    }
}
