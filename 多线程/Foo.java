package 多线程;
//我们提供了一个类：
//
//public class Foo {
//  public void one() { print("one"); }
//  public void two() { print("two"); }
//  public void three() { print("three"); }
//}
//三个不同的线程将会共用一个 Foo 实例。
//
//线程 A 将会调用 one() 方法
//线程 B 将会调用 two() 方法
//线程 C 将会调用 three() 方法
//请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/print-in-order
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Foo {

    private boolean firstFinished;
    private boolean sendFinished;
    private Object lock = new Object();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (lock){
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (lock){
            while (firstFinished==false){
                lock.wait();
            }
            printSecond.run();
            sendFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (lock){
            while (sendFinished==false){
                lock.wait();
            }
            printThird.run();
        }
    }
}
