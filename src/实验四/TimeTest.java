package 实验四;

import 实验二.MergeSort;

public class TimeTest {
    public static void main(String[] args) {
//        for(int size=1000;size<10000;size+=1000){
//            make(size);
//        }
        make(10000);
    }

    public static String getRandomString(int size){
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<size;i++){
            stringBuilder.append((char)(65 + ((int) (Math.random()*26))));
        }

        return stringBuilder.toString();
    }

    public static void make(int size){
        String s1 = getRandomString(size);
        String s2 = getRandomString(size);

        long startTime = System.currentTimeMillis();
        int commonLen = Recursion_Memo_LCSQ.memorized_LCS_LENGTH(s1,s2);
        long endtime = System.currentTimeMillis();

        long runTime = endtime - startTime;
        System.out.println("当n为"+ size +"运行时间：" + runTime);

    }
}
