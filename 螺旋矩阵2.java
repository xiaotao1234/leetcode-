public class 螺旋矩阵2 {
    public static void main(String[] args) {
        螺旋矩阵2 s1 = new 螺旋矩阵2();
        System.out.println(s1.generateMatrix(3).toString());
    }

    public int[][] generateMatrix(int n) { //耗时18%
        int[][] list = new int[n][n];
        boolean[][] isin = new boolean[n][n];
        int state = 0;
        int[] hf = {1, 0, -1, 0};
        int[] vf = {0, 1, 0, -1};
        int h = 0;
        int v = 0;
        for (int i = 0; i < n * n; i++) {
            list[v][h] = i + 1;
            isin[v][h] = true;
            if (h + hf[state] < n && h + hf[state] >= 0 && v + vf[state] < n && v + vf[state] >= 0&&!isin[v+vf[state]][h+hf[state]]){
                h = h+hf[state];
                v = v+vf[state];
            }else {
                state = (state + 1) % 4;
                h = h+hf[state];
                v = v+vf[state];
            }
        }
        return list;
    }

    public int[][] generateMatrix1(int n) {//耗时100%
        //先抠出上下左右的边界，然后每次对上下左右进行依次遍历(上下遍历的边界条件就是扣出的边界，左右遍历的边界条件就是抠出的左右边界)，在每次对上下左右遍历后对边界进行迁移，直到完成指定数目的安置，
        //所思所想，这些问题其实想起来很容易想到他的数据排列方式，但是要转化为具体的计算机可理解的方式，就要下一番功夫了，比如上面的方法，依靠定义一个阶段量且阶段在0-3之间循环，且将横竖在每个阶段情况下的变化情况进行一一对应，
        //然后逐步向下推进，
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }

}
