import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 线程
/*
Java 提供了三种创建线程的方法：
1.通过实现 Runnable 接口
2.通过继承 Thread 类本身
3.通过 Callable 和 Future 创建线程
* */
public class ThreadDemo {
    ThreadDemo()
    {
        // 测试通过Runnable 接口创建线程
        RunnableDemo r1 = new RunnableDemo("Thread-1");
        r1.start();
        RunnableDemo r2 = new RunnableDemo("Thread-2");
        r2.start();

        // 测试通过继承Thread 创建线程
        ThreadTest t1 = new ThreadTest("Thread-3");
        t1.start();
        ThreadTest t2 = new ThreadTest("Thread-4");
        t2.start();

        // 其他测试
        Runnable hello = new DisplayMessage("hello");
        Thread thread1 = new Thread(hello);
        thread1.setName("hello");
        thread1.setDaemon(true);
        System.out.println("Starting hello thread...");
        thread1.start();

        Runnable bye = new DisplayMessage("Goodbye");
        Thread thread2 = new Thread(bye);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.setDaemon(true);
        System.out.println("Starting goodbyte thread...");
        thread2.start();

        System.out.println("Starting thread3...");
        Thread thread3 = new GuessANumber(27);
        thread3.start();

        try
        {
            thread3.join();
        } catch (InterruptedException e)
        {
            System.out.println("Thread interruoted.");
        }

        System.out.println("Starting thread4");
        Thread thread4 = new GuessANumber(75);
        thread4.start();
        System.out.println("ThreadDemo() is ending...");


        CallableThreadTest.test();
    }
}

// 通过实现Runnable 接口创建线程
class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try
        {
            for (int i = 4; i > 0; i--)
            {
                System.out.println("Thread: " + threadName + "，" + i);
                // 让线程休眠一会
                Thread.sleep(50);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Thread " + threadName + " interrupted");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null)
        {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

/*
通过继承Thread来创建线程
创建一个线程的第二种方法是创建一个新的类，该类继承 Thread 类，然后创建一个该类的实例。
继承类必须重写 run() 方法，该方法是新线程的入口点。它也必须调用 start() 方法才能执行。
该方法尽管被列为一种多线程实现方式，但是本质上也是实现了 Runnable 接口的一个实例。
* */
class ThreadTest extends Thread {
    private Thread t;
    private String threadName;

    ThreadTest(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);

        try
        {
            for (int i = 4; i > 0; i--)
            {
                System.out.println("Thread: " + threadName + "，" + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }
        catch (InterruptedException ex)
        {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }
}

class DisplayMessage implements Runnable
{
    private String message;

    DisplayMessage(String message) {
        this.message = message;
    }

    public void run() {
        while (true)
        {
            System.out.println(message);
        }
    }
}

class GuessANumber extends Thread
{
    private int number;
    GuessANumber(int number)
    {
        this.number = number;
    }

    @Override
    public void run() {
        int counter = 0;
        int guess = 0;
        do {
            guess = (int)(Math.random() * 100 + 1);
            System.out.println(this.getName() + " guesses " + guess);
        } while (guess != number);

        System.out.println("** Correct!" + this.getName() + "in" + counter + "guesses.**");
    }
}

//通过 Callable 和 Future 创建线程
/*
1. 创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值。
2. 创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值。
3. 使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程。
4. 调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值。
* */
class CallableThreadTest implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++)
        {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }

    static void test()
    {
        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for (int i = 0; i < 100; i++)
        {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 20)
            {
                new Thread(ft, "有返回值的线程").start();
            }
            try {
                System.out.println("子线程的返回值：" + ft.get());
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } catch (ExecutionException e)
            {
                e.printStackTrace();
            }
        }
    }
}

