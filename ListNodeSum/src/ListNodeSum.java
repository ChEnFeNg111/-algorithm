/**
 * 题目：
 *    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  解题思路：
 *     1) 将当前结点初始化为返回列表的哑结点。
 *     2) 将进位 flag 初始化为 0。
 *     3) 将 p1 和 p2 分别初始化为列表 l1 和 l2 的头部。
 *     4) 遍历列表 l1 和 l2 直至到达它们的尾端。
 *             将 x 设为结点 p1 的值。如果 p 已经到达 l1 的末尾，则将其值设置为 0。
 *             将 y 设为结点 p2 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0。
 *             设定 sum = x + y + flag。
 *             更新进位的值，flag  = sum / 10
 *             创建一个数值为 (sum mod 10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
 *             同时，将 p1 和 p2 前进到下一个结点。
 *      5) 检查  flag=1 是否成立，如果成立，则向返回列表追加一个含有数字 1 的新结点。
 *      6) 返回哑结点的下一个结点。
 *
 *     注意： 使用哑结点来简化代码。如果没有哑结点，则必须编写额外的条件语句来初始化表头的值
 *
 *  复杂度分析
 *
 *      时间复杂度：O(max(m,n))，假设 m和 n分别表示 l1 和 l2 的长度，上面的算法最多重复 max(m,n) 次。
 *
 *      空间复杂度：O(max(m,n))， 新列表的长度最多为 max(m,n)+1。
 */

public class ListNodeSum {

    /**
     * 定义一个链表
     */
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode toNodeSum(ListNode l1,ListNode l2){
        ListNode l3 = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = l3;

        // 有进位：flag=1  没有进位：flag=0
        int flag = 0;

        while(p1 != null || p2!= null){
            int x = (p1!=null)?p1.val:0;
            int y = (p2!=null)?p2.val:0;

            int sum = flag+x+y;

            flag = sum/10;

            p3.next = new ListNode(sum%10);
            p3 = p3.next;

            if(p1!=null){
                p1 = p1.next;
            }

            if(p2!=null){
                p2=p2.next;
            }
        }
        if(flag>0){
            p3.next=new ListNode(flag);
        }

        return l3.next;
    }
    
    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);*/
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);

        ListNode l2 = new ListNode(0);


        ListNode listNode = toNodeSum(l1, l2);

        System.out.println(listNode);
    }

}
