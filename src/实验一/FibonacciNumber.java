package 实验一;

public class FibonacciNumber {
	public static final int F0 = 0; 
	public static final int F1 = 1; 
		
	
	public static int count(int n){
		long firsttime = System.currentTimeMillis();
		
		int temp = 0;
		int front = F0;
		int after = F1;
		
		for(int i=2;i<=n;i++){
			temp = after;
			
			after = front + after;
			
			front = temp;
		}
		
		long endtime = System.currentTimeMillis();
		long runTime = endtime - firsttime;
		System.out.println("当n为"+ n +"运行时间：" + runTime);
		
		return after;
	}
	
	
	public static void main(String[] args){
		System.out.println(count(100));
	}
}
