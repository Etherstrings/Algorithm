package Build;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-25
 */
public class L460_LFU_CACHE {

    class LFUCache{
        //容量
        int capacity;
        //map里存的是key-value
        HashMap<Integer,int[]> map;
        //优先队列 这个优先队列肯定需要对出现次数进行排序，那就是依靠key-showtime的方式进行排序
        Queue<int[]> smallget;
        //第几次操作
        int time;
        public LFUCache(int capacity) {
            this.time=1;
            this.capacity=capacity;
            this.map=new HashMap<>();
            this.smallget = new PriorityQueue<>(
                    (x, y) -> {
                        if (x[1] == y[1]) {
                            return y[2] - x[2];
                        }
                        return x[1]-y[1];
                    }
            );
        }

        public int get(int key) {
            time++;
            if(map.containsKey(key)){
                map.put(key,new int[]{map.get(key)[0],map.get(key)[1]+1});
                Queue<int[]> temp = new PriorityQueue<>(
                        (x, y) -> {
                            if (x[1] == y[1]) {
                                return y[2] - x[2];
                            }
                            return x[1]-y[1];
                        }
                );
                while(!smallget.isEmpty()){
                    int[] t=smallget.poll();
                    if(t[0]!=key){
                        temp.offer(t);
                    }
                }
                temp.offer(new int[]{key,map.get(key)[1],time});
                smallget=temp;
                return map.get(key)[0];
            }else {
                return -1;
            }
        }

        public void put(int key, int value) {
            time++;
            if(map.containsKey(key)){
                map.put(key,new int[]{value,map.get(key)[1]+1});
                Queue<int[]> temp = new PriorityQueue<>(
                        (x, y) -> {
                            if (x[1] == y[1]) {
                                return y[2] - x[2];
                            }
                            return Integer.compare(x[1], y[1]);
                        }
                );
                while(!smallget.isEmpty()){
                    int[] t=smallget.poll();
                    if(t[0]!=key){
                        temp.offer(t);
                    }
                }
                temp.offer(new int[]{key,map.get(key)[1],time});
                smallget=temp;
            }else {
                if(capacity==0){
                    //删除最小的
                    int[] t=smallget.poll();
                    map.remove(t[0]);
                    capacity++;
                    map.put(key,new int[]{value,1});
                    smallget.offer(new int[]{key,1,time});
                }else {
                    map.put(key,new int[]{value,1});
                    smallget.offer(new int[]{key,1,time});
                    capacity--;
                }
            }
        }
    }

}
