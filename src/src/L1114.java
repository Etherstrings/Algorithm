package src;

/**
 * @author Etherstrings
 * @create 2022-07-31 12:38 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1114 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/31 - the current system date.  12:38 - the current system time.  2022 - the current year.  07 - the current month.  31 - the current day of the month.  12 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L1114 {
    //1114. 按序打印
    //给你一个类：
    //
    //public class Foo {
    //  public void first() { print("first"); }
    //  public void second() { print("second"); }
    //  public void third() { print("third"); }
    //}
    //三个不同的线程 A、B、C 将会共用一个 Foo 实例。
    //
    //线程 A 将会调用 first() 方法
    //线程 B 将会调用 second() 方法
    //线程 C 将会调用 third() 方法
    //请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
    //
    //提示：
    //
    //尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
    //你看到的输入格式主要是为了确保测试的全面性。
    //
    //
    //示例 1：
    //
    //输入：nums = [1,2,3]
    //输出："firstsecondthird"
    //解释：
    //有三个线程会被异步启动。输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。正确的输出是 "firstsecondthird"。
    //示例 2：
    //
    //输入：nums = [1,3,2]
    //输出："firstsecondthird"
    //解释：
    //输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。正确的输出是 "firstsecondthird"。
    private volatile int flag=1;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag=2;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(flag!=2);
        printSecond.run();
        flag=3;
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(flag!=3);
        printThird.run();
    }
}
