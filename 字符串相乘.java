public class 字符串相乘 {
    public static void main(String[] args) {
        字符串相乘 s = new 字符串相乘();
        System.out.println(s.multiply11("999", "199"));
    }

    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return String.valueOf(0);
        }
        int[] ints = new int[num1.length() + num2.length()+1];
        int jw = 0;
        for (int i = 0; i < num2.length(); i++) {
            for (int j = 0; j < num1.length(); j++) {
                int tempare = Integer.parseInt(String.valueOf(num2.charAt(num2.length() - 1 - i))) * Integer.parseInt(String.valueOf(num1.charAt(num1.length() - 1 - j)));
                int a = tempare;
                for (int k = i + j; k <= i + j + String.valueOf(tempare).length(); k++) {
                    int ss = a%10 + ints[k] + jw;
                    int sa = ss % 10;
                    jw = ss / 10;
                    ints[k] = sa;
                    a = a / 10;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = ints.length - 1;
        while (ints[i] == 0) {
            i = i - 1;
        }
        for (int j = i; j >= 0; j--) {
            stringBuilder.append(ints[j]);
        }
        return String.valueOf(stringBuilder);
    }

    public String multiply11(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = Integer.parseInt(String.valueOf(num2.charAt(j)));
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;//最多进一位，因此只需要考虑当前及当前高一位的数，即两个低位相加（9+9）也最多进1，下一位相乘最多为81，相加也等于82，不可能进到更高位去。
                res[i + j] += sum / 10;//进位
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }
}
