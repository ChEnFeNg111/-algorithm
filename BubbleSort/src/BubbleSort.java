import java.util.Arrays;

/**
 * 冒泡排序思想：
 *         设排序序列的记录个数为n，进行n-1次遍历，每次遍历从开始位置依次往后比较前后相邻元素，这样较大的元素往后移，
 *         n-1次遍历结束后，序列有序
 *
 *  时间复杂度： 平均 **O(n^2)**
 *         最佳情况下冒泡排序只需一次遍历就能确定数组已经排好序，不需要进行下一次遍历，所以最佳情况下，时间复杂度为** O(n) **
 *         最坏情况下冒泡排序需要n-1次遍历，第一次遍历需要比较n-1次，第二次遍历需要n-2次，...，最后一次需要比较1次，最差情况下时间复杂度为** O(n^2) **
 *  空间复杂度：
 *         O(1)
 *   稳定性:
 *         稳定排序
 * @author chen
 */
public class BubbleSort {
    public static void main(String[] args) {
        // 定义一个没有顺序的数组
        int[] arr = {3,6,45,34,15,24,98,65,50,70,68,100,25,24,35};

        System.out.println("排序前："+Arrays.toString(arr));
        System.out.println("start："+System.currentTimeMillis());
        bubbleSort(arr);
        System.out.println("end: "+System.currentTimeMillis());
        System.out.println("排序后："+Arrays.toString(arr));

    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        // 减少没必要的比较次数
        boolean flag = true;

        for (int i = 0; i < arr.length-1 && flag ; i++) {
            // 更改标记
            flag = false;

            for (int j = 0; j < arr.length-1-i; j++) {

                // 相邻之间元素进行比较，若 前一个值 > 后一个值，进行交换
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // 交换之后，更改标志值
                    flag = true;
                }
            }
        }
    }
}
