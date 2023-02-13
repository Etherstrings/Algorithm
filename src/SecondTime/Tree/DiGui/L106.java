package SecondTime.Tree.DiGui;


import Tree.TreeNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-18 11:22
 */
public class L106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0||postorder.length==0){
            return null;
        }
        //从头到尾  左闭右开
        return buils(inorder,0,inorder.length
        ,postorder,0,postorder.length);

    }

    TreeNode buils(int[] inorder, int instart, int inend,
                   int[] postorder, int poststart, int postend){
        //先找后序中的当前root
        if(poststart==postend){
            return null;
        }
        //再根据root构建出root的left和root的right
        int rootval=postorder[postend-1];
        TreeNode root = new TreeNode(rootval);
        //在前序中找到当前root对应的index
        int rootindex=-1;
        for(int i=instart;i<inend;i++){
            if(inorder[i]==rootval){
                rootindex=i;
                break;
            }
        }
        //前序的
        //现在左边的是left
        int inleft1=instart;
        int inleft2=rootindex;
        //右边的是right
        int inright1=rootindex+1;
        int inright2=inend;

        //根据前序划分的长度
        //切割后序
        //left长度
        int length1=inleft2-inleft1;
        //right长度
        int length2=inright2-inright1;

        //后序切的left 左闭右开
        int postleft1=poststart;
        int postleft2=poststart+length1;

        //后序切的right
        int postright1=poststart+length1;
        int postright2=postend-1;

        root.left=buils(inorder,inleft1,inleft2,postorder,postleft1,postleft2);
        root.right=buils(inorder,inright1,inright2,postorder,postright1,postright2);

        return root;
    }
}
