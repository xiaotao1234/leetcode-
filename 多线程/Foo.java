package 多线程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

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

    //解法一：Synchronized锁和控制变量（这里的控制变量为firstFinished和sendFinished）
    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock) {
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (lock) {
            while (firstFinished == false) {
                lock.wait();
            }
            printSecond.run();
            sendFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        synchronized (lock) {
            while (sendFinished == false) {
                lock.wait();
            }
            printThird.run();
        }
    }

    //解法二：CountDownLatch方式
    //CountDownLatch主要作用是当前线程执行到countDownLatch.await()时，
    // 会去检查当前的countDownLatch中的count是否为0，为0才能继续向下执行，
    // 否者会被阻塞，当其他持有这个countDownLatch的线程调用countDown时，
    // 这个countDownLatch中的count会被减1，当其减少到0时，就会唤醒被当前countDownLatch
    // 阻塞的线程。
    private CountDownLatch countDownLatch1;
    private CountDownLatch countDownLatch2;

    public Foo() {
        countDownLatch1 = new CountDownLatch(1);
        countDownLatch2 = new CountDownLatch(1);
    }

    public void first1(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        countDownLatch1.countDown();
    }

    public void second1(Runnable printSecond) throws InterruptedException {
        countDownLatch1.await();
        printSecond.run();
        countDownLatch2.countDown();
    }


    public void third1(Runnable printThird) throws InterruptedException {
        countDownLatch2.await();
        printThird.run();

    }



    //解法三：Semaphore，相当于一个拥有一定数量的停车场（数量基于定义），semaphore.acquire()相当于请求停车，若请求成功停车，则semphore的内部数量减1，
    //semaphore.release()相当于车辆离开停车场，semaphore的内部数量加一，其会唤醒等待的线程中的一个
    private Semaphore semaphore1,semaphore2;
    public void Foo11(){
        semaphore1 = new Semaphore(0);
        semaphore2 = new Semaphore(0);
    }

    public void  first2(Runnable printfirst){
        printfirst.run();
        semaphore1.release();
    }

    public void sencond2(Runnable printsend) throws InterruptedException {
        semaphore1.acquire();
        printsend.run();
        semaphore2.release();
    }

    public void third2(Runnable thirdsned) throws InterruptedException {
        semaphore2.acquire();
        thirdsned.run();
    }
}






















