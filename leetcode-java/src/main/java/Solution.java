
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode constructFromArray(int[] array) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int i = 0; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


public class Solution {
    private static int getListNodeLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    int cur = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        head.next = removeNthFromEnd(head.next, n);
        cur++;
        if (n==cur) {
            return head.next;
        }
        return head;
    }
}
