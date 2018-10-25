import java.util.Arrays;

/**
 * 简单选择排序：
 *       思想：
 *           设排序序列的记录个数为n，进行n-1次选择，每次在n-i+1(i = 1,2,...,n-1)个记录中选择***关键字最小***的记录作为有效序列中的第i个记录
 *   时间复杂度：
 *          当i=1时，需进行n-1次比较；当i=2时，需进行n-2次比较；依次类推，共需要进行的比较次数是(n-1)+(n-2)+…+2+1=n(n-1)/2，
 *          即进行比较操作的时间复杂度为 O(n^2) ，进行移动操作的时间复杂度为 O(n) 。
 *          总的时间复杂度为 ** O(n^2) **
 *   空间复杂度：
 *           O(1)
 *   稳定性:
 *        不稳定
 *        选择排序是给每个位置选择当前元素最小的，比如给第一个位置选择最小的，在剩余元素里面给第二个元素选择第二小的，依次类推，直到第n - 1个元素，第n个元素不用选择了，因为只剩下它一个最大的元素了。
 *        那么，在一趟选择，如果当前元素比一个元素小，而该小的元素又出现在一个和当前元素相等的元素后面，那么交换后稳定性就被破坏了。
 *        举个例子，序列5 8 5 2 9，我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了，所以选择排序不是一个稳定的排序算法
 *
 * @author chen
 */

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {2,3,56,57,45,35,24,66,99,15,8,60};
        System.out.println("排序前："+Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后："+Arrays.toString(arr));

    }

    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            // 假定第一个数为最小值
            int min = i;

            // 从第二个数开始比较
            for (int j = i+1; j < arr.length; j++) {
                // 若存在比最小值小的值，则更新最小值的下标
                if(arr[min] > arr[j]){
                    min = j;
                }
            }

            // 若最小值已经更新了，则将最小值交换到数组的前面
            if(min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

}

