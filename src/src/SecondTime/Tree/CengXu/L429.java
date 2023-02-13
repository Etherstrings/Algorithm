package src.SecondTime.Tree.CengXu;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-15 21:52 SecondTime.Tree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L429 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/15 - the current system date.  21:52 - the current system time.  2022 - the current year.  08 - the current month.  15 - the current day of the month.  21 - the current hour.  52 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Node> Judge = new LinkedList<>();
        if(root==null){
            return list;
        }
        Judge.offer(root);
        while(!Judge.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int size=Judge.size();
            for(int i=0;i<size;i++){
                Node Temp=Judge.pop();
                levelList.add(Temp.val);
                if(Temp.children==null&&Temp.children.size()==0){
                    continue;
                }
                for(Node a: Temp.children){
                    if(a.children!=null){
                        Judge.offer(a);
                    }
                }
            }
            list.add(levelList);
        }
        return list;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
