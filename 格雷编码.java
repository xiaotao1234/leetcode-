import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class 格雷编码 {
    public static void main(String[] args) {
        格雷编码 s = new 格雷编码();
        System.out.println(s.grayCode211(3));
    }

    public List<Integer> grayCode211(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(head + list.get(j));
            }
            head <<= 1;
        }
        return null;
    }

    public List<Integer> grayCode(int n) { //利用树结构解,未完成
        if (n == 0) {
            return null;
        } else {
            Queue<node> queue = new LinkedBlockingQueue<>();
            node root = new node(-1, null, null);
            get(n, root, null, queue, 0);
        }
        return null;
    }

    public List<Integer> grayCode21(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(head + list.get(j));
            }
            head <<= 1;
        }
        return list;
    }

    public void get(int n, node root, node last, Queue<node> queue, int now) {
        if (root != null) {
            node leftnode = new node(0, null, null);
            node rightnode = new node(1, null, null);
            root.leftnode = leftnode;
            root.rightnode = rightnode;
            queue.add(leftnode);
            queue.add(rightnode);
            get(n, root, last, queue, now + 1);
        } else {
            boolean isero = true;
            while (queue.size() != 0) {
                if (isero) {
                    node nodeq = queue.poll();
                    node leftnode = new node(0, null, null);
                    node rightnode = new node(1, null, null);
                    nodeq.leftnode = leftnode;
                    nodeq.rightnode = rightnode;
                } else {
                    node nodeq = queue.poll();
                    node leftnode = new node(1, null, null);
                    node rightnode = new node(0, null, null);
                    nodeq.leftnode = leftnode;
                    nodeq.rightnode = rightnode;
                }
                isero = !isero;
            }
            get(n, root, last, queue, now + 1);
        }
    }

    class node {
        public node(int value, node leftnode, node rightnode) {
            this.value = value;
            this.leftnode = leftnode;
            this.rightnode = rightnode;
        }

        int value;

        public void setLeftnode(node leftnode) {
            this.leftnode = leftnode;
        }

        public void setRightnode(node rightnode) {
            this.rightnode = rightnode;
        }

        node leftnode;
        node rightnode;
    }

    public List<Integer> grayCode1(int n) { //利用树结构解,未完成
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                list.add("0");
                list.add("1");
            } else {
                List<String> list1 = new ArrayList<>();
            }
        }
        return null;
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }
}





















