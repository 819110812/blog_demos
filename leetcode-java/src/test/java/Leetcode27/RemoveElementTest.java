package Leetcode27;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveElementTest {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[left] = nums[i];
            left++;
        }
        return left;
    }


    @Test
    public void should_remove_element_successfully_01() {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        int res = removeElement(nums, val);
        int expected = 2;
        assertThat(res).isEqualTo(expected);
    }


    @Test
    public void should_remove_element_successfully_02() {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int res = removeElement(nums, val);
        int expected = 5;
        assertThat(res).isEqualTo(expected);
    }
}




