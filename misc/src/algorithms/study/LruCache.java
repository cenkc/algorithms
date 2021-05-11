package algorithms.study;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * https://java2blog.com/lru-cache-implementation-java/
 * https://dzone.com/articles/java-based-simple-cache-lru-eviction
 * https://algs4.cs.princeton.edu/13stacks/DoublyLinkedList.java.html
 *
 * created by Cenk Canarslan on 2021-05-02
 */
public class LruCache {

    private int capacity;
    private Map<Integer, Node> nodeMap;
    private Node head;
    private Node tail;

    public LruCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>(capacity);
    }

    public void deleteNode(Node node) {
        if (node == null) {
            return ;
        }
        if (node.prev != null) {
            // node could be somewhere in between head and tail or just the tail (it's next is null)
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void setHead(Node node) {
        if (node == null) {
            return;
        }
        node.next = head;
        node.prev = null;
        if(head!=null)
            head.prev = node;
        head = node;
        if(tail ==null)
            tail = head;
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            // cache accessed so we need to move it to head position.
            // in order to do that, first we need to remove it
            deleteNode(node);
            setHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            // var olan node u sil (remove)
            // value güncelle
            // en başa koy (setHead)
            Node oldNode = nodeMap.get(key);
            deleteNode(oldNode);
            oldNode.value = value;
            setHead(oldNode);
        } else {
            // kapasite dolduysa en sondakini sil
            // en başa koy
            Node newNode = new Node(key, value);
            if (nodeMap.size() >= capacity) {
                // kapasite dolduysa en son elemani (tail) ucur
                // tail node'u sil
                // yeni node u en basa koy
                nodeMap.remove(tail.key);
                deleteNode(tail);
                setHead(newNode);
            } else {
                // kapasite dolmadi daha yer var
                // yeni node u en basa koy
                setHead(newNode);
            }
            // yeni node u map e ekle
            nodeMap.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        LruCache lrucache = new LruCache(4);
        lrucache.put(1, 100);
        lrucache.put(10, 99);
        lrucache.put(15, 98);
        lrucache.put(10, 97);
        lrucache.put(12, 96);
        lrucache.put(18, 95);
        lrucache.put(1, 94);

        System.out.println(lrucache.get(1));
        System.out.println(lrucache.get(10));
        System.out.println(lrucache.get(15));
    }

    private class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                    .add("key=" + key)
                    .add("value=" + value)
                    .toString();
        }
    }
}
