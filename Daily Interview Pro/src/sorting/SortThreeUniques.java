package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * Question (This problem was recently asked by Google):
 * 
 * Given a list of numbers with only 3 unique numbers (1, 2, 3), sort the list in O(n) time.
 * Challenge: Try sorting the list using constant, O(1), space.
 */

/* Example 1:
 * Input: [3, 3, 2, 1, 3, 2, 1]
 * Output: [1, 1, 2, 2, 3, 3, 3]
 */

public class SortThreeUniques {

	public static void main(String[] args) {
		int[] nums = {3, 3, 2, 1, 3, 2, 1};
		solution(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	private static void solution(int[] nums) {
		// a Map that only stores the 3 unique numbers, so it's negligible for space complexity
		Map<Integer, Integer> uniques = new HashMap<>();
		
		if(nums.length == 0) {
			// cannot use an empty Array
			return;
		}
		
		// iterate through the nums Array and find each unique number
		for(int numIndex = 0; numIndex < nums.length; numIndex++) {
			int num = nums[numIndex];
			if(uniques.containsKey(num)) {
				// increment the frequency of this unique number
				int freq = uniques.get(num);
				uniques.put(num, freq + 1);
			} else {
				// put this unique number into the Map
				uniques.put(num, 1);
			}
		}
		
		// check for an invalid size of unique numbers
		final int UNIQUES = 3;
		if(uniques.size() != UNIQUES) {
			return;
		}
		
		// deep copy the 3 unique numbers, which is still negligible for space complexity
		ArrayList<Integer> sortedUniques = new ArrayList<>();
		for(int unique : uniques.keySet()) {
			sortedUniques.add(unique);
		}
		
		// sort the keys, there's always 3 keys, so sorting 3 numbers is negligible for time
		Collections.sort(sortedUniques);
		sort(nums, uniques,sortedUniques);
	}
	
	// sort the nums Array by counting the frequency of each sorted unique number
	private  static void sort(int[] nums, Map<Integer, Integer> uniques, ArrayList<Integer> sortedUniques) {
		for(int numIndex = 0; numIndex < nums.length; numIndex++) {
			// receive the current frequency of each unique number
			int smallFreq = uniques.get(sortedUniques.get(0));
			int midFreq = uniques.get(sortedUniques.get(1));
			int largeFreq = uniques.get(sortedUniques.get(2));
			
			if(smallFreq > 0) {
				// continue setting the smallest number
				nums[numIndex] = sortedUniques.get(0);
				uniques.put(sortedUniques.get(0), smallFreq - 1);
			} else if(midFreq > 0) {
				// continue setting the middle number
				nums[numIndex] = sortedUniques.get(1);
				uniques.put(sortedUniques.get(1), midFreq - 1);
			} else {
				// continue setting the largest number
				nums[numIndex] = sortedUniques.get(2);
				uniques.put(sortedUniques.get(2), largeFreq - 1);
			}
		}
	}
}
