//一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
//
//骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
//
//有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
//
//为了尽快到达公主，骑士决定每次只向右或向下移动一步。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/dungeon-game
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 地下城游戏 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int all = 0;
        int[][] nowPoint = new int[m][n];
        int[][] lowgestPoint = new int[m][n];
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == 0 && j == 0) {
                        nowPoint[i][j] = dungeon[0][0];
                        lowgestPoint[i][j] = dungeon[0][0];
                    } else if (i == 0) {
                        nowPoint[i][j] = nowPoint[i][j - 1] + dungeon[i][j];
                        lowgestPoint[i][j] = nowPoint[i][j] < lowgestPoint[i][j - 1] ? nowPoint[i][j] : lowgestPoint[i][j - 1];
                    } else if (j == 0) {
                        nowPoint[i][j] = nowPoint[i - 1][j] + dungeon[i][j];
                        lowgestPoint[i][j] = nowPoint[i][j] < lowgestPoint[i - 1][j] ? nowPoint[i][j] : lowgestPoint[i - 1][j];
                    } else {
                        nowPoint[i][j] = nowPoint[i - 1][j] > nowPoint[i][j - 1] ? nowPoint[i - 1][j] : nowPoint[i][j - 1] + dungeon[i][j];
                        int m1 = nowPoint[i][j - 1] + dungeon[i][j] < lowgestPoint[i][j - 1] ? nowPoint[i][j - 1] + dungeon[i][j] : lowgestPoint[i][j - 1];
                        int n1 = nowPoint[i - 1][j] + dungeon[i][j] < lowgestPoint[i - 1][j] ? nowPoint[i - 1][j] + dungeon[i][j] : lowgestPoint[i - 1][j];
                        lowgestPoint[i][j] = m1 > n1 ? m1 : n1;
                        nowPoint[i][j] = m1 > n1 ? nowPoint[i][j - 1] + dungeon[i][j] : nowPoint[i - 1][j] + dungeon[i][j];
                    }
                }
            }
        }
        return nowPoint[n-1][m-1];
    }

    //逆向进行动态规划问题(逆向取数)当正向走不通时
    //若正向走，既要考虑在当前格子的当前血量，又要考虑到达当前格子的这条路径上直至当前的所需的最小血量，
    public int calculateMinimumHP1(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int rowLen = dungeon.length;
        int colLen = dungeon[0].length;
        // 最低的耗血量为 + 1；就是骑士的救公主的最低血量。
        return dfs(0, 0, rowLen, colLen, dungeon) + 1;
    }

    public int dfs(int rowIndex, int colIndex, int rowSize, int colSize, int[][] dungeon) {
        //
        if (rowIndex >= rowSize || colIndex >= colSize) {
            return Integer.MAX_VALUE;
        }
        // 退出条件
        if (rowIndex == rowSize - 1 && colIndex == colSize - 1) {
            if (dungeon[rowIndex][colIndex] >= 0) {
                // 如果最后一个大于等于0，就返还0。
                return 0;
            } else {
                //如果最后一个小于零，就返回负的值。
                return -dungeon[rowIndex][colIndex];
            }
        }
//  右边格子的最优解，也就是最低的耗血量
        int rightMin = dfs(rowIndex, colIndex + 1, rowSize, colSize, dungeon);
//  下边格子的最优解
        int downMin = dfs(rowIndex + 1, colIndex, rowSize, colSize, dungeon);
        // f(i,j) = min(f(i+1, j), f(i, j+1)) - dungeon[i][j]
        int needMin = Math.min(rightMin, downMin) - dungeon[rowIndex][colIndex];
        int res;
        if (needMin < 0) {
            res = 0;
        } else {
            res = needMin;
        }
        System.out.println(rowIndex + " " + colIndex + " " + res);
        return res;
    }

    public int calculateMinimumHP22(int[][] dungeon) {
        //这种至下而上的方法是走不通的，因为动态规划的两个关键步骤：
        //1.状态定义
        //2.状态转移方程
        //这里的至下而上的状态转移方程是无法定义出来的。
        //reason：这里的状态转移方程的形式一般形式是---A[i][j] = (条件选择 A[i-1][j] or A[i][j-1])+B[i][j]
        //这里的关键是这里的(条件选择 A[i-1][j] or A[i][j-1])是无法做出选择，因为我们当前状态有两个，
        // 一个是当前的格子路径上的最小值（因为要满足起点到当前格子处每一处的血量都要为正），
        // 另外一个是当前格子的现有值，这个值是所有格子值的和，
        //这两个条件都会对当前的格子的选择造成影响，前者会影响当前的最小值，
        // 后者会影响当前值（虽然最终的结果是依靠最小值来求的，但是当前值对后面的最小值运算会造成影响，
        // 而这个影响对最小值得改变在从下至上的方式中是不能预估的，比如一个格子(i,j-1)最小值为-3，当前值为5，另外一个格子(i-1,j)最小值为-5，当前值为20，
        // 对于格子（i，j）就无法在这种情况下做出路径选择）
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] nowPoint = new int[m][n];
        int[][] lowgestPoint = new int[m][n];
        if (m == 1 && n == 1) {
            if (dungeon[0][0] > 0) {
                return 1;
            } else {
                return 1 - dungeon[0][0];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    nowPoint[i][j] = dungeon[0][0];
                    lowgestPoint[i][j] = dungeon[0][0];
                } else if (i == 0) {
                    nowPoint[i][j] = nowPoint[i][j - 1] + dungeon[i][j];
                    lowgestPoint[i][j] = nowPoint[i][j] < lowgestPoint[i][j - 1] ? nowPoint[i][j] : lowgestPoint[i][j - 1];
                } else if (j == 0) {
                    nowPoint[i][j] = nowPoint[i - 1][j] + dungeon[i][j];
                    lowgestPoint[i][j] = nowPoint[i][j] < lowgestPoint[i - 1][j] ? nowPoint[i][j] : lowgestPoint[i - 1][j];
                } else {
                    int m1 = nowPoint[i][j - 1] + dungeon[i][j] < lowgestPoint[i][j - 1] ? nowPoint[i][j - 1] + dungeon[i][j] : lowgestPoint[i][j - 1];
                    int n1 = nowPoint[i - 1][j] + dungeon[i][j] < lowgestPoint[i - 1][j] ? nowPoint[i - 1][j] + dungeon[i][j] : lowgestPoint[i - 1][j];
                    lowgestPoint[i][j] = m1 > n1 ? m1 : n1;
                    nowPoint[i][j] = m1 > n1 ? nowPoint[i][j - 1] + dungeon[i][j] : nowPoint[i - 1][j] + dungeon[i][j];
                }
            }
        }
        if (lowgestPoint[m - 1][n - 1] > 0) {
            return 1;
        } else {
            return 1 - lowgestPoint[m - 1][n - 1];
        }
    }

    public int calculateMinimumHP111(int[][] dungeon) {
        int low;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] nowPoint = new int[m][n]; //为要到达i，j这个格子的进入值
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    if (dungeon[m - 1][n - 1] >= 0) {
                        nowPoint[i][j] = 1;
                    } else {
                        nowPoint[i][j] = 1 - dungeon[m - 1][n - 1];
                    }
                    System.out.println("Point[" + i + "][" + j + "]="+nowPoint[i][j]);
                    continue;
                }
                if (i + 1 < m) {
                    if (dungeon[i][j] >= 0 && 1 + dungeon[i][j] >= nowPoint[i + 1][j]) {
                        nowPoint[i][j] = 1;
                    } else {
                        nowPoint[i][j] = nowPoint[i + 1][j] - dungeon[i][j];
                    }
                }
                if (j + 1 < n) {
                    int value;
                    if (dungeon[i][j] >= 0 && 1 + dungeon[i][j] >= nowPoint[i][j + 1]) {
                        value = 1;
                    } else {
                        value = nowPoint[i][j + 1] - dungeon[i][j];
                    }
//                    if (i + 1 >= m && (nowPoint[i][j] == 0 || nowPoint[i][j] > value)) {
//                        nowPoint[i][j] = value;
//                    }

                    if (i + 1 < m && value > nowPoint[i][j]) ;
                    else {
                        nowPoint[i][j] = value;//找r,c格子的最小进入值
                    }
                }
                System.out.println("Point[" + i + "][" + j + "]="+nowPoint[i][j]);
            }
        }
        return nowPoint[0][0];
    }


    public int calculateMinimumHP2(int[][] dungeon) {
        //地下城游戏解法
        //dp动规,dp[i][j]表示骑士从索引坐标（i,j）到地下城右下角的索引坐标所需要的最小初始能量
        //对此二维矩阵，自上而下的动规是不行的，因为如果进行自上而下的动规，就会牵涉到当前最优解与当前拥有利益值，无法动规下去
        //联想到记忆化回朔解法，从而想到对于二维矩阵，记忆化回朔可以改写成自下而上的动态规划
        int row = dungeon.length, col = dungeon[0].length;
        int[][] dp = new int[row][col];
        for (int r = row - 1; r > -1; r--)
            for (int c = col - 1; c > -1; c--) {
                if (r == row - 1 && c == col - 1) {
                    dp[row - 1][col - 1] = dungeon[row - 1][col - 1] < 0 ? 1 - dungeon[row - 1][col - 1] : 1;
                    continue;
                }
                if (r + 1 < row) {//在右边缘以左，横向
                    if (dungeon[r][c] >= 0) {//r，c格子的值大于0
                        if (1 + dungeon[r][c] >= dp[r + 1][c]) {//无需r，c格子的补足，其基本条件就能满足进入r+1,c格子的进入值，只要格子r,c的最小进入值和格子本身的值相加为累积值大于进入下一个格子的初始值，那么这个格子可以达到下一个格子
                            dp[r][c] = 1;  //格子r，c的初始值可以为最小值1（骑士必须存活的前提条件下）就能满足条件
                        } else {
                            dp[r][c] = dp[r + 1][c] - dungeon[r][c];//要r，c格子的进入值来补足，使其达到r+1,c的进入值
                        }
                    } else {//r，c格子的值小于0
                        dp[r][c] = dp[r + 1][c] - dungeon[r][c];//因为r,c格子的值小于零，那么要达到r+1，c的进入值，就需要r,c的进入值来进行补足r，c格子的值的减少量
                    }
                }//分别对应，若当前格子加1000，加5，减-3；而下一个格子进入值为+10的情况，那么就需要当前格子的最小进入值为1，5，13
                if (c + 1 < col) {//在下边缘以上，竖向
                    int value;//r,c格子的进入值
                    if (dungeon[r][c] >= 0) {//
                        if (1 + dungeon[r][c] >= dp[r][c + 1]) {
                            value = 1; //满足最低条件即可
                        } else {
                            value = dp[r][c + 1] - dungeon[r][c]; //需要进行补足
                        }
                    } else {
                        value = dp[r][c + 1] - dungeon[r][c];//需要进行补足
                    }
                    if (r + 1 < row && value > dp[r][c]) ;
                    else {
                        dp[r][c] = value;//找r,c格子的最小进入值
                    }
                    System.out.println("nowPoint[" + r + "][" + c + "]:" + value + "\n");
                }
            }
        return dp[0][0];
    }

    public int calculateMinimumHP11(int[][] dungeon) {
        int cro = dungeon[0].length;//h
        int cla = dungeon.length;//v
        int[][] Point = new int[cla][cro];
        for (int i = cla - 1; i >= 0; i--) {
            for (int j = cro - 1; j >= 0; j--) {
                if (i == cla - 1 && j == cro - 1) {
                    if (dungeon[i][j] > 0) {
                        Point[i][j] = 1;
                    } else {
                        Point[i][j] = 1 - dungeon[i][j];
                    }
                    System.out.println("Point[" + i + "][" + j + "]="+Point[i][j]);
                    continue;
                }
                if (i < cla - 1) {
                    if (dungeon[i][j] >= 0) {
                        if (1 + dungeon[i][j] >= Point[i + 1][j]) {
                            Point[i][j] = 1;
                        } else {
                            Point[i][j] = Point[i + 1][j] - dungeon[i][j];
                        }
                    } else {
                        Point[i][j] = Point[i + 1][j] - dungeon[i][j];
                    }
                }

                if (j + 1 < cro) {
                    int value;
                    if (dungeon[i][j] >= 0) {
                        if (1 + dungeon[i][j] > Point[i][j + 1]) {
                            value = 1;
                        } else {
                            value = Point[i][j + 1] - dungeon[i][j];
                        }
                    } else {
                        value = Point[i][j + 1] - dungeon[i][j];
                    }
                    if (value > Point[i][j] && i + 1 < cla) {
                    } else {
                        Point[i][j] = value;
                    }
                }
                System.out.println("Point[" + i + "][" + j + "]="+Point[i][j]);
            }
        }
        return Point[0][0];
    }

}
