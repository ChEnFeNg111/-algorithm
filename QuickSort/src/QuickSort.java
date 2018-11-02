import java.util.Arrays;

/**
 *   快速排序：
 *         思想：在待排序的序列中选择一个称为主元的元素，将数组分为两部分，
 *              使得第一部分中的所有元素都小于或等于主元，而第二部分中的所有元素都大于主元，然后对两部分递归地应用快速排序算法
 *
 *         时间复杂度： 平均：O(nlogn)
 *
 *             最优：每次主元将数组划分为规模大致相等的两部分，时间复杂度为 ** O(nlogn) **
 *
 *             最差：划分由n个元素构成的数组需要进行n次比较和n次移动，
 *                  在最差情况下，每次主元会将数组划分为一个大的子数组和一个空数组，这个大的子数组的规模是在上次划分的子数组的规模上减1，
 *                  这样在最差情况下算法需要(n-1)+(n-2)+...+1= ** O(n^2) **时间
 *
 *        空间复杂度：
 *               ** O(nlogn) **
 *
 *        稳定： 不稳定排序
 *
 * @author chen
 *
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3,6,2,1,4,47,67,15,9,8,100,0};
        System.out.println("排序前："+Arrays.toString(arr));

        doQuickSort(arr,0,arr.length-1);

        System.out.println("排序后："+Arrays.toString(arr));

    }

    private static void doQuickSort(int[] arr, int i, int j) {
        // 如果起始位置比借宿位置答，则无法进行排序
        if(i>j){
            return;
        }

        // 主元元素，进行比较, 默认为数组中的第一个
        int key = arr[i];

        // 起始位置 start 和 end
        int start = i;
        int end = j;


        while(start < end){

            // 先从右往左遍历，如果比 key 大，则继续往前遍历，直到找到比 key 小的值
            while( start<end && key<=arr[end] ){
                end--;
            }

            // 再从左往右遍历，如果比 key 小，则继续往后遍历，直到找到比 key 大的值
            while( start<end && key>=arr[start] ){
                start++;
            }

            // 如果找到值，则进行交换
            if(start < end){
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
        }

        // 如果 start 和 end 相遇了，则将 主元元素与 找到的值交换
        arr[i] = arr[start];
        arr[start] = key;

        // 完成一次排序，继续递归调用

        // 递归 key 的左半边
        doQuickSort(arr,i,end-1);

        // 递归 key 的右半边
        doQuickSort(arr,end+1,j);

    }


}
