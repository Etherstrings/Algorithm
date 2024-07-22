package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2024-07-22
 */
public class L2101 {
    public static void main(String[] args) {
        //	测试用例:[[1,1,100000],[100000,100000,1]]
        //	测试结果:2
        //	期望结果:1


        //[[2,1,3],[6,1,4]]
        int[][] bombs = {{2,1,3},{6,1,4}};
        System.out.println(maximumDetonation(bombs));
    }
    public static int maximumDetonation(int[][] bombs) {
        int ans = 1;
        //1.每一个炸弹都可以作为入口进行引爆
        for (int i = 0; i < bombs.length; i++) {
            boolean[] visited = new boolean[bombs.length];
            int temp = 1;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(bombs[i]);
            visited[i] = true;
            while (queue.size() > 0) {
                int[] now = queue.poll();
                for (int j = 0; j < bombs.length; j++) {
                    if (!visited[j] && areCirclesIntersecting(now, bombs[j])) {
                        visited[j] = true;
                        temp++;
                        queue.offer(bombs[j]);
                    }
                }
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    //判断炸弹2能不能被炸弹1引爆
    public static boolean areCirclesIntersecting(int[] bomb1, int[] bomb2) {
        int x1 = bomb1[0];
        int y1 = bomb1[1];
        int r1 = bomb1[2];
        int x2 = bomb2[0];
        int y2 = bomb2[1];

        // 计算圆心之间的距离的平方
        double distanceSquared = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
        // 计算第一个炸弹的爆炸半径的平方
        double radiusSquared = Math.pow(r1, 2);

        // 判断第二个炸弹是否在第一个炸弹的爆炸范围内
        return distanceSquared <= radiusSquared;
    }
}
