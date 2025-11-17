package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Justice_wby
 * @create 2023-01-30 13:11
 */
public class BM26 {

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> now = new LinkedList<>();
        now.offer(root);
        while(!now.isEmpty()){
            int size= now.size();
            ArrayList<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp=now.poll();
                level.add(temp.val);
                if(temp.left!=null){
                    now.offer(temp.left);
                }
                if(temp.right!=null){
                    now.offer(temp.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
