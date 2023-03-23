package Algorithms.DataStructure.HashTable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Objects;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 11 23:47
 * <p>
 * 散列表（哈希表）
 */
public class HashTable<K, V> {

    // 哈希表数组
    private Node<K, V>[] hashTable;

    private int size = 0;

    // 初始数组的大小为 16
    private final int HASHTABLE_INITIAL_LENGTH = 1 << 4;

    // 节点
    private static class Node<K, V> {
        int hash;   // 哈希值
        K key; // 键值
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return key + " -> " + value;
        }
    }

    // 创建哈希表
    public HashTable() {
        size = HASHTABLE_INITIAL_LENGTH;
        hashTable = (Node<K, V>[]) new Node[HASHTABLE_INITIAL_LENGTH];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 获取哈希值
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public V add(K key, V value) {
        return add(key, value, false);
    }

    // 添加节点
    private V add(K key, V value, boolean onlyIfAbsent) {    // onlyIfAbsent 为 true 时, 不覆盖相同的 key
        int hash = hash(key);
        int length = hashTable.length;
        int index;
        Node<K, V> n;
        // 当 hash 值指向的索引处没有节点, length - 1 & hash 与 hash % (length - 1) 相同
        if ((n = hashTable[index = (length - 1 & hash)]) == null) {
            hashTable[index] = new Node<>(hash, key, value, null);
        } else {
            Node<K, V> e;
            K k;
            // 如果数组该索引位置的节点与新加的节点的 key 相同
            if (n.hash == hash && ((k = n.key) == key || (key != null && key.equals(k)))) {
                e = n;
            } else {
                // 若数组该索引处的链表有节点的 key 与新加的 key 相同
                while ((e = n.next) != null) {
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        break;
                    }
                    n = e;  // 相当于 node = node.next, 但这里是直接对 next 进行操作
                }
                // 没有就创建新节点
                n.next = new Node<>(hash, key, value, null);
            }
            // 当 e 不为空时说明有节点的 key 与新加的 key 相同
            if (e != null) {
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null) {
                    e.value = value;
                }
                return oldValue;
            }
            size++;
        }
        return null;
    }

    // 查找节点
    public Node<K, V> getNode(K key) {
        if (key == null || isEmpty()) return null;
        int index = hash(key) % hashTable.length;
        Node<K, V> node = hashTable[index];
        while (node != null) {
            if (node.key == key) return node;
            node = node.next;
        }
        return null;
    }

    // 查找值
    public V getValue(K key) {
        if (key == null || isEmpty()) return null;
        int index = hash(key) % hashTable.length;
        Node<K, V> node = hashTable[index];
        while (node != null) {
            if (node.key == key) return node.value;
            node = node.next;
        }
        return null;
    }

    // 删除节点
    private Node<K, V> remove(K key) {
        if (key == null || isEmpty()) return null;
        int hash = hash(key), length = hashTable.length, index;
        Node<K, V> n;
        if ((n = hashTable[(index = (length - 1) & hash)]) != null) {
            Node<K, V> e = null;
            K k;
            if (n.hash == hash && ((k = n.key) == key || key.equals(k))) {
                e = n;
            } else {
                Node<K, V> node;
                while ((node = n.next) != null) {
                    if (node.hash == hash && ((k = node.key) == key || key.equals(k))) {
                        e = node;
                        break;
                    }
                    n = node;
                }
            }
            if (e != null) {
                if (e == n) {
                    hashTable[index] = e.next;
                } else {
                    n.next = e.next;
                }
                size--;
                return e;
            }
        }
        return null;
    }

    // 输出哈希表
    public void list() {
        if (isEmpty()) return;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < hashTable.length; i++) {
            Node<K, V> node = hashTable[i];
            stringBuilder.append("hashTable[" + i + "] ~ [");
            while (node != null) {
                stringBuilder.append(node.key).append(" : ").append(node.value);
                if (node.next != null) {
                    stringBuilder.append(" -> ");
                }
                node = node.next;
            }
            stringBuilder.append("]\n");
        }
        System.out.println(stringBuilder);
    }


    public static void main(String[] args) {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.add("孙庆洋", "男");
        hashTable.add("李志", "男");
        hashTable.add("李伟建", "男");
        hashTable.add("朱佳军", "男");
        hashTable.add("王志凯", "男");
        hashTable.add("陈志文", "男");
        hashTable.add("胡佳豪", "男");
        hashTable.add("刘道伟", "男");
        hashTable.add("江子永", "男");
        hashTable.add("李诗明", "男");
        hashTable.add("孔祥鸿", "男");


        System.out.println();
    }
}
