package LinkedList;

import Tool.ATool;

import java.util.Collections;
import java.util.List;

/**
 * @author Justice_wby
 * @create 2023-01-21 19:57
 */
public class BM12 {
    public ListNode sortInList (ListNode head) {
        // write code here

        List<Integer> temp=ATool.LinkedList2ArrayList(head);

        Collections.sort(temp);
        return ATool.Array2LinkedList(null,temp);
    }
}
