package 剑指offer;

/**
 * Created by Xiao Tao on 2020/2/14 8:50
 */
public class 矩阵中路径 {
    public static void main(String[] args) {
        矩阵中路径 s = new 矩阵中路径();
        System.out.println(s.exist(new char[][]{{'a'}},"a"));
    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(chars, 0, visited, i, j, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[] chars, int index, boolean[][] visited, int i, int j, char[][] board) {
        if(index>=chars.length){
            return true;
        }
        if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j] == true) {
            return false;
        }
        if (board[i][j] != chars[index]) {
            return false;
        }
        visited[i][j] = true;
        boolean result =
                dfs(chars, index + 1, visited, i + 1, j, board) ||
                        dfs(chars, index + 1, visited, i - 1, j, board) ||
                        dfs(chars, index + 1, visited, i, j + 1, board) ||
                        dfs(chars, index + 1, visited, i, j - 1, board);
        visited[i][j] = false;
        return result;
    }
}
