package LinkedList;

import Tool.ATool;

import java.util.List;

/**
 * @author Justice_wby
 * @create 2023-01-21 20:03
 */
public class BM13 {
    public boolean isPail (ListNode head) {
        // write code here
        List<Integer> objects = ATool.LinkedList2ArrayList(head);
        StringBuffer temp=new StringBuffer();
        for(Object o:objects){
            temp.append(o);
        }
        return temp.reverse().toString().equals(temp.toString());
    }


}
