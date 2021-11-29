package alan.sort;

import alan.utils.GenerateUtils;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = GenerateUtils.getArray(10);
        heapSort(array);
        GenerateUtils.printArrayByString(array);
    }
    public static void heapSort(int[] nums){
        //构建堆
        int N = nums.length;
        int[] heap = new int[N + 1];
        createHeap(nums,heap);
        while(N != 1){
            GenerateUtils.exch(heap,1,N);
            N--;
            sink(heap,1,N);
        }
        for(int i = 0;i < nums.length;i++){
            nums[i] = heap[i + 1];
        }
    }

    private static void createHeap(int[] nums, int[] heap) {
        for(int i = 0;i < nums.length;i++){
            heap[i + 1] = nums[i];
        }
        for(int i = heap.length / 2;i > 0;i--){
            sink(heap,i,heap.length - 1);
        }
    }

    private static void sink(int[] heap, int target, int N) {
        while (2 * target <= N){
            int max = 2 * target;
            if(2 * target + 1 <= N){
                if(GenerateUtils.AisLessB(heap,2 * target,2 * target + 1)){
                    max = 2 * target + 1;
                }
            }
            if(GenerateUtils.AisLessB(heap,target,max)){
                GenerateUtils.exch(heap,target,max);
            }
            target = max;
        }
    }
}
