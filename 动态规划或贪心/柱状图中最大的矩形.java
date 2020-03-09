package 动态规划或贪心;

import java.util.Map;
import java.util.Stack;

public class 柱状图中最大的矩形 {//关键就是依靠栈，然后向栈中压入了序号而不是每个序号矩形的高的，这样这个栈就能够记录更多的相关信息，为解题带来便利
    public static void main(String[] args) {
        柱状图中最大的矩形 s = new 柱状图中最大的矩形();
    }


    public int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {//对每个矩形高度进行出入栈
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])//当当前矩形的高度小于压入栈中的上一个矩形的高度时
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));//以栈中的当前矩形高度为高，栈中的上一个元素下标加上当前元素下标为宽，计算出以当前元素为高的最大矩形
            stack.push(i);//当当前元素比栈顶的元素大的时候，不再进行出栈操作，开始压栈
        }
        while (stack.peek() != -1)//当所有元素压栈完成，但是栈中元素还没出栈完，即还没计算那些以为出栈元素为高最大矩形的面积，则开始进行一一出栈
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));//高为当前元素的高，宽为当前元素的前一个元素的下标到右边界的长度
        // <若其前置有元素的话，若为-1代表没有前置元素为空，但是其依然能取到正确长度>（解释一下，因为其在最终矩形高度完全遍历后也没有出栈
        //说明其右边的所有矩形都高于他，且前置元素下标代表着其前置的下标范围，最终所有元素得以出栈
        return maxarea;
    }

    public int largestRectangleArea1ll(int[] heights) {//入栈条件是将栈内现有的比他小的所有元素弹出后再入栈（因为栈内元素相当于是排好了序的）
        Stack<Integer> stack = new Stack<>();//出栈要依靠后面比他小的元素的入栈来迫使其出栈
        stack.push(-1);//若遍历完后依然有元素为出栈，则手动出栈，宽度为此元素下标到数组元素的尾部
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                max = Math.max(max, heights[stack.peek()] * (i - stack.pop() - 1));
            }
            stack.push(heights[i]);
        }
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));//最终都没弹出说明其后没有比起小的元素，无法将其弹出
        }
        return max;
    }

    public int largestRectangleArea1ll1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] < heights[stack.peek()]) {
                while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                    max = Math.max(max, heights[stack.peek()] * (i - stack.peek() - 1));//这里为i-stack.peek-1的原因是其被当前元素弹出，则其右边界理应是i
                }
                stack.push(heights[i]);
            }
        }
        if(stack.peek()!=-1){
            while (stack.peek()!=-1){
                max = Math.max(max,(heights.length-stack.peek()-1)*heights[stack.pop()]);
            }
        }
        return max;
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
