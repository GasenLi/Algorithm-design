package 实验五_背包问题;

import 实验四.Recursion_Memo_LCSQ;

public class TimeTest {
    public static void main(String[] args) {
        for(int size=10;size<1000;size+=10){
            make(size);
        }
    }

    public static Recursion_Bag getRandomBags(int size){
        Recursion_Bag recursion_bag = new Recursion_Bag();

        recursion_bag.n = size;
        recursion_bag.W = (int)(Math.random()*size)*2;

        int[] w = new int[size];
        int[] v = new int[size];
        for(int i=0;i<size;i++){
            w[i] = (int)(Math.random()*10)+1;
            v[i] = (int)(Math.random()*20)+1;
        }

        recursion_bag.Weights = w;
        recursion_bag.Values = v;

        return recursion_bag;
    }

    public static void make(int size){
        Recursion_Bag bag = getRandomBags(size);

        long startTime = System.currentTimeMillis();
        bag.GetBestValue();
        long endtime = System.currentTimeMillis();

        long runTime = endtime - startTime;
        System.out.println("当n为"+ size +"运行时间：" + runTime);

    }
}
