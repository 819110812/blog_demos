package Leetcode80;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveDuplicatesFromSortedArrayIITest {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
                count++;
            } else {
                if (count > 2) {

                }
            }
        }
        return 0;
    }


    @Test
    public void should_remove_duplicates_01() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int res = removeDuplicates(nums);
        int expected = 5;
        assertThat(res).isEqualTo(expected);
    }


    @Test
    public void should_remove_duplicates_02() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5};
        int res = removeDuplicates(nums);
        int expected = 5;
        assertThat(res).isEqualTo(expected);
    }

}
