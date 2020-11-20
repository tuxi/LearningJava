/*
* Java 修饰符
Java语言提供了很多修饰符，主要分为以下两类：
访问修饰符
非访问修饰符
* */

import javax.print.attribute.standard.Finishings;

class Speaker {

}

public class AudioPlay {
    protected boolean openSpeaker(Speaker sp) {
        return false;
    }
}

class StreamingAudioPlayer extends AudioPlay {

    private static int numInstances = 0;
    protected static int getCount() {
        return numInstances;
    }

    private static void addInstance() {
        numInstances += 1;
    }

    StreamingAudioPlayer() {
        StreamingAudioPlayer.addInstance();
    }

    // 子类继承，重载
    @Override
    protected boolean openSpeaker(Speaker sp) {
        return super.openSpeaker(sp);
    }
}

// 抽象类
abstract class Caravan {
    private double price;
    private String model;
    private String yeal;
    // 抽象方法
    public abstract void goFast();
    public abstract void changeColor();
}

// 抽象类实现类
class SubClass extends Caravan {

    @Override
    public void goFast() {
        System.out.println("goFast()");
    }

    @Override
    public void changeColor() {
        System.out.println("changeColor()");
    }
}

// 接口
interface Runnable1 {
    void run();
}

// 接口实现类
class MyRunner implements Runnable1 {
    /*
    * volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
    * */
    private volatile boolean active;

    @Override
    public void run() {
        System.out.println("run()");

        active = true;
        while (active)
        {

        }
    }

    public void stop()
    {
        active = false;
    }
}