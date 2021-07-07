package com.sherwin.leetcode;

public class MathCode {
	/**
	 * 第七题 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 如果反转后整数超过 32
	 * 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。 假设环境不允许存储 64 位整数（有符号或无符号）。 示例 1：
	 * 
	 * 输入：x = 123 输出：321 示例 2： 输入：x = -123 输出：-321 示例 3： 输入：x = 120 输出：21 示例 4：
	 * 输入：x = 0 输出：0
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-integer
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		double sum = 0;
		int temp = x;
		if (x < 0) {
			temp = Math.abs(x);
		}
		while (temp > 0) {
			int mod = temp % 10;
			temp = temp / 10;
			sum = sum * (double) Math.pow(10, 1) + mod;
		}
		if (x < 0) {
			sum = 0 - sum;
		}
		if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) sum;
	}

	/**
	 * 第八题 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi
	 * 函数）。 函数 myAtoi(string s) 的算法如下： 读入字符串并丢弃无用的前导空格
	 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
	 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。 将前面步骤读入的这些数字转换为整数（即，"123" ->
	 * 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。 如果整数数超过 32
	 * 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为
	 * −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。 返回整数作为最终结果。
	 * 
	 * @param str
	 * @return
	 */
	public static int myAtoi(String str) {

		String testStr = str.trim();
		if (testStr == null || testStr.isEmpty()) {
			return 0;
		}
		char first = testStr.charAt(0);

		if ((first < '0' || first > '9') && first != '-' && first != '+') {
			return 0;
		}
		char[] charArray = testStr.toCharArray();
		boolean isNegative = false;
		if (first == '-') {
			charArray = testStr.substring(1).toCharArray();
			isNegative = true;
		} else if (first == '+') {
			charArray = testStr.substring(1).toCharArray();
			isNegative = false;
		}
		double sum = 0;
		for (int i = 0; i < charArray.length; i++) {
			if ((charArray[i] < '0' || charArray[i] > '9')) {
				break;
			}
			sum = sum * 10 + charArray[i] - '0';
		}
		if (isNegative) {
			sum = 0 - sum;
		}
		if (sum > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if (sum < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int) sum;
	}

	public int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		int first = 1;
		int second = 1;
		int res = 0;
		for (int i = 3; i <= n; i++) {
			res = (first + second) % 1000000007;
			first = second;
			second = res;
		}
		return res;
	}

}
