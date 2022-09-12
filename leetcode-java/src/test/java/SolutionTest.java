import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test1() {
        int[] head = new int[]{1, 2, 3, 4, 5};
        ListNode headNode = new ListNode();
        headNode = headNode.constructFromArray(head);
        int n = 2;
        int[] expected = new int[]{1, 2, 3, 5};
        ListNode expectedNode = new ListNode();
        expectedNode = expectedNode.constructFromArray(expected);
        Solution solution = new Solution();
        ListNode actual = solution.removeNthFromEnd(headNode, n);
        System.out.println(actual);
        assertEquals(expectedNode, actual);
    }


}
