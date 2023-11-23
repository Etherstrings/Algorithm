package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-15
 */
public class L773 {
    //华容道
    //在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示。一次 移动 定义为选择 0 与一个相邻的数字（上下左右）进行交换.
    //
    //最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
    //
    //给出一个谜板的初始状态 board ，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
    //将数组的上下左右可移动记录
    public static void main(String[] args) {
        int[][] board = new int[][]{{1,2,3},{4,0,5}};
        System.out.println(slidingPuzzle(board));
    }
    public static int[][] neighbor = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    public static int ans;
    public static int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                start += board[i][j];
            }
        }
        if(start.equals(target)){
            return 0;
        }
        ans=Integer.MAX_VALUE;
        Queue<String> queue = new LinkedList<>();
        HashSet<String> showUp = new HashSet<>();
        queue.offer(start);
        showUp.add(start);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String now = queue.poll();
                if(now.equals(target)){
                    return step;
                }
                int index = now.indexOf('0');
                for(int canMoveIndex : neighbor[index]){
                    String next = swap(now, index, canMoveIndex);
                    if(!showUp.contains(next)){
                        queue.offer(next);
                        showUp.add(next);
                    }else {
                        continue;
                    }
                }
            }
            //这里step++ 是因为这一次操作，只不过是上下左右的一轮移动，在里面的上下左右移动，实际上是一次操作
            step++;
        }
        return -1;
    }

    public static String swap(String now, int index, int canMoveIndex){
        char[] chars = now.toCharArray();
        char temp = chars[index];
        chars[index] = chars[canMoveIndex];
        chars[canMoveIndex] = temp;
        return new String(chars);
    }



}
