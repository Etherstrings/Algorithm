package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-11-10 21:18 Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1609 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/10 - the current system date.  21:18 - the current system time.  2022 - the current year.  11 - the current month.  10 - the current day of the month.  21 - the current hour.  18 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L1609 {
    public boolean isEvenOddTree(TreeNode root) {
        //偶层--都是奇数 并且递增
        //奇数--都是偶数 并且递减
        boolean flag=true;
        if(root==null){
            flag=false;
            return flag;
        }
        Queue<TreeNode> judge=new LinkedList<>();
        int level=0;
        judge.offer(root);
        while(!judge.isEmpty()){
            int size=judge.size();
            level++;
            int left=level%2;
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode now=judge.poll();
                temp.add(now.val);
                if(now.left!=null){
                    judge.offer(now.left);
                }
                if(now.right!=null){
                    judge.offer(now.right);
                }
            }
            if(left==1){
                //奇数层
                //都是偶数 并且严格递减
                if(temp.size()==1){
                    if(temp.get(0)%2==1){
                        flag=false;
                        break;
                    }
                }
                int first=temp.get(0);
                if(first%2==1){
                    flag=false;
                    break;
                }
                boolean now=true;
                for(int i=1;i<temp.size();i++){
                    int v=temp.get(i);
                    if(v%2==1){
                        now=false;
                        break;
                    }
                    if(v>=first){
                        now=false;
                        break;
                    }else {
                        first=v;
                        continue;
                    }
                }
                if(now==false){
                    flag=false;
                    break;
                }
            }else {
                //偶数层
                //都是奇数 严格递增
                if(temp.size()==1){
                    if(temp.get(0)%2==0){
                        flag=false;
                        break;
                    }
                }
                int first=temp.get(0);
                if(first%2==0){
                    flag=false;
                    break;
                }
                boolean now=true;
                for(int i=1;i<temp.size();i++){
                    int v=temp.get(i);
                    if(v%2==0){
                        now=false;
                        break;
                    }
                    if(v<=first){
                        now=false;
                        break;
                    }else {
                        first=v;
                        continue;
                    }
                }
                if(now==false){
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }
}
