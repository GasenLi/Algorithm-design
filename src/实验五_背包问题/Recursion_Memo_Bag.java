package 实验五_背包问题;

public class Recursion_Memo_Bag {

    int N = 4; //物品数量
    int C = 7; //背包容量
    int[] w = {2, 3, 5, 2};
    int[] v= {6, 4, 8, 4};
    int[][] m = new int[N][C+1]; //记录子问题的解的表格
    int x[] = new int[N];

    public void initial() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= C; j++) {
                m[i][j] = -1;
            }
        }
    }

    //以下使用备忘录法求解0-1背包问题（物品重量为整型）
    public int KnapsackMemoMethod(int i, int capacity) {
        if (m[i][capacity] != -1)
            return m[i][capacity]; //使用m[i][capacity]需要检查两个下标是否出界
        int result = 0;
        if (i == N - 1)
            if (capacity >= w[i]) {
                m[i][capacity] = v[i];
                return v[i];
            } else {
                m[i][capacity] = 0;
                return 0;
            }

        else {
            if (capacity >= w[i]) {
                int selected = KnapsackMemoMethod(i + 1, capacity - w[i]) + v[i];
                int unselected = KnapsackMemoMethod(i + 1, capacity);
                result = selected > unselected ? selected : unselected;
                m[i][capacity] = result;
                return result;
            } else //capacity < w[i]
            {
                result = KnapsackMemoMethod(i + 1, capacity);
                m[i][capacity] = result;
                return result;
            }

        }
    }

    public void Trace(int i, int capacity) {
        if (i == N - 1) {
            if (m[i][capacity] == v[i])
                x[i] = 1;
            else {
                x[i] = 0;
            }
            return;
        } else {
            if (m[i][capacity] == m[i + 1][capacity]) {
                x[i] = 0;
                Trace(i + 1, capacity);
            } else {
                x[i] = 1;
                Trace(i + 1, capacity - w[i]);
            }
        }
    }

    public void start(){
        initial();
//        System.out.println(KnapsackMemoMethod(0,C));
        KnapsackMemoMethod(0,C);
        Trace(0,C);

//        for (int i = 0; i < N; i++) {
//            System.out.print(x[i] + " ");
//        }
//        System.out.println();
    }

    public static void main(String[] args) {
        Recursion_Memo_Bag recursion_memo_bag = new Recursion_Memo_Bag();
        recursion_memo_bag.start();
    }
}