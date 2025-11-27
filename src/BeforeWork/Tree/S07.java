package Tree;

public class S07 {

    //思路
        //递归建树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return BulidHelper(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }

    TreeNode BulidHelper(int[] preorder,int preleft,int preright,
                         int[] inorder,int inleft,int inright){

        //递归的终止条件？
        if(preleft>preright||inleft>inright){
            return null;
        }

        int index=preleft;
        int val=preorder[preleft];

        //根据Root节点 建立起新的Root
        TreeNode root=new TreeNode(val);
        for(int i=inleft;i<=inright;i++){
            if(val==inorder[i]){
                //在中序遍历中 找到了 root节点
                index=i;
                break;
            }
        }

        root.left=BulidHelper(preorder,preleft+1,preleft+(index-preleft),
                inorder,inleft,index-1);
        root.right=BulidHelper(preorder,preleft+(index-preleft)+1,preright,
                inorder,index+1,inright);

        return root;
    }
}
