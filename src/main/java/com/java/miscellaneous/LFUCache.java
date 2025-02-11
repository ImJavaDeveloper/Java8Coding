package com.java.miscellaneous;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final Map<K, Integer> keyFreq;
    private final PriorityQueue<K> minHeap;

    LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.keyFreq = new HashMap<>();
        this.minHeap = new PriorityQueue<>((k1, k2) -> keyFreq.get(k1) - keyFreq.get(k2));
    }

    public static void main(String[] args) {

        LFUCache<Integer, Integer> lfuCache = new LFUCache<>(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));

    }

    public V get(K key) {
        if (!cache.containsKey(key))
            return null;
        //updating the frequency of the key
        keyFreq.put(key, keyFreq.get(key) + 1);
        //removing the key from the minHeap
        minHeap.remove(key);
        minHeap.add(key);
        return cache.get(key);

    }

    public void put(K key, V value) {

        if (capacity == 0) {
        }
        if (cache.size() > capacity) {
            //Evict the least frequently used key
            K leastFreqKey = minHeap.poll();
            cache.remove(leastFreqKey);
            keyFreq.remove(leastFreqKey);

        }
        cache.put(key, value);
        keyFreq.put(key, keyFreq.getOrDefault(key, 0) + 1);
        minHeap.add(key);

    }

}
