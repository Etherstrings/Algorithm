package SecondTime.Tree.CengXu;




import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-17 17:42
 */
public class L1302 {
    //1302. 层数最深叶子节点的和
    //给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
    public int deepestLeavesSum(TreeNode root) {
        //层序遍历
        Queue<TreeNode> Juege=new LinkedList<>();
        Juege.offer(root);
        int level=1;
        while(!Juege.isEmpty()){
            int size=Juege.size();
            for(int i=0;i<size;i++){
                TreeNode Temp=Juege.poll();
                if(Temp.left!=null){
                    Juege.offer(Temp.left);
                }
                if(Temp.right!=null){
                    Juege.offer(Temp.right);
                }
            }
            level++;
        }
        Queue<TreeNode> nJudge=new LinkedList<>();
        nJudge.offer(root);
        int newlevel=1;
        int ans=0;
        while(!nJudge.isEmpty()){

            int size=nJudge.size();
            if(newlevel==level-1){
                for(int i=0;i<size;i++){
                    TreeNode Temp=nJudge.poll();
                    ans+=Temp.val;
                    if(Temp.left!=null){
                        nJudge.offer(Temp.left);
                    }
                    if(Temp.right!=null){
                        nJudge.offer(Temp.right);
                    }
                }
                break;
            }
            for(int i=0;i<size;i++){
                TreeNode Temp=nJudge.poll();
                if(Temp.left!=null){
                    nJudge.offer(Temp.left);
                }
                if(Temp.right!=null){
                    nJudge.offer(Temp.right);
                }
            }
            newlevel++;
        }
        return ans;
    }


}
