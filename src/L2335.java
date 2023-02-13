import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Justice_wby
 * @create 2023-02-11 0:28
 */
public class L2335 {
    public int fillCups(int[] amount) {
        //大顶堆--堆顶大于每个子孩子。
        Queue<Integer> bigd = new PriorityQueue<>((x, y) -> (y - x));
        for(int now:amount){
            bigd.offer(now);
        }
        int ans=0;
        while(!bigd.isEmpty()){
            Integer now=bigd.poll();
            Integer second=bigd.poll();
            if(now==0){
                break;
            }
            if(second==0){
                ans+=now;
                break;
            }
            now--;
            second--;
            bigd.offer(now);
            bigd.offer(second);
            ans+=2;
        }
        return ans;
    }
}
