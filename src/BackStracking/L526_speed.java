package BackStracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-06
 */
public class L526_speed {
    public static void main(String[] args) {
        System.out.println(countArrangement(11));
    }
    static List<Integer>[] match;
    static boolean[] vis;
    static int num;
    public static int countArrangement(int n) {
        vis = new boolean[n + 1];
        match = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    match[i].add(j);
                }
            }
        }
        backtrack(1, n);
        return num;
    }
    public static void backtrack(int index, int n) {
        if (index == n + 1) {
            num++; return;
        }
        for (int x : match[index]) {
            if (!vis[x]) {
                vis[x] = true;
                backtrack(index + 1, n);
                vis[x] = false;
            }
        }
    }
}
