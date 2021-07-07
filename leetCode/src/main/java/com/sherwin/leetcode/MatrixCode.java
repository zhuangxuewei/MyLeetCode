package com.sherwin.leetcode;

public class MatrixCode {
	/**
	 * 在一个 n * m
	 * 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 * 示例: 现有矩阵 matrix 如下： [ [1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9,
	 * 16,22], [10, 13, 14, 17, 24], [1, 21, 23, 26, 30] ] 给定
	 * target = 5，返回 true。 给定 target = 20，返回 false。
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean findNumberIn2DArray(int[][] matrix, int target) {
		int i = matrix.length-1;
		int j = 0;
		while (i >=0 && j < matrix[0].length) {
			int element = matrix[i][j];
			if (element < target) {
				j++;
			} else if (element > target) {
				i--;
			} else {
				return true;
			}
		}
		return false;
	}
}
