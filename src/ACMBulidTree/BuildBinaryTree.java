package ACMBulidTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-09-15 18:24 ACMBulidTree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  BuildBinaryTree - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/15 - the current system date.  18:24 - the current system time.  2022 - the current year.  09 - the current month.  15 - the current day of the month.  18 - the current hour.  24 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class BuildBinaryTree {
    //如果父节点的数组下标是i，那么它的左孩子下标就是i * 2 + 1，右孩子下标就是 i * 2 + 2。
    TreeNode build(List<Integer> vec){
        List<TreeNode> vecTree=new ArrayList<>(vec.size());
        Collections.fill(vecTree,null);
        TreeNode root=null;
        for(int i=0;i<vec.size();i++){
            TreeNode node=null;
            if(vec.get(i)!=-1){
                node=new TreeNode(vec.get(i));
            }
            vecTree.set(i,node);
            if(i==0){
                root=node;
            }
        }
        for(int i=0;i*2+2<vec.size();i++){
            if(vecTree.get(i)!=null){
                vecTree.get(i).left=vecTree.get(i*2+1);
                vecTree.get(i).right=vecTree.get(i*2+2);
            }
        }
        return root;
    }
}
