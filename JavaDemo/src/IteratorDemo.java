// Java Iterator 迭代器

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {
    IteratorDemo() {
        ArrayList sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("enba.com");
        sites.add("Twitter");

        // 获取迭代器
        Iterator<String> it = sites.iterator();
        // 输出集合中的第一个元素
        System.out.println(it.next());

        // 输出集合中所有元素
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(10);
        numbers.add(11);
        numbers.add(8);
        numbers.add(5);
        System.out.println(numbers);
        Iterator<Integer> it1 = numbers.iterator();
        while (it1.hasNext()) {
            Integer i = it1.next();
            // 删除小于10的元素
            if (i < 10) {
                it1.remove();
            }
        }
        System.out.println(numbers);
    }
}
