class Solution {
    public int[] getConcatenation(int[] nums) {
        int n= nums.length;
        int[] doubleNums = new int[2*n];
        for(int i =0;i<n;i++){
            doubleNums[i] = nums[i];
            doubleNums[i+n] = nums[i];
        }

        return doubleNums;
    }
}