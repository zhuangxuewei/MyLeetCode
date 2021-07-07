package com.sherwin.leetcode;

import java.util.Stack;

import com.sherwin.leetcode.entity.ListNode;

public class ListCode {
	/**
	 * 第二题 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
	 * 请你将两个数相加，并以相同形式返回一个表示和的链表。 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		boolean shouPlus = false;
		int l3InitValue = l1.val + l2.val;
		if (l3InitValue >= 10) {
			l3InitValue = l3InitValue - 10;
			shouPlus = true;
		}
		ListNode l3 = new ListNode(l3InitValue);
		ListNode l3Iter = l3;

		while (l1.next != null && l2.next != null) {
			l1 = l1.next;
			l2 = l2.next;
			int l3IterValue = l1.val + l2.val;
			if (shouPlus) {
				l3IterValue = l3IterValue + 1;
			}
			if (l3IterValue >= 10) {
				l3IterValue = l3IterValue - 10;
				shouPlus = true;
			} else {
				shouPlus = false;
			}
			ListNode l3Node = new ListNode(l3IterValue);
			l3Iter.next = l3Node;
			l3Iter = l3Node;
		}
		while (l1.next != null) {
			l1 = l1.next;
			int l3IterValue = l1.val;
			if (shouPlus) {
				l3IterValue = l3IterValue + 1;
			}
			if (l3IterValue >= 10) {
				l3IterValue = l3IterValue - 10;
				shouPlus = true;
			} else {
				shouPlus = false;
			}
			ListNode l3Node = new ListNode(l3IterValue);
			l3Iter.next = l3Node;
			l3Iter = l3Node;
		}
		while (l2.next != null) {
			l2 = l2.next;
			int l3IterValue = l2.val;
			if (shouPlus) {
				l3IterValue = l3IterValue + 1;
			}
			if (l3IterValue >= 10) {
				l3IterValue = l3IterValue - 10;
				shouPlus = true;
			} else {
				shouPlus = false;
			}
			ListNode l3Node = new ListNode(l3IterValue);
			l3Iter.next = l3Node;
			l3Iter = l3Node;
		}
		if (shouPlus) {
			ListNode l3Node = new ListNode(1);
			l3Iter.next = l3Node;
			l3Iter = l3Node;
		}
		return l3;
	}
	/**
	 * 
	 * @param head
	 * @return
	 */
	public static int[] reversePrint(ListNode head) {
		Stack<Integer> stack = new Stack<Integer>();
		ListNode iter = head;
		while (iter!= null) {
			stack.push(iter.val);
			iter = iter.next;
		}
		
		int[] result = new int[stack.size()];
		int size=stack.size();
		for (int i = 0; i < size; i++) {
			result[i] = stack.pop().intValue();
		}
		return result;
	}
}
