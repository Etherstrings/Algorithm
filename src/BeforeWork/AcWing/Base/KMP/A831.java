package AcWing.Base.KMP;

import java.io.*;

/**
 * @author Etherstrings
 * @create 2023-04-04 0:47 AcWing.Base.KMP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A831 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/4 - the current system date.  0:47 - the current system time.  2023 - the current year.  04 - the current month.  04 - the current day of the month.  00 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class A831 {
    public static int N=100010;
    public static int[] P=new int[N];
    public static int[] S=new int[N];
    public static int[] Next=new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        //P在S中出现
        //用P去匹配S
        int N=Integer.parseInt(reader.readLine());
        char[] pc = reader.readLine().toCharArray();
        for (int i = 1; i <= N; i++)
            P[i] = pc[i-1]-'a';

        int M=Integer.parseInt(reader.readLine());
        char[] Sc = reader.readLine().toCharArray();
        for(int i=1;i<=M;i++){
            S[i]= Sc[i-1]-'a';
        }

        // 构造Next数组
        // 从1取到n 最大值是相同的 比如 aba 最大值就是1
        // 用谁来构造Next数组？
        // 模式串来构造
        for (int i = 2, j = 0; i <= N; i++) {
            //i从2开始，因为prefix[1]肯定为0
            while (j != 0 && P[i] != P[j + 1])
                j = Next[j];
            if (P[i] == P[j + 1])
                j++;
            Next[i] = j;
        }

        // kmp匹配
        // S总串
        // P模式串
        for (int i = 1, j = 0; i <= M; i++) {
            while (j != 0 && S[i] != P[j + 1]) {
                j = Next[j]; // s[i] != p[j + 1]即不匹配，则往后移动
            }
            if (S[i] == P[j + 1])
                j++; // 匹配时将j++进行下一个字符得匹配
            if (j == N) { // 匹配了n字符了即代表完全匹配了
                writer.write(i - N +" ");
                j = Next[j]; // 完全匹配后继续搜索
            }
        }
        writer.flush();//所有write下的内容，会先存在writers中，当启用flush以后，会输出存在其中的内容。如果没有调用flush，则不会将writer中的内容进行输出。
        writer.close();
        reader.close();

    }
}
