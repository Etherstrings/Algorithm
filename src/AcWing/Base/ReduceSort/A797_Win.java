package AcWing.Base.ReduceSort;

import java.io.*;

/**
 * @author Etherstrings
 * @create 2023-03-23 18:03 AcWing.Base.ReduceSort - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A797_Win - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/23 - the current system date.  18:03 - the current system time.  2023 - the current year.  03 - the current month.  23 - the current day of the month.  18 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A797_Win {
    static int N = 100010;
    // 数据数组，也是差分数组的 前缀和数组
    static int[] a = new int[N];
    // 差分数组b[i]，差分数组的定义：a[i] = b[1] + b[2] + ... + b[i]
    // 同时求差分数组的一种方式是：b[i] = a[i] - a[i - 1]
    // 比如：b[1] = a[1] - 0, b[2] = a[2] - a[1] 又因为 a[2] = b[1] + b[2]，所以两者是相等的
    static int[] b = new int[N];

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = sc.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        s = (" " + sc.readLine()).split(" ");
        for(int i = 1; i <= n; i ++) a[i] = Integer.parseInt(s[i]);
        /*
         * 构建差分数组
         * 方式一：
         * 将数据数组a，的每一项想成 0，然后构建差分数组b[i] = 区间 i 到 i 加上 a[i]
         * 比如：当i=1时，b[1] = b[1] + a[1]，b[2] = b[2] - a[1]
         *          化简：b[1] = a[1]，b[2] = - a[2]
         *      当i=2时，b[2] = b[2] + a[2] b[3]=...，由于上一步b[2]的值，所以化简为：
         *              b[2] = - a[1] + a[2] ====> 这又和差分的定义是一样的 b[i] = a[i] - a[i - 1]
         */
        for(int i = 1; i <= n; i ++) insert(i, i, a[i]);
        // 构建差分数组 方式二：
//        for(int i = 1; i <= n; i ++) b[i] = a[i] - a[i - 1];

        while (m -- > 0) {
            s = sc.readLine().split(" ");
            int l = Integer.parseInt(s[0]), r = Integer.parseInt(s[1]), c = Integer.parseInt(s[2]);
            insert(l, r, c);
        }
        // 这里是构造 +c 后的数组，由于数据数组是 差分数组的 前缀和数组，所以最后需要得到的数据，
        // 就是从差分数组构建成 前缀和数组就行
        for(int i = 1; i <= n; i ++) b[i] += b[i - 1];
        // 输出结果 System.out.printf("%d ", b[i]);
        for(int i = 1; i <= n; i ++) bw.write(b[i] + " ");
        sc.close();
        bw.close();
    }
    // 将 a数组的[l, r]区间 每一位加上c，就相当于给差分数组的b[l]+c，然后l 到 n都会加上c，所以要从 r+1开始 减去c
    // 比如：a[l]+c = b[1]+b[2]+...+b[l]+c，然后 a[l+1]+c = b[1]+b[2]+...+b[l]+c + b[l+1]
    public static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }

}
