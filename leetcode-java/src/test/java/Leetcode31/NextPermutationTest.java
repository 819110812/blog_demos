package Leetcode31;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NextPermutationTest {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 找到第一个左邻小于右邻的位置
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            // 找到第一个比nums[i]大的数字
            int j = nums.length - 1;
            // 从后往前找
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 交换
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    @Test
    public void should_return_next_permutation_successfully_01() {
        int[] nums = new int[]{1, 2, 3};
        nextPermutation(nums);
        assertThat(nums).isEqualTo(new int[]{1, 3, 2});
    }


    @Test
    public void should_return_next_permutation_successfully_02() {
        int[] nums = new int[]{3, 2, 1};
        nextPermutation(nums);
        assertThat(nums).isEqualTo(new int[]{1, 2, 3});
    }


    @Test
    public void should_return_next_permutation_successfully_03() {
        int[] nums = new int[]{1, 3, 2};
        nextPermutation(nums);
        assertThat(nums).isEqualTo(new int[]{2, 1, 3});
    }


    @Test
    public void should_return_next_permutation_successfully_04() {
        int[] nums = new int[]{1};
        nextPermutation(nums);
        assertThat(nums).isEqualTo(new int[]{1});
    }

    @Test
    public void should_return_next_permutation_successfully_05() {
        int[] nums = new int[]{5,4,7,5,3,2};
        nextPermutation(nums);
        assertThat(nums).isEqualTo(new int[]{5,5,2,3,4,7});
    }

    @Test
    public void should_return_next_permutation_successfully_06() {
        int[] nums = new int[]{1,5,1};
        nextPermutation(nums);
        assertThat(nums).isEqualTo(new int[]{5,1,1});
    }

}
