package Leetcode01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoNumbersTest {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> targetNums = new HashMap<>();
        for(int i=0;i<nums.length;++i) {
            if (targetNums.containsKey(nums[i])) {
                res[0] = targetNums.get(nums[i]);
                res[1] = i;
                return res;
            }
            targetNums.put(target-nums[i], i);
        }
        return new int[]{};
    }
    
    

    @Test
    public void should_get_array_successfully() {
        int[] nums = new int[] {3,2,4};
        int target = 6;
        int[] ints = twoSum(nums, target);
        int[] expected = new int[]{1,2};
        System.out.println(Arrays.toString(ints));
        assertArrayEquals(ints, expected);
    }


}
