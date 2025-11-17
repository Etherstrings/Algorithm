package AcWing.Base.SingleLinkedList;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-28 22:26 AcWing.Base.SingleLinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Main - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/28 - the current system date.  22:26 - the current system time.  2023 - the current year.  03 - the current month.  28 - the current day of the month.  22 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class Main {
    static SingleLinkedList sl=new SingleLinkedList();
    public static int index=0;
    public static void main(String[] args) {
        sl.init();
        Scanner in=new Scanner(System.in);
        int M=in.nextInt();
        for(int i=1;i<=M;i++){
            String s=in.next();
            if(s.equals("H")){
                int val=in.nextInt();
                sl.add(val);
            }else if(s.equals("I")){
                int index=in.nextInt();
                int val=in.nextInt();
                sl.insert(index,val);
            }else {
                int index=in.nextInt();
                sl.delete(index);
            }
        }
        ListNode Now=sl.Pre.next;
        while(Now!=null){
            System.out.print(Now.val+" ");
            Now=Now.next;
        }
    }
    static class SingleLinkedList{
        public ListNode Pre;

        public SingleLinkedList(){

        }
        public void init(){
            Pre=new ListNode(-1,null);
        }
        public void add(int val){
            if(Pre.next==null){
                index++;
                Pre.next=new ListNode(val,index);
            }else {
                ListNode head=Pre.next;
                index++;
                ListNode temp=new ListNode(val,null);
                temp.index=index;
                Pre.next=temp;
                temp.next=head;
            }
        }

        public void insert(int k,int val){
            ListNode Now=Pre.next;
            while(Now!=null){
                if(Now.index==k){
                    ListNode temp=Now.next;
                    index++;
                    Now.next=new ListNode(val,index);
                    Now.next.next=temp;
                    break;
                }
                Now=Now.next;
            }
        }

        public void delete(int k){
            if(k==0){
                Pre.next=Pre.next.next;
            }else {
                ListNode Now=Pre.next;
                while(Now!=null){
                    if(Now.index==k){
                        Now.next=Now.next.next;
                        break;
                    }
                    Now=Now.next;
                }
            }
        }
    }
    static class ListNode{
        public int val;
        public int index;
        public ListNode next=null;
        public ListNode(){

        }
        public ListNode(int val){
            this.val=val;
        }
        public ListNode(int val,int index){
            this.val=val;
            this.index=index;
        }
        public ListNode(int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }
}



