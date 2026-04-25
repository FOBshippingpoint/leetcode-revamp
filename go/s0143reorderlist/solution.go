package s0143reorderlist

type ListNode struct {
	Val  int
	Next *ListNode
}

func reorderListV1(head *ListNode) {
	var revHead *ListNode
	size := 1
	for curr := head; curr != nil; curr = curr.Next {
		size += 1
		revHead = &ListNode{curr.Val, revHead}
	}

	curr := head
	for range size/2 - 1 {
		next := curr.Next
		curr.Next = revHead
		revNext := revHead.Next

		curr = next
		revHead.Next = curr
		revHead = revNext
	}
	if size%2 == 0 {
		curr.Next = nil
	} else {
		curr.Next.Next = nil
	}
}

func reorderListV2(head *ListNode) {
	// Find half
	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		slow, fast = slow.Next, fast.Next.Next
	}

	// Reverse left half
	var revHead *ListNode
	curr := slow.Next
	slow.Next = nil
	for curr != nil {
		curr, revHead, curr.Next = curr.Next, curr, revHead
	}

	// Concat together
	for revHead != nil {
		head, head.Next, revHead, revHead.Next = head.Next, revHead, revHead.Next, head.Next
	}
}
