package HASH;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-03 13:58 HASH - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1487 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/3 - the current system date.  13:58 - the current system time.  2023 - the current year.  03 - the current month.  03 - the current day of the month.  13 - the current hour.  58 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> index = new HashMap<String, Integer>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!index.containsKey(name)) {
                //2019
                //直接赋值2019为1
                res[i] = name;
                index.put(name, 1);
            } else {
                //2019已经有了
                int k = index.get(name);
                while (index.containsKey(addSuffix(name, k))) {
                    //2020有吗？
                    //2021有吗？
                    k++;
                }
                //a(2022)没有 赋值
                res[i] = addSuffix(name, k);
                //下回再遇到2019，就从2023找，因为2022也已经有了
                index.put(name, k + 1);
                //2022是没有的，放进去
                index.put(addSuffix(name, k), 1);
            }
        }
        return res;
    }

    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }

}
