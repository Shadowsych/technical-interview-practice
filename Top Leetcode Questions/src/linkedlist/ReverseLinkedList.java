package linkedlist;

/*
 * Reverse a singly linked list.
 * 
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {
	
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode prev = head;
		ListNode cur = head.next;

		// set the head's next to null since it will now become the last Node
		head.next = null;

		while(cur != null) {
			ListNode next = cur.next;

			// swap the next Node reference for cur with its previous Node reference
			cur.next = prev;

			// set the previous Node to the current Node, then set the cur Node to the next Node that will be swapped
			prev = cur;
			cur = next;
		}
		return prev;
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}