package 实验二;

import java.util.LinkedList;

public class InsertSort {

    public static LinkedList<Integer> insertSort(int[] nums){
        LinkedList<Integer> sorted = new LinkedList<>();
        sorted.add(nums[0]);

        int position = 1;
        while (position < nums.length){
            int temp = nums[position];
            int frontSize = sorted.size();

            for(int index=0; index<sorted.size(); index++){
                if(temp < sorted.get(index)){
                    sorted.add(index, temp);
                    break;
                }
            }

            //检查是否是最大的元素没加进去
            if(frontSize == sorted.size()){
                sorted.addLast(temp);
            }

            position++;
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,8,7,9,6,5,54,56,12,54,88,54};

        LinkedList<Integer> sorted = insertSort(nums);
        System.out.println(sorted);
    }

}
