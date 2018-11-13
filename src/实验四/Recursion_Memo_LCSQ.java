package 实验四;

import static java.lang.Math.max;

public class Recursion_Memo_LCSQ {
    int lengthx  = 29;
    int lengthy = 28;

    int[][] c = new int[lengthx+1][lengthy+1];


    int memorized_LCS_LENGTH(String X,String Y){
        int m= lengthx;
        int n=lengthy;
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
                c[i][j]=-1;
        return LOOKUP_CHAIN(X,Y,m,n);
    }


    int LOOKUP_CHAIN(String x,String y,int i,int j){
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

    int main(){

        String s1="ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
        String s2="GTCGTTCGGAATGCCGTTGCTCTGTAAA";
        memorized_LCS_LENGTH(s1,s2);
        return 0;

    }
}


