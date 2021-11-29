package alan.sort;

import alan.utils.GenerateUtils;

import javax.annotation.Generated;
import javax.swing.*;

/**
 * @Author Alan_
 * @create 2021/9/8 16:49
 * @Description: 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = GenerateUtils.getArray(10);
        quickSort(array);
        GenerateUtils.printArrayByString(array);
    }
    public static int[] quickSort(int[] nums){
        sort(nums,0,nums.length -1);
        return nums;
    }
    public static void sort(int[] nums,int lo,int hi){
        if(lo >= hi){
            return;
        }
        int pat = pattion(nums,lo,hi);
        sort(nums,lo,pat - 1);
        sort(nums,pat + 1,hi);
    }
    public static int pattion(int[] nums,int lo,int hi){
        int pat = nums[lo];
        int left = lo;
        int right = hi + 1;
        while (true){
            while (nums[--right] > pat){
                if(right == lo){
                    break;
                }
            }
            while (nums[++left] < pat){
                if(left == hi){
                    break;
                }
            }
            if(left >= right){
                break;
            }else {
                GenerateUtils.exch(nums,left,right);
            }
        }
        GenerateUtils.exch(nums,right,lo);
        return right;
    }
}
