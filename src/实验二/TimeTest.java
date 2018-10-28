package 实验二;

import java.util.LinkedList;

import static 实验二.InsertSort.insertSort;

public class TimeTest {
    public static void main(String[] args) {
        int size = 100000;

            make(size);


    }

    static void make(int size){
        int[] nums = new int[size];

        for(int i=0; i<size; i++){
            nums[i] = (int)(Math.random()*101);
        }

        long startTime = System.currentTimeMillis();
        LinkedList<Integer> sorted = insertSort(nums);
        long endtime = System.currentTimeMillis();

        long runTime = endtime - startTime;
        System.out.println("当n为"+ size +"运行时间：" + runTime);
    }
}
