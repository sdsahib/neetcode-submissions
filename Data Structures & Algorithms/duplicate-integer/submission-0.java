class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> uniqueNums = new HashSet<Integer>();

        for(int i=0;i<nums.length;i++){
            if(uniqueNums.contains(nums[i])){
                return true;
            }
            uniqueNums.add(nums[i]);
        }
        return false;
    }
}