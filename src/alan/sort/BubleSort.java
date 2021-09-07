package alan.sort;

import alan.utils.GenerateUtils;


/**
 * @Author Alan_
 * @create 2021/9/7 22:13
 * @Description: 冒泡排序 时间O(n^2) 空间O(1)
 */
public class BubleSort {
    public static void main(String[] args) {
        int[] array = GenerateUtils.getArray(10);
        bubleSort(array);
        GenerateUtils.printArrayByString(array);
    }
    public static void bubleSort(int[] nums){
        for(int i = nums.length - 1;i > 0;i--){
            for(int j = 0;j < i;j++){
                if(nums[j] > nums[j + 1]){
                    GenerateUtils.exch(nums,j,j+1);
                }
            }
        }
    }

}
