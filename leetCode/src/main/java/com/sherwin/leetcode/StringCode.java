package com.sherwin.leetcode;

public class StringCode {
	/**
	 * 第三题 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 示例 1: 输入: s = "abcabcbb" 输出: 3
	 * 解释:因为无重复字符的最长子串是 "abc"，所以其长度为 3。 示例 2: 输入: s = "bbbbb" 输出: 1
	 * 解释:因为无重复字符的最长子串是 "b"，所以其长度为 1。 示例 3: 输入: s = "pwwkew" 输出: 3 解释:
	 * 因为无重复字符的最长子串是 "wke"，所以其长度为 3。   请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。 示例
	 * 4:输入: s = "" 输出: 0
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 1) {
			return 1;
		}
		int startIndex = 0;
		int endIndex = 0;
		int maxSubSize = 0;
		int strSize = s.length();
		while (endIndex != strSize) {
			String subStr = s.substring(startIndex, endIndex + 1);
			char end = s.charAt(endIndex);
			if ((endIndex + 1) != strSize) {
				end = s.charAt(endIndex + 1);
			}
			int containIndex = subStr.indexOf(end);
			if (containIndex != -1) {
				startIndex = startIndex + containIndex + 1;
				if (subStr.length() >= maxSubSize) {
					maxSubSize = subStr.length();
				}
			}
			endIndex = endIndex + 1;
		}
		return maxSubSize;
	}

	/**
	 * 给你一个字符串 s，找到 s 中最长的回文子串。 示例 1： 输入：s = "babad" 输出："bab" 解释："aba"
	 * 同样是符合题意的答案。 示例 2： 输入：s = "cbbd" 输出："bb" 示例 3： 输入：s = "a" 输出："a" 示例 4：
	 * 输入：s = "ac" 输出："a"
	 * 
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}
		if (s.length() == 2) {
			if (s.charAt(0) == s.charAt(1)) {
				return s;
			} else {
				return String.valueOf(s.charAt(0));
			}
		}
		char[] charArray = s.toCharArray();
		String longestStr = String.valueOf(charArray[0]);
		boolean allSome = true;
		// 已第i位字符向两边搜索，查找
		for (int i = 0; i < charArray.length; i++) {
			int someCount = someCharNum(charArray, i);
			// 重复的字符个数,根据奇偶数判断left,right
			int left = i + someCount / 2;
			int right = i + someCount / 2;
			if (someCount % 2 == 0) {
				left = i + someCount / 2 - 1;
				right = i + someCount / 2;
			}

			String palindStr = palindrome(charArray, left, right);
			if (palindStr.length() > longestStr.length()) {
				longestStr = palindStr;
			}
			if (charArray[i] != charArray[0]) {
				allSome = false;
			}
		}
		if (allSome) {
			longestStr = s;
		}
		return longestStr;
	}

	private static String palindrome(char[] charArray, int left, int right) {
		String palindromeStr = String.valueOf(charArray, left, right - left + 1);
		// 最后一位
		if (right == charArray.length - 1) {
			return palindromeStr;
		}
		// 往数组左右搜索
		while (left != 0 && right != charArray.length - 1) {
			left = left - 1;
			right = right + 1;
			if (left < 0 || right > charArray.length - 1) {
				palindromeStr = String.valueOf(charArray, left + 1, right - left + 1);
				break;
			}
			if (charArray[left] == charArray[right]) {
				palindromeStr = String.valueOf(charArray, left, right - left + 1);
			} else {
				break;
			}
		}
		return palindromeStr;

	}

	// 重复的字符个数
	private static int someCharNum(char[] charArray, int i) {
		int count = 0;
		for (int j = i; j < charArray.length; j++) {
			if (charArray[j] != charArray[i]) {
				break;
			} else {
				count++;
			}
		}
		return count;
	}

	/**
	 * 第九题 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
	 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 示例 1： 输入：x = 121
	 * 输出：true 示例 2： 输入：x = -121 输出：false 解释：从左向右读, 为 -121 。 从右向左读, 为 121-
	 * 。因此它不是一个回文数。 示例 3： 输入：x = 10 输出：false 解释：从右向左读, 为 01 。因此它不是一个回文数。 示例 4：
	 * 输入：x = -101 输出：false
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {

		if (x <= 9 && x >= 0) {
			return true;
		}
		char[] charArray = String.valueOf(x).toCharArray();
		for (int i = 0, j = charArray.length - 1; i <= j; i++, j--) {
			if (charArray[i] != charArray[j]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 第十四题 编写一个函数来查找字符串数组中的最长公共前缀。 如果不存在公共前缀，返回空字符串 ""。
	 * 
	 * 示例 1： 输入：strs = ["flower","flow","flight"] 输出："fl" 示例 2： 输入：strs =
	 * ["dog","racecar","car"] 输出："" 解释：输入不存在公共前缀。
	 * 
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String commonPrefix = strs[0];
		char[] commonArray = commonPrefix.toCharArray();
		for (int i = 0; i < strs.length; i++) {
			int index = 0;
			while (index < strs[i].length() && index < commonArray.length) {
				// 不相等，比较结束，设置公共前缀
				if (strs[i].charAt(index) != commonArray[index]) {
					// 第一个字符就不相等，返回空
					if (index == 0) {
						return "";
					}
					commonArray = strs[i].substring(0, index).toCharArray();
					break;
				}
				index++;
			}
			// 比较完成，前缀还比比较的字符串长，说明比较的字符串短，且都匹配。
			if (commonArray.length > strs[i].length()) {
				commonArray = strs[i].substring(0, strs[i].length()).toCharArray();
			}

		}
		return String.valueOf(commonArray);
	}

	/**剑指offer第5题
	 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 示例 1： 输入：s = "We are happy."
	 * 输出："We%20are%20happy."
	 * 
	 * @param s
	 * @return
	 */
	public static String replaceSpace(String s) {
		char[] charArray = new char[s.length() * 3];
		int size = 0;
		for (int i = 0; i < s.length(); i++) {
			char charEle = s.charAt(i);
			if (charEle == ' ') {
				charArray[size++] = '%';
				charArray[size++] = '2';
				charArray[size++] = '0';
			} else {
				charArray[size++] = charEle;
			}
		}
		String result = new String(charArray, 0, size);
		return result;
	}
}
