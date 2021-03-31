package day3.s90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> rs = new ArrayList<>();
		Arrays.sort(nums);
		calcSubsets(rs, new ArrayList<>(), 0, nums);
		return rs;
	}

	private void calcSubsets(List<List<Integer>> rs, List<Integer> cur, int index, int[] nums) {
		rs.add(new ArrayList<>(cur));
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i-1])
				continue;
			cur.add(nums[i]);
			calcSubsets(rs, cur, i + 1, nums);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.subsetsWithDup(new int[]{1, 2, 2}));
	}
}
