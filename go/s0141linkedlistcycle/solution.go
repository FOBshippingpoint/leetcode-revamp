package s0141linkedlistcycle

type ListNode struct {
	Val  int
	Next *ListNode
}

func hasCycleV1(head *ListNode) bool {
	curr := head
	for range 10001 { // Max list size is 10^4, so if we have 10001th node, loop!
		if curr != nil {
			curr = curr.Next
		} else {
			return false
		}
	}
	return true
}

func hasCycleV2(head *ListNode) bool {
	if head == nil {
		return false
	}

	turtle := head
	rabit := head

	for rabit != nil && rabit.Next != nil {
		turtle = turtle.Next
		rabit = rabit.Next.Next
		if rabit == turtle { // If rabit catch up turtle, then there is a cycle
			return true
		}
	}
	return false
}
