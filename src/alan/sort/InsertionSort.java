package alan.sort;

import alan.utils.GenerateUtils;

import java.util.Arrays;

/**
 * @Author Alan_
 * @create 2021/9/7 22:52
 * @Description: 插入排序 时间O(n^2) 空间O(1)
 */
public class InsertionSort {
    public static void main(String[] args) {
        GenerateUtils.printArrayByString(insertionSort(GenerateUtils.getArray(10)));
    }
    public static int[] insertionSort(int[] nums){
        for(int i = 1;i < nums.length;i++){
            for(int j = i;j > 0;j--){
                if(GenerateUtils.AisLessB(nums,j,j -1)){
                    GenerateUtils.exch(nums,j - 1,j);
                }else{
                    break;
                }
            }
        }
        return nums;
    }

}
