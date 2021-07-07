package com.sherwin.leetcode;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.sherwin.leetcode.entity.ListNode;

public class ListCodeTest {

	@Test
	public void testAddTwoNumbers() {
		fail("Not yet implemented");
	}

	@Test
	public void testReversePrint() {
		ListNode head = new ListNode(1, new ListNode(3, new ListNode(2)));
		ListCode.reversePrint(head);
	}

}
