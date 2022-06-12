package BackStracking;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-05-25 20:37 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L332 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/25 - the current system date.  20:37 - the current system time.  2022 - the current year.  05 - the current month.  25 - the current day of the month.  20 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L332 {
    //332. 重新安排行程
    //给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
    //
    //所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
    //
    //例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
    //假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
    //输出：["JFK","MUC","LHR","SFO","SJC"]
    //示例 2：
    //
    //
    //输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    //输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
    //解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
    private Deque<String> res;
    private Map<String, Map<String, Integer>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, Map<String, Integer>>();
        res = new LinkedList<>();
        for(List<String> t : tickets){
            Map<String, Integer> temp;
            if(map.containsKey(t.get(0))){
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else{
                temp = new TreeMap<>();//升序Map
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);

        }
        res.add("JFK");
        BackTarcking(tickets.size());
        return new ArrayList<>(res);
    }

    private boolean BackTarcking(int ticketNum){
        if(res.size()==ticketNum+1){
            return true;
        }

        String last= res.getLast();
        if(map.containsKey(last)){
            for(Map.Entry<String,Integer> target:map.get(last).entrySet()){
                int count=target.getValue();
                if(count>0){
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if(BackTarcking(ticketNum)) return true;
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }


}
