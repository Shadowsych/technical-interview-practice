package arrays;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Question:
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 */

/* Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		System.out.println(Arrays.toString(solution(nums, 9)));
	}

	public static int[] solution(int[] nums, int target) throws IllegalArgumentException {
		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < nums.length; i++) {
			// receive the complement of the target subtracted from the current number using a HashMap
			int complement = target - nums[i];
			if(map.containsKey(complement)) {
				return new int[] {map.get(complement), i};
			}
			// put this number and its index into the map to check with other complements
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution.");
	}
}
