package BackStracking;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-07-09 11:15 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L332_1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/9 - the current system date.  11:15 - the current system time.  2022 - the current year.  07 - the current month.  09 - the current day of the month.  11 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L332_1 {
    private Deque<String> res;
    private Map<String, Map<String, Integer>> map;
    public List<String> findItinerary(List<List<String>> tickets) {
        //存的是映射关系
        //出发地点---到达地点 出发地点到到达地点由几张票
        //A-B 3 A-C 1
        //key是出发地点 map里存了所有的出发地点可以到哪里 有几张票
        map = new HashMap<String, Map<String, Integer>>();

        //最终目的是线性的关系 A-B-C-D
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

        //最先从JFK出发
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }
    private boolean backTracking(int ticketNum){
        //如果A-B-C-D 最终有4个机场 3张票
        //如果路径的size==票数+1---全部走了一遍了
        if(res.size() == ticketNum + 1){
            return true;
        }
        //上一步到达的目的地
        //初始为JFK为例
        String last = res.getLast();
        if(map.containsKey(last)){//防止出现null
            //机票哪些是从这个末尾出发的 可以连一起的有哪些？
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                //遍历选择机场 -A -B -C
                //这里选择的是大子树

                //遍历 JFK可以到哪些机场

                //JFK到这个机场有几个票
                int count = target.getValue();

                //如果>0 这个票还没用
                if(count > 0){
                    //那就是往下递归了

                    //那就在路程当中 加上这个分叉树
                    //JFK-A了
                    res.add(target.getKey());
                    //那就把到这个机场的票的方式 减去1
                    target.setValue(count - 1);

                    //继续往下遍历--判断这个分支是不是可以
                    //比如总体JFK可以去A 可以去B
                    //这个就是判断JFK去A是不是可以
                    if(backTracking(ticketNum)) return true;

                    //不行 那就要换一个分支了
                    //这时候的分支是 JKF-A
                    //要删掉A---变回JFK
                    //人还在JFK 票也没用 也要返回
                    //然后递归回来
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }

}
