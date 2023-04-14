package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2023-04-06 10:08 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  S35 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/6 - the current system date.  10:08 - the current system time.  2023 - the current year.  04 - the current month.  06 - the current day of the month.  10 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class S35 {

        Map<Node, Node> cachedNode = new HashMap<Node, Node>();

        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            if (!cachedNode.containsKey(head)) {
                Node headNew = new Node(head.val);
                cachedNode.put(head, headNew);
                headNew.next = copyRandomList(head.next);
                headNew.random = copyRandomList(head.random);
            }
            return cachedNode.get(head);
        }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
