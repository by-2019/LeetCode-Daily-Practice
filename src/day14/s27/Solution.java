package day14.s27;

/**
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int moveIndex = nums.length - 1;
        for (int i = 0; i < moveIndex; i++) {
            if (nums[i] != val)
                continue;
            nums[i--] = nums[moveIndex--];
        }
        return nums[moveIndex] == val ? moveIndex : moveIndex + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}