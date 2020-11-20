/*
* Java 枚举(enum)
Java 枚举是一个特殊的类，一般表示一组常量，比如一年的 4 个季节，一个年的 12 个月份，一个星期的 7 天，方向有东南西北等。
Java 枚举类使用 enum 关键字来定义，各个常量使用逗号 , 来分割。
* */
public class EnumDemo {
    EnumDemo() {
        Color c = Color.RED;
        System.out.println(c);;

        // 迭代枚举元素
        for (Color color: Color.values()) {
            // 查看枚举的索引
            System.out.println(color + " at index " + color.ordinal());

            System.out.println(color.colorInfo());
        }
        // 使用 valueOf() 返回枚举常量，不存在的会报错 java.lang.IllegalArgumentException: No enum constant Color.While
        System.out.println(Color.valueOf("RED"));

        // 在switch 中使用枚举
        switch (c) {
            case RED:
                System.out.println("红色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
        }
    }
}

enum Color
{
    RED, GREEN, BLUE;

    String colorInfo() {
        switch (this) {
            case RED:
                return "红色";
            case BLUE:
                return "蓝色";
            case GREEN:
                return "绿色";
        }
        return null;
    }
}

class Color1 {
    public static final Color1 RED = new Color1();
    public static final Color1 GREEM = new Color1();
    public static final Color1 BLUE = new Color1();
}