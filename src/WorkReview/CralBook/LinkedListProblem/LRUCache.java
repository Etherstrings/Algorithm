package WorkReview.CralBook.LinkedListProblem;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-14
 */
class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache = new LinkedHashMap<>(); // 内置 LRU

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 删除 key，并利用返回值判断 key 是否在 cache 中
        Integer value = cache.remove(key);
        if (value != null) { // key 在 cache 中
            cache.put(key, value);
            return value;
        }
        // key 不在 cache 中
        return -1;
    }

    public void put(int key, int value) {
        // 删除 key，并利用返回值判断 key 是否在 cache 中
        if (cache.remove(key) != null) { // key 在 cache 中
            cache.put(key, value);
            return;
        }
        // key 不在 cache 中，那么就把 key 插入 cache，插入前判断 cache 是否满了
        if (cache.size() == capacity) { // cache 满了
            Integer eldestKey = cache.keySet().iterator().next();
            cache.remove(eldestKey); // 移除最久未使用 key
        }
        cache.put(key, value);
    }
}

