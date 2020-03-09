package 面向对象的demo练习;

/**
 * Created by Xiao Tao on 2020/3/7 21:29
 */
public class 上下转型 {
    public static class A {
        public int i = 10;

        void print() {
            System.out.println("我是A中的函数");
        }
    }

    static class B extends A {
        public int i = 20;

        void print() {
            System.out.println("我是B中的函数，我重写了A中的同名函数");
        }

        void speek() {
            System.out.println("向上转型时我会丢失");
        }

        public static void main(String[] args) {
            B b = new B();
            A a = b;//此处向上转型
            b.print();
            System.out.println(b.i);
            b.speek();
            a.print();
            System.out.println(a.i);
            ((B) a).speek();//a在创建时虽然丢失了speek方法但是向下转型又找回了
            System.out.println(((B) a).i);
        }
    }
}
