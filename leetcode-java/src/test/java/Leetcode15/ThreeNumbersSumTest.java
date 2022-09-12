package Leetcode15;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeNumbersSumTest {


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Set<List<Integer>> temp = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    temp.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(temp);
    }


    @Test
    public void should_get_three_sum_successfully() {
        int[] nums = new int[]{1, -1, -1, 0};
        List<List<Integer>> expected = new ArrayList<>();
//        expected.add(Arrays.asList(-1, -1, 2));
        expected.add(Arrays.asList(-1, 0, 1));
        List<List<Integer>> res = threeSum(nums);
        assertThat(res).isEqualTo(expected);

    }


    @Test
    public void should_get_three_sum_01() {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1, -1, 2));
        expected.add(Arrays.asList(-1, 0, 1));
        List<List<Integer>> res = threeSum(nums);
        assertThat(res).isEqualTo(expected);
    }

}
