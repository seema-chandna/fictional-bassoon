import javafx.util.Pair;

import java.util.*;

/**
 * @author schandna created on 24/04/20
 */
public class LRUCache {

    static Deque<Integer> dq;
    static Map<Integer, Integer> map;
    static int size;

    public LRUCache(int capacity) {
        dq = new ArrayDeque<>();
        map = new HashMap<Integer, Integer>();
        size = capacity;
    }

    public int get(int key) {
        Integer val = map.get(key);
        if(val != null){
            put(key, val);
        } else {
            val = -1;
        }

        return val;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(dq.size() == size) {
                int last = dq.removeLast();
                map.remove(last);
            }
        } else {
            int i=0, index=0;
            Iterator<Integer> itr = dq.iterator();
            while(itr.hasNext()) {
                if(itr.next() == key) {
//                    index = i;
                    itr.remove();
                    break;
                }
                i++;
            }
//            dq.remove(index);
//            dq.remove(key);
        }
        dq.push(key);
        map.put(key, value);
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static void main(String[] args) {
        case1();
        case2();

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.poll();

        Set<Integer> lh = new LinkedHashSet<>();
        lh.add(1);
        lh.remove(1);

        int[] Rnums = new int [2];

        Queue<Pair<Integer, Integer>> queue = new ArrayDeque();
        int column = 0;
        queue.offer(new Pair(1, column));

//        String ipStr = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
//        String[] ts = ipStr.split(":");
//        System.out.println(ts);
    }

    public static void case1(){

        // ["LRUCache","put","put","get","put","get","put","get","get","get"]
        // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

        // Expected [null,null,null,1,null,-1,null,-1,3,4]

        LRUCache cache= new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println();
        System.out.print(" " + cache.get(1));
        cache.put(3,3);
        System.out.print(" " + cache.get(2));
        cache.put(4,4);
        System.out.print(" " + cache.get(1));
        System.out.print(" " + cache.get(3));
        System.out.print(" " + cache.get(4));



    }

    public static void case2(){

        // ["LRUCache","put","get","put","get","get"]
        //[[1],[2,1],[2],[3,2],[2],[3]]

        // Expected [null,null,1,null,-1,2]

        LRUCache cache= new LRUCache(1);
        cache.put(2,1);
        System.out.println();
        System.out.print(" " + cache.get(2));
        cache.put(3,2);
        System.out.print(" " + cache.get(2));
        System.out.print(" " + cache.get(3));

    }
}

// Approach 1: Ordered dictionary
class LRUCacheOrdered extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCacheOrdered(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

// Approach 2: Hashmap + DoubleLinkedList
class LRUCacheDoubleLinkedList {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        /**
         * Remove an existing node from the linked list.
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node){
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCacheDoubleLinkedList(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if(size > capacity) {
                // pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }
}