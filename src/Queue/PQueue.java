package Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PQueue {
    public static void main(String[] args) {
        //小顶堆--堆顶小于每个子孩子
        Queue<Integer> queue1 = new PriorityQueue<>((x, y) -> (x - y));
        //大顶堆--堆顶大于每个子孩子。

        //分别为加入、推出、取堆顶元素
        queue1.offer(5);
        queue1.poll();
        queue1.peek();
    }

}
