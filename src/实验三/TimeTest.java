package 实验三;

public class TimeTest {
    public static void main(String[] args) {
//        int[] nums = new int[]{5,1,2,4,9,8,7,6,5,4};
       for(int size=10; size<=100000000; size*=10){
           make(getRandomNums(size));
       }

    }

    public static void make(int[] nums){
        long startTime = System.currentTimeMillis();
        int result = MedianSort.select(nums,0);
        long endtime = System.currentTimeMillis();

        long runTime = endtime - startTime;
        System.out.println("当n为"+ nums.length +"运行时间：" + runTime);

//        for(int num : nums){
//            System.out.println(num);
//        }

    }



    public static int[] getRandomNums(int size){
        int[] nums = new int[size];

        for(int i=0; i<size; i++){
            nums[i] = (int)(Math.random()*101);
        }

        return nums;
    }

}
