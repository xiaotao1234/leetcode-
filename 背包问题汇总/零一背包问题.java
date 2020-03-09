package 背包问题汇总;

/**
 * Created by Xiao Tao on 2020/2/5 8:41
 */
public class 零一背包问题 {
    public static void main(String[] args) {
        零一背包问题 s = new 零一背包问题();
        System.out.println(s.dpmethod1(new int[]{2, 4, 1, 3, 5, 3}, 10, new int[]{3, 5, 2, 6, 7, 10}));
    }

    public int dpmethod1(int[] weigth, int capital, int[] value) {//01背包问题的解的遍历过程是这样的
        //首先对第一个元素是否放入容量为0-capital的背包进行遍历，遍历的决策关键是取元素在当前情况下放入和不放入背包两种情况下的最大值，
        //容量表：2,4,1,3,5,6
        //价值表：3,5,2,6,7,10
        //背包总容量：10
        //第一个元素
        //for(背包容量)
        //若元素要占用的容量不大于背包的容量，则进行Math.max(dp[i - 1][j], dp[i - 1][j - weigth[i-1]] + value[i-1])
        //否则不能放入背包
        //具体过程，如第二个元素放入时（第二个元素的容量为4），然后对背包容量进行1-10遍历，
        //当容量小于4时，由于当前的背包容量不足以放下这个元素，不放入元素，当容量大于4时，判断放入当前元素和不放入当前元素的情况下背包能放入的最大价值。
        //如当前为6（目前已对第一个元素的各个背包容量进行了判断），放入当前元素则取背包容量为2时，其最大值为3，即最大价值为8，不放入时为3，取两者最大，最终为8，
        int[][] dp = new int[weigth.length][capital+1];
        for (int i = 0; i < weigth.length; i++) {
            for (int j = 1; j <= capital; j++) {
                if(i==0){
                    if(j>weigth[i]){
                        dp[i][j] = value[i];
                    }
                }else {
                    if (j - weigth[i] >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j - weigth[i]] + value[i], dp[i - 1][j]);
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[weigth.length-1][capital];
    }

    public int dpmethod(int[] weigth, int capital, int[] value) {
        int[][] dp = new int[weigth.length + 1][capital + 1];
        for (int i = 1; i <= weigth.length; i++) {
            for (int j = 1; j <= capital; j++) {
                if (i == 1) {
                    if (j > weigth[i]) {
                        dp[i][j] = value[i];
                    }
                } else {
                    if (j > weigth[i - 1])
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weigth[i - 1]] + value[i - 1]);
                    else
                        dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weigth.length][capital];
    }
}
