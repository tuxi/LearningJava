public class StringDemo {

    StringDemo() {
        // 创建字符串
        String greeing = "我是字符串";
        // 通过字符数组创建字符串
        char[] helloArray = {'r', 'u', 'u', 'o', 'b' };
        String helloString = new String(helloArray);
        // 字符串长度
        System.out.println(helloString + "长度 = " + helloString.length());
        // 连接字符串
        // 通过concat 连接字符串
        String newStr1 = helloString.concat(greeing);
        newStr1 += "hello";

        // 创建格式化字符串printf()
        float floatVar = 10.5f;
        int intVar = 12;
        String stringVar = "I'm str";
        System.out.printf("浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                "is %s", floatVar, intVar, stringVar);
        // 也可以这么写String.format()
        String fs;
        fs = String.format("浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                "is %s", floatVar, intVar, stringVar);
        System.out.println(fs);
    }

    static void testStringBuffer() {
        StringBuffer sBuffer = new StringBuffer("我是：");
        sBuffer.append("杨");
        sBuffer.append("孝");
        sBuffer.append("远");
        System.out.println(sBuffer);

    }
}
