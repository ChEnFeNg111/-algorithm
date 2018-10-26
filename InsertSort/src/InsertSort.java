import java.util.Arrays;

/**
 *  直接插入排序：
 *        思想：是将一个记录插入到已排好序的有序表中，从而得到一个新的、记录数增1的有序表
 *
 *          例子：排序序列(3,2,1,5)的过程是，初始时有序序列为(3)，然后从位置1开始，先访问到2，将2插入到3前面，得到有序序列(2,3)，
 *                之后访问1,找到合适的插入位置后得到有序序列(1,2,3)，最后访问5，得到最终有序序列(1,2,3,5)
 *
 *   时间复杂度： 平均情况下，时间复杂度为 ** O(n^2) **
 *           最好情况下，当待排序序列中记录已经有序时，则需要n-1次比较，不需要移动，时间复杂度为 ** O(n) **
 *           最差情况下，当待排序序列中所有记录正好逆序时，则比较次数和移动次数都达到最大值，时间复杂度为 ** O(n^2) **
 *
 *   空间复杂度：
 *            O(1)
 *    稳定性：
 *          稳定排序
 *
 * @author chen
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {9,4,2,5,58,34,25,14,66,78,36,46,100,1,55};
        System.out.println("排序前："+Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后："+Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        int j;
        for (int i = 1; i < arr.length; i++) {
            // 定义一个中间变量
            int temp = arr[i];
            // temp的前一个元素
            j = i-1;
            while(j>-1 && temp<arr[j]){
                // 将temp前面的元素都往后移一位
                arr[j+1] = arr[j];
                j--;
            }
            // 若 temp > arr[j] ，则将temp的值直接加到该有序元素的后面
            arr[j+1] = temp;
        }
    }
}
