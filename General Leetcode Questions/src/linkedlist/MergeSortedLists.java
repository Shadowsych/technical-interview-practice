package linkedlist;

/*
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeSortedLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		} else if(l2 == null) {
			return l1;
		}

		// have two references to each individual Node of the two lists
		ListNode list1 = l1;
		ListNode list2 = l2;

		// receive the first reference Node
		ListNode result = null;
		ListNode nextNode = null;
		if(list1.val <= list2.val) {
			result = new ListNode(list1.val);
			nextNode = result;

			// go to the next Node
			list1 = list1.next;
		} else {
			result = new ListNode(list2.val);
			nextNode = result;

			// go to the next Node
			list2 = list2.next;
		}

		// keep iterating until all elements are added
		while(!(list1 == null && list2 == null)) {
			if(list1 == null && list2 != null) {
				// add remaining elements of list2
				nextNode.next = new ListNode(list2.val);
				nextNode = nextNode.next;
				list2 = list2.next;
			} else if(list2 == null && list1 != null) {
				// add remaining elements of list1
				nextNode.next = new ListNode(list1.val);
				nextNode = nextNode.next;
				list1 = list1.next;
			} else if(list1.val <= list2.val) {
				// add the list 1 value since it's smaller or equal to list 2
				nextNode.next = new ListNode(list1.val);

				// go to the next Node
				nextNode = nextNode.next;
				list1 = list1.next;
			} else if(list2.val < list1.val) {
				// add the list 2 value since it's smaller than list 1
				nextNode.next = new ListNode(list2.val);

				// go to the next Node
				nextNode = nextNode.next;
				list2 = list2.next;
			}
		}

		return result;
	}
	
	// ListNode class used as the Node to a LinkedList
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
}
