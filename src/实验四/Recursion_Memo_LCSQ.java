package 实验四;

import static java.lang.Math.max;

public class Recursion_Memo_LCSQ {
    static int[][] c;


    public static int memorized_LCS_LENGTH(String X,String Y){
        c = new int[X.length()][Y.length()];

        for(int i=0;i<X.length();i++)
            for(int j=0;j<Y.length();j++)
                c[i][j]=-1;
        return LOOKUP_CHAIN(X,Y,X.length()-1,Y.length()-1);
    }


    public static int LOOKUP_CHAIN(String x,String y,int i,int j){
        if(c[i][j]>-1)
            return c[i][j];
        if(i==0||j==0)
            c[i][j]=0;
        else{
            if(x.charAt(i-1)==y.charAt(j-1))
                c[i][j]=LOOKUP_CHAIN(x,y,i-1,j-1)+1;
            else
                c[i][j]=max(LOOKUP_CHAIN(x,y,i,j-1),LOOKUP_CHAIN(x,y,i-1,j));

        }
        return c[i][j];


    }

    public static void main(String[] args) {
        String s1="ACCGG";
        String s2="GTCGT";
        System.out.println(memorized_LCS_LENGTH(s1,s2) + "");
    }
}


