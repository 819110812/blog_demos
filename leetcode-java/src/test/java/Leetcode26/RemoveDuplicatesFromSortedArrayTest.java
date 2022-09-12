package Leetcode26;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveDuplicatesFromSortedArrayTest {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                left++;
                nums[left] = nums[right];
                right++;
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(left);
        return left + 1;
    }

    @Test
    public void should_remove_duplicates_01() {
        int[] nums = new int[]{1, 1, 2};
        int res = removeDuplicates(nums);
        int expected = 2;
        assertThat(res).isEqualTo(expected);
    }

    @Test
    public void should_remove_duplicates_02() {
        int[] nums = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int res = removeDuplicates(nums);
        int expected = 5;
        assertThat(res).isEqualTo(expected);
    }

}
