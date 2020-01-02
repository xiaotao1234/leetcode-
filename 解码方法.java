//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/decode-ways
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 解码方法 {
    public static void main(String[] args) {
        解码方法 s = new 解码方法();
        System.out.println(s.numDecodings1("26"));
    }

    public int numDecodings(String s) {
        int[] an = new int[s.length()];
        anInt(s, an);
        return an[s.length() - 1];
    }

    public int anInt(String s, int[] an) {
        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 2) {
            if (Integer.parseInt(s) <= 24) {
                return 2;
            } else {
                return 1;
            }
        } else {
            if (an[s.length() - 2] > 0 && an[s.length() - 3] > 0) {
                an[s.length() - 1] = an[s.length() - 2] + 1 + (Integer.parseInt(s.substring(s.length() - 3, s.length() - 2)) <= 24 ? an[s.length() - 3] + 2 : an[s.length() - 3] + 1);
            } else if (an[s.length() - 2] > 0) {
                an[s.length() - 3] = anInt(s.substring(s.length() - 3, s.length() - 1), an);
                an[s.length() - 1] = an[s.length() - 2] + 1 + (Integer.parseInt(s.substring(s.length() - 2, s.length() - 2)) <= 24 ? an[s.length() - 3] + 2 : an[s.length() - 3] + 1);
            } else {
                an[s.length() - 3] = anInt(s.substring(s.length() - 3, s.length() - 1), an);
                an[s.length() - 2] = anInt(s.substring(s.length() - 2, s.length() - 1), an);
                an[s.length() - 1] = an[s.length() - 2] + 1 + (Integer.parseInt(s.substring(s.length() - 3, s.length() - 2)) <= 24 ? an[s.length() - 3] + 2 : an[s.length() - 3] + 1);
            }
        }
        return an[s.length() - 1];
    }

    public int numDecodings1(String s) {
        int[] an = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (Integer.parseInt(s.substring(i, i + 1)) == 0) {
                if (s.length() == 1 || Integer.parseInt(s.substring(i - 1, i)) > 2) {
                    return 0;
                }else if(i>=1){
                    an[i] = an[i - 1];
                }else {
                    an[i] = an[i - 1]+ an[i - 2] * 1;
                }
            }else {
                if (i == 0) {
                    an[i] = 1;
                    continue;
                }
                if (i == 1) {
                    an[i] = and(s.substring(0, 2));
                    continue;
                }
                an[i] = an[i - 1] + an[i - 2] * and(s.substring(i - 1, i + 1));
            }
        }
        return an[s.length() - 1];
    }

    public int and(String a) {
        if (Integer.parseInt(a) > 24) {
            return 1;
        } else {
            return 2;
        }
    }
}
