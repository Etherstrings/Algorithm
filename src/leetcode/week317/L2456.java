package leetcode.week317;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-11-01 14:54 leetcode.week317 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2456 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/1 - the current system date.  14:54 - the current system time.  2022 - the current year.  11 - the current month.  01 - the current day of the month.  14 - the current hour.  54 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L2456 {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        //第一步 找到值最高的
        //名-id-value
        HashMap<String,List<Integer>> full=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        HashMap<String,Integer> name_value=new HashMap<>();
        for(int i=0;i<creators.length;i++){
            String name=creators[i];
            String id=ids[i];
            int value=views[i];
            //
            set.add(creators[i]);
            if(name_value.containsKey(name)){
                name_value.put(name,name_value.get(name)+views[i]);
            }else {
                name_value.put(name,views[i]);
            }
            //
            if(full.containsKey(name)){
                List<Integer> temp=full.get(name);
                temp.add(value);
                full.put(name,temp);
            }else {
                List<Integer> temp=new ArrayList<>();
                temp.add(value);
                full.put(name,temp);
            }
        }
        //查找谁的Value最大
        int vmax=0;
        for(String name:set){
            vmax=Math.max(vmax,name_value.get(name));
        }
        //作者名单
        List<String> names=new ArrayList<>();
        for(String name:set){
            if(name_value.get(name)==vmax){
                names.add(name);
            }
        }
        Collections.sort(names);


        List<List<String>> ans=new ArrayList<>();
        for(String name:names){
            List<String> now=new ArrayList<>();
            now.add(name);
            //v
            List<Integer> values = full.get(name);
            Collections.sort(values);
            int value=values.get(values.size()-1);
            for(int i=0;i<creators.length;i++){
                if(views[i]==value&&creators[i].equals(name)){
                    now.add(ids[i]);
                    break;
                }
            }
            ans.add(now);
        }
        return ans;
    }
}
