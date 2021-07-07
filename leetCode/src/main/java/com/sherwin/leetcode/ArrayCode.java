package com.sherwin.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayCode {
	/**
	 * leetcode 第一题 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 
	 * 的那 两个 整数，并返回它们的数组下标。 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
	 * 你可以按任意顺序返回答案。
	 * 
	 * 示例 1： 输入：nums = [2,7,11,15], target = 9 输出：[0,1] 解释：因为 nums[0] + nums[1]
	 * == 9 ，返回 [0, 1] 。 示例 2： 输入：nums = [3,2,4], target = 6 输出：[1,2] 示例 3：
	 * 输入：nums = [3,3], target = 6 输出：[0,1]
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		List<Integer> numsList = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			numsList.add(target - nums[i]);
		}
		int[] resultArray = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int index = numsList.indexOf(nums[i]);
			if (index != -1) {
				resultArray[0] = i;
				resultArray[1] = index;
				if (i == index) {
					continue;
				}

				return resultArray;
			}
		}
		return resultArray;
	}

	/**
	 * 第十一题 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线
	 * i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
	 * 说明：你不能倾斜容器。 示例 1： 输入：[1,8,6,2,5,4,8,3,7] 输出：49 解释：图中垂直线代表输入数组
	 * [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 输入：height = [1,1]
	 * 输出：1 示例 3： 输入：height = [4,3,2,1,4] 输出：16 示例 4： 输入：height = [1,2,1] 输出：2
	 * 
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		if (height.length < 2) {
			return 0;
		}
		int maxArea = 0;
		int tempArea = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			if (height[left] >= height[right]) {
				tempArea = (right - left) * height[right];
				right--;
			} else {
				tempArea = (right - left) * height[left];
				left++;
			}
			if (tempArea >= maxArea) {
				maxArea = tempArea;
			}
		}
		return maxArea;
	}

	/**
	 * 第五十三题 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 示例 1： 输入：nums =
	 * [-2,1,-3,4,-1,2,1,-5,4] 输出：6 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。 示例 2： 输入：nums
	 * = [1] 输出：1 示例 3： 输入：nums = [0] 输出：0 示例 4： 输入：nums = [-1] 输出：-1 示例 5：
	 * 输入：nums = [-100000] 输出：-100000
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int sum = 0;
		int max = nums[0];
		int i = 0;
		int j = 0;
		while (i < nums.length) {
			sum = sum + nums[i];
			if (sum > max) {
				max = sum;
			}
			if (sum < 0) {
				i++;
				j = i;
				sum = 0;
			} else {
				i++;
			}

		}
		return max;
	}

	/**
	 * 第121题 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 你只能选择 某一天
	 * 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
	 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 示例 1： 输入：[7,1,5,3,6,4] 输出：5 解释：在第 2
	 * 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。 注意利润不能是 7-1 = 6,
	 * 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。 示例 2： 输入：prices = [7,6,4,3,1] 输出：0
	 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int minPrice = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < prices.length; i++) {

			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else if (prices[i] - minPrice > result) {
				result = prices[i] - minPrice;
			}
		}

		return result;
	}

	/**
	 * 剑指offer第三题 找出数组中重复的数字。 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1
	 * 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。 示例 1： 输入：
	 * [2, 3, 1, 0, 2, 5, 3] 输出：2 或 3
	 * 
	 * @param nums
	 * @return
	 */
	public int findRepeatNumber(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int repeat = -1;
		for (int num : nums) {
			if (!set.add(num)) {
				repeat = num;
				break;
			}
		}
		return repeat;
	}

}
