import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LinkedListDemo {

    LinkedListDemo() {
        LinkedList<String> sites = new LinkedList<>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");

        System.out.println(sites);

        // 使用addFirst在头部添加元素
        sites.addFirst("Wiki");
        System.out.println(sites);

        // 使用removeFirst() 移除头部元素
        sites.removeFirst();
        sites.removeLast();

        System.out.println(sites);
        System.out.println(sites.getFirst());

        for (int size = sites.size(), i = 0; i < size; i++) {
            System.out.println(sites.get(i));
        }

        for (String item: sites) {
            System.out.println(item);
        }

        new HashSetDemo();
        new HashMapDemo();
    }
}
/*
HashSet 基于 HashMap 来实现的，是一个不允许有重复元素的集合。
HashSet 允许有 null 值。
HashSet 是无序的，即不会记录插入的顺序。
HashSet 不是线程安全的， 如果多个线程尝试同时修改 HashSet，则最终结果是不确定的。 您必须在多线程访问时显式同步对 HashSet 的并发访问。
HashSet 实现了 Set 接口。
* */
class HashSetDemo {
    HashSetDemo() {
        HashSet<String> sites = new HashSet<>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        // 重复的元素不会被添加
        sites.add("Runoob");
        System.out.println(sites.contains("Taobao"));
        System.out.println(sites);

        // 删除元素，删除成功返回 true，否则为 false
        sites.remove("Runoob");
        System.out.println(sites);

        for (String item: sites) {
            System.out.println(item);
        }

        sites.clear();
        System.out.println(sites);
    }
}

/*
HashMap 是一个散列表，它存储的内容是键值对(key-value)映射。
HashMap 实现了 Map 接口，根据键的 HashCode 值存储数据，具有很快的访问速度，最多允许一条记录的键为 null，不支持线程同步。
HashMap 是无序的，即不会记录插入的顺序。
HashMap 继承于AbstractMap，实现了 Map、Cloneable、java.io.Serializable 接口。
* */
class HashMapDemo {
    HashMapDemo() {
        HashMap<Integer, String> sites = new HashMap<Integer, String>();
        // 添加键值对
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");
        sites.put(4, "Zhihu");

        System.out.println(sites);

        // 根据key取值
        System.out.println(sites.get(2));

        // 根据key删除元素
        sites.remove(4);

        for (Integer key : sites.keySet()) {
            System.out.println("key: " + key + " value: " + sites.get(key));
        }

        sites.clear();
        sites.put(5, "enba.com");
        System.out.println(sites);
    }
}