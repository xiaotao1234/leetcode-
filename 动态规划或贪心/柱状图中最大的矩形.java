package 动态规划或贪心;

import java.util.Stack;

public class 柱状图中最大的矩形 {
    public static void main(String[] args) {
        柱状图中最大的矩形 s = new 柱状图中最大的矩形();
    }


    public int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxarea;
    }

    public int largestRectangleArea11(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, (heights[stack.pop()] * (i - stack.peek() - 1)));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return max;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int largestRectangleArea(int[] height) {
        Stack<item> stack = new Stack<>();
        int max = 0;
        stack.push(new item(-1, -1));
        int[] heights = new int[height.length + 1];
        for (int i = 0; i < height.length; i++) {
            heights[i] = height[i];
        }
        heights[height.length] = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > stack.peek().value) {
                stack.push(new item(i, heights[i]));
            } else {
                while (heights[i] < stack.peek().value) {
                    item im = stack.pop();
                    int ll = (i - stack.peek().id - 1) * im.value;
                    max = max > ll ? ll : max;
                }
                stack.push(new item(i, heights[i]));
            }
        }
        return max;
    }

    class item {
        int id;
        int value;

        public item(int id, int value) {
            this.id = id;
            this.value = value;
        }
    }
}
