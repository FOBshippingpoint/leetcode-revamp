package s0206reverselinkedlist

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseListV1(head *ListNode) *ListNode {
	var prev *ListNode
	curr := head

	for curr != nil {
		next := curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}

	return prev
}

func reverseListV2(head *ListNode) *ListNode {
	if head == nil {
		return nil // For empty linked list
	}
	if head.Next == nil {
		return head // End condition
	}

	newHead := reverseListV2(head.Next)
	head.Next.Next = head
	head.Next = nil

	return newHead
}

func reverseListV3(head *ListNode) *ListNode {
	var prev *ListNode
	curr := head

	for curr != nil {
		curr.Next, prev, curr = prev, curr, curr.Next
	}

	return prev
}
