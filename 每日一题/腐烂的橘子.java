package 每日一题;

/**
 * Created by Xiao Tao on 2020/3/4 8:36
 */
public class 腐烂的橘子 {

    int max = 0;

    //我的错误解法
    //对于这个问题，我遇到的瓶颈在于，我一开始想要进行递归的广度优先搜索（BFS），每次递归内做的事是遍历一次矩阵内的所有元素
    //对于矩阵内的所有元素，当遇到腐烂的橘子2时，就将这个橘子的周围橘子也变为腐烂，但是问题是，这样就改变了其他元素，我们不知道
    //当前的这个腐烂的橘子是上一层已经坏了的还是当前这一层刚刚坏的，若是刚刚坏的，那么同一层就不能继续向下传播
    //所以我又新加了一个c来标准层数及当前层的坏的橘子，在下一层将上一层坏的橘子置为正常腐坏。避免单层递归内的超过一天时间限制的传播
    //但是又很麻烦
    public void get(int[][] grid, int c) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == c) {
                    grid[i][j] = 2;
                }
                if (grid[i][j] == 2) {
                    if (i - 1 > 0) {
                        grid[i - 1][j] = c - 1;
                    }
                    if (i + 1 < grid.length) {
                        grid[i + 1][j] = c - 1;
                    }
                    if (j - 1 > 0) {
                        grid[i][j - 1] = c - 1;
                    }
                    if (j + 1 < grid[0].length) {
                        grid[i][j + 1] = c - 1;
                    }
                }
            }
        }
        max = Math.min(c, max);
    }


    //别人的解法
    //然后根据入口信息，当找到为2的腐烂的橘子后，对这个腐烂的橘子进行dfs搜索
    //每次递归腐烂橘子周围的橘子的腐烂程度都会加一，对被传播的腐烂的橘子置为以2为起点腐烂值每次加一的值，
    // 且对于要传播的下一个橘子，只有当现在传播路径下要被传播的橘子有更小的val时才会去更新这个橘子且将当前橘子继续向下传播来更新在其传播下的其他橘子
    // 这样可以将当前搜索路径上的其他橘子都进行更新
    int grid[][];
    int r;
    int l;

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0)
            return -1;
        this.r = grid.length;
        this.l = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {      //烂橘子开始传染病毒
                    dps(i, j, 2);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;            //有新鲜的橘子
                max = Math.max(grid[i][j], max);  //找到烂的 最久的橘子
            }
        }
        return max - 2;
    }

    public void dps(int i, int j, int val) {
        grid[i][j] = val;           //判断周围是新鲜的橘子或者是烂得更慢的橘子

        if (i > 0 && (grid[i - 1][j] == 1 || grid[i - 1][j] - grid[i][j] > 1)) {
            dps(i - 1, j, 1 + val);
        }
        if (j > 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] - grid[i][j] > 1)) {
            dps(i, j - 1, 1 + val);
        }
        if (i < r - 1 && (grid[i + 1][j] == 1 || grid[i + 1][j] - grid[i][j] > 1)) {
            dps(i + 1, j, 1 + val);
        }
        if (j < l - 1 && (grid[i][j + 1] == 1 || grid[i][j + 1] - grid[i][j] > 1)) {
            dps(i, j + 1, 1 + val);
        }
    }

//    作者：adidas
//    链接：https://leetcode-cn.com/problems/rotting-oranges/solution/java-2ms-100-by-adidas/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
