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
        if(end <= start){
            return;
        }
        int mid = start + (end - start) / 2;

        sort(nums,start,mid);
        sort(nums,mid + 1,end);
        merge(nums,start,mid,end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int p = start;
        int p1 = start;
        int p2 = mid + 1;

        while(p1 <= mid && p2 <= end){
            if(nums[p1] < nums[p2]){
                tem[p++] = nums[p1++];
            }else{
                tem[p++] = nums[p2++];
            }
        }
        while(p1 <= mid){
            tem[p++] = nums[p1++];
        }
        while(p2 <= end){
            tem[p++] = nums[p2++];
        }
        for(int i = start;i <= end;i++){
            nums[i] = tem[i];
        }
    }
}

