package Tool;


import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Justice_wby
 * @create 2023-01-16 15:10
 */
public class ATool {

    //将静态数组Or动态数组顺序转为LinkedList
    public static ListNode Array2LinkedList(int[] array, List<Integer> arraylist){
        ListNode head=null;
        if(array==null&&arraylist==null){
            return head;
        }
        if(array==null){
            if(arraylist.size()==1){
                int temp=(int)arraylist.get(0);
                head=new ListNode(temp);
                head.next=null;
                return head;
            }
            int temp=(int)arraylist.get(0);
            head=new ListNode(temp);
            ListNode Now=head;
            ListNode Dummy=new ListNode(-1);
            Dummy.next=head;
            for(int i=1;i<arraylist.size();i++){
                int t=(int)arraylist.get(i);
                ListNode node=new ListNode(t);
                Now.next=node;
                Now=Now.next;
            }
            Now.next=null;
            return Dummy.next;
        }
        if(arraylist==null){
            if(array.length==1){
                int temp=(int)array[0];
                head=new ListNode(temp);
                head.next=null;
                return head;
            }
            int temp=(int)array[0];
            head=new ListNode(temp);
            ListNode Now=head;
            ListNode Dummy=new ListNode(-1);
            Dummy.next=head;
            for(int i=1;i<array.length;i++){
                int t=(int)array[i];
                ListNode node=new ListNode(t);
                Now.next=node;
                Now=Now.next;
            }
            Now.next=null;
            return Dummy.next;
        }
        return head;
    }


    //将静态数组Or动态数组逆序转为LinkedList
    public static ListNode ReArray2LinkedList(int[] array, List<Integer> arraylist){
        ListNode head=null;
        if(array==null&&arraylist==null){
            return head;
        }
        if(array==null){
            if(arraylist.size()==1){
                int temp=(int)arraylist.get(0);
                head=new ListNode(temp);
                head.next=null;
                return head;
            }
            Collections.reverse(arraylist);
            int temp=(int)arraylist.get(0);
            head=new ListNode(temp);
            ListNode Now=head;
            ListNode Dummy=new ListNode(-1);
            Dummy.next=head;
            for(int i=1;i<arraylist.size();i++){
                int t=(int)arraylist.get(i);
                ListNode node=new ListNode(t);
                Now.next=node;
                Now=Now.next;
            }
            Now.next=null;
            return Dummy.next;
        }
        if(arraylist==null){
            if(array.length==1){
                int temp=(int)array[0];
                head=new ListNode(temp);
                head.next=null;
                return head;
            }
            //反转

            List<Integer> objects = new ArrayList<>();
            for(int i=array.length-1;i>=0;i--){
                objects.add(array[i]);
            }
            for(int i=0;i<array.length;i++){
                array[i]=objects.get(i);
            }
            int temp=(int)array[0];
            head=new ListNode(temp);
            ListNode Now=head;
            ListNode Dummy=new ListNode(-1);
            Dummy.next=head;
            for(int i=1;i<array.length;i++){
                int t=(int)array[i];
                ListNode node=new ListNode(t);
                Now.next=node;
                Now=Now.next;
            }
            Now.next=null;
            return Dummy.next;
        }
        return head;
    }


    //将LinkedList转为ArrayList
    public static List<Integer> LinkedList2ArrayList(ListNode head){
        if(head==null){
            return new ArrayList<>();
        }
        List<Integer> ans=new ArrayList<>();
        ListNode now=head;
        while(now!=null){
            ans.add(now.val);
            now=now.next;
        }
        return ans;
    }


    //通过String构建ArrayList
    public static List<Object> String2ArrayList(String nums){
        List<Object> ans=new ArrayList<>();
        if(nums==null||nums.equals("")){
            return ans;
        }
        for(char now:nums.toCharArray()){
            ans.add(Integer.parseInt(now+""));
        }
        return ans;
    }

}
