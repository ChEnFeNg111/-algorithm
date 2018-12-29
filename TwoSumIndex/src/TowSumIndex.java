import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 *    给定 nums = [2, 7, 11, 15], target = 9
 *
 *    因为 nums[0] + nums[1] = 2 + 7 = 9
 *    所以返回 [0, 1]
 *
 */
public class TowSumIndex {

    public static void main(String[] args) {
        int[] nums = {2,7,11,8};
        int target = 9;

        int[] index1 = twoSumIndex(nums, target);
        int[] index2 = twoHash(nums, target);
        int[] index3 = oneHash(nums, target);

        System.out.println(Arrays.toString(index1));
        System.out.println(Arrays.toString(index2));
        System.out.println(Arrays.toString(index3));
    }

    /** 暴力拆解法
     *        遍历每个元素 x，并查找是否存在一个值与 target−x 相等的目标元素
     *
     *   时间复杂度：O(n^2)
     *        对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n) 的时间。因此时间复杂度为 O(n^2)
     *
     *   空间复杂度：O(1)。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumIndex(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1 ; j < nums.length; j++) {
                if(nums[j] == target-nums[i]){
                    return new int[]{i,j};
                }else{
                    continue;
                }
            }
        }

        throw new IllegalArgumentException("no two sum solution!");
    }

    /**
     * 两遍哈希表
     *    在第一次迭代中，我们将每个元素的值和它的索引添加到表中。然后，
     *    在第二次迭代中，我们将检查每个元素所对应的目标元素（target−nums[i]）是否存在于表中。注意，该目标元素不能是 nums[i] 本身！
     *
     *  时间复杂度：O(n)，
     *       把包含有 n 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1)，所以时间复杂度为 O(n)。
     *
     * 空间复杂度：O(n)，
     *       所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n 个元素
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoHash(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num2 = target - nums[i];

            if(map.containsKey(num2) && map.get(num2) !=i){
                return new int[]{i,map.get(num2)};
            }
        }

        throw new IllegalArgumentException("no two sum solution!");
    }

    /**
     * 一遍哈希表
     *      在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回
     *
     * 时间复杂度：O(n)，
     *      我们只遍历了包含有 n个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。
     *
     * 空间复杂度：O(n)，
     *      所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n个元素
     * @param nums
     * @param target
     * @return
     */
    public static int[] oneHash(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {
            int num2 = target - nums[i];
            if(map.containsKey(num2)){
                return new int[]{map.get(num2),i};
            }
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("no two sum solution!");
    }
}
