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
        int[] heap = new int[nums.length + 1];
        createHeap(nums,heap);
        int N = heap.length - 1;
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
        for(int i = 1;i < heap.length;i++){
            heap[i] = nums[i - 1];
        }
        //从heap一半处对每个元素做下沉操作
        for(int i = (heap.length - 1 )/ 2;i > 0;i--){
            sink(heap,i,heap.length - 1);
        }
    }

    private static void sink(int[] heap, int target, int N) {
        while(2 * target <= N){
            int max = 2 * target;
            //如果存在右节点，找到其中最大值
            if(2 * target + 1 <= N){
                if(GenerateUtils.AisLessB(heap,2 * target,2 * target + 1)){
                    max = 2 * target + 1;
                }
            }
            //比较当前值与max的大小，如果大于则交换
            if(GenerateUtils.AisLessB(heap,target,max)){
                GenerateUtils.exch(heap,target,max);
            }
            target = max;
        }
    }
}
