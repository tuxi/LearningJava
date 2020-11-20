/*
* 所有的包装类（Integer、Long、Byte、Double、Float、Short）都是抽象类 Number 的子类。
包装类	基本数据类型
Boolean	boolean
Byte	byte
Short	short
Integer	int
Long	long
Character	char
Float	float
Double	double
* */


public class NumberDemo {

    private int num;
    public NumberDemo(int num) {
        this.num = num;
    }

    static void test1() {
        int a = 5000;
        float b = 13.65f;
        byte c = 0x4a;
    }

    static void test2() {
        Integer x = 5;
        x = x + 10;
        System.out.println(x);
    }

    private static void test(double num) {
        System.out.println("Math.floor(" + num + ")=" + Math.floor(num));
        System.out.println("Math.round(" + num + ")=" + Math.round(num));
        System.out.println("Math.ceil(" + num + ")=" + Math.ceil(num));
    }

    static void testMath() {
        /*
        * Java 的 Math 包含了用于执行基本数学运算的属性和方法，如初等指数、对数、平方根和三角函数。
        * Math 的方法都被定义为 static 形式，通过 Math 类可以在主函数中直接调用
        * */
        System.out.println("90 度的正弦值：" + Math.sin(Math.PI/2));
        System.out.println("0度的余弦值：" + Math.cos(0));
        System.out.println("60度的正切值：" + Math.tan(Math.PI/3));
        System.out.println("1的反正切值： " + Math.atan(1));
        System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI/2));
        System.out.println(Math.PI);

        double[] nums = { 1.4, 1.5, 1.6, -1.4, - 1.5, - 1.6 };
        for (double num: nums) {
            test(num);
        }
    }


}
