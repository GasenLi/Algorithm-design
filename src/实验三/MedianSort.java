package 实验三;

import java.util.Arrays;

public class MedianSort {
    public static int select(int[] A, int k) {
        return selectDo(A, 0, A.length - 1, k);
    }

    private static int selectDo(int[] A, int low, int high, int k) {
        //selectkminnumber
        int p = high - low + 1;
        if (p < 44) {
            Arrays.sort(A, low, high + 1);
            return A[low + k];
        }
        //Adividedintoqgroups,eachgroup5elements,andsortthem
        int q = p / 5;
        int[] M = new int[q];
        for (int i = 0; i < q; i++) {
            Arrays.sort(A, low + 5 * i, low + 5 * i + 5);
            M[i] = A[low + 5 * i + 2];
        }

        //selectmidinM
        int mid = selectDo(A, 0, q - 1, (q - 1) / 2);
        //Adividedinto3groups
        int[] A1 = new int[p];
        int[] A2 = new int[p];
        int[] A3 = new int[p];
        int count1, count2, count3;
        count1 = count2 = count3 = 0;
        for (int i = low; i <= high; i++) {
            if (A[i] < mid)
                A1[count1++] = A[i];
            else if (A[i] == mid)
                A2[count2++] = A[i];
            else
                A3[count3++] = A[i];
        }
        if (count1 >= k)
            return selectDo(A1, 0, count1 - 1, k);
        if (count1 + count2 >= k)
            return mid;
        return selectDo(A3, 0, count3 - 1, k - count1 - count2);
    }


}
