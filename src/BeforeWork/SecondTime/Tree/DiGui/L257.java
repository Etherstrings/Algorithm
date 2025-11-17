package SecondTime.Tree.DiGui;

import Tree.TreeNode;

import javax.management.BadAttributeValueExpException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-16 14:26
 */
public class L257 {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        if(root==null){
            return ans;
        }
        BackTarcking(root,ans,paths);
        return ans;
    }

    void BackTarcking(TreeNode root,List<String> ans,List<Integer> paths){
        //终止条件
        paths.add(root.val);
        if(root.left==null&&root.right==null){
            String temp="";
            for(int i=0;i<paths.size()-1;i++){
                temp+=paths.get(i)+"->";
            }
            temp+=paths.get(paths.size()-1);
            ans.add(temp);
            return;
        }

        //单层回溯的方式
        //每一层都有拼左 拼右的两种方式
        if(root.left!=null){
            BackTarcking(root.left,ans,paths);
            paths.remove(paths.size()-1);
        }
        if(root.right!=null){
            BackTarcking(root.right,ans,paths);
            paths.remove(paths.size()-1);
        }
    }
}
