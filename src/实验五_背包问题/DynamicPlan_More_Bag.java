package 实验五_背包问题;

public class DynamicPlan_More_Bag {

    private static int n = 5;//总的背包数目
    private static int w = 11;//总重量
    private static int weight[]={1,3,5,6,7};//负重限制
    private static int value[]={10,10,22,22,24};//价值数组
    private static  int memory[][]=new int[n+1][w+1];//备忘录
    private static  String answer = new String();//答案字符串

    public DynamicPlan_More_Bag(){
        //初始化备忘录 为 0
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                memory[i][j]=0;
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        showMemory();//展示备忘录
        getMemory();//计算备忘录
        showMemory();//展示备忘录
        backTrace(n,w,answer);//回溯备忘录取得最优解

    }
    //计算备忘录
    //请注意备忘录从1开始计算而value和weight从0开始计算
    public static  void getMemory(){
        for(int i=1;i<n+1;i++){// n from 1 to 5
            for(int j=1;j<w+1;j++){//j from 1 to 11
                if(weight[i-1]>j) memory[i][j] = memory[i-1][j];
                else memory[i][j] = Math.max(memory[i-1][j], value[i-1]+memory[i-1][j-weight[i-1]]);
            }
        }
    }
    //展示备忘录
    public static void showMemory(){
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                System.out.print(memory[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //backtrace the best solutions from the x and y in memory 缺点 只能找到一个解，无法解决多个解的情况 可供参考
    /*public static void backTrace(int start_x,int start_y){
        if(memory[start_x][start_y]>0){
            if(memory[start_x][start_y]==memory[start_x-1][start_y]){//start_x may not in the best solution
                backTrace(start_x-1,start_y);
            }
            else{//start_x in the best solution
                System.out.print(start_x + "  ");
                backTrace(start_x-1,start_y-weight[start_x-1]);
            }
        }
    }*/

    //从x和y开始回溯备忘录，找到解的空间，并存放在字符串中输出
    public static void backTrace(int start_x,int start_y,String answer){
        if(start_y>=0&&memory[start_x][start_y]>0){//
            //start_x in the best solutions，start_x一定在最优解中，存入并计算
            if(memory[start_x][start_y]>memory[start_x-1][start_y]){
                //System.out.print(start_x + " ");
                answer += start_x + " ";
                backTrace(start_x-1,start_y-weight[start_x-1],answer);
            }
            //start_x not in the solutions，start_x一定不在最优解中，计算start_x-1
            else if((start_y>=weight[start_x-1])&&(memory[start_x-1][start_y]!=(value[start_x-1]+memory[start_x-1][start_y-weight[start_x-1]]))){
                backTrace(start_x-1,start_y,answer);
            }
            else{//both are possible,start_x此时都有可能存在于最优解，分别计算
                String answer_no = new String(answer);
                //not in 不在里面
                backTrace(start_x-1,start_y,answer_no);

                //in 在里面
                answer += start_x + " ";
                backTrace(start_x-1,start_y-weight[start_x-1],answer);
            }
        }
        else if(start_y>=0){//start_y在计算过程中有可能小于0，避免此类情况，并且start_y>＝0是结束的判断条件
            System.out.println(answer);
        }
    }
}