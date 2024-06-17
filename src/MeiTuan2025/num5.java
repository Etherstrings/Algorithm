package MeiTuan2025;


import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Scanner;

public class num5 {
    static class UnionFind {
        int[] parent;
        int[] rank;
        int[] xorToParent;  // 存储到父节点的异或值

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            xorToParent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
                xorToParent[i] = 0;  // 初始自己到自己的异或值是0
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                int originalParent = parent[x];
                parent[x] = find(parent[x]);
                xorToParent[x] ^= xorToParent[originalParent];
            }
            return parent[x];
        }

        public void union(int x, int y, int weight) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                    xorToParent[rootY] = xorToParent[x] ^ xorToParent[y] ^ weight;
                } else {
                    parent[rootX] = rootY;
                    xorToParent[rootX] = xorToParent[x] ^ xorToParent[y] ^ weight;
                    if (rank[rootX] == rank[rootY]) {
                        rank[rootY]++;
                    }
                }
            }
        }

        public int getXor(int x, int y) {
            if (find(x) == find(y)) {
                return xorToParent[x] ^ xorToParent[y];
            } else {
                return -1;
            }
        }
    }
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        String[] firstLine = reader.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int q = Integer.parseInt(firstLine[1]);

        UnionFind uf = new UnionFind(n + 1);
        ArrayList<int[]> edges = new ArrayList<>();
        ArrayList<int[]> queries = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            String[] edgeInfo = reader.nextLine().split(" ");
            int u = Integer.parseInt(edgeInfo[0]);
            int v = Integer.parseInt(edgeInfo[1]);
            int w = Integer.parseInt(edgeInfo[2]);
            edges.add(new int[]{u, v, w});
        }

        for (int i = 0; i < q; i++) {
            String[] query = reader.nextLine().split(" ");
            int op = Integer.parseInt(query[0]);
            if (op == 1) {
                int index = Integer.parseInt(query[1]) - 1;
                queries.add(new int[]{op, index});
            } else if (op == 2) {
                int u = Integer.parseInt(query[1]);
                int v = Integer.parseInt(query[2]);
                queries.add(new int[]{op, u, v});
            }
        }

        Collections.reverse(queries);  // Reverse to process from last to first for edge deletions
        BitSet activeEdges = new BitSet(n - 1);
        activeEdges.set(0, n - 1);  // Initially, all edges are active

        ArrayList<String> results = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                // Activate this edge (in reverse processing, this is deletion)
                int index = query[1];
                activeEdges.clear(index);
            } else if (query[0] == 2) {
                int u = query[1];
                int v = query[2];
                results.add(String.valueOf(uf.getXor(u, v)));
            }
        }

        Collections.reverse(results);
        results.forEach(System.out::println);

        // Finally, activate the edges in the UnionFind (add all inactive edges)
        for (int i = 0; i < edges.size(); i++) {
            if (!activeEdges.get(i)) {
                int[] edge = edges.get(i);
                uf.union(edge[0], edge[1], edge[2]);
            }
        }
    }
}
