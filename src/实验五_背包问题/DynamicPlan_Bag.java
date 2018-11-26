package 实验五_背包问题;

import java.util.Scanner;

public class DynamicPlan_Bag {

    public static int[] bag(int N, int V, int[] c, int[] w){
        //初始化dp数组边缘数据
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < V + 1; i++) {
            dp[0][i] = 0;
        }

        //动态规划过程
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (c[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + w[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        //打印列表
//        for (int i = 0; i < N + 1; i++) {
//            for (int j = 0; j < V + 1; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println(dp[N][V]);
//
        //倒序打印编号
        int[] x = new int[N + 1];
        for (int i = N; i > 0; i--) {
            if (dp[i - 1][V] == dp[i][V]) {
                x[i] = 0;
            } else {
                x[i] = 1;
                //System.out.println(i);
                V -= c[i];
            }
        }

        return x;
    }

    public static void main(String[] args) {
        //输入
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();//物品数
//        int V = sc.nextInt();//背包容量
//        int[] c = new int[N + 1];//单件物品容量
//        for (int i = 1; i < N + 1; i++) {
//            c[i] = sc.nextInt();
//        }
//        int[] w = new int[N + 1];//单件物品价值
//        for (int i = 1; i < N + 1; i++) {
//            w[i] = sc.nextInt();
//        }

        int number = 4;
        int weight = 5;
        int[] w = new int[]{0,2,1,3,2};
        int[] v = new int[]{0,12,10,20,15};
        bag(number, weight, w, v);


    }
}

////完全背包：
//
//        for(int i=1;i<N+1;i++){
//        for(int j=c[i];j<V+1;j++){
//        if(c[i]<j){
//        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-c[i]]+w[i]);
//        }else{
//        dp[i][j]=dp[i-1][j];
//        }
//        }
//
//        }
//
////        多重背包：
//
//        for(int i=1;i<N+1;i++){
//        for(int j=1;j<V+1;j++){
//        for(int k=0;k<=num[i];k++){
//        if(c[i]<j){
//        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-k*c[i]]+k*w[i]);
//        }else{
//        dp[i][j]=dp[i-1][j];
//        }
//        }
//        }

