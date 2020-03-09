package 设计;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Xiao Tao on 2020/2/12 20:23
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache s1 = new LRUCache(2);
        s1.put(2, 6);
        s1.get(1);
        s1.put(1, 5);
        s1.put(1, 2);
        s1.get(1);
        s1.get(2);
        System.out.println();
    }

    LinkedHashMap<Integer, Integer> map;
    int length;
    int nowLength;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, (float) 0.75, true);
        length = capacity;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (nowLength >= length && map.get(key) == null) {
            map.remove(map.entrySet().iterator().next().getKey());
        } else if (nowLength >= length) {
            nowLength++;
        }
        map.put(key, value);
    }


    class item {//手写双链表节点类
        public int value, key;
        public item pre;
        public item after;

        public item(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    class DoubleList {//双链表类
        private item head, tail;
        private int size;

        public DoubleList() {
            head = new item(0, 0);
            tail = new item(0, 0);
            head.after = tail;
            tail.pre = head;
        }

        public void addFirst(item node) {//在链表头部添加节点
            tail.pre = node;
            node.after = tail;
            head.after = node;
            node.pre = head;
            size++;
        }

        public void deleteNode(item node)//删除链表中的节点（此节点在链表中一定存在）
        {
            node.after.pre = node.pre;
            node.pre.after = node.after;
            size--;
        }

        public item deleteLast() {//删除链表中的最后一个节点并返回被删除节点
            if (tail.pre == head) {
                return null;
            }
            deleteNode(tail.pre);
            item u = tail.pre;
            size--;
            return u;
        }
    }

}
