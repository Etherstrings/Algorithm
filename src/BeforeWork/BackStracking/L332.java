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

    List<String> res=new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        //String-起始位置
        //TreeMap-目的地，还剩几张票
        HashMap<String,TreeMap<String,Integer>> map=new HashMap<>();
        for(List<String> Ticket:tickets){
            //出发地
            String from=Ticket.get(0);
            //目的地
            String to=Ticket.get(1);

            map.putIfAbsent(from,new TreeMap<>());
            TreeMap<String,Integer> treeMap=map.get(from);
            treeMap.put(to,treeMap.getOrDefault(to,0)+1);
        }
        res.add("JFK");
        backtrack(tickets,map,0);

        return res;
    }

    private boolean backtrack(List<List<String>> tickets,HashMap<String,TreeMap<String,Integer>> map,int progress){
        if(progress==tickets.size()){
            return true;
        }
        TreeMap<String,Integer> tos=map.get(res.get(res.size()-1));
        if(tos==null||tos.isEmpty()||tos.size()==0){
            return false;
        }
        for(String str:tos.keySet()){
            if(tos.get(str)==0){
                continue;
            }
            res.add(str);
            tos.put(str,tos.get(str)-1);

            if(backtrack(tickets,map,progress+1)){
                return true;
            }
            res.remove(res.size()-1);
            tos.put(str,tos.get(str)+1);
        }
        return false;
    }


}
