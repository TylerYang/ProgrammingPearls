public class Solution {
    public int maxSubSum(int[] nums) {
        int maxSoFar = 0, maxEndingHere = 0;
        for(int i = 0; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], 0);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
