import java.util.ArrayList;
import java.util.List;

public class 复原IP地址 {

    public static void main(String[] args) {
        复原IP地址 s = new 复原IP地址();
        System.out.println(s.restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        get(s, new String(), 0);
        return list;
    }

    List<String> list = new ArrayList<>();

    public void get(String s, String l, int num) {
        if (num == 3 && s.length() > 0 && (s.length() <= 3 && Integer.parseInt(s) <= 255) && (Integer.parseInt(String.valueOf(s.charAt(0))) != 0 || s.length() == 1)) {
            list.add(l + s);
        } else if (num < 3) {
            for (int i = 1; i <= 3; i++) {
                if (s.length() >= i) {
                    String tem = s.substring(0, i);
                    if (Integer.parseInt(String.valueOf(tem.charAt(0))) != 0 || tem.length() == 1) {
                        if (Integer.parseInt(tem) <= 255) {
                            get(s.substring(i), l + tem + ".", ++num);
                            num = num - 1;
                        }
                    }
                }
            }
        }
    }
}
