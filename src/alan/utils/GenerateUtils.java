package alan.utils;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Alan_
 * @create 2021/9/7 22:16
 */
public class GenerateUtils {
    /**
     * 交换元素
     * @param nums 一维数组
     * @param index1
     * @param index2
     */
    public static void exch(int[] nums,int index1,int index2){
        int tem = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tem;
    }

    /**
     * 获取指定长度得数组，并随机填充元素
     * @param n
     * @return
     */
    public static int[] getArray(int n){
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * n);
        }
        return arr;
    }

    /**
     * 以字符串形式打印数组
     * @param array
     */
    public static void printArrayByString(int[] array){
        System.out.println(Arrays.toString(array));
    }

    public static boolean AisLessB(int[] nums,int index1,int index2){
        return nums[index1] <= nums[index2];
    }
}
