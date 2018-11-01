package 实验二;

public class QuickSort {
    public static int[] sort(int[] list, int left, int right) {
        int temp;
        if(left<right) {
            temp=partition(list,left,right);
        }
        return list;
    }
    public static int[] sort(int[] list) {

        return sort(list,0,list.length-1);
    }

    public static void exchange(int[] list,int i,int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static int partition(int[] list, int left, int right) {
        int pivot = list[left];
        int i = left;
        int j = right;
        while(i<=j) {
            while(list[i] < pivot) {
                i++;
            }
            while(list[j] > pivot) {
                j--;
            }
            if(i <= j) {
                exchange(list,i,j);
                i++;
                j--;
            }
        }
        if(left<j) {
            partition(list,left,j);
        }
        if(i < right) {
            partition(list,i,right);
        }

        return left;
    }
}
