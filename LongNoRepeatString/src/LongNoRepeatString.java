import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 *    输入: "abcabcbb"
 *    输出: 3
 *    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LongNoRepeatString {


    /** 暴力拆解法
     *     将字符串中所有的组合依次进行遍历
     *
     *    1）假设开始和结束的索引分别为 i 和 j。那么我们有  0≤i<j≤n （这里的结束索引 j 是按惯例排除的）。
     *       因此，使用 i 从0到 n−1 以及 j 从 i+1 到 n 这两个嵌套的循环，我们可以枚举出 s 的所有子字符串。
     *
     *    2）要检查一个字符串是否有重复字符，可以使用集合。遍历字符串中的所有字符，并将它们逐个放入 set 中。
     *       在放置一个字符之前，我们检查该集合是否已经包含它。如果包含，我们会返回 false。循环结束后，我们返回 true
     *
     *   时间复杂度：
     *        O(n3)
     *   空间复杂度：
     *        O(min(n,m))，我们需要 O(k) 的空间来检查子字符串中是否有重复字符，其中 k 表示 Set 的大小。
     *        而 Set 的大小取决于字符串 n 的大小以及字符集/字母 m 的大小
     * @param s
     * @param start
     * @param end
     * @return
     */
    public static boolean allString(String s,int start,int end){
        Set<Character> hashSet = new HashSet<>();
        for (int i = start; i < end ; i++) {
            char c = s.charAt(i);
            if(hashSet.contains(c)){
                return false;
            }else {
                hashSet.add(c);
            }
        }

        return true;
    }

    public static int getMax(String s){
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if(allString(s,i,j)){
                    result = Math.max(result,j-i);
                }
            }
        }

        return result;
    }

    /**
     *  使用 HashSet 作为滑动窗口，我们可以用 O(1)O(1) 的时间来完成对字符是否在当前的子字符串中的检查
     *  滑动窗口：
     *       使用 HashSet 将字符存储在当前窗口 [i, j)（最初 j = i）中。 然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。直到 s[j] 已经存在于 HashSet 中。
     *       此时，我们找到的没有重复字符的最长子字符串将会以索引 i 开头。如果我们对所有的 i 这样做，就可以得到答案
     *
     *  时间复杂度：O(2n)=O(n)，在最糟糕的情况下，每个字符将被 i 和 j 访问两次。
     *
     *  空间复杂度：O(min(m,n))，与之前的方法相同。滑动窗口法需要 O(k) 的空间，其中 k 表示 Set 的大小。
     *                           而Set的大小取决于字符串 n 的大小以及字符集/字母 m 的大小。
     * @param s
     * @return
     */
    public static int lengthOfLongestString(String s){
        Set<Character> set = new HashSet<>();
        int result = 0;
        int i=0,j=0;

        while(i<s.length() && j<s.length()){
            // 遍历出 [i,j) 最长的无重复子串
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                result = Math.max(result,j-i);
            }else {
                // 继续遍历 [i++,j)
                set.remove(s.charAt(i));
                i++;
            }
        }

        return result;
    }




    public static void main(String[] args) {
        String s = "acncdnlcajfn";
        int max = getMax(s);
        int max1 = lengthOfLongestString(s);
        System.out.println(max1);

        System.out.println("the longest no repeation string is :"+max);
    }
}
