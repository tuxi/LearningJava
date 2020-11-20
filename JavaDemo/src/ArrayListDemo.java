import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListDemo {

    ArrayListDemo() {
        ArrayList<String> array = new ArrayList<String>();
        array.add("Google");
        array.add("Runoob");
        array.add("Taobao");
        array.add("Weibo");
        System.out.println(array);

//        int[] a1 = {10, 1, 4};
//        int[] a = new int[5];
//        a[0] = 1;
        System.out.println(array.get(1));

        array.set(2, "Wiki");

        // 字母排序
        Collections.sort(array);

        array.remove(3);

        System.out.println(array.size());

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }

        ArrayList<Integer> li = new ArrayList();
        li.add(10);
        li.add(80);
        li.add(50);
        for (int item: li) {
            System.out.println(item);
        }

        // 数字排序
        Collections.sort(li);
        System.out.println(li);

        li.toArray();
    }
}
