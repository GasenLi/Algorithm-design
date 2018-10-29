package 实验二;

public class FastSort {

    public static void fastSort(int[] nums, int start, int end){

        //判断是否为最小数组
        int D_value = end - start;
        if(D_value<=1){
            if(D_value == 1){
                compare(nums, start, end);
            }

            return;
        }

        int middleIndex = singleSort(nums, start, end);

        //递归分解 同时判断比较数是否为首尾
        if(middleIndex != 0){
            fastSort(nums, start,middleIndex-1);
        }

        if(middleIndex != nums.length-1){
            fastSort(nums, middleIndex+1, end);
        }

    }

    public static int singleSort(int[] nums, int start, int end){
        int firstIndex = start+1;
        int lastIndex = end;
        int middleIndex = start;

        while (firstIndex<=lastIndex){
            while (firstIndex<=lastIndex){
                if(nums[middleIndex] > nums[lastIndex]){
                    change(nums, middleIndex, lastIndex);
                    middleIndex = lastIndex;
                    lastIndex--;

                    break;
                }else {
                    lastIndex--;
                    continue;
                }
            }

            while (firstIndex<=lastIndex){
                if(nums[middleIndex] < nums[firstIndex]){
                    change(nums, middleIndex, firstIndex);
                    middleIndex = firstIndex;
                    firstIndex++;

                    break;
                }else {
                    firstIndex++;
                    continue;
                }
            }
        }

        return middleIndex;
    }

    //比较大小
    public static void compare(int[] nums , int a, int b){
        if(nums[a]>nums[b]){
            change(nums, a, b);
        }
    }


    //交换两个数的位置
    public static void change(int[] nums, int indexFir, int indexSec){
        int temp = nums[indexFir];
        nums[indexFir] = nums[indexSec];
        nums[indexSec] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{50, 8, 15, 56, 89, 65, 15, 65, 47, 98, 88, 42, 100, 8};
        fastSort(nums,0,13);

        for(int num : nums){
            System.out.print(num + " ");
        }
    }


}
