package AcWing.Base.DanDiaoQueue;

import java.io.*;

public class A154 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = 1000010;
    static int[] q = new int[N];  // 队列数组, 其中存放 arr的下标值
    static int[] arr = new int[N];
    static int hh = 0, tt = -1;  // tt指向栈顶元素

    public static void main(String[] args) throws IOException {
        // 对输入数据进行初始化
        String[] s1 = reader.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);

        // 查找最小值
        for (int i = 0; i < n; i++) {
            // 判断队头是否已经滑出窗口, 如果滑出窗口, 则弹出队首元素,维护窗口大小不超过 k, 每次值滑动一次, 所以可以使用 if
            if (hh <= tt && i - k + 1 > q[hh])
                hh++;
            // 寻找窗口中的最小值
            while (hh <= tt && arr[q[tt]] >= arr[i]) tt--;

            q[++tt] = i;    // 将本轮下标添加到队列中
            // 保证满足窗口大小, 比如窗口大小为 3, 不能此时只进入 2个数字
            if (i + 1 >= k) log.write(arr[q[hh]] + " ");    // 窗口内的最小值为队首元素
        }
        log.write("\n");
        hh = 0;
        tt = -1;
        // 查找最大值
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && arr[q[tt]] <= arr[i]) tt--;
            q[++tt] = i;
            if (i + 1 >= k) log.write(arr[q[hh]] + " ");
        }
        // 关闭输入输出流
        log.flush();
        reader.close();
        log.close();
    }
}

