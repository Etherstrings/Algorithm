package MeiTuan2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class num3 {
    static final int MOD = 1000000007;
    static List<Integer>[] graph;
    static boolean[] visited;
    static char[] colors;

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int n = Integer.parseInt(reader.nextLine());
        String color = reader.nextLine();

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        colors = color.toCharArray();

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            String[] edge = reader.nextLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph[u].add(v);
            graph[v].add(u);
        }

        long totalSum = 0;
        for (int i = 1; i <= n; i++) {
            if (colors[i - 1] == 'R' && !visited[i]) {
                long product = dfs(i);
                totalSum = (totalSum + countFactors(product)) % MOD;
            }
        }

        System.out.println(totalSum);
    }

    private static long dfs(int node) {
        visited[node] = true;
        long product = node;
        for (int neighbor : graph[node]) {
            if (colors[neighbor - 1] == 'R' && !visited[neighbor]) {
                product = (product * dfs(neighbor)) % MOD;
            }
        }
        return product;
    }

    private static long countFactors(long number) {
        long count = 0;
        for (long i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                if (i * i == number) {
                    count = (count + 1) % MOD;  // Perfect square
                } else {
                    count = (count + 2) % MOD;  // i and number/i are factors
                }
            }
        }
        return count;
    }
}