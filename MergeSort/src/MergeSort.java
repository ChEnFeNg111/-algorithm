import java.util.Arrays;

/**
 * 归并排序：
 *        思想：将待排序序列分为两部分，对每部分 **递归** 地应用归并排序，在两部分都排好序后进行 **合并**
 *
 *        例如，排序序列(3,2,8,6,7,9,1,5)的过程是，先将序列分为两部分，(3,2,8,6)和(7,9,1,5)，然后对两部分分别应用归并排序，
 *        第1部分(3,2,8,6)，第2部分(7,9,1,5)，对两个部分分别进行归并排序，第1部分继续分为(3,2)和(8,6)，(3,2)继续分为(3)和(2)，(8,6)继续分为(8)和(6)，
 *        之后进行合并得到(2,3)，(6,8)，再合并得到(2,3,6,8)，第2部分进行归并排序得到(1,5,7,9)，最后合并两部分得到(1,2,3,5,6,7,8,9)
 *
 *        时间复杂度：
 *                O(nlogn)，java.util.Arrays类中的sort方法就是 **使用归并排序的变体** 来实现的
 *
 *        空间复杂度：
 *                 O(n)
 *
 *        稳定性：
 *               是一种稳定的排序
 *
 * @author chen
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,2,8,6,7,9,1,5};
        System.out.println("排序前："+Arrays.toString(arr));
        Arrays.sort(arr);

        // 递归 对数组进行分部排序
        doMergeSort(arr);

        System.out.println("排序后："+Arrays.toString(arr));
    }

    private static void doMergeSort(int[] arr) {
        if(arr.length>1){

            // 将数组分为两部分
            int length1 = arr.length /2;
            int[] arr1 = new int[length1];

            // 将长度为 length1 的数组数据 赋值给 arr1
            System.arraycopy(arr,0,arr1,0,length1);

            // 递归调用，继续分为两部分
            doMergeSort(arr1);

            int length2 = arr.length-length1;
            int[] arr2 = new int[length2];
            // 将长度为 length1 的数组数据 赋值给 arr1
            System.arraycopy(arr,length1,arr2,0,length2);

            // 递归调用，继续分为两部分
            doMergeSort(arr2);

            // 每部分进行排序
            int[] arr3 = merge(arr1,arr2);

            // 将排序好的数组重新赋值给 原数组 arr[]
            System.arraycopy(arr3,0,arr,0,arr.length);

        }

    }

    // 合并数组
    private static int[] merge(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length+arr2.length];

        int count1=0;
        int count2=0;
        int count3=0;

        while(count1<arr1.length && count2<arr2.length){
            if(arr1[count1] < arr2[count2]){
                arr3[count3++] = arr1[count1++];
            }else{
                arr3[count3++] = arr2[count2++];
            }
        }

        while(count1 < arr1.length){
            arr3[count3++] = arr1[count1++];
        }

        while(count2 < arr2.length){
            arr3[count3++] = arr2[count2++];
        }

        return arr3;
    }
}
