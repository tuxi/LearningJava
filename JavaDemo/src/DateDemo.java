import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateDemo {

    DateDemo() {
        // 构造函数使用当前日期和时间来初始化对象。
        Date now = new Date();
        // 构造函数接收一个参数，该参数是从1970年1月1日起的毫秒数
        Date date1 = new Date(1129291911);
        // 若当调用此方法的Date对象在指定日期之后返回true,否则返回false。
        boolean isAfter = now.after(date1);
        boolean isBefore = now.before(date1);
        System.out.println(isAfter);
        // 若当调用此方法的Date对象在指定日期之前返回true,否则返回false。
        System.out.println(isBefore);
        // 返回对象的副本
        Date cloneDate = (Date) date1.clone();
        // System.identityHashCode() 获取对象的hashCode 或者通过对象的date1.hashCode()获取
        System.out.println("date1 = " + System.identityHashCode(date1) + ", cloneDate = " + System.identityHashCode(cloneDate));

        // 获取时间的毫秒数，返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
        long time = now.getTime();
        System.out.println("时间戳: " + time);
        System.out.println(now.toString());
    }

    void test() {
        Date date=new Date();
        //b的使用，月份简称
        String str=String.format(Locale.US,"英文月份简称：%tb",date);
        System.out.println(str);
        System.out.printf("本地月份简称：%tb%n",date);
        //B的使用，月份全称
        str=String.format(Locale.US,"英文月份全称：%tB",date);
        System.out.println(str);
        System.out.printf("本地月份全称：%tB%n",date);
        //a的使用，星期简称
        str=String.format(Locale.US,"英文星期的简称：%ta",date);
        System.out.println(str);
        //A的使用，星期全称
        System.out.printf("本地星期的简称：%tA%n",date);
        //C的使用，年前两位
        System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n",date);
        //y的使用，年后两位
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n",date);
        //j的使用，一年的天数
        System.out.printf("一年中的天数（即年的第几天）：%tj%n",date);
        //m的使用，月份
        System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n",date);
        //d的使用，日（二位，不够补零）
        System.out.printf("两位数字的日（不足两位前面补0）：%td%n",date);
        //e的使用，日（一位不补零）
        System.out.printf("月份的日（前面不补0）：%te",date);

        System.out.println("\n" + stringToDate("2020-10-11"));
    }

     Date stringToDate(String strDate) {
        if (strDate.isEmpty()) {
            return null;
        }
        // 使用 SimpleDateFormat 格式化日期
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print(strDate + " Parses as ");

        Date date = null;
        try {
            date = ft.parse(strDate);
        }
        catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
        }
        return date;
    }
}
