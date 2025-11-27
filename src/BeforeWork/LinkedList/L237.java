package LinkedList;

public class L237 {

    public void deleteNode(ListNode node) {
        //删掉node
        node=node.next;
        node.next=node.next.next;
    }
}
