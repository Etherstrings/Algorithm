package src.SecondTime.BackTarcking;

import java.util.*;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-22 15:57
 */
public class L322 {
    LinkedList<String> Path=new LinkedList<>();
    HashMap<String, TreeMap<String,Integer>> ticketsMap;
    public List<String> findItinerary(List<List<String>> tickets) {
        ticketsMap=new HashMap<>();
        for(List<String> ticket:tickets){
            if(ticketsMap.containsKey(ticket.get(0))){
                //有没有以此出发的机票

                //已经有了以此出发的机票
                //有没有包含目的地的机票
                TreeMap<String, Integer> tempmap = ticketsMap.get(ticket.get(0));
                if(tempmap.containsKey(ticket.get(1))){
                    tempmap.put(ticket.get(1),tempmap.get(ticket.get(1))+1);
                }else {
                    tempmap.put(ticket.get(1),1);
                }
                ticketsMap.put(ticket.get(0),tempmap);

            }else {
                TreeMap<String,Integer> temp=new TreeMap<>();
                temp.put(ticket.get(1),1);
                ticketsMap.put(ticket.get(0),temp);
            }
        }

        //此时已经有了对应的机票
        //开始拼接
        //需要初始化
        //从JFK出发
        Path.offer("JFK");
        Backtarcking(tickets.size());
        return new ArrayList<>(Path);
    }

    boolean Backtarcking(int ticketNum){
        //所有的票都要用完
        if(Path.size() == ticketNum + 1){
            return true;
        }
        //从哪个机场来？
        String last=Path.getLast();
        if(ticketsMap.containsKey(last)){
            TreeMap<String, Integer> canGoWhereTree = ticketsMap.get(last);
            Set<String> canGoWhere = canGoWhereTree.keySet();
            for(String target:canGoWhere){
                int ticketleft=canGoWhereTree.get(target);
                if(ticketleft>0){
                    Path.offer(target);
                    canGoWhereTree.put(target,ticketleft-1);
                    if(Backtarcking(ticketNum)){
                        return true;
                    }
                    canGoWhereTree.put(target,ticketleft);
                    Path.removeLast();
                }
            }
        }
        return false;
    }
}
