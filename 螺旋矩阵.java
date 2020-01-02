import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//https://leetcode-cn.com/problems/spiral-matrix/
public class 螺旋矩阵 {
    public static void main(String[] args) {
        螺旋矩阵 s1 = new 螺旋矩阵();
        System.out.println(s1);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        //关键是通过dc，dr两个数组来对横向和竖向两个方向的数据增长情况进行定义，
        //然后再每次横向或者竖向向前时，进行是否到达该方向边界的判断，
        //dc，dr两个数组的作用是将横向和竖向的发展情况和当前状态编号di做关联，即减少了变化，即现在的变化只和当前的状态号有关系，和其他的状态量都没关系。
        //每次到达边界时，就去计算取出当前得状态号，然后根据状态号去取得横向和竖向得变化量，下次得横竖坐标就根据两个方向得基础量加变化量得到
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int R = matrix.length;
        int C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dc = {1, 0, -1, 0};
        int[] dr = {0, 1, 0, -1};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            list.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (cr < R && 0 <= cr && cc >= 0 && C > cc && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return list;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int h = matrix[0].length;
        int v = matrix.length;
        boolean[][] record = new boolean[v][h];
        int rh = 0, rv = 0, di = 0;
        int[] hdi = {1, 0, -1, 0};
        int[] vdi = {0, 1, 0, -1};
        for (int i = 0; i < h * v; i++) {
            list.add(matrix[rv][rh]);
            record[rv][rh] = true;
            if (rh + hdi[di] < h && rv + vdi[di] < v && rh + hdi[di] >= 0 && rv + vdi[di] >= 0 && record[rv + vdi[di]][rh + hdi[di]] == false) {
                rv = rv + vdi[di];
                rh = rh + hdi[di];
            }else {
                di = (di+1)%4;
                rh = rh+hdi[di];
                rv = rv+vdi[di];
            }
        }
        return list;
    }
}
