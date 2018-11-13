package 实验四;

import java.util.Arrays;

public class DynamicPlan_LCSQ {
    public static int[][] vals ;

    public static int getLCS(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();

        vals = new int[len1+1][len2+1];

        for(int i=0;i<len1;i++){
            // 二维数组从[1][1]开始进行有效存储
            int fi = i+1;
            for(int j=0;j<len2;j++){
                int fj = j+1;
                //字符相同
                if(str1.charAt(i) == str2.charAt(j)){
                    // 满足第一种状况
                    vals[fi][fj] = vals[fi-1][fj-1] + 1;
                    //字符不相同
                }else if(str1.charAt(i) != str2.charAt(j)){
                    //满足第二种状况
                    vals[fi][fj] = Math.max(vals[fi-1][fj],vals[fi][fj-1]);
                }
            }
        }

        for(int i=0;i<len1;i++){
            System.out.println(Arrays.toString(vals[i]));
        }

        return vals[len1][len2];
    }
    public static void main(String[] args) {
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        System.out.println(getLCS(str1,str2));
    }
}