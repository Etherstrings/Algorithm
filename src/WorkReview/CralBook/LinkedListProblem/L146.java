package WorkReview.CralBook.LinkedListProblem;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-14
 */
public class L146 {
    public class LRUCache{
        private Map<Integer,Integer> map = new LinkedHashMap<>();
        private Integer cap;

        public LRUCache (int cap) {
            this.cap = cap;
        }

        public int get(int key) {
            // 删除 key，并利用返回值判断 key 是否在 cache 中
            Integer value = map.remove(key);
            if (value != null) { // key 在 cache 中
                map.put(key, value);
                return value;
            }
            // key 不在 cache 中
            return -1;
        }

        public void put(int key,int value){
            // 删除 key，并利用返回值判断 key 是否在 cache 中
            if (map.remove(key) != null) { // key 在 cache 中
                map.put(key, value);
                return;
            }
            // key 不在 cache 中，那么就把 key 插入 cache，插入前判断 cache 是否满了
            if (map.size() == cap) { // cache 满了
                Integer eldestKey = map.keySet().iterator().next();
                map.remove(eldestKey); // 移除最久未使用 key
            }
            map.put(key, value);
        }
    }
}
