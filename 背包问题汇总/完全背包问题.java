package 背包问题汇总;

/**
 * Created by Xiao Tao on 2020/2/14 13:23
 * 有N种物品和一个容量为V的背包，每种物品都有无限件可用。第i种物品的费用是w[i]，价值是val[i]。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 */
public class 完全背包问题 {
    public static void main(String[] args) {
        完全背包问题 s = new 完全背包问题();
        System.out.println(s.dpmethod(new int[]{2, 4}, 10, new int[]{3, 5}));
    }

    public int dpmethod(int[] weigth, int capital, int[] value) {
        int[] dp = new int[capital];
        for (int i = 0; i < weigth.length; i++) {
            for (int j = 0; j < capital; j++) {
                if (weigth[j] < i) {
                    dp[i] = Math.max(dp[i - weigth[j]] + value[j], dp[1]);
                }
            }
        }
        return dp[weigth.length - 1];
    }
}
