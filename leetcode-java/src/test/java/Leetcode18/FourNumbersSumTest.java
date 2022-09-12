package Leetcode18;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class FourNumbersSumTest {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        Set<List<Integer>> temp = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }

                int tar = target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == tar) {
                        temp.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < tar) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(temp);

    }


    @Test
    public void should_get_four_numbers_01() {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-2, 0, 0, 2));
        expected.add(Arrays.asList(-2, -1, 1, 2));
        expected.add(Arrays.asList(-1, 0, 0, 1));
        List<List<Integer>> res = fourSum(nums, target);
        assertThat(res).isEqualTo(expected);
    }


    @Test
    public void should_get_four_number_02() {
        int[] nums = new int[]{2,2,2,2,2};
        int target = 8;
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(2,2,2,2));
        List<List<Integer>> res = fourSum(nums, target);
        assertThat(res).isEqualTo(expected);
    }


}
