package ACMBulidTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-10-22 19:31 ACMBulidTree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  NumberOfSiblingsOfAGivenNodeInNAryTree - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/22 - the current system date.  19:31 - the current system time.  2022 - the current year.  10 - the current month.  22 - the current day of the month.  19 - the current hour.  31 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class NumberOfSiblingsOfAGivenNodeInNAryTree {

    public static int maxDepth(Node root) {
        if (root == null)
            return 0;
        int max = 0;
        for (Node n : root.children) {
            max = Math.max(max, maxDepth(n));
        }
        return max + 1;
    }

    private static int siblings(Node root, int target) {
        // if the given node is equals to the root or root is null, return 0
        if (root == null || root.val == target) {
            return 0;
        }
        // create a queue of nodes
        Queue<Node> queue = new LinkedList<>();
        // push the root to queue
        queue.add(root);
        // do a BFS of the tree
        while (!queue.isEmpty()) {
            // remove one element from the queue
            Node curr = queue.poll();
            // traverse its children
            for (int i = 0; i < curr.children.size(); i++) {
                // current child
                Node currChild = curr.children.get(i);
                // if current child is the target, return (parent's children count - 1)
                if (currChild.val == target) {
                    return (curr.children.size() - 1);
                }
                // add the child to the queue
                queue.add(currChild);
            }
        }
        // if there is no match, return -1
        return -1;
    }
}
