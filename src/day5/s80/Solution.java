package day5.s80;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int moveIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            if ( nums[moveIndex-2] != nums[i])
                nums[moveIndex++] = nums[i];
        }
        return moveIndex;
    }
}
