package src.GuangLianDa;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-08-31 18:27 GuangLianDa - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  LiZi - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/31 - the current system date.  18:27 - the current system time.  2022 - the current year.  08 - the current month.  31 - the current day of the month.  18 - the current hour.  27 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class LiZi {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String howmany=in.nextLine();
            String shoot=in.nextLine();
            String to=in.nextLine();

            int target=Integer.parseInt(howmany);
            String[] shoots = shoot.split(" ");
            String[] tos=to.split(" ");
            int[] shootlist=new int[target];
            int[] tolist=new int[target];
            //转换发送以及到达时间
            for(int i=0;i<shootlist.length;i++){
                shootlist[i]=Integer.parseInt(shoots[i]);
                tolist[i]=Integer.parseInt(tos[i]);
            }
            //应该存一个数组
            //发送编号以及到达编号
            //存第几个发送-节点
            HashMap<Integer,Integer> Send_Node=new HashMap<>();
            for(int i=0;i<shootlist.length;i++){
                //节点号
                int index=i+1;
                //编号从1-target
                Send_Node.put(shootlist[i],index);
            }
            //节点--对应一个到达时间
            HashMap<Integer,Integer> Node_To=new HashMap<>();
            for(int i=0;i<tolist.length;i++){
                //节点号
                int index=i+1;
                Node_To.put(index,tolist[i]);
            }
            //只要当前的发送的顺序 如果比前面发送的任意一个先到 就有问题

            //遍历第几个发送的
            int ans=0;
            for(int i=target;i>=2;i--){

                //这是第几个发送的？
                //最后一个发送
                int index=i;
                //这是第几个节点？
                int Node=Send_Node.get(index);
                //这个节点第几个到达
                int toend=Node_To.get(Node);
                //应该是比任意一个比他先发送的先到 就有问题
                for(int j=1;j<i;j++){
                    if(toend<Node_To.get(Send_Node.get(j))){
                        ans++;
                        break;
                    }
                }

            }
            System.out.print(ans);

        }
    }
}
