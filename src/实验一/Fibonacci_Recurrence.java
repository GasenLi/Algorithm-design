package 实验一;

public class Fibonacci_Recurrence {
	
	public static int count(int n){
		if(n<=2){
			return 1;
		}else
			return count(n-1)+count(n-2);
	}
	
	public static void main(String[] args){
	    int n = 56;
		long firsttime = System.currentTimeMillis();

		System.out.println(count(n));
		
		long endtime = System.currentTimeMillis();
        long runTime = endtime - firsttime;

		System.out.println("当n为"+ n +"运行时间：" + runTime);
	}
}
