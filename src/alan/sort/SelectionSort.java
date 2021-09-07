package alan.sort;

import alan.utils.GenerateUtils;

/**
 * @Author Alan_
 * @create 2021/9/7 22:41
 * @Description: 选择排序 时间O(n^2) 空间O(1)
 */
public class SelectionSort {
    public static void main(String[] args) {
        GenerateUtils.printArrayByString(selectionSort(GenerateUtils.getArray(10)));
    }
    public static int[] selectionSort(int[] nums){
        int n = nums.length;
        for(int i = 0;i < n - 1;i++){
            int minIndex = i;
            for(int j = i + 1;j < n;j++){
                if(GenerateUtils.AisLessB(nums,j,minIndex)){
                    minIndex = j;
                }
            }
            GenerateUtils.exch(nums,minIndex,i);
        }
        return nums;
    }
}
