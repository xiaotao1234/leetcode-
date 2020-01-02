import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 单词搜索 {
    public static void main(String[] args) {
        单词搜索 s = new 单词搜索();
        System.out.println(s.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE"));
    }

    Map<Character, List<lat>> map = new HashMap<>();

    public boolean exist(char[][] board, String word) {
        int num = word.length();
        int m = board.length;//行
        int n = board[0].length;//列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map.get(board[i][j]) != null) {
                    map.get(board[i][j]).add(new lat(i, j));
                } else {
                    List<lat> ls = new ArrayList<>();
                    ls.add(new lat(i, j));
                    map.put(board[i][j], ls);
                }
            }
        }
        return get(map, word, false, 0, 0, new ArrayList<>(),0,num);
    }

    public boolean get(Map map, String word, boolean findead, int x, int y, List<lat> lisRecord,int have,int num) {
        if (have == num) {
            return true;
        }
        char s = word.charAt(0);
        List<lat> list = (List) map.get(s);
        for (lat l : list) {
            if (findead == false) {
                System.out.println("||||"+l.x+"|"+l.y);
                lisRecord.add(l);
                get(map, word.substring(1), true, l.x, l.y, lisRecord,have+1,num);
            } else {
                if ((((l.x == x + 1 || l.x == x - 1) && l.y == y) || ((l.y == y + 1 || l.y == y - 1) && l.x == x)) && !lisRecord.contains(l)) {
                    System.out.println(l.x+"|"+l.y);
                    lisRecord.add(l);
                    get(map, word.substring(1), true, l.x, l.y, lisRecord,have+1,num);
                    lisRecord.remove(l);
                }
            }
          }
        return false;
    }

    class lat {
        int x;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        int y;

        public lat(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof lat) {
                if (((lat) obj).getX() == x && ((lat) obj).getY() == y) {
                    return true;
                }
            }
            return false;
        }
    }
}
