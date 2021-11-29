package alan.sort;

import alan.utils.GenerateUtils;

import java.time.temporal.Temporal;

/**
 * @Author Alan_
 * @create 2021/9/8 9:56
 * @Description: 归并排序 时间O(NlogN) 空间O(N)
 */
public class MergeSort {
    static int[] tem;
    public static void main(String[] args) {
        int[] array = GenerateUtils.getArray(10);
        int[] ints = mergeSort(array);
        GenerateUtils.printArrayByString(ints);
    }
    public static int[] mergeSort(int[] nums){
        tem = new int[nums.length];
        sort(nums,0,nums.length - 1);
        return nums;
    }
    public static void sort(int[] nums,int start,int end){
        if(start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
        sort(nums,start,mid);
        sort(nums,mid + 1,end);
        merge(nums,start,mid,end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int p = start;
        while(left <= mid && right <= end){
            if(GenerateUtils.AisLessB(nums,left,right)){
                tem[p++] = nums[left++];
            }else{
                tem[p++] = nums[right++];
            }
        }
        while(left <= mid){
            tem[p++] = nums[left++];
        }
        while (right <= end){
            tem[p++] = nums[right++];
        }

        for(int i = start;i <= end;i++){
            nums[i] = tem[i];
        }
    }
}

