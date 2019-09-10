package dp;

/* Question:
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 */

/* Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 */

/* Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

/* Personal Example:
 * Input: 4
 * Output: 4
 * Explanation: There are five ways to climb to the top.
 * 1. 1 + 1 + 1 + 1
 * 2. 2 + 2
 * 3. 2 + 1 + 1
 * 4. 1 + 2 + 1
 * 5. 1 + 1 + 2
 * 
 * Notice how the total number of steps is equal to the previous example's number of steps
 * plus the previous previous example's number of steps. This is like fibonacci, so we can
 * use dynamic programming to solve this!
 */
public class ClimbingStairs {
	
	public static void main(String[] args) {
		System.out.println(solution(3));
	}

	public static int solution(int n) {
        // let's create a DP structure to answer the question when n = 0, 1, 2, 3, etc.
        int[] dp = new int[n + 1];
        if(n <= 2) {
            return n;
        }
        dp[1] = 1;
        dp[2] = 2;
        
        // construct the data structure for each value of i until n
        for(int i = 3; i <= n; i++) {
            // the problem is similar to the fibonacci sequence
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
	}
}
