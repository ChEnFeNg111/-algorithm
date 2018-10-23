/**
 *  二分查找：又称折半查找
 *
 *      基本思想： 是将n个元素分成大致相等的两部分，取a[n/2]与x做比较，如果x=a[n/2],则找到x，算法中止；
 *                 如果x<a[n/2]，则只要在数组a的左半部分继续搜索x，如果x>a[n/2]，则只要在数组a的右半部搜索x
 *
 *      对于有序表来说，
 *           优点：   ***比较次数少***，***查找速度快***，***平均性能好***
 *
 *      时间复杂度：O( logn )
 * @author chen
 */
public class BinarySearch {

    public static void main(String[] args) {
        //定义一个有序数组
        int[] arr = {2,4,5,8,10,13,35,46,57,88,100};

        // 调用二分查找的方法，参数：有序数组，指定值
        int data = 88;
        int index = findData(arr,data);

        System.out.println(data+"在数组中的下标值："+index);
    }

    /**
     * 利用二分查找查找出指定值的下标
     */
    public static int findData(int[] arr,int data){
        // 定义两个变量：
        //    low:  数组的第一个下标
        //    high: 数组的最后一个下标
        int low  = 0;
        int high = arr.length-1;

        while(low <= high){
            //定义数组中间下标 mid ,比较 data 和 arr[mid] 的值
            int mid = (low + high)/2;

            if( data == arr[mid]){
                // 若找到data的下标，则返回该下标值
                return mid;
            }else if(data < arr[mid]){
                // 如果 data < arr[mid] 则更新 high 的下标志，继续查找
                high = mid-1;
            }else{
                // 如果 data > arr[mid] 则更新 low 的下标志，继续查找
                low = mid +1;
            }
        }

        // 若数组arr中不存在data，则返回-1
        return -1;
    }

}
