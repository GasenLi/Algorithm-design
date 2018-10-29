package 实验二;

import java.util.LinkedList;

import static 实验二.FastSort.fastSort;
import static 实验二.InsertSort.insertSort;
import static 实验二.MergeSort.merge_sort_up2down;

public class TimeTest {
    public static void main(String[] args) {
        int size = 100;

        for(; size<=100000000; size*=10){
            make(size);
        }
//        make(100000000);
    }

    static void make(int size){
        int[] nums = new int[size];

        for(int i=0; i<size; i++){
            nums[i] = (int)(Math.random()*101);
        }

        long startTime = System.currentTimeMillis();
        fastSort(nums,0,nums.length-1);
        long endtime = System.currentTimeMillis();

        long runTime = endtime - startTime;
        System.out.println("当n为"+ size +"运行时间：" + runTime);

//        for(int num : nums){
//            System.out.println(num);
//        }

    }
}
