package 实验六;

import 实验五_背包问题.Bag;
import 实验五_背包问题.DynamicPlan_Bag;

public class TimeTest {
    public static void main(String[] args) {
        for(int size=10;size<=100000000;size*=10){
            make(size);
        }
    }

    public static int[][] getRandomMatrix(int size){
        int[][] matrix = new int[size][size];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(i==j){
                    matrix[i][j] = 0;
                }else {
                    matrix[i][j] = getRandomVlen();
                }
            }
        }

        return matrix;
    }

    public static int getRandomVlen(){
        int judge = (int)(Math.random()*10)+1;
        if(judge<=2){
            return Integer.MAX_VALUE;
        }else {
            return (int)(Math.random()*10)+1;
        }
    }

    public static char[] getRandomVexs(int size){
        char[] Vexs = new char[size];

        for(char i : Vexs){
            i = (char)(Math.random()*100+ 1);
        }

        return Vexs;
    }

    public static void make(int size){
        MapBuilder builder = new MapBuilder();
        builder.pointNum = size;

        long startTime = System.currentTimeMillis();
        new Kruskal().buildTree(builder);
        long endtime = System.currentTimeMillis();

        long runTime = endtime - startTime;
        System.out.println("当n为"+ size +"运行时间：" + runTime);

    }
}
