/*
* Java 正则表达式
正则表达式定义了字符串的模式。
正则表达式可以用来搜索、编辑或处理文本。
正则表达式并不仅限于某一种语言，但是在每种语言中有细微的差别。
* */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    RegexDemo() {
        // 使用了正则表达式 .*runoob.* 用于查找字符串中是否包了 runoob 子串：
        String content = "I am noob " +
                "from runoob.com.";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中包含了 'runoob' 子字符串？" + isMatch);

        new RegexMatches();
    }
}

class RegexMatches
{
    RegexMatches() {
        // 捕获组
        //捕获组是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建。

        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";
        // 创建Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 创建Matcher对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));;
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
    }
}