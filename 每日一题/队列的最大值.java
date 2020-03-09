package 每日一题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Xiao Tao on 2020/3/7 12:30
 */
public class 队列的最大值 {

    public static void main(String[] args) {
        队列的最大值 s1 = new 队列的最大值();
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(6);
        maxQueue.push_back(1);
        maxQueue.push_back(4);
        maxQueue.push_back(5);
        maxQueue.push_back(3);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }

    static class MaxQueue {

        Deque<Integer> queue;
        Deque<Integer> help;

        public MaxQueue() {
            queue = new LinkedList<>();//向上转型，即父类指向子类，子类被强转为父类型
            help = new LinkedList<>();
            LinkedList<Integer> linkedList = (LinkedList<Integer>) queue;//向下转型，即子类指向父类，父类被强转为子类型
        }

        public int max_value() {
            if (help.size() != 0) {
                return help.peek();
            }
            return -1;
        }

        public void push_back(int value) {
            queue.offer(value);
            while (help.size() != 0 && help.peekLast() < value) {
                help.pollLast();
            }
            help.offer(value);
        }

        public int pop_front() {
            if (queue.size() == 0) {
                return -1;
            }
            int value = queue.pollFirst();
            if (value == help.peekFirst()) {
                help.pollFirst();
            }
            return value;
        }
    }
}
