package 实验五_背包问题;

import 实验四.Recursion_Memo_LCSQ;

public class TimeTest {
    public static void main(String[] args) {
        for(int size=10;size<100000000;size*=10){
            make(size);
        }
    }

    public static Bag getRandomBags(int size){
        Bag bag = new Bag();

        bag.setNumber(size);
        bag.setWeight((int)(Math.random()*size)*2);

        int[] w = new int[size+1];
        int[] v = new int[size+1];
        for(int i=0;i<=size;i++){
            w[i] = (int)(Math.random()*10)+1;
            v[i] = (int)(Math.random()*20)+1;
        }

        bag.setW(w);
        bag.setV(v);

        return bag;
    }

    public static void make(int size){
        Bag bag = getRandomBags(size);

        long startTime = System.currentTimeMillis();
        int[] choose = DynamicPlan_Bag.bag(bag.getNumber(), bag.getWeight(), bag.getW(), bag.getV());
        long endtime = System.currentTimeMillis();

        long runTime = endtime - startTime;
        System.out.println("当n为"+ size +"运行时间：" + runTime);

    }
}
