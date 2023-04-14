package AcWing.Base.SingleLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Etherstrings
 * @create 2023-03-30 16:41 AcWing.Base.SingleLinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L826 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/30 - the current system date.  16:41 - the current system time.  2023 - the current year.  03 - the current month.  30 - the current day of the month.  16 - the current hour.  41 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L826 {
    static int n;
    static int N = 100010;
    static int head;
    static int[] e = new int[N], ne = new int[N];
    static int idx;

    public static void init(){
        head = -1;
        idx = 1;
    }

    public static void addToHead(int x){
        e[idx] = x;
        ne[idx] = head;
        head = idx;
        idx ++;
    }

    public static void remove(int k){
        if(k==0){
            head=ne[head];
        }else {
            ne[k] = ne[ne[k]];
        }

    }

    public static void insert(int k, int x){
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx ++;
    }

    public static void main(String[] args) throws IOException {
        init();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        while(n -- != 0){
            int k, x;
            String[] s = br.readLine().split(" ");
            String opt = s[0];
            if(opt.equals("H")){
                x = Integer.parseInt(s[1]);
                addToHead(x);
            }else if(opt.equals("D")){
                k = Integer.parseInt(s[1]);
                if(k == 0) head = ne[head];
                else remove(k - 1);
            }else{
                k = Integer.parseInt(s[1]);
                x = Integer.parseInt(s[2]);
                insert(k - 1, x);
            }
        }

        for(int i = head; i != -1; i = ne[i]){
            System.out.print(e[i] + " ");
        }
    }


}
