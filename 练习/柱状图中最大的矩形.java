package 练习;

import java.util.Stack;

/**
 * Created by Xiao Tao on 2020/2/12 8:22
 */
public class 柱状图中最大的矩形 {
    public static void main(String[] args) {
        柱状图中最大的矩形 s = new 柱状图中最大的矩形();
        System.out.println(s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() > 0 && heights[i] < heights[stack.peek()]) {
                max = Math.max(max, heights[stack.peek()] * (i - stack.pop()));
            }
            stack.push(i);
        }
        return max;
    }
}
