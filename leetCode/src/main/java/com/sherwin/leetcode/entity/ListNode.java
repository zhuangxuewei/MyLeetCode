package com.sherwin.leetcode.entity;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public ListNode(int x, ListNode next) {
		this.val = x;
		this.next = next;
	}
}